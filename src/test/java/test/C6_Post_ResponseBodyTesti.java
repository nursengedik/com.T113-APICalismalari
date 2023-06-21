package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C6_Post_ResponseBodyTesti {//POST REQUEST BODY BILGILERINI ASSERT YAPMA

    /*
       https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
       gonderdigimizde
          {
            "title":"API",
            "body":"API ogrenmek ne guzel",
            "userId":10,
          }

       donen Response’ın,

          Status code’unun 201,
          ve content type’inin application/json
          ve Response Body'sindeki,
             "title"'in "API" oldugunu
             "userId" degerinin 100'den kucuk oldugunu
             "body" nin "API" kelimesi icerdigini
          test edin.
    */

    @Test
    public void post01(){

        //1- Url (ya da endpoint) ve Request (rigrest) Body hazırlama

        String url = "https://jsonplaceholder.typicode.com/posts";

        /*
          {
            "title":"API",
            "body":"API ogrenmek ne guzel",
            "userId":10,
          }
       */

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println("reqBody = " + reqBody);

        //2- Expected Data hazırla (yok)

        //3- Response'i kaydet (API'Yİ çalıştırdığımız adım)
        //API given() ile başlayıp http methodu ile biten kısımla çalışır
        //response'sı, dönen sonuçlar üzerinde doğrulamalar yapabilmek için kaydediyoruz


        Response response = given()
                                  .contentType(ContentType.JSON)//post'ta body oluşturacağımız için given'dan
                            .when()                             //sonra content type (dili belirtilir) yazılır
                                  .body(reqBody.toString())//body miz Json formatında hazırlansa da kodlarımız
                            .post(url);                   //java ile çalışacağı için toString() ile
                                                         //javaya çevrilir ve öyle gönderilir

        response.prettyPrint();//response yazdırma

        //4- Assertion (doğrulama adımı)
        response
                .then()
                      .assertThat()
                      .statusCode(201)//status code 201 mi assert et demek
                      .contentType("application/json")
                      .body("title", Matchers.equalTo("API"))
                      .body("userId", Matchers.lessThan(100))
                      .body("body", Matchers.containsString("API"));

        //response'daki body test edebilmek için body() methodunu çağırıp içerisine hangi key değerinin ne
        //olması beklediğimizi yazıyoruz, body() methodu bunu Matchers class'ından yardım alarak yapıyor

    }


    /* konsolda

    reqBody = {"title":"API","body":"API ogrenmek ne guzel","userId":10} =====> Request body


    {  =======> dönen Response'mızın body'si

      "title": "API",
      "body": "API ogrenmek ne guzel",
      "userId": 10,
      "id": 101
    }

    */





}

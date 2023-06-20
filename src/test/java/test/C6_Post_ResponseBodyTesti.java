package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

       onen Response’un,

          tatus code’unun 201,
          e content type’inin application/json
          e Response Body'sindeki,
          title"'in "API" oldugunu
          userId" degerinin 100'den kucuk oldugunu
          body" ni
    */

    @Test
    public void post01(){

        //1- Url (post request olduğu için) ve Request (rigrest) Body hazırlama

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

        Response response = given()
                                  .contentType(ContentType.JSON)//post'ta body oluşturacağımız için
                            .when()
                                  .body(reqBody.toString())
                            .post(url);




    }







}

package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {//response temel bilgilerini assert yapma

    /*
       https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
       Json formatindaki body ile bir PUT request gonderdigimizde
            {
              "title": "Ahmet",
              "body": "Merhaba",
              "userId": 10,
              "id": 70
            }

      donen Response’un,

            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK

    */


    @Test
    public void put01(){

        //1- Endpoint ve Request (rigrest) Body hazırlama

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        //3P'de (Put, Post ve Patch) body hazırlamak zorunludur

        /* body hazırlama
            {
              "title": "Ahmet",
              "body": "Merhaba",
              "userId": 10,
              "id": 70
            }
       */

        //PUT request update işlemi yapar (70 id var, bir tanesini güncellemiş oluruz)

        JSONObject reqBody = new JSONObject();//body hazırlayıp göndermek için JSON objesi oluşturulur

        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put( "userId", 10);
        reqBody.put("id", 70);

        //2- Expected Data hazırla (soruda expected data yok, bizden response'ın temel bilgilerini test etmemiz
        //isteniyor)

        //3- Response'i (rispans) kaydet

        //NOT: Eğer sorgumuzda bir request body gönderiyorsak gönderdiğimiz datanın formatını belirtmek
        //zorundayız. Bunu da hemen given() methodundan sonra pre-condition olarak belirtebiliriz.

        //manuel Api sorgusunda yaptığımız adımları burada kodlarla otomatik olarak yapıyoruz
        Response response = given()
                                  .contentType(ContentType.JSON)//önce body'mizin içerik dilini belirtiriz
                            .when()
                                  .body(reqBody.toString())//kodlarımız java ile çalıştığı için toString ile
                                  .put(url);              //javaya çevirir göndeririz
        response.prettyPrint();//response'ı yazdırırız, çalıştırdığımızda dönen response'ı kaydetmek için

        /*

        {
          "id": 70,
          "title": "Ahmet",
          "body": "Merhaba",
          "userId": 10
        }

        */

        //4- Assertion
        //then() methodu olmadan assertThat() methodu gelmez
        response
                .then()
                      .assertThat()
                      .statusCode(200)
                      .contentType("application/json; charset=utf-8")
                      .header("Server", "cloudflare")
                      .statusLine("HTTP/1.1 200 OK");







    }



}

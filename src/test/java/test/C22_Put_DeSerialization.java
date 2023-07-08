package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlace;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {//basit katmanlı body testi

     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    @Test
    public void put01(){

        // 1- Url ve request body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();

        //Request body hazırlama
        HashMap <String, Object> reqBody = testDataJsonPlace.requestBodyOlusturMap();//obje üzerinden Map olan
                                                                                   //methodumuzu çağırıyoruz
        // 2 - Expected Data hazirla

        //expected body request body'imiz ile aynı olduğu için ismini değiştirerek aynısını kullanırız
        HashMap <String, Object> expData = testDataJsonPlace.requestBodyOlusturMap();

        // 3 - Response'i kaydet

        Response response = given()
                                  .spec(specJsonPlace)
                                  .contentType(ContentType.JSON)
                            .when()
                                  .body(reqBody)//map'imiz java olduğu için reqBody'i toString() ile javaya
                                               //çevirmiyoruz
                                  .put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        //şimdiye kadar dönen response body'sinin içine girebilmek için response'ımızı JsonPath'e dönüştürüyorduk
        //şimdi ise HashMap'e dönüştüreceğiz, çünkü expected body'mizi HashMap olarak hazırladık, dönen
        //response'ımızı da HashMap olarak hazırlayalım ki ikisini rahatlıkla kıyaslayabilelim
        //bunu da response üzerinden as() methodu ile yaparız

        HashMap <String,Object> respMap = response.as(HashMap.class);//response'ımızı Map formatına dökmüş oluyoruz
                                                                    //HashMap döneceği için HashMap'e kaydederiz

        assertEquals( expData.get("title") , respMap.get("title") );//Map'in içindeki verileri get() methodu
        assertEquals( expData.get("body") , respMap.get("body") );//ile alıyoruz
        assertEquals( expData.get("userId") , respMap.get("userId") );
        assertEquals( expData.get("id") , respMap.get("id") );

    }

}
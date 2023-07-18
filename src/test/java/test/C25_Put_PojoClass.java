package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceRequestBodyPOJO;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseURL {

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

    Expected Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01(){//Pojo ile request body hazırlama

        // 1 - Url ve Request Body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        //burada testData ile değil Pojo ile request body hazırlayacağız
        //bunun için java'nın altında pojo package oluşturulur ve altında bütün formatlarımız ve
        //bütün json objeleri method olarak değil class olarak oluşturulur
        //Pojo: basit bir java objesidir, kodların dinamik olması için oluşturulan bir kalıptır

       //request body hazırlama
        JsonPlaceRequestBodyPOJO reqBody = new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);
        //JsonPlaceRequestBodyPOJO class'ından request body obje oluşturularak kalıp haline geirilerek dinamik
        //hale gelir
        //burada request body java objesi olarak oluşturmuş olduk

        System.out.println("reqBody = " + reqBody);

        // 2 - Expected Data hazirla

        JsonPlaceRequestBodyPOJO expBody = new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        // 3 - Response'i kaydet

        Response response = given()
                                  .spec(specJsonPlace)
                                  .contentType(ContentType.JSON)
                            .when()
                                  .body(reqBody)
                                  .put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        //şimdiye kadar yaptıklarımız
        // JsonPath respJP = response.jsonPath();
        // HashMap<String,Object> respMap = response.as(HashMap.class);

        JsonPlaceRequestBodyPOJO respPojo =response.as(JsonPlaceRequestBodyPOJO.class);
        //dönen response'ı da pojo ile kalıplara dökmüş olduk JsonPlaceRequestBodyPOJO class'ı ile

        assertEquals( expBody.getTitle() ,respPojo.getTitle()   );
        assertEquals( expBody.getBody() ,respPojo.getBody()   );
        assertEquals( expBody.getId() ,respPojo.getId()   );
        assertEquals( expBody.getUserId() ,respPojo.getUserId()   );

    }
}
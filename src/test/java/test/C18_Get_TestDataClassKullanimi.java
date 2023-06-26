package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    /*

  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu (expected data) test ediniz

   Response body = Expected Body
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

        // 1 - Url hazirla (Get sorgusu olduğu için request body hazırlanmayacak)

        specJsonPlace.pathParams("pp1","posts","pp2",22);

        // 2 - Expected Data hazirla
        //response body'sinin verilen ile aynı olduğunu test edin denilince expected data hazırlanır

        //TestDataJsonPlace class'ındaki herhangi bir method veya objeye ulaşabilmek için test methodumuzda
        //o class'tan obje oluşturulur ve obje üzerinden de verilere ulaşılır
        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();

        JSONObject expData = testDataJsonPlace.expectedBodyOlusturJSON();
        //testDataJsonPlace class'ından expectedBodyOlusturJSON() methodu method call (method çağırma) yapılarak
        //method çağrılır, çağrılan method bize sonuç döndüreceği için direk kullanılamaz, çağrılan methodun
        //return type'ı (data türü) JSONObject'tir, call edilen methoddaki objeyi kullanabilmek için JSONObject
        //datasına sahip obje oluşturularak atama yapılır

        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(testDataJsonPlace.basariliStatusCode, response.getStatusCode());

        assertEquals(expData.get("userId"), respJP.get("userId"));
        assertEquals(expData.get("id"), respJP.get("id"));
        assertEquals(expData.get("title"), respJP.get("title"));
        assertEquals(expData.get("body"), respJP.get("body"));

    }

}
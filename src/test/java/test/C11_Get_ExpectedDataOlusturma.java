package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {

    /*
      https://jsonplaceholder.typicode.com/posts/22 url'ine
      bir GET request yolladigimizda (expected data) donen response body’sinin
      asagida verilen ile ayni oldugunu test ediniz

      Response body :
       {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut
         atque rem suscipit\nnam impedit esse"
       }
     */

    @Test
    public void get01(){

        // 1 - Url hazirla (Get sorgusu olduğu için request body yok, hazırlanmayacak)

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2 - Expected Data hazirla (GET request yolladigimizda)
        //expected data'nın API ile hiç bir ilgisi yok, sadece obje oluşturup yazdırıyoruz

        JSONObject expData = new JSONObject();

        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia" +
                    "molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println("expData = " + expData);

        // 3 - Response'i kaydet (API ile ilgilidir)

        Response response = given().when().get(url);//Get request olduğu için body ve pre conditions yok

        response.prettyPeek(); //prettyPrintten farkli olarak size response ile ilgili tum degerleri dondurur
        //yazdırma komutları yoruma alınır, testler yazıldıktan sonra kullanılmaz

        //konsolda iki çıktı olacak expected data ve response

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(expData.get("userId"), respJP.get("userId"));
        assertEquals(expData.get("id"), respJP.get("id"));
        assertEquals(expData.get("title"), respJP.get("title"));
        assertEquals(expData.get("body"), respJP.get("body"));

    }


}
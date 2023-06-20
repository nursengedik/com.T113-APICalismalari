package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C5_Get_ResponseBodyTesti {//GET REQUEST BODY BILGILERINI ASSERT YAPMA

    /*
       https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
       donen Response’in

            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sinde bulunan userId'nin 5,
            ve response body'sinde bulunan title'in "optio dolor molestias sit"

            oldugunu test edin.
    */


    @Test
    public void get01(){

        //1- Endpoint hazırla

        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //2- Expected Data hazırla (yok)

        //3- Response'i kaydet

        Response response = given().when().get(url);//get olduğu için body yok ve pre condition'a gerek yok

        response.prettyPrint();

        /*
          {
           "userId": 5,
           "id": 44,
           "title": "optio dolor molestias sit",
           "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
         }
         */ //manuel olarak test ettik

        response
                .then()
                      .assertThat()
                      .statusCode(200)
                      .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))//body'nin değerlerini test etme
                .body("title", Matchers.equalTo("optio dolor molestias sit"));//burada da otomatik
                                                                                       //olarak test ettik

    }
}

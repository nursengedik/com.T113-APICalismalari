package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {//otomasyon test


    /*
      https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
      gonderdigimizde donen Response’un,

      status code’unun 200,
      ve content type’inin application/json; charset=utf-8,
      ve Server isimli Header’in degerinin Cowboy,
      ve status Line’in HTTP/1.1 200 OK

      olduğunu test edin.
   */

    @Test
    public void get01(){

        //Request hazırlama

        //1- Url hazırla (Get sorgusu olduğu için body yok)
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Expected Data hazırla

        //3- Response (rispans) kaydet
        Response response = given().when().get(url);
        //dönen response'sı görmek istersek
        response.prettyPrint();//normalde api sorgularında response yazdırma satırı yoruma alınır

        //4- Assertion
        response
                .then()//then() methodu assertThat() methodunu sağlar
                     .assertThat()//assertThat() methodu response'ın temel bilgilerini assert ile test etmeyi sağlar
                     .statusCode(200).contentType("application/json; charset=utf-8")
                     .header("Server", "Cowboy")
                     .statusLine("HTTP/1.1 200 OK");








    }









}

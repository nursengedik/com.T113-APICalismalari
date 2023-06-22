package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    /*
       http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
       donen Response'in
            status code'unun 200,
            ve content type'inin application/json,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */

    @Test
    public void get01(){

        // 1 - Url hazirla

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        //Get sorgusu olduğu için request body hazırlamıyoruz (API bizden isterse göndeririz)

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().when().get(url);//request body olmadığı için content type (pre conditions)
                                                   //ve body() yok
        response.prettyPrint();

        // 4 - Assertion
        //dönen response'nin temel bilgilerini response üzerinden test edebiliriz
        //response objesi dönen response (rispans) sadece jsonPath formatında verebilir jsonObject olarak
        //vermiyor, response'ın body değerlerini jsonPath olarak doğrulayabiliyoruz
        //çünkü response jsonPath'i biliyor JsonObject'i bilmiyor

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id", hasSize(24),//data.id listesinin 24 tane id'si var mı
                        "data.employee_name", hasItem("Ashton Cox"),//data.employee_name isim listesinde
                        //Ashton Cox nesnesi (hasItem) var mi
                        "data.employee_age", hasItems(61,30,40));//data.employee_age yaş listesinde 61,30,40
                                                                //yaşları (hasItems=nesneleri) var mı
    }

    //JSONPath'de   https://jsonpath.com
    /*
     1- employees sayisinin 24
        data[.id   =   .body("data.id", hasSize(24)

     2- ve employee'lerden birinin "Ashton Cox"
        data[.employee_name = listedeki tüm isimleri getirir
        data[2].employee_name = "Ashton Cox" verir

        "data.employee_name", hasItem("Ashton Cox")  body() methodu ile

     3- ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu
        data[.employee_age = listedeki tüm yaşları döndürür

        "data.employee_age", hasItems(61,30,40)  body() methodu ile

     */

}
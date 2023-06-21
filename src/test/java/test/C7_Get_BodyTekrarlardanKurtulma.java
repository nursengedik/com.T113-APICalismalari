package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C7_Get_BodyTekrarlardanKurtulma {

    /*
      https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
      donen Response’un,

      status code’unun 200,
      ve content type’inin application/json; charset=utf-8,
      ve response body’sindeki
          "firstname“in, "Susan",
          ve "lastname“in, "Wilson",
          ve "totalprice“in, 613,
          ve "depositpaid“in, false,
          ve "additionalneeds“in, "Breakfast"

      oldugunu test edin

     */


    @Test
    public void get01(){

        //1- Url hazırla
        String url = " https://restful-booker.herokuapp.com/booking/10";

        //2- Expected Data hazırla (yok)

        //3- Response'ı kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        /* dönen response
           {
             "firstname": "Susan",
             "lastname": "Wilson",
             "totalprice": 613,
             "depositpaid": false,
             "bookingdates": {
                 "checkin": "2016-12-05",
                 "checkout": "2021-06-14"
           },
             "additionalneeds": "Breakfast"
           }
       */

        //4- Assertion

        /*response
                .then()
                      .assertThat()
                      .statusCode(200)
                      .contentType("application/json; charset=utf-8")
                      .body("firstname", Matchers.equalTo("Susan"),//firstname Susan'a eşit mi
                              "lastname", Matchers.equalTo("Wilson"),
                              "totalprice", Matchers.equalTo(613),
                              "depositpaid", Matchers.equalTo(false),
                              "additionalneeds", Matchers.equalTo("Breakfast"));

         //her bir key ve value değeri için ayrı ayrı body() methodunu yazmayıp hepsini
        //aynı body() methodnun içerisine yazacağız
        */

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Susan"),//firstname Susan'a eşit mi
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(613),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));

        //Sadece bir method kullanılacaksa Matchers'ı silerek equalTo() methodunu static olarak import ederiz
        //(import static org.hamcrest.Matchers.equalTo;) ve bu durumda her seferinde Matchers yazmak zorunda
        //kalmayız, ancak testte farklı methodlar kullanacaksak * koyarak bütün methodları import ederiz
        //(import static org.hamcrest.Matchers.*;) ama bu durum testimize yüktür, tek methodu import ederiz





    }

}

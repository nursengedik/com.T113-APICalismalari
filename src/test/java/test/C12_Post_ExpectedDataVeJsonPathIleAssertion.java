package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST (yeni bir rezervasyon cerate ediyoruz bu body ile)
    request gonderdigimizde donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void post01(){

        // 1 - Url ve Request Body hazirla (post request olduğu için body göndermek zorundayız)

        String url = "https://restful-booker.herokuapp.com/booking";

        /*Request body
                   {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
         */
        //request body'i obje oluşturarak hazırlayıp gönderiyoruz

        JSONObject bookingdates = new JSONObject();//önce içteki  jsonobjesi oluşturulur

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();//sonra dıştaki jsonobjesi oluşturulur

        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("additionalneeds" , "wi-fi");
        reqBody.put("bookingdates" , bookingdates);//"bookingdates" key'inin değeri yukarıda oluşturulan
                                                  //bookingdates objesidir

        //2- Expected Data hazırlama (Jsonobje olarak hazırlayacağız)

        /*
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                               }
                    }
         */

        //expected datanın içi yukarıda hazırladığımız request body ile aynı olduğu için burada tekrar
        //oluşturmuyoruz ve o objeleri burada kullanabiliyoruz
        JSONObject expData = new JSONObject();

        expData.put("bookingid",24);//body oluştururken "bookingid" oluşturulur ama "bookingid" test edilmez
                                   //çünkü "bookingid" sistem otomatik olarak veriyor, atama yapıyor, biz de
                                  //ön göremeyeceğimiz değeri test edemeyiz
        expData.put("booking", reqBody);//"booking" değeri request body'de hazırladığımız reqBody objesidir

        // 3 - Response kaydet

        Response response = given()                         //body gönderme durumunda formatımızı belirtmeliyiz
                                 .contentType(ContentType.JSON)//request body hazırladığımız için
                            .when()                           // pre conditions belirtmeliyiz
                                 .body(reqBody.toString())//request body'i toString() ile dönüştürerek göndeririz
                                 .post(url);

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();//öncelikle response'ı test edebileceğimiz formata sokuyoruz
                                             //yani jasonPath'e

        //expected datamız jsonobject olduğu için .getJSONObject() methodu kullanılır
        //expData.get("booking") bize booking'in tamamını getirir, booking'in içindeki değerleri test edebilmek
        //için expData.getJSONObject("booking").get("firstname"),
        //expected datada JsonObject'te methodlarla tek tek objelerin içerisine giriyoruz,
        //actual datada jsonPath'de ise değere ulaşma yolu noktalardır respJP.get("booking.firstname")

        //Assert import edilir
        assertEquals(expData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname") );
        assertEquals(expData.getJSONObject("booking").get("lastname"), respJP.get("booking.lastname") );
        assertEquals(expData.getJSONObject("booking").get("totalprice"), respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), respJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin") ,
                respJP.get("booking.bookingdates.checkin") );
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout") ,
                respJP.get("booking.bookingdates.checkout") );

    }




}
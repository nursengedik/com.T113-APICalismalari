package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerokuapp {

    public int basariliStatusCode = 200;

    /* Request body
        {
	      "firstname" : "Ali",
	      "lastname" : “Bak",
	      "totalprice" : 500,
	      "depositpaid" : false,
	      "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
	      "additionalneeds" : "wi-fi"
	       }
         */

    //içi içe oluşturulan nested JsonObject'leri için ayrı ayrı method oluşturmak daha kullanışlıdır

    public JSONObject bookingdatesOlusturJSON(){//sonuç döndüreceği için return type'ı JSONObject (void değil)

        JSONObject bookingdates = new JSONObject(); //bookingdates objesini sadece bu method içerisinde
                                                   //kullanabiliriz
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }

    public JSONObject bookingOlusturJSON(){//sonuç döndüreceği için return type'ı JSONObject

        JSONObject booking = new JSONObject();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500);
        booking.put("depositpaid" ,false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , bookingdatesOlusturJSON());

        //"bookingdates" key'inin değeri olarak bookingdates objesini kullanamayız, çünkü bookingdates objesinin
        //scope (kapsam veya geçerlilik alanı) bookingdatesOlusturJSON() methodu olduğu için başka bir methoddan
        //çağırıp kullanamayız,  bunun yerine "bookingdates" key'inin değeri olarak bookingdatesOlusturJSON()
        //methodunu call ederek (method çağırma) yukarıda oluşturduğumuz methodu başka bir methoddan çağırarak
        //iç içe Json objelerini tamamlamış oluyoruz
        //testimizi yaptığımız class'ta test methodunda key'in değeri olarak objeyi kullandığımız gibi
        //kullanamıyoruz

        return booking;
    }

    /* Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    public JSONObject expectedBodyOlusturJSON(){

        JSONObject expData = new JSONObject();

        expData.put("bookingid" , 24);
        expData.put("booking" , bookingOlusturJSON());

        return expData;
    }
    public HashMap bookingdatesMap(){

        HashMap<String,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }
    /*
         Request body
       {
            "firstname" : "Ali",
            "lastname" : "Bak",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                     "checkin" : "2021-06-01",
                     "checkout" : "2021-06-10"
                              },
            "additionalneeds" : "wi-fi"
        }
         */
    public HashMap reqBodyMap(){

        HashMap<String,Object> booking = new HashMap<>();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500.0);
        booking.put("depositpaid" , false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , bookingdatesMap());

        return booking;
    }
    /*
      Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
     */
    public HashMap expBodyMap(){

        HashMap<String,Object> expBody = new HashMap<>();

        expBody.put("bookingid" , 24);
        expBody.put("booking" , reqBodyMap());

        return expBody;
    }



}
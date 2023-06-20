package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    /*
      Asagidaki JSON Objesini olusturup konsolda yazdirin.

      {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
      }

   */

    @Test
    public void jsonObje01(){

        JSONObject ilkJsonObje = new JSONObject();//obje oluşturulur

        ilkJsonObje.put("title", "Ahmet");//put methodu ile obje içerisine istediğmiz değerler key ve value
        ilkJsonObje.put("body", "Merhaba");//şeklinde konulur
        ilkJsonObje.put("userId", 1);

        //görmek istediğimizde yazdırmalıyız
        System.out.println("Ilk Json Objemiz " + ilkJsonObje);

        //Konsolda
        //Ilk Json Objemiz {"title":"Ahmet","body":"Merhaba","userId":1} döndürür

        /*

           Düzenlediğimizde soruda istenilen hale gelir

          {
           "title":"Ahmet",
           "body":"Merhaba",
           "userId":1
          }

       */

    }


    @Test
    public void jsonObje02(){//içi içe json objesi oluşturma

        /*
           Asagidaki JSON Objesini olusturup konsolda yazdirin.

            {
              "firstname":"Jim",
              "additionalneeds":"Breakfast",
              "bookingdates":{
                              "checkin":"2018-01-01",
                              "checkout":"2019-01-01"
                             },
              "totalprice":111,
              "depositpaid":true,
              "lastname":"Brown"
            }
       */

        //önce içteki obje oluşturulur

        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        //sonra dıştaki obje oluşturulur
        JSONObject outerJson = new JSONObject();

        outerJson.put("firstname", "Jim");
        outerJson.put("additionalneeds", "Breakfast");
        outerJson.put("totalprice", 111);
        outerJson.put("depositpaid", true);
        outerJson.put("lastname", "Brown");
        outerJson.put("bookingdates", bookingDates);//"bookingdates" key'inin value değeri yukarıda
                                                   //oluşturduğumuz bookingDates objesidir

        System.out.println("Booking Json Objemiz : " + outerJson);

        //konsolda
        //Booking Json Objemiz : {"firstname":"Jim","additionalneeds":"Breakfast","bookingdates":
        // {"checkin":"2018-01-01","checkout":"2019-01-01"},"totalprice":111,"depositpaid":true,"lastname":"Brown"}

        //düzenlediğimizde
        /*
           {
             "firstname":"Jim",
             "additionalneeds":"Breakfast",
             "bookingdates":{
                             "checkin":"2018-01-01",
                             "checkout":"2019-01-01"
                            },
             "totalprice":111,
             "depositpaid":true,
             "lastname":"Brown"
           }

         */


    }





}

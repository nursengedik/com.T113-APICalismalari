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












}

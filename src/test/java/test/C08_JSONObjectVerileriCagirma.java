package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {

   /*
        JSONPath JSON verilerini okuma ve update etme fırsatı verir.
     Bir JSON objesinin icinde birden fazla data turunde primitive
     data veya obje bulunabilir.
     Ornegin yandaki JSON objesi incelenirse
     firstName -- String
     lastName -- String
     age -- Int

     Yandaki Json objesini olusturmak istedigimizde once address ve
     phoneNumbers objelerini olusturmali sonra bunlari asil Json
     objemize eklemeliyiz (sayfa 113)

     C8_JsonPathKullanimi
     address -- Json obje
     phoneNumbers ise icinde iki Json objesi olan bir arraydir

    */

    /* karmaşık (iç içe-nested) json objesi
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
                "streetAddress": "naist street",
                "city": "Nara",
                "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */


    @Test
    public void jsonObje01(){

        //önce içteki objeler oluşturulur
        //phoneNumbers body'sini hazırlamak için obje oluşturma

        /*
             {
               "type": "iPhone",
               "number": "0123-4567-8888"
              },
         */
        JSONObject cepTel = new JSONObject();

        cepTel.put("type", "iPhone");
        cepTel.put( "number", "0123-4567-8888");


        /*
          {
            "type": "home",
            "number": "0123-4567-8910"
          }
       */

        JSONObject evTel = new JSONObject();

        evTel.put("type", "home");
        evTel.put( "number", "0123-4567-8910");

        //Oluşturduğumuz objeleri Json array'ine koymalıyız
        JSONArray phoneNumbers = new JSONArray();//JSONArray oluşturduk

        phoneNumbers.put(0,cepTel);//Array'in içine objeleri put ile ekleyerek index ile koyuyoruz
        phoneNumbers.put(1,evTel);//Array bize index'le çalışma imkanı veriyor


        //address body'sini hazırlamak için obje oluşturma
        /*
        "address": {
                    "streetAddress": "naist street",
                    "city": "Nara",
                    "postalCode": "630-0192"
                   }
         */

        JSONObject address = new JSONObject();

        address.put("streetAddress", "naist street");
        address.put("city", "Nara");
        address.put("postalCode", "630-0192");

        //en dıştaki body hazırlamak için obje oluşturma
        JSONObject kisiBilgisi = new JSONObject();

        kisiBilgisi.put("firstName", "John");
        kisiBilgisi.put("lastName", "doe");
        kisiBilgisi.put("age", 26);
        kisiBilgisi.put("address", address);//address key'inin değeri yukarıda oluşturduğumuz address isimli
                                           //JSON objesi olacak
        kisiBilgisi.put("phoneNumbers", phoneNumbers);//phoneNumbers key'inin değeri yukarıda oluşturduğumuz
                                                     //phoneNumbers isimli JSON array'i olacak

        System.out.println("kisiBilgisi = " + kisiBilgisi);

        //konsolda
        //kisiBilgisi = {"firstName":"John","lastName":"doe","address":{"streetAddress":"naist street",
        // "city":"Nara","postalCode":"630-0192"},"age":26,"phoneNumbers":[{"number":"0123-4567-8888",
        // "type":"iPhone"},{"number":"0123-4567-8910","type":"home"}]}


        /*düzenlenmiş hali
        {
        "firstName":"John",
        "lastName":"doe",
        "address":{
                    "streetAddress":"naist street",
                    "city":"Nara",
                    "postalCode":"630-0192"
                    },
        "age":26,
        "phoneNumbers":[
                        {
                           "number":"0123-4567-8888",
                           "type":"iPhone"
                         },
                        {
                            "number":"0123-4567-8910",
                            "type":"home"
                         }
                        ]
          }
         */
        //path = yol
        //https://jsonpath.com

        //karmaşık Json objesi içindeki bilgileri yazdırma
        System.out.println("Isim : " + kisiBilgisi.get("firstName"));
        System.out.println("Soyisim : " + kisiBilgisi.get("lastName"));
        System.out.println("Yas : " + kisiBilgisi.get("age"));
        System.out.println("Sokak adi : " + kisiBilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("Sehir : " + kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("Posta kodu : " + kisiBilgisi.getJSONObject("address").get("postalCode"));
        System.out.println("Tel no : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number"));
        System.out.println("Tel turu : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("type"));
        System.out.println("Tel no : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("number"));
        System.out.println("Tel turu : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("type"));
    }

}












package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {//manuel test

    /*
      https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
      gonderdigimizde donen Response’un,

              status code’unun 200,
              ve content type’inin application/json; charset=utf-8,
              ve Server isimli Header’in degerinin Cowboy,
              ve status Line’in HTTP/1.1 200 OK
              ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
   */

    //1- Göndereceğimiz Request için gerekli olan URL ve ihtiyacımız varsa Request Body hazırla
    //2- Eğer soruda bize verilmişse Expected Data hazırla
    //3- Bize dönen Response'i Actual Data olarak kaydet
    //4- Expected Data ile Actual Datayı karşılaştırmamız yani Assertion yapmamız gerek

    @Test
    public void get01(){

        //1- Göndereceğimiz Request için gerekli olan URL ve ihtiyacımız varsa Request Body hazırla

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Eğer soruda bize verilmişse Expected Data hazırla

        //3- Bize dönen Response'i Actual Data olarak kaydet

        Response response =given().when().get(url);//dönen respon'sı objeye kaydettik
        //eğer respon'sı görmek istersek response objesini kullanarak yazdırırız
        response.prettyPrint();//yazdırmazsak hiçbir şey dönmez, yazdırma methodlarını testlerimizi
        //hazırlarken oluşturur sonra yoruma alırız çünkü yazdırma teste ağır yük bindirir

        System.out.println("Status Code : " +response.getStatusCode());//Status Code getirir
        System.out.println("Content Type : " +response.getContentType());
        System.out.println("Server Header Degeri : " +response.getHeader("Server"));
        System.out.println("Status Line : " +response.getStatusLine());
        System.out.println("Response Suresi : " +response.getTime());//getTime() ms olarak veriyor


        //4- Expected Data ile Actual Datayı karşılaştırmamız yani Assertion yapmamız gerek





    }

}

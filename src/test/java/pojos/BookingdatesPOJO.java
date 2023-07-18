package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //@Data notasyonu Getter, Setter ve toString'leri oluşturuyor
@NoArgsConstructor //parametresiz constructor'ları oluşturuyor
@AllArgsConstructor//tüm argümanları içeren constructor'ları oluşturuyor
public class BookingdatesPOJO {//iç body'nin pojo sunu oluşturma

    //pojo'ların otomatik olması için pom.xml'e org.projectlombok eklenir
    //yukarıdaki 3 notasyonu kullanarak pojo'yu kısa yoldan oluşturmuş olacağız
    //JsonPlaceRequestBodyPOJO class'ında olduğu gibi uzun uzun hazırlamaya gerek yok

    /*
     {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  }
     */

    private String checkin;
    private String checkout;


}
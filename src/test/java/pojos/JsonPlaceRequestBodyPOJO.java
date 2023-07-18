package pojos;

public class JsonPlaceRequestBodyPOJO {

    /*
     {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    //pojo hazırlarken sadece key değerleri ile ilgili hazırlıklar yapılır

    // 1 - Obje icerisindeki tum key degerlerini class levelda kabul ettiği değerde ve private
    //     variable olarak hazirlanır
    //     variable'ların değişmesini (değerleri değişebilir ama title'nin kendisi değişmez) istemiyorsak
    //     ve kullanacaksak private yapılır

    private String title;//isimleri birebir aynı olmalı
    private String body;
    private int userId;
    private int id;

    // 2 - Getter - Setter lari hazirla
    //Getter ile okuma, Setter ile değer atama yapabiliyoruz

    //sayfada iken sağ tıklanır ve Generate/Getter and Setter seçilir, Ctrl'ye basılı tutularak
    //tüm veriable'lar seçilir ve OK denir

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3 - Tum parametreleri iceren Constructor olustur

    //Constructor oluşturmak için Getter ve Setter'deki yol takip edilir sadece Generate/Constructor seçilir

    public JsonPlaceRequestBodyPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4 - Parametresiz Constructor olustur
    //bir class'ta parametreli constructor oluşturulduğunda default yani parametresiz constructor ölür
    //ihtiyacımız olacağı için burada tekrar oluşturulur
    //sağ tıkla/Generate/Constructor/Select None

    public JsonPlaceRequestBodyPOJO() {
    }

    // 5 - toString() methodu olustur
    //sağ tıkla/Generate/toString()/hepsi seçili olur ve OK tuşuna basılır

    @Override
    public String toString() {
        return "JsonPlaceRequestBodyPOJO{" +
                "title='" + title + '\'' + // {title='Ahmet', body='Merhaba' ,userId=70, id=3}
                ", body='" + body + '\'' +
                ", userId=" + userId +    //değeri int olduğu için tırnak kullanmıyoruz
                ", id=" + id +
                '}';
    }
}

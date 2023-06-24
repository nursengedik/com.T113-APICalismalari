package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseURL {

    protected RequestSpecification specJsonPlace;//class levelde obje oluşturup

    @Before
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder()//method içerisinde de atamasını yaparız
                .setBaseUri("https://jsonplaceholder.typicode.com")//url'in base url kısmını alırız
                .build();

    }


}

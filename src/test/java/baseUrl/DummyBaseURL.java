package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseURL {

    protected RequestSpecification specDummy;//RequestSpecification data type'lı specDummy objemizi oluşturup

    @Before
    public void setUp(){

        specDummy = new RequestSpecBuilder()//RequestSpecBuilder() constructor'ına sahip atamasını yapıyoruz
                .setBaseUri("http://dummy.restapiexample.com")
                .build();
    }




}
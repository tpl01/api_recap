package recap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C09_Map_Post {


    @Test
    public void map_Post() throws JsonProcessingException {

        String url = "https://petstore.swagger.io/v2/pet";

        String data="{\"id\":9898,\"category\":{\"id\":0,\"name\":\"Köpek\"},\"name\":\"Pamuk\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"Sibirya Kurdu\"}],\"status\":\"available\"}";

        Map<String,Object> payLoad=new ObjectMapper().readValue(data, HashMap.class);

        Response response=given().when().body(payLoad).contentType(ContentType.JSON).post(url);  //serialization
        Map<String,Object> actualData=response.as(HashMap.class);    //de-serialization


        Assert.assertEquals(payLoad.get("id"),actualData.get("id"));

    }
}

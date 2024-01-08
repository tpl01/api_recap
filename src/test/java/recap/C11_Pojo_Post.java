package recap;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C11_Pojo_Post {

    @Test
    public void pojo_Post() throws JsonProcessingException {
        String url="https://petstore.swagger.io/v2/pet/";

        String data ="{\"id\":9898,\"category\":{\"id\":0,\"name\":\"Köpek\"},\"name\":\"Pamuk\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"Sibirya Kurdu\"}],\"status\":\"available\"}";

       ResponsePojo payLoad= new ObjectMapper().readValue(data, ResponsePojo.class);

       Response response=given().when().get(url);

       ResponsePojo actualData=response.as(ResponsePojo.class);  //deserialization

        assertEquals(payLoad.getId(), actualData.getId());
        assertEquals(payLoad.getCategory().getId(), actualData.getCategory().getId());
        assertEquals(payLoad.getCategory().getName(), actualData.getCategory().getName());
        assertEquals(payLoad.getName(), actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().get(0).getId(), actualData.getTags().get(0).getId());
        assertEquals(payLoad.getTags().get(0).getName(), actualData.getTags().get(0).getName());
        assertEquals(payLoad.getStatus(), actualData.getStatus());

    }


}

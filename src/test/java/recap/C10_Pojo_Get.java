package recap;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.ResponsePojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C10_Pojo_Get {

    @Test
    public void pojo_Get() throws JsonProcessingException {
        String url="https://petstore.swagger.io/v2/pet/9898";

        String data ="{\"id\":9898,\"category\":{\"id\":0,\"name\":\"Köpek\"},\"name\":\"Pamuk\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"Sibirya Kurdu\"}],\"status\":\"available\"}";

       ResponsePojo expectedData= new ObjectMapper().readValue(data, ResponsePojo.class);

       Response response=given().when().get(url);

       ResponsePojo actualData=response.as(ResponsePojo.class);  //deserialization

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getCategory().getId(), actualData.getCategory().getId());
        assertEquals(expectedData.getCategory().getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(expectedData.getTags().get(0).getId(), actualData.getTags().get(0).getId());
        assertEquals(expectedData.getTags().get(0).getName(), actualData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(), actualData.getStatus());

    }


}

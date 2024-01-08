package recap;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C08_Map_GetList {

    @Test
    public void map_GetList() {
        String url="https://petstore.swagger.io/v2/pet/findByStatus?status=available";

        Response response=given().when().get(url);
        JsonPath json=response.jsonPath();

        List<Map> allList=json.getList("", Map.class);

        boolean idVarmi=false;
        for(Map w:allList){
            if(w.get("id").equals(9898)){
                idVarmi=true;
                break;
            }
        }
        Assert.assertTrue(idVarmi);

    }
}

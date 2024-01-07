package recap;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import  static org.hamcrest.Matchers.*;

public class C03_HamcrestMatchers_Post {

    @Test
    public void post() {
        // 1. Set the URL
        String url = "https://petstore.swagger.io/v2/pet";
        // 2. Set the expected data
        String payLoad = "{\n" +
                "  \"id\": 9898,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Köpek\"\n" +
                "  },\n" +
                "  \"name\": \"Pamuk\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Sibirya Kurdu\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        // 3. Send the request and get the response
        given().when().body(payLoad).contentType(ContentType.JSON).post(url);

        // 4. Do assertion

    }
}

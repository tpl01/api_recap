package recap;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class C01_HamcrestMatchers_Get {


/*
    Given
        https://petstore.swagger.io/v2/pet/9898
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        "name" şu metni içermeli: "Pamuk",
    And
        "status" değeri "available" olmalı
    And
        "category" altındaki "name" değeri "Köpek" olmalı
    And
        "tags" altındaki "name" değeri "Sibirya Kurdu" olmalı
 */

    @Test
    public void get() {
        //set the url
        //set the expected data
        //send the request and get the response
        //do assertion

        String url = "https://petstore.swagger.io/v2/pet/9898";
        given().when().get(url)
                .then()         //dogrulama icin

                .statusCode(200)                                              //rest assured
                .contentType(ContentType.JSON)                                   //rest assured
                .body("name", containsString("Pamuk"))                   //hamcrest matcher
                .body("status", equalTo("available"))
                .body("category.name", equalTo("Köpek"))
                .body("tags[0].name", equalTo("Sibirya Kurdu"))
                .body("tags.find{it.id==0}.name",equalTo("Sibirya Kurdu"))
                 //groovy language (list varsa)
                .header("Connection", "keep-alive")
                .log()
                .all();
    }
}

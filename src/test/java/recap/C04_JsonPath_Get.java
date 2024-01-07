package recap;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_JsonPath_Get {
    
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
    public void jsonPath_Get() {

        String url="https://petstore.swagger.io/v2/pet/9898";

        given().when().get(url).prettyPrint();
    }
}

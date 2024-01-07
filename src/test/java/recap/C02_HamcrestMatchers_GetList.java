package recap;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class C02_HamcrestMatchers_GetList {
    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        Listede id değeri 9898 olan bir eleman olmalı
    And
        Listede name değeri "Pamuk" olan bir eleman olmalı
    And
        Listede name değerleri "Pamuk", "doggie", "fish" olan elemanlar olmalı
    And
        Listede en az 200 tane eleman olmalı
    And
        Listede 1000'den az eleman olmalı
    And
        Listenin ilk elemanının category - id değeri 0 olmamalı
    And
        Listenin ilk elemanının photoUrls değeri "string" olmamalı
    And
        Listenin ilk elemanının tags - id değeri 0 olmamalı
 */

    @Test
    public void getList() {
        String url="https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        given().when().get(url)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", Matchers.hasItem(9898))
                .body("name",Matchers.hasItem("Pamuk"))
                .body("name",Matchers.hasItems("Pamuk","doggie","fish"))
                .body("id",hasSize(greaterThan(200)))
                .body("id",hasSize(lessThan(1000)))
                .body("[0].category.id",not(Matchers.equalTo(0)))
                .body("[0].photoUrls[0]", not(equalTo("string")))
                .body("[0].tags[0].id", not(equalTo(0)));
    }
}

package recap;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
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

        Response response=given().when().get(url);
        JsonPath json=response.jsonPath();
        // Response datasını JsonPath datasına dönüştürdüğümüzde sadece body kısmı json içerisine gelir.

        // JsonPath, json bir data içerisinde bir değişkenin değerini alıp, bir konteynıra koymamızı sağlar.
        int id= json.getInt("id");             //9898
        String name= json.getString("name");   //Pamuk

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("application/json",response.contentType());

        Assert.assertEquals(9898,json.getInt("id"));
        Assert.assertEquals("Pamuk",json.getString("name"));
        Assert.assertEquals("available",json.getString("status"));
        Assert.assertEquals("Köpek",json.getString("category.name"));
        Assert.assertEquals("Sibirya Kurdu",json.getString("tags[0].name"));

        //body içindeki datayi konteynira koyma gereği hissettiğimizde kullaniriz
        //list gelir ve bir degeri cekmek lazım oldugunda



    }
}

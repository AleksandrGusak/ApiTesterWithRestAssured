package org.example;
import io.restassured.RestAssured;
import org.junit.Before;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateJsonFile {

    @Before
    public void setUp () {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
            public void updateJsonFilesVasiliy () {

        File UpdateJsonFile = new File("/Users/aleksandgusak/IdeaProjects/ApiTester/src/main/resources/updateProfile.json");
        Response response = given()
                .header("Content-type", "application/json")
                .auth().oauth2("Введите сюда свой токен")
                .and()
                .body(UpdateJsonFile)
                .when()
                .patch("/api/users/me");
response.then().assertThat().statusCode(200).and()
        .body("data.name", equalTo("Василий Васильев"));
    }

}

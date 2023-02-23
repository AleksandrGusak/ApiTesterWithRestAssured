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

public class GoJsonFile {


    @Before
            public void setUp () {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test


    public void AddPostFile () {
     File jsonPost = new File("/Users/aleksandgusak/IdeaProjects/ApiTester/src/main/resources/newCard.json");
     Response response = given()
             .header("Content-Type","application/json")
                     .auth().oauth2("Введите сюда свой токен")
                     .and()
                             .body(jsonPost)
                                     .when()
                                             .post("/api/cards");
                response.then().assertThat().body("data._id", notNullValue()).and().statusCode(201);
    }

    @Test

    public void JsonPatchFile () {

        File jsonPatch = new File("/Users/aleksandgusak/IdeaProjects/ApiTester/src/main/resources/newCard.json");
        Response response = given()
                .header("Content-Type","application/json")
                .auth().oauth2("Введите сюда свой токен")
                .and()
                .body(jsonPatch)
                .when()
                .patch("/api/cards");
        response.then().assertThat().body("data._id", notNullValue()).and().statusCode(201);
    }


}

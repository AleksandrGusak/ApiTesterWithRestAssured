package org.example;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
import org.junit.*;

import static io.restassured.RestAssured.given;

public class Practikum {


@Before

    public void setUp() {

RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
}

@Test

    public void MyInfoStatusCode () {
    Response response = given()
            .auth()
            .oauth2("Введите сюда свой токен").get("/api/users/me");
    response.then().assertThat().body("data.name", equalTo("Жак-Ив Кусто"));
    System.out.println(response.body().asString());
}

    @Test

    public void MyInfoStatusCodeCard () {
     Response response = given().auth().oauth2("Введите сюда свой токен").get("api/users/me");
     response.then().statusCode(200);
     System.out.println(response.statusCode());
    }


    @Test
    public void ActivityClienResponce () {
    Response response = given().auth().oauth2("Введите сюда свой токен").get("data.about");
    response.then().assertThat().body("orderWeight", equalTo(11));
    System.out.println(response.body().asString());
    }


}




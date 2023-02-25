package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateJsonFile2 {

    @Before
            public void setUp () {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
            public void UdateJsonFileAfterObject () {

        Profile profile = new Profile("Василий Васильев", "Самый крутой исследователь");

        given()
                .header("Content-type", "application/json")
                       .auth().oauth2("Введите сюда свой токен")
                .and()
                .body(profile)
                .when()
                .patch("api/users/me")
                       .then().assertThat()
                       .statusCode(200);
    }

}
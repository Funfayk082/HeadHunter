package com.adventurer.webapp.steps;
import org.apache.catalina.connector.Response;

import java.awt.desktop.QuitResponse;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    public void getUserById(Long id) {
        Response response = (Response) given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/api/users/2")
                .then().assertThat()
                .statusCode(200);
    }
}

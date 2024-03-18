package com.bmg13.quarkus.example.controller;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FilmControllerTest {

    @Test
    void shouldReturnFilmCount() {
        given()
                .header(ACCEPT, MediaType.APPLICATION_JSON)
        .when()
                .get("/api/films")
        .then()
                .statusCode(200)
                .body("size()", is(3));
    }

    @Test
    void shouldReturnSpecificFilm() {
        given()
                .header(ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("title", "Dune Part 2")
        .when()
                .get("/api/films/{title}")
        .then()
                .statusCode(200)
                .body("author", is("Dennis Villenneuve"))
                .body("yearOfPublication", is(2024));
    }
}
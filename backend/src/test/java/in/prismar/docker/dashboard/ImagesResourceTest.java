package in.prismar.docker.dashboard;

import in.prismar.docker.dashboard.model.ImageDto;
import in.prismar.docker.dashboard.resource.ImagesResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@QuarkusTest
@TestHTTPEndpoint(ImagesResource.class)
public class ImagesResourceTest {

    @Inject
    LocalImagesService service;

    @BeforeEach
    public void setup() {
        service.getImages().clear();

        ImageDto dto = new ImageDto();
        dto.setId("Test");
        service.getImages().add(dto);
    }

    @Test
    public void testGetAll() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body("isEmpty()", is(false));
    }

    @Test
    public void testGet() {
        given()
                .when().get("/Test")
                .then()
                .statusCode(200)
                .body("id", is("Test"));
    }

    @Test
    public void testDelete() {
        given()
                .when().delete("/Test")
                .then()
                .statusCode(204);
    }


}

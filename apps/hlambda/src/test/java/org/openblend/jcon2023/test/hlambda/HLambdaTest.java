package org.openblend.jcon2023.test.hlambda;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openblend.jcon23.hlambda.PriceDto;

import static io.restassured.RestAssured.given;

/**
 * @author Ales Justin
 */
@QuarkusTest
public class HLambdaTest {
    @Test
    public void testRest() {
        PriceDto dto = given()
            .contentType("application/json")
            .accept("application/json")
            .body(new PriceDto(123.0))
            .when()
            .post("/")
            .then()
            .statusCode(200)
            .extract()
            .as(PriceDto.class);
        Assertions.assertEquals(150.06, dto.getPrice());
    }
}

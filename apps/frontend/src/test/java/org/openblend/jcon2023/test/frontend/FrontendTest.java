package org.openblend.jcon2023.test.frontend;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * @author Ales Justin
 */
@QuarkusTest
@QuarkusTestResource(value = FrontendTestResource.class, restrictToAnnotatedClass = true)
public class FrontendTest {
    @Test
    public void pokeRest() {
        RestAssured.get("/prices/poke?name=JCon2023")
            .then()
            .body(Matchers.equalTo("Hello JCon2023"));
    }

}

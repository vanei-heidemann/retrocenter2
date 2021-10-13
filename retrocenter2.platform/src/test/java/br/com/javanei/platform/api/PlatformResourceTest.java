package br.com.javanei.platform.api;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import br.com.javanei.platform.api.vo.PlatformVO;

@QuarkusTest
public class PlatformResourceTest {
    @Test
    public void findById() {
        given()
            .when().get("/api/v1/platforms/1")
            .then()
            .assertThat()
            .statusCode(200)
            .body("id", equalTo(1));
    }

    @Test
    public void findPageSize10() {
        given()
            .when().get("/api/v1/platforms?page=0&pageSize=10")
            .then()
            .assertThat()
            .statusCode(200)
            .body("platforms.size()", is(10));
    }

    @Test
    public void findPageSize20Start10() {
        given()
            .when().get("/api/v1/platforms?page=10&pageSize=20")
            .then()
            .assertThat()
            .statusCode(200)
            .body("platforms.size()", is(20));
    }

    @Test
    public void create() {
        PlatformVO vo = new PlatformVO().setId(1l).setName("Arcade");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(vo)
            .when().post("/api/v1/platforms")
            .then()
            .assertThat()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("name", equalTo("Arcade"));
            ;
    }
}

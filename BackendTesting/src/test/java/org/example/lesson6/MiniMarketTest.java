package org.example.lesson6;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.val;
import net.javacrumbs.jsonunit.JsonAssert;
import org.example.api.ApiAddNewProductRequest;
import org.example.api.ApiAddShoppingListRequest;
import org.example.api.ApiUserConnectResult;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readAllBytes;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MiniMarketTest {

    private static Integer idForRemove;


    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";
    }

    @Test
    @Order(1)
    void addNewProduct() {
        ApiAddNewProductRequest request = ApiAddNewProductRequest.builder()
                .title("Cake")
                .price(100)
                .categoryTitle("Food")
                .build();
        String actually = given()
                .body(request)
                .expect()
                .log()
                .all()
                .when()
                .post ("/api/v1/products")
                .asPrettyString();

        idForRemove = JsonPath.given(actually).get("id");

        String expected = readResourceAsString("AddNewProduct/expected.json");
        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }

    @Test
    @Order(2)
    void checkDeleteNewProduct(){
        given()
                .pathParam("id", 1368)
                .expect()
                .log()
                .all()
                .statusCode(404)
                .when()
                .get("/api/v1/products/{id}");

    }


    public String readResourceAsString(String resourceName) {
        String path = getClass().getSimpleName() + FileSystems.getDefault().getSeparator() + resourceName;
        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            assert inputStream != null;
            byte[] data = readAllBytes((Paths.get(path)));
            return new String(data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

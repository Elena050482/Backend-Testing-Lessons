package org.example.lesson4;

import io.restassured.path.json.JsonPath;
import net.javacrumbs.jsonunit.JsonAssert;
import org.example.api.ApiAddShoppingListRequest;

import org.example.api.ApiUserConnectResult;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingListTest extends BaseApiTest {

    private static ApiUserConnectResult userData;
    private static Integer idForRemove;



    @Test
    @Order(1)
    void connectUser() {
        userData = given()
                .body("{}")
                .expect()
                .log()
                .all()
                .statusCode(200)
                .body("status", is ("success"))
                .body("username", notNullValue())
                .body("hash", notNullValue())
                .when()
                .post("/users/connect")
                .as(ApiUserConnectResult.class);

    }

    @Test
    @Order(2)
    void getEmptyItems() {
        String actually = given()
                .pathParam("username", userData.getUsername())
                .queryParam("hash", userData.getHash())
                .expect()
                .log()
                .all()
                .when()
                .get ("/mealplanner/{username}/shopping-list")
                .asPrettyString();

        String expected = readResourceAsString("getEmptyItems/expected.json");
        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );

    }

    @Test
    @Order(3)
    void addItemsToShoppingList() {
        ApiAddShoppingListRequest request = ApiAddShoppingListRequest.builder()
                .item("1 bag of oranges")
                .aisle("orange")
                .parse(true)
                .build();
        String actually = given()
                .pathParam("username", userData.getUsername())
                .queryParam("hash", userData.getHash())
                .body(request)
                .expect()
                .log()
                .all()
                .when()
                .post ("/mealplanner/{username}/shopping-list/items")
                .asPrettyString();

        idForRemove = JsonPath.given(actually).get("id");

        String expected = readResourceAsString("addItemsToShoppingList/expected.json");
        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }

    @Test
    @Order(3)
    void deleteItem() {
        given()
                .pathParam("username", userData.getUsername())
                .pathParam("id",idForRemove)
                .queryParam("hash", userData.getHash())
                .expect()
                .log()
                .all()
                .when()
                .delete("/mealplanner/{username}/shopping-list/items/{id}");

        getEmptyItems();
    }

}

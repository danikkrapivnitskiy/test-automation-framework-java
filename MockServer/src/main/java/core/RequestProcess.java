package core;

import api.Specification;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestProcess {

    public Response getMethod(Object id, String url) {
        return Specification.sendGetRequest(url, new HashMap<>(Map.of(DBConfiguration.ID.getQuery(), id)))
                .then().extract().response();
    }

    public Response postMethod(String requestBody, String url) {
        return given()
                .body(requestBody)
                .when()
                .post(url)
                .then().extract().response();
    }

    public Response patchMethod(String requestBody, Object id, String url) {
        return given()
                .body(requestBody)
                .queryParam(DBConfiguration.ID.getQuery(), id)
                .when()
                .patch(url)
                .then().extract().response();
    }

    public Response deleteMethod(Object id, String url) {
        return Specification.sendDeleteRequest(url, Map.of(DBConfiguration.ID.getQuery(), id))
                .then().extract().response();
    }
}

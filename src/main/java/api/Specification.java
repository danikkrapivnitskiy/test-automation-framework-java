package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Specification {
    public static RequestSpecification requestSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpecOK200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responseSpecError400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
    public static ResponseSpecification responseSpec(int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }
    public static void installSpecification(RequestSpecification requestSpec, ResponseSpecification responseSpec){
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    public static void installSpecification(RequestSpecification requestSpec){
        RestAssured.requestSpecification = requestSpec;
    }
    public static void installSpecification(ResponseSpecification responseSpec){
        RestAssured.responseSpecification = responseSpec;
    }

    private static Response sendRequest(Method method, String path, Map<String, Object> queryParams, Map<String, Object> body) {
        return given()
                .queryParams(queryParams)
                .body(body)
                .request(method, path);
    }

    public static Response sendGetRequest(String path, Map<String, Object> queryParams) {
        return sendRequest(Method.GET, path, queryParams, new HashMap<>());
    }

    public static Response sendPostRequest(String path, Map<String, Object> body) {
        return sendRequest(Method.POST, path, new HashMap<>(), body);
    }

    public static Response sendPutRequest(String path, Map<String, Object> body) {
        return sendRequest(Method.PUT, path, new HashMap<>(), body);
    }

    public static Response sendDeleteRequest(String path) {
        return sendRequest(Method.DELETE, path, new HashMap<>(), new HashMap<>());
    }

}


package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j(topic = "|Specification|")
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

    public static Response sendGetRequest(String path, Map<String, Object> queryParams) {
        log.info(String.format("Send GET request to %s with params %s ", path, queryParams.values()));
        return given()
                .params(queryParams)
                .request(Method.GET, path);
    }

    public static Response sendPostRequest(String path, Map<String, Object> body) {
        log.info(String.format("Send POST request to %s with body %s", path, body));
        return given()
                .body(body)
                .request(Method.POST, path);
    }

    public static Response sendPutRequest(String path, Map<String, Object> body) {
        log.info(String.format("Send PUT request to %s with body %s", path, body));
        return given()
                .body(body)
                .request(Method.PUT, path);
    }

    public static Response sendPatchRequest(String path,Map<String, Object> queryParams, Map<String, Object> body) {
        log.info(String.format("Send PATCH request to %s with body %s and params %s", path, body, queryParams));
        return given()
                .queryParams(queryParams)
                .body(body)
                .request(Method.PATCH, path);
    }

    public static Response sendDeleteRequest(String path, Map<String, Object> queryParams) {
        log.info(String.format("Send DELETE request to %s with params %s ", path, queryParams.values()));
        return given()
                .queryParams(queryParams)
                .request(Method.DELETE, path);
    }

}


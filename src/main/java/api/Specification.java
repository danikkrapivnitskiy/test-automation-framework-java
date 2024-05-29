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

    private static Response sendRequest(Method method, String path, Map<String, Object> queryParams, Map<String, Object> body) {
        log.info(String.format("Send %s request to %s with params %s and body %s",
                method.toString(), path, queryParams.values(), body));
        RequestSpecification requestSpec = given();

        if (!queryParams.isEmpty()) {
            requestSpec.queryParams(queryParams);
        }

        if (body != null) {
            requestSpec.body(body);
        }

        return requestSpec.request(method, path);
    }

    public static Response sendGetRequest(String path, Map<String, Object> queryParams) {
        return sendRequest(Method.GET, path, queryParams, null);
    }

    public static Response sendPostRequest(String path, Map<String, Object> body) {
        return sendRequest(Method.POST, path, null, body);
    }

    public static Response sendPutRequest(String path, Map<String, Object> body) {
        return sendRequest(Method.PUT, path, null, body);
    }

    public static Response sendDeleteRequest(String path) {
        return sendRequest(Method.DELETE, path, null, null);
    }

}


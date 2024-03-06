package api.book;

import db.DbConnection;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import static api.book.DBConfiguration.DB;
import static api.book.DBConfiguration.SELECT;

@Slf4j(topic = "|Response processing|")
public class ResponseProcess {
    DbConnection dbConnection = new DbConnection();

    public void assertResponseEquals(Response response, Integer expectedStatusCode, String expectedValue) {
        log.info("Response validation");
        checkStatusCode(response, expectedStatusCode);
        if (expectedValue == null || expectedValue.matches("\\d+")) {
            checkBodyFromSql(response, expectedValue);
        } else checkBodyByExpectedValue(response, expectedValue);
    }
    public void checkStatusCode(Response response, Integer expectedStatusCode) {
        log.info("Check expected code");
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status codes are not equals");
    }
    public void checkBodyFromSql(Response response, String id) {
        log.info("Check body from SQL");
        String expectedBody = dbConnection.returnDbInJson(DB.getQuery(), id, SELECT.getQuery());
        Assert.assertEquals(response.getBody().asString(), expectedBody, "Body are not equals");
    }
    private void checkBodyByExpectedValue(Response response, String expectedValue) {
        log.info("Check body expected value");
        Assert.assertEquals(response.getBody().asString(), expectedValue, "Body are not equals");
    }

}

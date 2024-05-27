package mockServerBook;

import mockServerBook.db.DbConnection;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mockserver.integration.ClientAndServer;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;
import static org.mockserver.model.MediaType.APPLICATION_JSON;

@Slf4j(topic = "|Mock server|")
public class MockServer {
    private final ClientAndServer mockServerClient;
    DbConnection dbConnection = new DbConnection();

    public static final String BOOK_ID = "1";
    private static final String BOOK_URL = "/book";
    private static final String CONTENT_TYPE = "Content-Type";

    public MockServer() {
        log.info("Creating mock server");
        mockServerClient = startClientAndServer(1080);
    }

    public void closeConnection() {
        log.info("Closing mock server");
        mockServerClient.close();
    }

    /**
     * Creating requests for mock server
     */
    @SneakyThrows
    public void createMockServerForSelect() {
        getSpecificMockServer(BOOK_ID, dbConnection.returnDbInJson(DBConfiguration.DB.getQuery(), BOOK_ID, DBConfiguration.SELECT.getQuery()));
        getAllMockServer(dbConnection.returnDbInJson(DBConfiguration.DB.getQuery(), null, DBConfiguration.SELECT.getQuery()));
    }

    public void createMockServerPostMethod() {
        postMockServer(DBConfiguration.CREATE_BODY.getQuery(), dbConnection.addObjectToSql().returnDbInJson(DBConfiguration.DB.getQuery(), "5", DBConfiguration.SELECT.getQuery()));
    }

    public void createMockServerPatchMedhod() {
        updateMockServer("id", "5", DBConfiguration.UPDATE_BODY.getQuery(), dbConnection.updateObjectToSql().returnDbInJson(DBConfiguration.DB.getQuery(), "5", DBConfiguration.SELECT.getQuery()));
    }

    public void createMockServerDeleteMethod() {
        deleteMockServer("id", "5", dbConnection.removeObjectFromSql().getMessage());
    }

    private void getSpecificMockServer(String id, String responseBody) {
        mockServerClient.when(
                request()
                        .withMethod("GET")
                        .withPath(BOOK_URL)
                        .withQueryStringParameter(DBConfiguration.ID.getQuery(), id)
        ).respond(
                response()
                        .withStatusCode(200)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
                        .withBody(responseBody)
        );
    }

    private void getAllMockServer(String responseBody) {
        mockServerClient.when(
                request()
                        .withMethod("GET")
                        .withPath("/allBooks")
        ).respond(
                response()
                        .withStatusCode(200)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
                        .withBody(responseBody)
        );
    }
    public void postMockServer(String requestBody, String responseBody) {
        mockServerClient.when(
                request()
                        .withMethod("POST")
                        .withPath(BOOK_URL)
                        .withBody(json(requestBody))
        ).respond(
                response()
                        .withStatusCode(201)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
                        .withBody(responseBody)
        );
    }

    private void deleteMockServer(String parameter, String value, String responseBody) {
        mockServerClient.when(
                request()
                        .withMethod("DELETE")
                        .withPath(BOOK_URL)
                        .withQueryStringParameter(parameter, value)
        ).respond(
                response()
                        .withStatusCode(202)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
                        .withBody(responseBody)
        );
    }

    private void updateMockServer(String parameter, String value, String requestBody, String responseBody) {
        mockServerClient.when(
                request()
                        .withMethod("PATCH")
                        .withPath(BOOK_URL)
                        .withQueryStringParameter(parameter, value)
                        .withBody(requestBody)
        ).respond(
                response()
                        .withStatusCode(200)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
                        .withBody(responseBody)
        );
    }
}

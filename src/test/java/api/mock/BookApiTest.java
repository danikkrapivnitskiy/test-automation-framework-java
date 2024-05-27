package api.mock;

import mockServerBook.MockServer;
import mockServerBook.RequestProcess;
import mockServerBook.ResponseProcess;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static mockServerBook.DBConfiguration.*;

class BookApiTest {

    private MockServer server;
    private final RequestProcess request = new RequestProcess();
    private final ResponseProcess responseProcess = new ResponseProcess();
    private static final String BOOK_ID_ONE = "1";
    private static final String BOOK_URL = "/book";
    private static final String ALL_BOOK_URL = "/allBooks";
    private static final Object BOOK_ID_FIVE = 5;
    private static final String EXPECTED_MESSAGE = "Query is successful";

    @BeforeEach
    void startMockServer() {
        if (server == null) {
            server = new MockServer();
        }
    }

    @ParameterizedTest
    @MethodSource("booksApiParams")
    void retrieveBookDetails(String url, Integer code) {
        server.createMockServerForSelect();
        Response response = request.getMethod(BOOK_ID_ONE, url);

        if (url.equals("/allBooks")) {
            responseProcess.assertResponseEquals(response, code, null);
        } else responseProcess.assertResponseEquals(response, code, BOOK_ID_ONE);
    }
    private static Stream<Arguments> booksApiParams() {
        return Stream.of(
                Arguments.of(BOOK_URL, 200),
                Arguments.of(ALL_BOOK_URL, 200)
        );
    }

    @Test
    @Order(1)
    void addNewBook() {
        server.createMockServerPostMethod();
        Response response = request.postMethod(CREATE_BODY.getQuery(), BOOK_URL);
        responseProcess.assertResponseEquals(response, 201, "5");
    }

    @Test
    @Order(2)
    void updateBook() {
        server.createMockServerPatchMedhod();
        Response responsePatch = request.patchMethod(UPDATE_BODY.getQuery(), BOOK_ID_FIVE, BOOK_URL);
        responseProcess.assertResponseEquals(responsePatch, 200, "5");
    }

    @Test
    @Order(3)
    void removeBook() {
        server.createMockServerDeleteMethod();
        Response responseDelete = request.deleteMethod(BOOK_ID_FIVE, BOOK_URL);
        responseProcess.assertResponseEquals(responseDelete, 202, EXPECTED_MESSAGE);
    }

    @AfterEach()
    void verifyAndCloseConnection() {
        server.closeConnection();
    }
}

package openLibriaryPages.api;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j(topic = "|SearchApi|")
public class SearchApi {
    private static final String baseUrl = "https://openlibrary.org/search.json";
    BooksResponse booksResponse = new BooksResponse();

    @SneakyThrows
    public Object getAuthorByBookAndYear(String title, int publishYear) {
        Map<String, Object> bookAndYear = new HashMap<>();
        bookAndYear.put("title", title);
        bookAndYear.put("publish_year", publishYear);
        List<BooksResponse> response = getResponse(bookAndYear);
        return getObjectFromResponse(response, response.get(0).getAuthor_name().get(2));
    }

    private List<BooksResponse> getResponse(Map<String, Object> params) {
        log.info("Send API request by params: " + params.values());
        Specification.requestSpec(baseUrl);
        return given()
                .params(params)
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("docs", BooksResponse.class);
    }

    private Object getObjectFromResponse(List<BooksResponse> response, Object getObjectFromResponse) {
        log.info("Check if the response is correct");
        if (!response.isEmpty()) {
            return getObjectFromResponse;
        } else {
            System.out.println("Failed to fetch search results. Response code: ");
        }
        return null;
    }

    @SneakyThrows
    private String getAnnotationNameOfField(String filed) {
        return BooksResponse.class.getField(filed).getAnnotation(CompareFlag.class).value();
    }
}

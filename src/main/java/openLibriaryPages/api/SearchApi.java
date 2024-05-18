package openLibriaryPages.api;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j(topic = "|SearchApi|")
public class SearchApi {
    private static final String baseUrl = "https://openlibrary.org/search.json";

    public Object getAuthorByBookAndYear(String title, int publishYear) {
        Map<String, Object> bookAndYear = new HashMap<>();
        bookAndYear.put("title", title);
        bookAndYear.put("publish_year", publishYear);
        List<Pojo> response = getResponse(bookAndYear);
        return getObjectFromResponse(response, response.get(0).getAuthor_name().get(0));
    }

    private List<Pojo> getResponse(Map<String, Object> params) {
        log.info("Send API request by params: " + params.values());
        return given()
                .params(params)
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("docs", Pojo.class);
    }

    private Object getObjectFromResponse(List<Pojo> response, Object getObjectFromResponse) {
        log.info("Check if the response is correct");
        if (!response.isEmpty()) {
            return getObjectFromResponse;
        } else {
            System.out.println("Failed to fetch search results. Response code: ");
        }
        return null;
    }
}

package openLibriaryPages.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "|SearchApi|")
public class SearchApi {
    private static final String baseUrl = "https://openlibrary.org/search.json";
    private static final String getAuthorFromJson = "docs[0].author_name[0]";

    public String getAuthorByBookAndYear(String title, int publishYear) {
        Response response = getResponse(title, publishYear);
        return getObjectFromResponse(response, getAuthorFromJson);
    }

    private Response getResponse(String title, int publishYear) {
        log.info("Send API request by params: title '" + title + "', publishYear '" + publishYear + "'");
        return RestAssured.given()
                .param("title", title)
                .param("publish_year", publishYear)
                .get(baseUrl);
    }

    private String getObjectFromResponse(Response response, String jsonPath) {
        log.info("Check if the response is correct");
        if (response.getStatusCode() == 200) {
            return response.jsonPath().getString(jsonPath);
        } else {
            System.out.println("Failed to fetch search results. Response code: " + response.getStatusCode());
        }
        return null;
    }
}

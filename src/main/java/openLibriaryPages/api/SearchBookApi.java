package openLibriaryPages.api;

import api.Specification;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j(topic = "|SearchBookApi|")
public class SearchBookApi {
    private static final String BASE_URL = "https://openlibrary.org/search.json";

    @SneakyThrows
    public Object getAuthorByBookAndYear(String title, int publishYear) {
        Map<String, Object> bookAndYear = new HashMap<>();
        bookAndYear.put("title", title);
        bookAndYear.put("publish_year", publishYear);
        List<BooksResponse> response = getBooksResponse(bookAndYear);
        return getAuthorByParams(response, bookAndYear);
    }

    private List<BooksResponse> getBooksResponse(Map<String, Object> params) {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpecOK200());
        return Specification.sendGetRequest(BASE_URL, params)
                .then()
                .extract().body().jsonPath().getList("docs", BooksResponse.class);
    }

    private Object getAuthorByParams(List<BooksResponse> response, Map<String, Object> params) {
        log.info("Check if the response is correct");
        Optional<String> author = response.stream()
                .filter(item -> item.getTitle().equals(params.get("title")) &&
                        item.getPublish_year().contains(params.get("publish_year")))
                .findFirst()
                .map(item -> item.getAuthor_name().get(0));

        if (author.isPresent()) {
            return author.get();
        } else {
            log.error("Failed to fetch search results.");
            return null;
        }
    }
}

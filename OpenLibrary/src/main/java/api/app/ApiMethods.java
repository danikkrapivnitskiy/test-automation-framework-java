package api.app;

import api.Specification;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j(topic = "|ApiMethods|")
public class ApiMethods extends Specification {
    protected List<BooksResponse> getListOfBooksByParams(Map<String, Object> params) {
        log.info("Get list of books by params: " + params);
        return Specification.sendGetRequest("", params)
                .then()
                .extract().body().jsonPath().getList("docs", BooksResponse.class);
    }

    protected Object getAuthorByTitleAndYear(List<BooksResponse> response, Map<String, Object> params) {
        log.info("Get author by params: " + params);
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

package api.businessLogic;

import api.mainLogic.ApiMethods;
import api.mainLogic.BooksResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j(topic = "|SearchBookApi|")
public class SearchBookApi extends ApiMethods {

    @SneakyThrows
    public Object getAuthorByBookAndYear(String title, int publishYear) {
        Map<String, Object> bookAndYear = new HashMap<>();
        bookAndYear.put("title", title);
        bookAndYear.put("publish_year", publishYear);
        List<BooksResponse> response = getListOfBooksByParams(bookAndYear);
        return getAuthorByTitleAndYear(response, bookAndYear);
    }
}

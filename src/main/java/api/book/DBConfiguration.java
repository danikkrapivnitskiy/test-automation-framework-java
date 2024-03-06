package api.book;

import lombok.Getter;

@Getter
public enum DBConfiguration {
    SQL("bookTest.sqlite"),
    DB("book"),
    SELECT("SELECT * FROM "),
    DELETE("DELETE "),
    ID("id"),
    TITLE("title"),
    AUTHOR("author"),
    ISBN("isbn"),
    BOOK_ID("1"),
    CREATE_BODY("""
                {
                    "id": 5,
                    "title": "The Great Gatsby",
                    "author": "F. Scott Fitzgerald",
                    "isbn": 9780141182636
                }"""),
    UPDATE_BODY("""
                {
                    "title": 1984,
                    "author": "George Orwell",
                    "isbn": 9780060936228
                }""");

    private final String query;

    DBConfiguration(String query) {
        this.query = query;
    }

}

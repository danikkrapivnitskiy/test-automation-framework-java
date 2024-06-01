package mockServer.db;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import project.support.listeners.ListenerAllureJunit;
import projects.mockServerBook.db.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
@ExtendWith(ListenerAllureJunit.class)
public class UnitDbTest {
    static DbConnection dbConnection = new DbConnection();
    @BeforeAll
    public static void startConnection() {
        dbConnection.connect();
    }
    @AfterAll
    public static void closeDbConnection() {
        dbConnection.disconnect();
    }
    @Test
    void unitTest() throws SQLException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM book");
        Assertions.assertTrue(resultSet.next(), "Result set should not be empty.");
    }
}

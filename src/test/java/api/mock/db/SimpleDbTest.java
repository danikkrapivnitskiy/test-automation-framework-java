package api.mock.db;
import mockServerBook.db.DbConnection;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleDbTest {
    DbConnection dbConnection = new DbConnection();
    @BeforeClass
    public void startConnection() {
        dbConnection.connect();
    }
    @AfterClass
    public void closeDbConnection() {
        dbConnection.disconnect();
    }
    @Test
    void unitTest() throws SQLException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM book");
        Assert.assertTrue(resultSet.next(), "Result set should not be empty.");
    }
}

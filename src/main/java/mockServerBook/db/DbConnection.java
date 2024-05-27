package mockServerBook.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import static mockServerBook.DBConfiguration.*;

@Slf4j(topic = "|DB connection|")
public class DbConnection {
    protected String connectionString;
    protected Connection connection;
    public DbConnection() {
        connectionString = "jdbc:sqlite:src/main/java/db/" + SQL.getQuery();
    }

    /**
     * Connect to DB
     */
    public void connect() {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
    @SneakyThrows
    public void disconnect() {
        if (connection != null) {
            connection.close();
        }
    }
    private void execute(String sql) {
        if (connection == null) {
            connect();
        }
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Get result from DB
     * @param sql - request
     * @return set from query
     */
    @SneakyThrows
    public ResultSet executeQuery(String sql) {
        if (connection == null) {
            connect();
        }
        Statement statement = connection.createStatement();
        log.info("Request to table : '" + sql + "'");
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    /**
     * Method for retunring JSON object from DB with parameters
     * @param db - SQL DB
     * @param id - parameter
     * @return
     */
    @SneakyThrows
    public String returnDbInJson(String db, String id, String method) {
        Map<String, String> variables = getData(executeQuery(getQuery(db, id, method)));
        return new ObjectMapper().writeValueAsString(variables);
    }

    @SneakyThrows
    public DbConnection addObjectToSql() {
        execute("INSERT INTO " + DB.getQuery() +
                " (" + ID.getQuery() + ", " + TITLE.getQuery() + ", " + AUTHOR.getQuery() + ", " + ISBN.getQuery() +
                ") VALUES (5, 'The Great Gatsby', 'F. Scott Fitzgerald', 9780141182636);");
        return this;
    }

    @SneakyThrows
    public DbConnection removeObjectFromSql() {
        execute("DELETE FROM " + DB.getQuery() + " WHERE " + ID.getQuery() + " = 5;");
        return this;
    }

    @SneakyThrows
    public DbConnection updateObjectToSql() {
        execute("UPDATE  " + DB.getQuery() + " SET "
                + TITLE.getQuery() + " = '1984', " + AUTHOR.getQuery() + " = 'George Orwell', " + ISBN.getQuery()  + " = 9780060936228 "
                + " WHERE " + ID.getQuery() + " = 5;");
        return this;
    }

    public String getMessage() {
        return "Query is successful";
    }

    @SneakyThrows
    private Map<String, String> getData(ResultSet resultSet) {
        Map<String, String> variables = new LinkedHashMap<>();
        while (resultSet.next()) {
            variables.put(ID.getQuery() + resultSet.getRow(), resultSet.getString(ID.getQuery()));
            variables.put(TITLE.getQuery() + resultSet.getRow(), resultSet.getString(TITLE.getQuery()));
            variables.put(AUTHOR.getQuery() + resultSet.getRow(), resultSet.getString(AUTHOR.getQuery()));
            variables.put(ISBN.getQuery() + resultSet.getRow(), resultSet.getString(ISBN.getQuery()));
        }
        return variables;
    }

    private String getQuery(String db, String id, String method) {
        String query;
        if (id != null && method.equals(DELETE.getQuery())) {
            query = method + db + " WHERE id = " + id;
        } else if (id != null && method.equals(SELECT.getQuery())) {
            query = method + db + " WHERE id = " + id;
        } else {
            query = method + db;
        }
        log.info("Query to DB : '" + query + "'");
        return query;
    }
}

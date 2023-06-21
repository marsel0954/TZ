import dataBase.Connection;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseTest {
    private java.sql.Connection connection;
    @BeforeTest
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection(Connection.URL, Connection.USERNAME, Connection.PASSWORD);
    }
    @AfterTest
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testFindValueInDatabase() throws SQLException {
        String query = "SELECT*FROM mydbautotest.datatest";
        ResultSet resultSet = Connection.statement.executeQuery(query);

        List<String> results = new ArrayList<>();

        while (resultSet.next()) {
            String resultUserName = resultSet.getString("userName");
            String resultIduser = resultSet.getString("iduser");
            String resultSurName = resultSet.getString("userSurname");
            results.add(resultIduser);
            results.add(resultUserName);
            results.add(resultSurName);
        }
        System.out.println("Записи в бд " + results);

        Assert.assertTrue(results.contains("Антонов"),"Такого значения нет");
    }
}
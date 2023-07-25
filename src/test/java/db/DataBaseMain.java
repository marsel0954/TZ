package db;

import dataBase.Connection;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseMain {
    protected final String query = "SELECT*FROM mydbautotest.datatest";
    protected java.sql.Connection connection;
    @BeforeTest
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection(Connection.URL, Connection.USERNAME, Connection.PASSWORD);
    }
    @AfterTest
    public void tearDown() throws SQLException {
        connection.close();
    }

    protected List<String> showDataBase() throws SQLException {
        ResultSet resultSet = Connection.statement.executeQuery(query);
        List<String> results = new ArrayList<>();

        while (resultSet.next()) {
            String resultUserName = resultSet.getString("userName");
            String resultIduser = resultSet.getString("iduser");
            String resultSurName = resultSet.getString("userSurname");
            String resultAge = resultSet.getString("age");
            results.add(resultIduser);
            results.add(resultUserName);
            results.add(resultSurName);
            results.add(resultAge);
        }
        System.out.println("Записи в бд " + results);

        return results;
    }
    protected void showSoutDB(String query) throws SQLException {
        ResultSet resultSet = Connection.statement.executeQuery(query);
        List<String> results = new ArrayList<>();

        while (resultSet.next()) {
            String resultUserName = resultSet.getString("userName");
            String resultIduser = resultSet.getString("iduser");
            String resultSurName = resultSet.getString("userSurname");
            String resultAge = resultSet.getString("age");
            results.add(resultIduser);
            results.add(resultUserName);
            results.add(resultSurName);
            results.add(resultAge);
        }
        System.out.println("Записи в бд " + results);

    }



    protected void addNewUser(String iduserValue, String usernameValue, String userSurnameValue, String ageValue) throws SQLException {
        String addUserSQL = "INSERT INTO mydbautotest.datatest (iduser, userName, userSurname, age) " +
                "VALUES " + "('" + iduserValue + "'," + "'" + usernameValue + "'," + "'" + userSurnameValue + "',"
                + "'" + ageValue + "');";

        System.out.println(addUserSQL);

        connection.createStatement().execute(addUserSQL);
    }

}

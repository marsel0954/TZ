package db;

import dataBase.Connection;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;


public class DatabaseTest extends DataBaseMain{
    @Test
    public void testFindValueInDatabase() throws SQLException {
        List<String> results = showDataBase();
        Assert.assertTrue(results.contains("Антонов"),"Такого значения нет");
    }
    @Test
    public void testAddUser() throws SQLException {
        //Проверка добавление нового сотрудника через метод в DataBaseMain
        addNewUser("7","Артур","Пирожков", "55");
        List<String> results = showDataBase();

        SoftAssertions soft = new SoftAssertions();
        //Проверка на содержание 'Артур' необходимо улучшить проверку
        soft.assertThat(results).contains("Артур");

        //Удаление созданного клиента
        connection.createStatement().execute("DELETE FROM mydbautotest.datatest WHERE (iduser = 7);");
        List<String> resultsAfterDelete = showDataBase();

        //Проверка на отсутсвие 'Артур' необходимо улучшить проверку
        soft.assertThat(resultsAfterDelete).doesNotContain("Артур");
        soft.assertAll();
    }
    @Test
    public void changeUserAttribute() throws SQLException {
        //Изменение атрибутов пользователя
        showDataBase();
        connection.createStatement().execute("UPDATE mydbautotest.datatest SET age = '17' WHERE (iduser = 3)");
        showDataBase();
    }
    @Test
    public void getSomeQuery() throws SQLException {
        //Добавление нового пользователя
        Connection.statement.executeQuery("INSERT INTO mydbautotest.datatest (iduser, userName, userSurname, age) " +
                "VALUES ('5', 'Александр', 'Попов', '27');");
    }

}

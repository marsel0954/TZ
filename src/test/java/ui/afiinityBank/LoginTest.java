package ui.afiinityBank;

import org.openqa.selenium.By;
import ui.afiinityBank.core.BaseTest;
import org.testng.annotations.Test;
import ui.afiinityBank.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "C6016705. Авторизация. Верный телефон + верный пароль",timeOut = 10000)
    public void checkAuthByPhoneNumber(){
        LoginPage loginPage = new LoginPage();
        loginPage.authByPhone("79990234561","qpMc39zas");
    }

    @Test(description = "C6016734. Авторизация. Верный телефон + неверный пароль",timeOut = 10000)
    public void checkAuthByPassport(){
        LoginPage loginPage = new LoginPage();
        loginPage.authByPassport("79990234561","qpMc39444");

    }
    @Test(description = "C6016734. Авторизация. Верный номер паспорта + верный пароль",timeOut = 10000)
    public void checkAuthByPhoneWithWrongPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.authByPassport("MR2417879","qpMc39zas");
    }

    @Test(description = "C6017587. Авторизация. Неверный номер паспорта + верный пароль",timeOut = 10000)
    public void checkAuthByMistakePassport(){
        LoginPage loginPage = new LoginPage();
        loginPage.authByPassport("MR2417878","qpMc39zas");
    }

    @Test(description = "C6017586. Авторизация. через белорусский телефон",timeOut = 10000)
    public void checkAuthByPhoneNumberBybLR(){
        LoginPage loginPage = new LoginPage();
        loginPage.authByPhoneBLR("33523841","qpMc39zas");
    }
}

package ui.afiinityBank;

import org.testng.annotations.Test;
import ui.afiinityBank.core.BaseTest;
import ui.afiinityBank.pages.LoginPage;

public class CurrencyTest extends BaseTest {
    @Test(timeOut = 10000)
    public void toCurrency(){
        LoginPage loginPage = new LoginPage();
        loginPage.toCurrency();
    }

}

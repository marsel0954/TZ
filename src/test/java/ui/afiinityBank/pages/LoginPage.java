package ui.afiinityBank.pages;

import ui.afiinityBank.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    // делает поиск только когда мы обращаемся к этому элементу
    @FindBy(xpath = "//input[@placeholder='Телефон']" )
    private WebElement loginByPhone;
    @FindBy(xpath = "//button[@aria-label='Select country']")
    private WebElement chooseMobileCountryButton;
    @FindBy(xpath = "//*[@id=\"country-BY\"]")
    private WebElement chooseMobileCountry;
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwordByPhone;
    @FindBy(xpath = "//input[@placeholder='Номер паспорта']")
    private WebElement loginByPassport;
    //Кнопка перехода на авторизацию через паспорт
    @FindBy(xpath = "//button[@data-testid='tab-По паспорту']")
    private WebElement toLoginByPassword;
    @FindBy(xpath = "//*[@id=\"LoginForm\"]/button")
    private WebElement enterAuthButton;
    @FindBy(xpath = "//a[@data-testid='/exchange_rate-link']")
    private WebElement toCurrency;

    @FindBy(xpath = "//a[@data-testid='/exchange_rate-link']")
    private WebElement t2oCurrency;

    public LoginPage(){
        driver.get("https://a-finny-dev.astondevs.ru/");
        PageFactory.initElements(driver, this);
    }
    public LoginPage authByPhone(String loginValue, String passwordValue){
        loginByPhone.sendKeys(loginValue);
        passwordByPhone.sendKeys(passwordValue);
        enterAuthButton.click();
        return this;
    }
    public LoginPage authByPassport(String passportValue, String passwordValue){
        toLoginByPassword.click();
        loginByPassport.sendKeys(passportValue);
        passwordByPhone.sendKeys(passwordValue);
        enterAuthButton.click();
        return this;
    }
    public LoginPage authByPhoneBLR(String loginValue, String passwordValue){
        chooseMobileCountryButton.click();
        chooseMobileCountry.click();
        loginByPhone.sendKeys(loginValue);
        passwordByPhone.sendKeys(passwordValue);
        enterAuthButton.click();
        return this;
    }
    public LoginPage toCurrency(){
        toCurrency.click();
        return this;
    }

}
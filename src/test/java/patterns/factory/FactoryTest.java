package patterns.factory;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FactoryTest {
    @Test
    public void mobileTests() throws MalformedURLException {
        WebDriver driver = DriverTestFactory.getTestDriver("ios");
        WebElement signButton = driver.findElement(MobileBy.IosUIAutomation("signIn"));
        Assert.assertTrue(signButton.isDisplayed());
    }

    @Test
    public void androidTest() throws MalformedURLException {
        WebDriver driver = DriverTestFactory.getTestDriver("android");
        WebElement signButton = driver.findElement(MobileBy.AndroidUIAutomator("signIn"));
        Assert.assertTrue(signButton.isDisplayed());
    }
}

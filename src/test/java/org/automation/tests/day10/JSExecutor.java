package org.automation.tests.day10;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @Test
    public void scrollTest() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        // you need to cast if reference type is a WebDriver
        // JavascriptException js = (JavascriptException) driver;
        // scroll down 250 pixels
        // x, y coordinates
        //driver.executeScript("window.scrollBy(0,250)");

        for (int i=0; i < 10; i++){
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(30);
    }
    @Test
    public void scrollToElementTest (){
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        // scrollIntoView - javascript method
        // arguments[0] - means 1st webelement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(3);
    }

    @BeforeMethod
    private void setup() {
//        driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

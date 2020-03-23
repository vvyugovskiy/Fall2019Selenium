package org.automation.tests.day11_jsExecutor_webTables;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    private void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void clickTest() {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
//      disable this click action, to perform it with js executor
//      link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // after "" you can list webElements that will be used
        // as part of your javascript code
        // it's varargs, so you can list 0+
        // arguments - listed after,
        // use index to get specific webElement
        // WebElement arguments = {element, link, link2};
        // from left - to right
        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click()", button6);

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "Now it's gone!");

    }

    @Test
    public void textInputTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to get test from input box - read attribute "value"
        // to enter text - set attribute "value"

        js.executeScript("arguments[0].setAttribute('value','tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader, expected);
    }

    @Test
    public void scrollToElement() {
        //href = link, URL
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("");
    }

    @Test
    public void scrollTest() {
        BrowserUtils.wait(2);
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            BrowserUtils.wait(1);
        }
    }

    @Test
    public void verifyTitle() {
        String expected = "Practice";
        // we create javascriptexecutor object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // executeScript - this method executes javascript code
        // we provide js code as a String
        // return document.title - javascript code
        // document - represents HTML page
        // .toString() - to avoid additional casting from Object to Strong
//        String actual = (String) js.executeScript("return document.title");
        String actual = js.executeScript("return document.title").toString();

        Assert.assertEquals(actual, expected);
    }


    @AfterMethod
    public void teardown() throws IOException {
        BrowserUtils.wait(2);
        driver.quit();
        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

package com.automation.tests.vytrack.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {

    private WebDriver driver;
    // https is a secured version of http protocol
    // http - it's a hypertext transfer protocol that every single website is using now days
    // https - data encrypted, no chance for hackers to retrieve info
    // http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test(description = "verify that warning displays when user enters invalid username")
    public void invalidUsername() {
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("USerUser123", Keys.ENTER);
        BrowserUtils.wait(2);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
    }

    @Test(description = "Login as store manager and verify that tile is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual, expected, "Page title is not correct!");
    }

    @AfterMethod
    public void teardown() {
        // if webdriver object alive
        if (driver != null) {
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }


    }
}

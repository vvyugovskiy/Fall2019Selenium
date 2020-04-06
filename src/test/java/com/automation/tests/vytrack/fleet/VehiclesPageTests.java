package com.automation.tests.vytrack.fleet;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VehiclesPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";

    private String username = "storemanager85";
    private String password = "UserUser123";
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains (text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By pageNumberBy = By.cssSelector("input[type='number']");

    @Test
    public void verifyPageSubTitle() {

        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());

    }

    /**
     *     ################ TASK 5 minutes
     *
     *     Given user is on the vytrack landing page
     *     When user logs on as a store manager
     *     Then user navigates to Fleet --> Vehicles
     *     And user verifies that page number is equals to "1"
     */
    @Test
    public void verifyPageNumber(){

        BrowserUtils.wait(3);
        // //label[text()='Page:']/..//input
        // input[type='number']
        // Xpath //input[@type='number']
        String expected = "1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");
        assertEquals(expected,actual);

    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        // click on fleet
//        driver.findElement(fleetBy).click();
        // Action class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        // move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform - to execute command
        // every action should end with perform()

        BrowserUtils.wait(3);
        // click on Vehicle
        driver.findElement(By.linkText("Vehicles")).click();

        BrowserUtils.wait(3);
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
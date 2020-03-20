package org.automation.tests.day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Create a class called PracticeTests
 * <p>
 * - setup before/after methods
 * - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 * - in after method - just close webdriver.
 * <p>
 * - create a test called loginTest
 * - go to "Form Authentication" page
 * - enter valid credentials
 * username: tomsmith
 * password: SuperSecretPassword
 * <p>
 * - verify that following sub-header message is displayed: "Welcome to the Secure Area. When you are done click logout below."
 */
public class PracticeTest {
    private WebDriver driver;

    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test // create a test called loginTest
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword", Keys.ENTER);
        // driver.findElement(By.xpath("//button[@type='submit']")).click();
        BrowserUtils.wait(3);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        // if assertion fails - it will throw exception and message will be printed
        // 3 parameters: (actual, expected, message in case of error)
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    /**
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test
    public void retrievePassword() {
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("cybertek@cybertek.com");
        driver.findElement(By.id("form_submit")).click();
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals(actual, expected, "Confirmation message is not valid!");
    }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */
    @Test
    public void checkboxes() {

        driver.findElement(By.linkText("Checkboxes")).click();
        // locator for specific checkbox, xpath: //input[1], cssSelector: input:nth-of-type(1)
        WebElement checkbox1 = driver.findElement(By.xpath("// input[@type='checkbox'][1]"));
        checkbox1.click();
        // driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();

        Assert.assertTrue(checkbox1.isSelected(), "Checkbox #1 is not selected!");
        // collect all checkboxes
        // List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        // checkBoxes.get(0).click();
        // Assert.assertTrue(checkBoxes.get(0).isSelected(),"Checkbox #1 is not selected!");

    }

    @BeforeMethod
    public void beforeMethod() {
        // setup WebDriver
        WebDriverManager.chromedriver().setup();
        // INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        // ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        // to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

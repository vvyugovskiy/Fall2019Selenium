package org.automation.tests.vytrack.activities;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CallsPageTests {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");
    private By createEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu>a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(3);

        // hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);


    }

    /**
     * Scenario: Verify for store manager
     *
     * Login as store manager
     * Go to Activities --> Calls
     * Verify that Log Call button is displayed
     */
    @Test
    public void verifyLogCallButton() {
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(2);
        WebElement logCallBtnElement =  driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());
    }

    /**
     * Scenario: Verify for store manager
     *
     * Login as store manager
     * Go to Activities --> Calendar Events
     * Verify that Create Calendar Event button isDisplayed
     */
    @Test
    public void verifyCreateCalendarEventButton (){
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(2);
        WebElement createEventBtnElement = driver.findElement(createEventBtnBy);
        Assert.assertTrue(createEventBtnElement.isDisplayed());
    }

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     *
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test (description = "default options")
    public void verifyDefaultValues (){
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(2);
        //Click on Create Calendar Event
        driver.findElement(createEventBtnBy).click();
        BrowserUtils.wait(2);

        String currentUserName = driver.findElement(currentUserBy).getText();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName,defaultOwnerName, "Names don't match");
        // Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        // DatePatternSyntax: https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        // Default date should be the current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate,expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:mm a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime,expectedTime);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

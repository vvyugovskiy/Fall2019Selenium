package com.automation.study.practice.Bitrix24;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.BrokenBarrierException;

public class activityStreamAC2 {


    @FindBy (css = "iframe[class='bx-editor-iframe']")
    private WebElement iframe;

    protected WebDriver driver;
    protected Actions actions;

    private By sendButtonBy = By.id("blog-submit-button-save");

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get("http://login1.nextbasecrm.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk31@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser", Keys.ENTER);
        BrowserUtils.wait(1);
    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }


    @Test(description = "User should be able to add users and recipients From Resent")
    public void acceptanceCriteria2_1() {

        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more")); // moreOptionsDropdown
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']")); // announcementOption
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-destination-tag")).click();  // addMore
        BrowserUtils.wait(2);
        WebElement recent = driver.findElement(By.cssSelector("[id^='destLastTab_destination']")); // recentBar
        recent.click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("(//a[starts-with(@id,'destination')])[3]")).click(); // userToTestInRecent

    }

    @Test(description = "User should be able to add users and recipients From Employees and Departments")
    public void acceptanceCriteria2_2() {

        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-destination-tag")).click(); // addMore
        BrowserUtils.wait(2);
        WebElement employeesAndDepartments = driver.findElement(By.cssSelector("[id^='destDepartmentTab_destination']"));  // employeesAndDepartmentsBar
        employeesAndDepartments.click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("(//a[@class='bx-finder-company-department-employee  bx-finder-element'])[3]")).click(); // userToTestEmployeesAndDepartments

    }

    @Test(description = "User should be able to add users and recipients From E-mail user")
    public void acceptanceCriteria2_3() {

        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-destination-tag")).click();
        BrowserUtils.wait(2);
        WebElement email = driver.findElement(By.cssSelector("[id^='destEmailTab_destination']")); // emailBar
        email.click();
        BrowserUtils.wait(1);

    }

    }
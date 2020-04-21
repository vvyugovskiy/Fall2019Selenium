package com.automation.tests.vytrack.login;

import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReport;
    protected ExtentTest test;

    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 10);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}

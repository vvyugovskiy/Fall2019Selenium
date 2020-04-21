package com.automation.study.officeHour.OH_2020_04_08_Myroslava;

import com.automation.tests.vytrack.login.TestBase;
import com.automation.utilities.ConfigurationReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportPractice extends TestBase {

    @BeforeMethod
    public void setUp() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/reportMiroslava.html";
        htmlReport = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReport);

        report.setSystemInfo("browser", ConfigurationReader.getProperty("browser")); // setting general system settings

    }

    @Test
    public void test1() {
        test = report.createTest("Login to a website");
        test.info("Navigate to URL");
        driver.get(ConfigurationReader.getProperty("url"));

        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));

        test.info("Enter Username");
        user.sendKeys(ConfigurationReader.getProperty("username"));
        test.info("Enter Password");
        password.sendKeys(ConfigurationReader.getProperty("password"));
        test.info("Click submit button");
        submit.click();
        test.pass("PASS: login successful");

    }

    @AfterMethod
    public void teardown() {
        report.flush();
    }
}

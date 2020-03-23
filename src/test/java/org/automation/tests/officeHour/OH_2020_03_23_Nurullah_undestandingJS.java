package org.automation.tests.officeHour;

import org.automation.utilities.BrowserFactory;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OH_2020_03_23_Nurullah_undestandingJS {

    private WebDriver driver;

//    @BeforeMethod
//    public void setup() {
//        driver = BrowserFactory.getDriver("chrome");
//
//    }
    @Test
    public void test1 (){
        // driver instance created
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://etsy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }

//    @AfterMethod
//    public void teardown() {
//        driver.quit();
//    }
}
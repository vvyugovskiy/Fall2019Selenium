package com.automation.study.officeHour;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OH_2020_03_23_Nurullah_undestandingJS {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
    }

    @Test(description = "Send text to search box on etsy")
    public void test1() {
        driver.get("https://etsy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }

    @Test(priority = 1, description = "Clicking on an element")
    public void test2() {
        // Navigating to etsy.com
        driver.get("http://etsy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('catnav-primary-link-891').click();");

    }

    @Test(priority = 2, description = "get the page title (return a value)")
    public void test3() {
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);

    }

    @Test(description = "return page URL")
    public void test4() {
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageURL = js.executeScript("return document.URL").toString();
        System.out.println(pageURL);
    }

    @Test(description = "return element text")
    public void test5() {
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String elementText = js.executeScript("return document.getElementById('catnav-primary-link-11049').innerHTML").toString();
        elementText = elementText.trim();
        System.out.println(elementText);

    }

    @Test(description = "scroll an element into view")
    public void test6() {
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('email-list-signup-email-input').scrollIntoView();");

    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }
}
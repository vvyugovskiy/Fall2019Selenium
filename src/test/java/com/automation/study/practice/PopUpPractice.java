package com.automation.study.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpPractice {

    private WebDriver driver;
//    private String actual = driver.findElement(By.id("result")).getText();

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

    }

    @Test(description = "Click OK in pop up message")
    public void alert1() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expected, actual, "Wrong button");
        BrowserUtils.wait(2);
    }

    @Test(description = "Click cancel in pop up message")
    public void alert2() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String expected = "You clicked: Cancel";
        String actual = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expected, actual, "Wrong button");
        BrowserUtils.wait(2);
    }

    @Test(description = "Pass Java is fun in a pop up menu, click OK")
    public void alert3() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Java is fun!");
        driver.switchTo().alert().accept();
        String actual = driver.findElement(By.id("result")).getText();
        String expected = "You entered: Java is fun!";
        Assert.assertEquals(expected, actual, "Wrong message");

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
    @AfterSuite
    public void exit()throws Exception {
        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }

}

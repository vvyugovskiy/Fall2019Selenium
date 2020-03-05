//package org.automation.tests.practice;
//
//import com.automation.utilities.DriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class Omer1 {
//
//    WebDriver driver;
//
//    @BeforeClass
//    public void start() {
//        driver = DriverFactory.createDriver("chrome");
//    }
//
//    @Test
//    public void ebay() {
//        driver.get("https://ebay.com");
//        driver.findElement(By.xpath("//input[@placeholder]")).sendKeys("macbook");
//        driver.findElement(By.id("gh-btn")).click();
//        System.out.println(driver.findElement(By.xpath("//*[@id=\"mainContent\"]//span[@class=\"BOLD\"]")).getText());
//    }
//
//    @AfterTest
//    public void close() {
//        driver.close();
//    }
//
//}

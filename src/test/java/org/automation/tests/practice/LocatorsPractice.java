package org.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement btn1 = driver.findElement(By.id("gbqfbb"));
        // get value of a button
        String actualText = btn1.getAttribute("value");
        String expectedText = "I'm Feeling Lucky";
        if (actualText.equals(expectedText)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
            System.out.println("Expected text: " + expectedText);
            System.out.println("Actual text: " + actualText);
        }
        //btn1.click();
        Thread.sleep(5000);
        driver.close();


    }
}

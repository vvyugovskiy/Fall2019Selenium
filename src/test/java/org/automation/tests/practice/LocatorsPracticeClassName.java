package org.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassName {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
        List<WebElement> listOfExamples = driver.findElements(By.className("list-group-item"));
        System.out.println("Size: " + listOfExamples.size());
        Thread.sleep(3000);
        driver.close();


        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

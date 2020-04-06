package com.automation.study.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);

        //  how to collect all the links from the page?
        //  <a> - stands for a link

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
        }
        for (int i = 1; i < links.size(); i++) {
            // driver.findElements(By.tagName("a")).get(i).click();
            //  driver.navigate().back();
            links.get(i).click();
            driver.navigate().back();
            // refresh list
            links = driver.findElements(By.tagName("a"));
        }

        driver.quit();


        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

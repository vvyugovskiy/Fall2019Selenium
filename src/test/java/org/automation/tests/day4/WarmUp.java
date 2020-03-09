package org.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class WarmUp {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.out.println("OS Running = " + System.getProperty("os.name"));
//        Go to ebay
//        enter search term
//        click on search button
//        print number of results

//        go to amazon
//        Go to ebay
//        enter search term
//        click on search button
//        verify title contains search term
//
//        Go to wikipedia.org
//        enter search term `selenium webdriver`
//        click on search button
//        click on search result `Selenium (software)`
//        verify url ends with `Selenium_(software)`

//        ebayTest();
//        amazonTest();
//        wikiTest();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }

    // eBay
    public static void ebayTest() throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        // go to eBay
        driver.get("http://ebay.com");

        Thread.sleep(2000);//to wait 2 seconds

        // enter search terms
        driver.findElement(By.id("gh-ac")).sendKeys("Java book" + Keys.ENTER);
        // driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));

        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();
    }

    // Amazon

    public static void amazonTest() {

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://Amazon.com");
        //enter text and click ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        String title = driver.getTitle();
        if (title.contains("java book")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    // wiki

    public static void wikiTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Wiki");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);

        Thread.sleep(2000);//to wait 2 seconds

        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = driver.getCurrentUrl(); // to get link as a String

        if (link.endsWith(("Selenium_(software)"))){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}

package com.automation.study.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // By.name("q") -->> name="q"  searching for q on the page
        // name - it's one of the selenium locators
        // there are 8 locators
        // we use locators to find elements
        // to chose locators
        WebElement search = driver.findElement(By.name("q"));

        // once we found an element, how to enter text?
        // to enter text, use sendKeys();
        // how to press "Enter"?
        // use Key.ENTER
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);

        // if see <a> elements, it calls link
        //visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();//to click on the element
        Thread.sleep(4000);

        driver.quit();
    }
}

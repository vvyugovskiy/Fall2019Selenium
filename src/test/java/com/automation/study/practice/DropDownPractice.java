package com.automation.study.practice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    static WebDriver driver = DriverFactory.createDriver("chrome");

    public static void main(String[] args) throws Exception {

//        selectByTextTest();
//        selectByValueTest();
        selectByIndex();
    }

    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    public static void selectByTextTest() throws Exception {
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");

        Thread.sleep(2000);
        driver.quit();
    }

    public static void selectByValueTest() throws Exception {
        setup();
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("DC");
        String expected = "District of Columbia";
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        driver.quit();
    }

    public static void selectByIndex() {
        setup();
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(1);
        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();

        String expectedValue = "AL";
        String actualValue = select.getFirstSelectedOption().getAttribute("value");

        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);

        System.out.println("Expected Value = " + expectedValue);
        System.out.println("Actual Value = " + actualValue);
        driver.quit();
    }

    public static void multiSelectDropDownTest () {
        setup();
        Select select = new Select(driver.findElement(By.name("Languages")));

        List<WebElement> options = select.getOptions();

        for (WebElement option: options ) {
            select.selectByVisibleText(option.getText());
        }
        driver.quit();

    }
}

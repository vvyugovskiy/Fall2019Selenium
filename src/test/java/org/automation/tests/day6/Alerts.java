package org.automation.tests.day6;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("TEST #1");

        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(2);
        // to get the text from popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        driver.switchTo().alert().accept(); // to click OK
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equalsIgnoreCase(actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected = " + expected);
            System.out.println("Actual = " + actual);
        }

        BrowserUtils.wait(2);
//------------------------------------------------------------------------------
        System.out.println("TEST #2");

        buttons.get(1).click(); // to click on the 2nd button
        BrowserUtils.wait(2);
        // to click cancel
        driver.switchTo().alert().dismiss(); // dismiss ->> CANCEL

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equalsIgnoreCase(actual2)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected = " + expected2);
            System.out.println("Actual = " + actual2);
        }
//------------------------------------------------------------------------------------------------------
        // TASK: Click on button # 3
        // Enter some text: Hello, World!
        // Verify that result text ends with Hello, World!
        System.out.println("TEST #3");
        BrowserUtils.wait(2);
        buttons.get(2).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!"); // enter text
        alert.accept();

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";

        if (actual3.endsWith(expected3)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected = " + expected3);
            System.out.println("Actual = " + actual3);
        }

        BrowserUtils.wait(2);
        driver.quit();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

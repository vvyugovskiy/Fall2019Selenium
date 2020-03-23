package org.automation.tests.day12;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUpTask {

    private WebDriver driver;
    /**
     * Go to http://practice.cybertekschool.com/tables
     * Click on "Last name" column name
     * Verify that table is sorted by last name in alphabetic order.
     *
     * The Java String c ompareTo() method is used for comparing two strings lexicographically.
     * Each character of both the strings is converted into a Unicode value for comparison.
     * If both the strings are equal then this method returns 0 else it returns positive or negative value.
     * The result is positive if the first string is lexicographically greater than
     * the second string else the result would be negative.
     *
     *  This method is coming from Comparable interface.
     *  If you want ot be able to sort collection of some class
     *  you need to implement this interface
     *  and override compareTo method
     *
     "a".compareTo("b") = -1
     61 - 62 = -1
     a is before b
     "a".compareTo("a")
     61 - 61 = 0
     0 means 2 strings are equals
     *
     */

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @Test
    public void lastNameSortVerify() {
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        WebElement lastNameSort = driver.findElement(By.xpath("//th[@class='header']"));  //table[1]//*[text()='LastName'] --> xpath

        lastNameSort.click();
        //collect all values from the first column

        List<WebElement> listLastNames = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < listLastNames.size()-1; i++) {
            String value = listLastNames.get(i).getText();
//            System.out.println(value);
            String nextValue = listLastNames.get(i+1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals

            Assert.assertTrue(value.compareTo(nextValue) <=0);
        }
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}

package org.automation.tests.day6;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class SelectByText {

    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        // create a WebElement object for a dropdown first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        // provide WebElement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        // Select select = new Select(driver.findElement(By.id("dropdown")));
        // select by VisibleText
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropdown.selectByVisibleText("Option 1");
        //
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectYear.selectByVisibleText("2003");
        selectMonth.selectByValue("0");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("25");
        BrowserUtils.wait(2);


        // select all month one by one
        // .getOptions(); returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth:months) {
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }


        BrowserUtils.wait(2);
        driver.quit();


        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

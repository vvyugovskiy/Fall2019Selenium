package org.automation.tests.day6;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class SelectByIndex {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        // index starts from 0
        stateSelect.selectByIndex(9); //District of Columbia perhaps
        BrowserUtils.wait(2);

        // select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);







        BrowserUtils.wait(2);
        driver.quit();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

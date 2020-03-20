package org.automation.tests.day6;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class SelectByValue {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();
        if (expected.equalsIgnoreCase(actual)){
            System.out.println("YEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        BrowserUtils.wait(2);
        driver.quit();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
    }
}

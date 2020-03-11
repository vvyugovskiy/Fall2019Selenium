package org.automation.tests.day7;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);




        BrowserUtils.wait(2);
        driver.quit();
    }
}

package org.automation.tests.day7;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    static String loginBtnLocator = "//button[contains(text(),'L')]";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();


        BrowserUtils.wait(2);
        driver.quit();
    }
}

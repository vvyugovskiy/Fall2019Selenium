package org.automation.tests.practice;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InputAttributeValue {

    @Test
    public void attributeValueTest (){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://temp-mail.org/en/");
        WebElement email = driver.findElement(By.id("mail"));
        System.out.println(email.getAttribute("value"));
        BrowserUtils.wait(3);
        driver.quit();
    }

}

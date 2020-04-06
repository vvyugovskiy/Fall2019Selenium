package com.automation.study.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(2);
        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        driver.findElement(By.name("phone")).sendKeys("571-343-2342");
        List<WebElement> genders = driver.findElements(By.name("gender"));
        //select gender
        genders.get(1).click();//select male, for example
        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);
        // ADD VALIDATION PART

        String expected = "Well done!";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        BrowserUtils.wait(3);
        driver.quit();


        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

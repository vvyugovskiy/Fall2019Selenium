package org.automation.tests.practice;

import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsPracticeCSS {

    public static void main(String[] args) throws Exception {

            WebDriver driver = DriverFactory.createDriver("chrome");
            driver.manage().window().maximize();
            driver.get("http://practice.cybertekschool.com/registration_form");
            driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("James");
            driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Bond");
            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("supersdet");
            driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email@cybertekschool.com");
            driver.findElement(By.cssSelector("input[name='password']")).sendKeys("qwerty123456");
            driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("843-333-3701");
            driver.findElement(By.cssSelector("input[value='male']")).click();
            driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");
            Select departmentSel = new Select(driver.findElement(By.cssSelector("select[name='department']")));
            departmentSel.selectByValue("MO");

            Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
            select.selectByVisibleText("SDET");

            driver.findElement(By.cssSelector("input[value='java']")).click();
            // driver.findElement(By.id("inlineCheckbox2")).click();

            driver.findElement(By.id("wooden_spoon")).click();

            Thread.sleep(3000);

            driver.quit();



    }
}

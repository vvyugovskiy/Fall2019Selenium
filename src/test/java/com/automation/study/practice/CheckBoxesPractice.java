package com.automation.study.practice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPractice {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)")).click();
//        Thread.sleep(2000);
        // find all elements with tagName input
//        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
//        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));


        // loop through this elements and if
        // checkbox is not selected yet then select it
        for (WebElement checkbox:checkboxes) {
            Thread.sleep(2000);
            if (!checkbox.isSelected()){
                    checkbox.click();
                }
        }
        driver.quit();
    }
}

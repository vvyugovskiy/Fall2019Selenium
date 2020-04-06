package com.automation.study.practice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsPracticeXpathPart2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement headerText = driver.findElement(By.xpath("//span[@class='h1y']"));
        System.out.println("h1y text: " + headerText.getText());

        Thread.sleep(2000);

        WebElement contextMenuLink = driver.findElement(By.xpath("//a[.='Context Menu']"));
        contextMenuLink.click();
        driver.navigate().back();

        Thread.sleep(2000);
        WebElement dragAndDrop = driver.findElement(By.xpath("//a[.='Drag and Drop']"));
        dragAndDrop.click();

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

        driver.close();
    }
}

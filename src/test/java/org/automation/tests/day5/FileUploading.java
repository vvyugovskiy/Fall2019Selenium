package org.automation.tests.day5;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(2);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml"; // returns a way for current project
        System.out.println(filePath);
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();  // click to upload
        BrowserUtils.wait(2);

        driver.quit();
    }
}

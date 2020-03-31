package org.automation.tests.officeHour;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OH_2020_03_25_Myroslava {

    /**
     * iFrame - webdocument inside of other webdocument (html inside of html)
     **/
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(2);        //we landed to red webdocument - default content
        driver.switchTo().frame("frame-top");
        //we are landed to blue web-doc
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop to get index for each frame
            2. switch to each frame
                a. get test from body
                b. switch to parent - just so you are able to switch to next frame in next iteration
         */
        for (int i = 0; i < frameList.size(); i++) {
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent(); //will always take you to the main html - default (red in the schema)
        driver.switchTo().frame("frame-bottom"); // switched to bottom frame
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);
        driver.switchTo().defaultContent(); //switch back to default after you finished your iteraction with frame content
    }

}

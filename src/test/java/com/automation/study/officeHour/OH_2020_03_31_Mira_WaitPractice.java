package com.automation.study.officeHour;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OH_2020_03_31_Mira_WaitPractice  {

    private WebDriver driver = DriverFactory.createDriver("chrome");
    /*
        http://qa3.vytrack.com
        salesmanager110
        UserUser123
     */

    /*
        Implicit Wait - set it 1 time and it will work for every findElement method
                        -NoSuchElementException

       Thread.sleep - not Selenium wait! Thread - java class, sleep() method of Thread class
                        stops the execution of java program
                        -We never want to use this method in our tests

        Explicit wait - we have to declare every time before the iteration with element
                        Expected Condition we are looking for

        Singelton - it helps us to make sure we have only 1 instance of driver object at a time
     */

    @Test
    public void testWait() {
        driver.get("http://qa3.vytrack.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        webDriverWait.until(ExpectedConditions.titleIs("Login"));

        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));

        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        submit.click();

        WebElement account = driver.findElement(By.xpath("//span[.='Accounts']/following-sibling::span/following-sibling::a"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(account));

        account.click();

        /*
                table
                    tbody
                        thead - header
                        tr - table row
                        td - table data
                        print all owner names
         */

        List<WebElement> owners = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
        for (WebElement each : owners) {
            System.out.println(each.getText());
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr/td[6]")));
        driver.findElement(By.xpath("//a[@title='Filters']")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Owner')]")).click();
        String searchFor = "cyber tek";
        WebElement filterInput = driver.findElement(By.id("s2id_autogen2"));
        filterInput.sendKeys(searchFor, Keys.ENTER);

        driver.findElement(By.xpath("//span[.='" + searchFor + "']")).click(); ////span[.='cyber tek']
        driver.findElement(By.xpath("(//button[.='Update'])[1]")).click();


    }

}

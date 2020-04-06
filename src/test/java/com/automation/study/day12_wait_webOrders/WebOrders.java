package com.automation.study.day12_wait_webOrders;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**
     * 7 minutes until 5:21
     * Go to web orders page
     * Click on "Check All" button
     * Verify that all records are selected
     */
    @Test
    public void checkBoxTest() {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> checkboxes = driver.findElements(By.tagName("checkbox"));
        for (WebElement checkbox: checkboxes ) {
            Assert.assertTrue(checkbox.isSelected());

        }
    }

    /**
     * until 5:37
     * :: TASK for 10 minutes ::
     * Go to web orders page
     * Verify that Steve Johns zip code is 21233
     * Then update his zip code to 20002
     * Then verify that Steve Johns zip code is 20002
     */

    @Test
    public void zipUpdateTest (){

//        String expectedZip = "21233";
//        String actualZip = driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText(); //td[text()='Steve Johns']//following-sibling::td[7]
//        Assert.assertEquals(actualZip,expectedZip);

        WebElement zipcode = driver.findElement(By.xpath(""));
        Assert.assertEquals(zipcode.getText(),"21233");

        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[4]/td[13]/input")).click();
        WebElement zipField = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
        zipField.clear();
        zipField.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        String expectedUpdetedZip = "20002";
        String actualupdatedZip = driver.findElement(By.xpath("//table//tr[4]//td[9]")).getText();

        Assert.assertEquals(actualupdatedZip,expectedUpdetedZip);
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}

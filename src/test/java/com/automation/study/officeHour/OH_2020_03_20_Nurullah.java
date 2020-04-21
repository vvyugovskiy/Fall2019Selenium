package com.automation.study.officeHour;

import com.automation.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OH_2020_03_20_Nurullah {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");

    }
           /*
     Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
     Step 2. And click on "Status Codes".
     Step 3. Then click on "500".
     Step 4. Verify that following message is displayed: "This page returned a 500 status code"
      */

     /*
       xpath :
          //a[text()='Status Codes']
          //a[contains(text(),'Status Codes')]
          //ul/li[46]
          //a[@href="/status_codes"]
       linkText :
          lintText("Status Codes")
       partialLinkText:
          partialLintText("Status Codes")
          partiallinkText("Status")
          partiallinkText("Codes")
          CssSelector
          [href="/status_codes"]
      */

 /*
 Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
 Step 2. And click on "Status Codes".
 Step 3. Then click on "404".
 Step 4. Verify that following message is displayed: "This page returned a 404 status code"
  */

    @DataProvider(name = "testData")
    public static Object[] testData() {

        return new Object[]{"404", "500", "301", "200"};
    }
    /*
         DataProvider returns data in form of single dimensional Object array (Object [])or 2 dimensional object array (Object [] [])
         Object [] --> When you have only 1 parameter
         Object [] [] --> When you have 2+ parameters
      */

    @Test(dataProvider = "testData", description = "Verify that the following message is displayed : 'This page returned a Status Code'")
    public void statusCodes(String code) {

        //Step 1
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();

        //Step 3
        WebElement statusCode = driver.findElement(By.linkText(code));
        statusCode.click();

        //Step 4
        String expectedMessage = "This page returned a " + code + " status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
//        if (actualMessage.contains(expectedMessage)) {
//            System.out.println("Passed");
//        } else {
//            System.out.println("FAILED");
//        }
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
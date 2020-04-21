package com.automation.study.officeHour;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OH_2020_04_06_Nurullah_WebTables {

    /*
    1. We navigate to the practice website
    2. Click on the Sortable Table Link

    Tests Cases:
    Verify that row 2, column 4 is %51.00

    Verify the number of row is 4 in the table1 body

    Verify the number of columns is 6 in table1

     */

    @BeforeMethod
    public void setup () {
        // PreConditions1
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        // Step 2:
        Driver.getDriver().findElement(By.linkText("Sortable Data Tables")).click();
        BrowserUtils.wait(2);

    }

    @Test (description = "Verify that row 2, column 4 is $51.00")
    public void testCase1 (){
        WebElement data = Driver.getDriver().findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[4]"));
        String actualData = data.getText();
        String expectedData = "$51.00";
        Assert.assertEquals(actualData,expectedData,"Data mismatch");
    }

    @Test (description = "Verify the number of row is 4 in the table1 body")
    public void testCase2 (){
        List<WebElement> allRowsOfTable1 = Driver.getDriver().findElements(By.xpath("(//tbody)[1]/tr"));
        int actualRows = allRowsOfTable1.size();
        Assert.assertEquals(actualRows,4,"Mismatch number of rows");

    }

    @Test (description = "    Verify the number of columns is 6 in table1")
    public void testCase3 (){
        List<WebElement> columnsOfTable1 = Driver.getDriver().findElements(By.xpath("(//tbody)[1]/tr[1]/td"));
        int actualColumns = columnsOfTable1.size();
        Assert.assertEquals(actualColumns,6,"Mismatch number of rows");
    }

    @AfterMethod
    public void teardown (){
        Driver.closeDriver();
    }
}

package org.automation.tests.day10;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);

    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


        // build() is needed when you have couple of actions
        // always end with perform()
        // pause(1000). - like Thread.sleep(1000)
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        // hover on the first img
        // verify "name: user1" is displayed
        // hover over image to make it visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        // verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        // move to the second element
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }

    @Test
    public void jqueryMenuTest() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtils.wait(3);
        WebElement enable = driver.findElement(By.id("ui-id-3"));
        WebElement download = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

//        actions.moveToElement(enable).perform();
//        BrowserUtils.wait(2);
//        actions.moveToElement(download).perform();
//        BrowserUtils.wait(2);
//        actions.moveToElement(pdf).perform();
//        pdf.click();

        actions.moveToElement(enable).pause(2000).moveToElement(download).pause(2000).click(pdf).build().perform();
    }

    @Test
    public void dragAndDropTest (){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);

        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual,expected);

    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}

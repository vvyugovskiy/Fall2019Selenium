package org.automation.tests.officeHour;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;

public class OH_2020_03_30_Vasil {

    private WebDriver driver = Driver.getDriver();

    @Test
    public void test() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(2);

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        // gives you number  from 0 to
        int counter = 0;

        while (counter < 3) {
            Random random = new Random();
            int checkBoxToSelect = random.nextInt(checkboxes.size() - 1);
            if (checkboxes.get(checkBoxToSelect).isEnabled()) {

                checkboxes.get(checkBoxToSelect).click();

                System.out.println("Selected :: " + labels.get(checkBoxToSelect).getText());

                if (labels.get(checkBoxToSelect).getText().equals("Friday")) {
                    counter++;
                }
            }
        }

        driver.quit();
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select testYear = new Select(driver.findElement(By.id("year")));
        Select testMonth = new Select(driver.findElement(By.id("month")));
        Select testDay = new Select(driver.findElement(By.id("day")));

        Random random = new Random();
        int yearToSelect = random.nextInt(testYear.getOptions().size());

        testYear.selectByIndex(yearToSelect);

        for (int i = 0; i < 12; i++) {
            LocalDate localDate = LocalDate.of(yearToSelect, i + 1, 1);
            testMonth.selectByIndex(i);

            int actual = testDay.getOptions().size();//actual number of days
            int expected = Month.from(localDate).length(isLeapYear(yearToSelect)); //expected number of days in a month

            System.out.println("Month: " + testMonth.getFirstSelectedOption().getText());
            System.out.println("Expected number of days: " + expected);
            System.out.println("Actual number of days: " + actual);
            System.out.println();
            Assert.assertEquals(actual, expected);
        }
        driver.quit();
    }
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
        }
        return year % 4 == 0;
    }

    @Test
    public void test3() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.linkText("Under $25")).click();
        //we collect only dollar values from the price of every item
        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        //we convert collection of web elements into collection of strings
        List<String> pricesText = BrowserUtils.getTextFromWebElements(prices);
        System.out.println(pricesText);
        for (String price : pricesText) {
            //we convert every price as a string into integer
            int priceConverted = Integer.parseInt(price);
            //checking if the price of every item is under 25
            Assert.assertTrue(priceConverted < 25);
        }
        driver.quit();
    }
    @Test
    public void test4(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> prices = driver.findElements(By.cssSelector("span[class='a-price'] > [class='a-offscreen']"));
        List<WebElement> description = driver.findElements(By.cssSelector("[class='a-size-base-plus a-color-base a-text-normal']"));

        WebElement quantity = driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span"));

        int actual = Integer.parseInt(quantity.getText().trim());

        Assert.assertEquals(actual,1);

    }

    // Khumayra Yusupova
    private By itemNameBy = By.xpath("//div[@class='a-section a-spacing-medium']//span[@class='a-size-base-plus a-color-base a-text-normal']");
    @Test
    public void searchWoodenSpoonVerify() {
        List<WebElement> list = driver.findElements(itemNameBy);
        List<WebElement> wholePrice = driver.findElements(By.cssSelector(".a-price-whole"));
        List<WebElement> fractionPrice = driver.findElements(By.cssSelector(".a-price-fraction"));

        Random r = new Random();
        int index = r.nextInt(list.size());

        String item = list.get(index).getText().trim();
        String price = "$" + wholePrice.get(index).getText() + "." + fractionPrice.get(index).getText();

        list.get(index).click();

        String actualItem = driver.findElement(By.id("productTitle")).getText().trim();
        Assert.assertEquals(actualItem, item);

        String actualPrice = driver.findElement(By.id("priceblock_ourprice")).getText();
        Assert.assertEquals(actualPrice, price);

        String qty = driver.findElement(By.cssSelector("span[class='a-dropdown-label']+span")).getText().trim();
        Assert.assertEquals(qty, "1");

        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
    }
}

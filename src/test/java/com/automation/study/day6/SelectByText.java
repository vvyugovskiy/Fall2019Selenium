package com.automation.study.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class SelectByText {

    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        // create a WebElement object for a dropdown first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        // provide WebElement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        // Select select = new Select(driver.findElement(By.id("dropdown")));
        // select by VisibleText
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        // select your DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));  // create 1 Select object for 1 DropDown
        Select selectMonth = new Select(driver.findElement(By.id("month")));  // create Another Select object for 1 DropDown
        Select selectDay = new Select(driver.findElement(By.id("day")));    // create 1 more Select object for 1 DropDown

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByValue("0");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("25");
        BrowserUtils.wait(2);

        // select all month one by one
        // .getOptions(); returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth:months) {
            // get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(2);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        // options that is currently selected
        // getFirstSelectedOption() -> returns a WebElement, that's why we need to call getText()
        // getText() - retrieves visible text from the WebElement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption : states) {
            System.out.println(stateOption.getText());
            System.out.println(stateOption.getAttribute("value"));
        }

        BrowserUtils.wait(2);
        driver.quit();


        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

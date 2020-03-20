package org.automation.tests.day6;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

         Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        // whether this select element support selecting multiple options at the same time ?
        // this is done by checking the value of the multiple attribute

        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);  // ->> True if you can select more than one option

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        BrowserUtils.wait(2);

        languagesSelect.deselectByVisibleText("Java");

        // let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage : selectedLanguages) {
            System.out.println(selectedLanguage.getText());
        }

        BrowserUtils.wait(2);

        languagesSelect.deselectAll();

        BrowserUtils.wait(2);
        driver.quit();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}

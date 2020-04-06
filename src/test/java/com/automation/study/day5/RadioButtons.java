package com.automation.study.day5;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("firefox");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        // <input type='radio'>
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons) {
            // <input type='radio' id='red' name='color'>
            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected? " + isSelected);
            // to check if button is Available for click();
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on :: " + id);
                // BrowserUtils.wait(1);
            } else {
                System.out.println("Button is disabled :: " + id);
            }
            System.out.println();
        }
        driver.quit();
    }
}

package com.automation.study.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click(); // to extend the dropdown menu

        // <a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>


        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + ":" + link.getAttribute("href"));
        }

        driver.findElement(By.linkText("Etsy")).click(); // click on option

        System.out.println(driver.getTitle());
        BrowserUtils.wait(2);
        driver.quit();

        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
    }
}

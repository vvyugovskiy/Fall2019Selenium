package org.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverFactory {
    /**
     * You homework will be to improve this method!
     * This method return webdriver object based on browser type
     * If you want to use chrome browser, just provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */
    public static WebDriver createDriver (String browserName) {
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            return null;
        }



    }

}

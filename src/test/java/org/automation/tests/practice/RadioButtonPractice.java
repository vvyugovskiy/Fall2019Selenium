package org.automation.tests.practice;

import net.bytebuddy.implementation.bytecode.Throw;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Text;

import java.util.List;

public class RadioButtonPractice {
    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        Thread.sleep(2000);
        // checking if Yellow Radio button is Enabled
//        System.out.println("Yellow Enabled : " + driver.findElement(By.xpath("//label[contains(text(),'Yellow')]/preceding-sibling::input")).isEnabled());
//        driver.findElement(By.xpath("//label[text()='Yellow']/preceding-sibling::input")).click();
//        // checking if Green Radio button is Enabled
//        System.out.println("Green Enabled : " + driver.findElement(By.xpath("//label[contains(text(),'Green')]/preceding-sibling::input")).isEnabled());
//        driver.findElement(By.xpath("//label[contains(text(),'Green')]/preceding-sibling::input")).click();

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement radio: radioButtons){
//            Thread.sleep(2000);
            System.out.println(radio.getAttribute("id")+"-"+radio.isEnabled());
        }

        Thread.sleep(2000);
        driver.close();



        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
    }

}


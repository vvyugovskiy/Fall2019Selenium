package com.automation.study.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));

        fullName.sendKeys("Vladislav Vyugovskiy");

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("cybertek@mail.com");

        Thread.sleep(3000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        // when you see type="submit", you use submit() instead of click()
        // it makes sense to use when click() method doesn't work
        signUp.click() /*or .submit */;

        Thread.sleep(3000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText(); // to get the text <h3>Text</h3>

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


        driver.quit(); // to close everything
    }
}

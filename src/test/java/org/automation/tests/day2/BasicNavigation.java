package org.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        // to start selenium script we need :
        // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        /*RemoteWebDriver*/ ChromeDriver driver = new ChromeDriver();
        // In selenium, everything starts from WebDriver interface
        driver.get("http://google.com"); //to open a website
        driver.manage().window().maximize(); //to maximize browser
        // driver.manage().window().fullscreen();
        Thread.sleep(3000); // for demo wait 3 seconds
        // method that returns page title
        // you can see the name of browser
        String title = driver.getTitle(); // returns<title> some title</title> text
        String expectedTitle = "Google"; // we provide it

        System.out.println("Title is: "+ title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }

        // go to another window within the browser
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000); // for demo wait 3 seconds

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }

        // come back to google
        driver.navigate().back();
        Thread.sleep(3000);//for demo, wait 3 seconds

        // check if page title is equal to Google
        // .getTitle() - returns page title
        verifyEquals(driver.getTitle(),"Google");
        // move forward in the browser history
        // again, going to amazon
        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh(); //to reload page
        Thread.sleep(3000); //for demo, wait 3 seconds

        System.out.println("Title = " + driver.getTitle());
        //driver.getTitle() - returns page title of the page that is currently opened

        System.out.println(driver.getCurrentUrl());

        //driver.navigate().to() = driver.get()
        //must be at the end
        driver.close();//to close browser
        //browser cannot close itself

    }

    public static void verifyEquals (String arg1, String arg2){
        if (arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
    }
}

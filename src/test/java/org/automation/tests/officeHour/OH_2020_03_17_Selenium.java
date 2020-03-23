package org.automation.tests.officeHour;

import org.automation.utilities.BrowserUtils;
import org.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class OH_2020_03_17_Selenium {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://qa3.vytrack.com");
        BrowserUtils.wait(3);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        WebElement contacts_link = driver.findElement(By.xpath("(//a[@href='/contact'])[5]"));

        BrowserUtils.wait(2);

        contacts_link.click();

        BrowserUtils.wait(2);

        WebElement create_contact = driver.findElement(By.linkText("Create Contact"));
        create_contact.click();

        BrowserUtils.wait(2);

        String currentTitle = driver.getTitle();
        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")) {
            System.out.println("Title is expected");
        } else {
            System.out.println("Title is NOT expected");
        }

        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First Name","John");
        contact1.put("Last Name","Smith");
        contact1.put("Phone","571-236-4545");
        contact1.put("Street","400 Main Street");
        contact1.put("City","Tysons");
        contact1.put("State","VA");
        contact1.put("Zip Code","22102");
        contact1.put("Sales Group","true");
        contact1.put("Country","United States");

        System.out.println("Contact 1: " + contact1);

        WebElement first_name = driver.findElement(By.cssSelector("[id*='oro_contact_form_firstName-uid']"));
        WebElement last_name = driver.findElement(By.xpath("//input[@name='oro_contact_form[lastName]']"));
        WebElement phone = driver.findElement(By.xpath("//*[@name='oro_contact_form[phones][0][phone]']"));
        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state = driver.findElement(By.name("oro_contact_form[addresses][0][region_text]"));
        WebElement zipcode = driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup = driver.findElement(By.xpath("(//input[starts-with(@id,'oro_contact_form_groups_')])[1]"));


        first_name.sendKeys(contact1.get("First Name"));
        last_name.sendKeys(contact1.get("Last Name"));
        phone.sendKeys(contact1.get("Phone"));
        /*
            To handle dropdowns in selenium we are using Select class
            to use it we have to ensure we have <select></select> tag in our dropdown
            to create Select class we are using webelement of <select></select> element from html (we need to locate our
            dropdown which should have select tag)
         */

        street.sendKeys(contact1.get("Street"));
        city.sendKeys(contact1.get("City"));
        state.sendKeys(contact1.get("State"));
        zipcode.sendKeys(contact1.get("Zip Code"));

        if (contact1.get("Sales Group").equalsIgnoreCase("true")){
            salesGroup.click();
        }

        Select country_dropdwn = new Select(country); //this is special class in selenium to handle dropdowns
        /*
        it has different methods that help us interact with dropdown
         */
        country_dropdwn.selectByVisibleText(contact1.get("Country"));

        BrowserUtils.wait(2);

        WebElement saveAndClose = driver.findElement(By.xpath("//button[@class='btn btn-success action-button' and contains(text(),'Save and Close')]"));
        saveAndClose.click();

        BrowserUtils.wait(3);

        driver.quit();
    }

}
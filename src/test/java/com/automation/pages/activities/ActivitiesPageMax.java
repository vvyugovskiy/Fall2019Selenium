package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivitiesPageMax extends AbstractPageBase {

    String title = "Kukusik";
    String description = "Checking Event";

    @FindBy(css = "[class='control-label html-property']>p")
    private WebElement descriptionTxt;

    public String getDescriptionTxt() {
        BrowserUtils.waitForPageToLoad(10);
        return descriptionTxt.getText();
    }

    public void clickCreateButton() {
        driver.findElement(By.cssSelector("[class='btn-group']>[title='Create Calendar event']")).click();
        BrowserUtils.wait(3);
    }

    public void clickSaveButton() {
        driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-success action-button']")).click();
        BrowserUtils.wait(3);
    }

    public void createEvent() {
        driver.findElement(By.name("oro_calendar_event_form[title]")).sendKeys(title);
        WebElement iframe = driver.findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description-uid')]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("[id='tinymce']")).clear();
        driver.findElement(By.cssSelector("[id='tinymce']")).sendKeys(description);
        BrowserUtils.wait(1);
        driver.switchTo().defaultContent();
        clickSaveButton();

    }

    public void verifyEvent() {
        List<WebElement> list = driver.findElements(By.cssSelector("[class*='control-group']"));
    }

}

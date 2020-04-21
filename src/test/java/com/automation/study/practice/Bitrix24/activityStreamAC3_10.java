package com.automation.study.practice.Bitrix24;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activityStreamAC3_10 {

    protected WebDriver driver;
    protected Actions actions;

    private By sendButtonBy = By.id("blog-submit-button-save");

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get("http://login1.nextbasecrm.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk31@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser", Keys.ENTER);
        BrowserUtils.wait(1);
    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }



    @Test(description = "User should be able to attach link by clicking on the link icon")
    public void acceptanceCriteria3 () {

        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[class='bxhtmled-top-bar-btn bxhtmled-button-link']")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("linkidPostFormLHE_blogPostForm-text")).sendKeys("Hello World");
        BrowserUtils.wait(1);
        driver.findElement(By.id("linkidPostFormLHE_blogPostForm-href")).sendKeys("www.yandex.ru");
        BrowserUtils.wait(1);
        driver.findElement(By.id("undefined")).click();
        BrowserUtils.wait(3);
        driver.findElement(sendButtonBy).click();


    }

    @Test(description = "User should be able to insert videos by clicking on the video icon and entering the video URL")
    public void acceptanceCriteria4 () {

        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);

        driver.findElement(By.cssSelector("[class='bxhtmled-top-bar-btn bxhtmled-button-video']")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[id='video_idPostFormLHE_blogPostForm-source']")).sendKeys("www.youtube.com");
        BrowserUtils.wait(1);
        driver.findElement(By.id("undefined")).click();

    }


    @Test(description = "User should be able to create a quote by clicking on the Comma icon.")
    public void acceptanceCriteria5 () {

        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[title='Quote text']")).click();
        driver.switchTo().frame(2);
                WebElement quoteFrame = driver.findElement(By.cssSelector("[class='bxhtmled-quote']"));
        quoteFrame.sendKeys("wuz up");

//        driver.findElement(By.cssSelector("[class='bxhtmled-quote']>blockquote")).sendKeys("Peace!");
//        driver.switchTo().defaultContent();

    }

    @Test(description = "User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown")
    public void acceptanceCriteria6 () {
        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-b-mention-blogPostForm")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("(//*[starts-with(@id,'mention')])[1]")).click();
        BrowserUtils.wait(1);
        driver.findElement(sendButtonBy).click();
    }

    @Test(description = "7.User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box")
    public void acceptanceCriteria7 () {
        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("lhe_button_editor_blogPostForm")).click();

    }

    @Test (description = "8.User should be able to click on the Topic icon to see the announcement Topic text box displays on top of the message box")
    public void acceptanceCriteria8 (){
        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("lhe_button_title_blogPostForm")).click();
    }

    @Test (description = "9.User should be able to click on \"Record Video\" tab to record a video and attach it with the message")
    public void acceptanceCriteria9 (){
        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("(//*[@class='feed-add-post-form-but-cnt feed-add-videomessage'])[1]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[class='popup-window-button popup-window-button-blue']")).click();
    }

    @Test (description = "10. User should be able to add tags by selecting existing tags or creating new tags by clicking on the # icon")
    public void acceptanceCriteria10 (){
        WebElement moreDropdown = driver.findElement(By.id("feed-add-post-form-link-more"));
        moreDropdown.click();
        BrowserUtils.wait(2);
        WebElement moreAnnouncement = driver.findElement(By.cssSelector("[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']"));
        moreAnnouncement.click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("bx-b-tag-input-blogPostForm")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.name("TAGS_blogPostForm")).sendKeys("#faraonB15",Keys.ENTER);
        BrowserUtils.wait(1);

    }
}

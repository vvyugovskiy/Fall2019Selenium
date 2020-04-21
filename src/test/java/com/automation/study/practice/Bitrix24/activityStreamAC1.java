package com.automation.study.practice.Bitrix24;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activityStreamAC1 {


    protected WebDriver driver;
    protected Actions actions;

    private By sendButtonBy = By.id("blog-submit-button-save");

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
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


    @Test (description = "upload files and pictures from local disks")
    public void test1() {

        driver.findElement(By.id("microoPostFormLHE_blogPostForm")).click(); // sendMessageField
        driver.switchTo().frame(0);
        WebElement sendMessage = driver.switchTo().activeElement();
        BrowserUtils.wait(1);
        sendMessage.sendKeys("Hello Batch15");
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click();  // uploadFile
        BrowserUtils.wait(2);

        driver.findElement(By.name("bxu_files[]")).sendKeys(System.getProperty("user.dir")+"/pom.xml");  // sendFile

        BrowserUtils.wait(1);
        driver.findElement(By.id("blog-submit-button-save")).click();
    }

    @Test(description = "download from external drive")
    public void test2() {

        driver.findElement(By.id("microoPostFormLHE_blogPostForm")).click();  // sendMessageField
        driver.switchTo().frame(0);

        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click(); // uploadFile
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("(//span[@data-bx-doc-handler='gdrive'])[1]")).click();  // downloadFromExternalDrive
    }


    @Test(description = "select documents from bixtrix24")
    public void test3() {
        driver.findElement(By.id("microoPostFormLHE_blogPostForm")).click(); // sendMessageField
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click(); // uploadFile
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link'])[1]")).click();  // selectDocumentFromBitrix24
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[title='Recent items']")).click();  // resentItemsBar
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//a[@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file' and contains(text(),'HELLO.txt')]")).click(); // fileToUploadHELLO
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[class='popup-window-button popup-window-button-accept']")).click(); // selectDocument
    }

    @Test(description = "create files to upload")
    public void test4() {
        driver.findElement(By.id("microoPostFormLHE_blogPostForm")).click(); // sendMessageField
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click();  // uploadFile
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-text'])[1]")).click();  // createFileOptions
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[class='menu-popup-item bx-viewer-popup-item item-gdocs ']")).click(); // createFileInGoogleDocs
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-icon feed-file-icon-doc'])[1]")).click();  // createDocFile

    }

}
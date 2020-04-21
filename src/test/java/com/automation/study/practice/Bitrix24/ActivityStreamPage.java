package com.automation.study.practice.Bitrix24;


/**import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BrowserUtils;

public class ActivityStreamPage extends AbstractBasePage {


    @FindBy(id = "POST_TITLE")
    private WebElement topic;

    @FindBy(id = "microoPostFormLHE_blogPostForm")
    private WebElement sendMessageField;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    private WebElement uploadFile;

    @FindBy(name = "bxu_files[]")
    private WebElement sendFile;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath = "(//span[@data-bx-doc-handler='gdrive'])[1]")
    private WebElement downloadFromExternalDrive;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link'])[1]")
    private WebElement selectDocumentFromBitrix24;

    @FindBy(css = "[title='Recent items']")
    private WebElement recentItemsBar;

    @FindBy(xpath = "//a[@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file' and contains(text(),'HELLO.txt')]")
    private WebElement fileToUploadHELLO;

    @FindBy(css = "[class='popup-window-button popup-window-button-accept']")
    private WebElement selectDocumentButton;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-editor-text'])[1]")
    private WebElement createFileOptions;

    @FindBy(css = "[class='menu-popup-item bx-viewer-popup-item item-gdocs ']")
    private WebElement createFileInGoogleDocs;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-editor-icon feed-file-icon-doc'])[1]")
    private WebElement createDocFile;
    //-----------------------------------------------------------------------------------------------------------
    @FindBy(id = "feed-add-post-form-link-more")
    private WebElement moreOptionsDropdown;

    @FindBy(css = "[class='menu-popup-item menu-popup-no-icon feed-add-post-form-important feed-add-post-form-important-more ']")
    private WebElement announcementOption;

    @FindBy(id = "bx-destination-tag")
    private WebElement addMore;

    @FindBy(css = "[id^='destLastTab_destination']")
    private WebElement recentBar;

    @FindBy(xpath = "(//a[starts-with(@id,'destination')])[3]")
    private WebElement userToTestInRecent;

    @FindBy(css = "[id^='destDepartmentTab_destination']")
    private WebElement employeesAndDepartmentsBar;

    @FindBy(xpath = "(//a[@class='bx-finder-company-department-employee  bx-finder-element'])[3]")
    private WebElement userToTestEmplAndDepnts;

    @FindBy(css = "[id^='destEmailTab_destination']")
    private WebElement emailBar;

    @FindBy(css = "[class='bxhtmled-top-bar-btn bxhtmled-button-link']")
    private WebElement linkIcon;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-text")
    private WebElement linkText;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    private WebElement linkURL;

    @FindBy(id = "undefined")
    private WebElement linkSaveButton;

    @FindBy(id = "feed-add-post-destination-input")
    private WebElement addMoreUsersField;

    @FindBy(css = "[class='popup-window-close-icon']")
    private WebElement popWindowsClose;

    @FindBy(id = "feed-add-post-form-tab-message")
    private WebElement messageSubheader;

    @FindBy(id = "bx-html-editor-iframe-cnt-idPostFormLHE_blogPostForm")
    private WebElement messagePostFrame;

    @FindBy(css = "[class='bxhtmled-top-bar-btn bxhtmled-button-video']")
    private WebElement insertVideoIcon;

    @FindBy(id = "video_idPostFormLHE_blogPostForm-source")
    private WebElement videoLinkURLField;

    @FindBy(css = "[title='Quote text']")
    private WebElement createQuoteIcon;

    @FindBy(id = "bx-b-mention-blogPostForm")
    private WebElement addMentionIcon;

    @FindBy(xpath = "(//*[starts-with(@id,'mention')])[1]")
    private WebElement mentionUser;

    @FindBy(id = "lhe_button_editor_blogPostForm")
    private WebElement visualEditorIcon;

    @FindBy(id = "lhe_button_title_blogPostForm")
    private WebElement topicIcon;

    @FindBy(xpath = "(//*[@class='feed-add-post-form-but-cnt feed-add-videomessage'])[1]")
    private WebElement recordVideoIcon;

    @FindBy(css = "[class='popup-window-button popup-window-button-blue']")
    private WebElement blueAllowButton;

    @FindBy(id = "bx-b-tag-input-blogPostForm")
    private WebElement addTagIcon;

    @FindBy(name = "TAGS_blogPostForm")
    private WebElement createTagField;

    public void clickToUploadFiles() {
        wait.until(ExpectedConditions.visibilityOf(sendMessageField)).click();
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
        uploadFile.click();

    }

    public void uploadPomFileFromLocalDisk(String titleMessage) {
        BrowserUtils.wait(2);
        sendFile.sendKeys(System.getProperty("user.dir") + "/pom.xml");
//        sendMessageField.sendKeys(titleMessage);
//        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();

    }

    public void downloadFromExternalDrive() {
        BrowserUtils.wait(2);
        downloadFromExternalDrive.click();
    }

    public void downloadFromBitrix() {
        BrowserUtils.wait(2);
        selectDocumentFromBitrix24.click();
        wait.until(ExpectedConditions.visibilityOf(recentItemsBar)).click();
        fileToUploadHELLO.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentButton)).click();
//        topic.sendKeys(titleMessage);
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();

    }

    public void createFileToUpload() {
        BrowserUtils.wait(2);
        createFileOptions.click();
        wait.until(ExpectedConditions.visibilityOf(createFileInGoogleDocs)).click();
        wait.until(ExpectedConditions.elementToBeClickable(createDocFile)).click();
    }

    public void goAnnouncementClickMore() {
        wait.until(ExpectedConditions.visibilityOf(moreOptionsDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementOption)).click();
//        driver.switchTo().frame(0);
//        driver.findElement(By.cssSelector("[class='bx-editor-iframe']")).sendKeys("Hello");
//        BrowserUtils.wait(2);
        addMore.click();
    }

    public void goAnnouncement() {
        wait.until(ExpectedConditions.visibilityOf(moreOptionsDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(announcementOption)).click();
    }

    public void addUserFromRecent() {
        wait.until(ExpectedConditions.elementToBeClickable(recentBar)).click();
        wait.until(ExpectedConditions.visibilityOf(userToTestInRecent)).click();
        wait.until(ExpectedConditions.elementToBeClickable(popWindowsClose)).click();
//        sendButton.click();
    }

    public void addUserFromEmployeesAndDepartments() {
        wait.until(ExpectedConditions.elementToBeClickable(employeesAndDepartmentsBar)).click();
        wait.until(ExpectedConditions.visibilityOf(userToTestEmplAndDepnts)).click();
        wait.until(ExpectedConditions.elementToBeClickable(popWindowsClose)).click();
    }

    public void addUserFromEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(emailBar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(popWindowsClose)).click();
    }

    public void addLink(String text, String URL) {
        wait.until(ExpectedConditions.elementToBeClickable(linkIcon)).click();
        BrowserUtils.wait(2);
        linkText.sendKeys(text);
        BrowserUtils.wait(1);
        linkURL.sendKeys(URL);
        wait.until(ExpectedConditions.elementToBeClickable(linkSaveButton)).click();
    }

    public void addRecipientAndSendLink() {
        wait.until(ExpectedConditions.elementToBeClickable(addMore)).click();
        wait.until(ExpectedConditions.elementToBeClickable(popWindowsClose)).click();
        BrowserUtils.wait(2);
        sendButton.click();
    }

    public void addTheVideoURL(String linkURL) {
        wait.until(ExpectedConditions.elementToBeClickable(insertVideoIcon)).click();
        BrowserUtils.wait(2);
        videoLinkURLField.sendKeys(linkURL);
        wait.until(ExpectedConditions.elementToBeClickable(linkSaveButton)).click();
    }

    public void createQuote() {
        wait.until(ExpectedConditions.elementToBeClickable(createQuoteIcon)).click();
//        BrowserUtils.wait(2);
    }

    public void addMention() {
        wait.until(ExpectedConditions.elementToBeClickable(addMentionIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(mentionUser)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void clickVisualEditor() {
        wait.until(ExpectedConditions.elementToBeClickable(visualEditorIcon)).click();
    }

    public void addTopic(String topicMessage) {
        wait.until(ExpectedConditions.elementToBeClickable(topicIcon)).click();
        BrowserUtils.wait(2);
        topic.sendKeys(topicMessage);
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.elementToBeClickable(topicIcon)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public void clickRecordVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(recordVideoIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(blueAllowButton)).click();
    }

    public void createTag(String tag) {
        wait.until(ExpectedConditions.elementToBeClickable(addTagIcon)).click();
        BrowserUtils.wait(2);
        createTagField.sendKeys(tag, Keys.ENTER);

    }

}**/

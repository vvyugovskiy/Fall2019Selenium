package org.automation.tests.vytrack.login;

import org.automation.pages.LoginPage;
import org.automation.tests.vytrack.AbstractTestBase;
import org.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is a "Dashboard"
     */
    @Test
    public void verifyPageTitle (){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard","Tittle mismatch");
    }
    /**
     * Enter wrong credentials and verify warning message
     */
    @Test
    public void verifyWarningMessage (){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
    }
}

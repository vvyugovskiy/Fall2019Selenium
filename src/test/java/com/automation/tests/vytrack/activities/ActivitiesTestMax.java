package com.automation.tests.vytrack.activities;

import com.automation.pages.activities.ActivitiesPageMax;
import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivitiesTestMax extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    ActivitiesPageMax activitiesPage = new ActivitiesPageMax();

    @Test
    public void addActivitiesAndCancel() {

       loginPage.login();
        activitiesPage.navigateTo("Activities", "Calendar Events");
        activitiesPage.clickCreateButton();
        activitiesPage.createEvent();

        String expectedDescription = activitiesPage.getDescriptionTxt();
        Assert.assertEquals(expectedDescription,"Checking Event");
    }

}

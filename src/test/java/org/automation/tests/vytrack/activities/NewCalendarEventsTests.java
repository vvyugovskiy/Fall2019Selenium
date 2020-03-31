package org.automation.tests.vytrack.activities;

import org.automation.pages.LoginPage;
import org.automation.pages.activities.CalendarEventsPage;
import org.automation.tests.vytrack.AbstractTestBase;
import org.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    /**
     * Test Case: Default options
     * Login as sales manager
     * Click on Create Calendar Event
     * Default owner name should be current user
     */

    @Test
    public void defaultOptionsTest() {

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.gerCurrentUserName());

        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);
    }

    /**
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     */
    @Test
    public void timeDifference() {
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        // MY WAY
//        String actualStartTime = calendarEventsPage.getStartTime().split(":")[0];
//        int intStartTime = Integer.parseInt(actualStartTime);
//        if (intStartTime==12){
//            intStartTime=0;
//        }
//        System.out.println(intStartTime);
//        String actualEndTime = calendarEventsPage.getEndTime().split(":")[0];
//        int intEndTime = Integer.parseInt(actualEndTime);
//        System.out.println(intEndTime);
//        Assert.assertEquals(intEndTime,intStartTime+1);

        String starTime = calendarEventsPage.getStartTime();
        String endTime = calendarEventsPage.getEndTime();
        String format = "h:mm a"; // format 5:15 AM for example

        long actual = DateTimeUtilities.getTimeDifference(starTime, endTime, format);

        Assert.assertEquals(actual, 1, "Time difference is not correct");

    }

    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     */

    @Test
    public void verifyColumnNamesTest (){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");

        Assert.assertEquals(calendarEventsPage.getColumnNames(),expected);
    }
}

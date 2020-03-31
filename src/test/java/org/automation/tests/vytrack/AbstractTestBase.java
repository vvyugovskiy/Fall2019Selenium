package org.automation.tests.vytrack;

import org.automation.utilities.ConfigurationReader;
import org.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTestBase {


    // will be visible in the subclass, regardless on subclass location (same package or not)
    protected WebDriverWait wait;
    protected Actions action;

    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        action = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
}

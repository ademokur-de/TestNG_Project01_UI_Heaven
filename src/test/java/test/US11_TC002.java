package test;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US11_TC002 extends TestBaseReport {

    @Test
    public void testLoginCorrectly(){
        extentTest=extentReports.createTest("testLoginCorrectly","testLoginCorrectly");
        UserHomepage userHomepage = new UserHomepage();
        UserDashboard userDashboard = new UserDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Navigated related page");
        //Verify that the home page is visible
        Assert.assertTrue(userHomepage.searchForALocation.isDisplayed());
        extentTest.pass("Home page is visible");
        //Click Sign in button
        userHomepage.linkSignIn.click();
        extentTest.info("Click Sign in ");
        //Verify that you are in sign in page
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        extentTest.pass("you are in sign in page");
        //Fill in your acoount information and Click 'Login'
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        extentTest.info("filled in sign in page");
        //Verify that logged in as a agent
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        extentTest.pass("you are in agent account");
        //Click Your Account name on navbar
        userDashboard.headerUserName.click();
        extentTest.info("Click Your Account name on navbar");
        //Verify that 'Dasboard' buttons are enabled

        Assert.assertTrue(userDashboard.dashBoard.isDisplayed());
        extentTest.pass("Verify that 'Dasboard' buttons are enabled");
        Assert.assertTrue(userDashboard.userProfileImageAndText.isDisplayed());
        extentTest.pass("Verify that 'userProfileImageAndText' buttons are enabled");
        Assert.assertTrue(userDashboard.settings.isDisplayed());
        extentTest.pass("Verify that 'settings' buttons are enabled");
        Assert.assertTrue(userDashboard.buyCredits.isEnabled());
        extentTest.pass("Verify that 'buyCredits' buttons are enabled");
        Assert.assertTrue(userDashboard.properties.isEnabled());
        extentTest.pass("Verify that 'properties' buttons are enabled");
        Assert.assertTrue(userDashboard.security.isEnabled());
        extentTest.pass("Verify that 'security' buttons are enabled");

        //Click Dashboard buttons as a naturel order and Verify that information of buttons are visible
        userDashboard.allowCookiesButton.click();
        Assert.assertTrue(userDashboard.approvedProperties.isDisplayed());
        extentTest.pass("Verify that 'approvedProperties' buttons are visible");


        userDashboard.settings.click();
        ReusableMethods.sleep(4);
        Assert.assertTrue(userDashboard.accountInformationText.isDisplayed());
        extentTest.pass("Verify that 'accountInformationText' buttons are visible");
        ReusableMethods.sleep(2);


        userDashboard.buyCredits.click();
        ReusableMethods.sleep(4);
        Assert.assertTrue(userDashboard.buyCreditsPageVisible.isDisplayed());
        extentTest.pass("Verify that 'buyCreditsPageVisible' buttons are visible");
        ReusableMethods.wait(2);


        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitAndClick(userDashboard.properties);
        ReusableMethods.wait(3);
        Assert.assertTrue(userDashboard.propertiesPageVisible.isDisplayed());
        extentTest.pass("Verify that 'propertiesPageVisible' buttons are visible");
        ReusableMethods.wait(2);


        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitAndClick(userDashboard.writeAProperty);
        ReusableMethods.sleep(2000);
        Assert.assertTrue(userDashboard.writePropertySaveButton.isDisplayed());
        extentTest.pass("Verify that 'writePropertySaveButton' buttons are visible");


        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitAndClick(userDashboard.security);
        ReusableMethods.sleep(4);
        Assert.assertTrue(userDashboard.securityText.isDisplayed());
        extentTest.pass("Verify that 'securityText' buttons are visible");
        ReusableMethods.wait(1);


        //Log out from the agent account
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitAndClick(userDashboard.userDashboardLogOut);
        //Verify that you are logged out
        ReusableMethods.wait(1);
        Assert.assertTrue(userHomepage.linkSignIn.isEnabled());
        extentTest.pass("Verify that you are logged out");


        //Think about WebDriverWait instead of sleep
    }



}

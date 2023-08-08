package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US11_TC003 extends TestBaseReport {

    @Test
    public void testMakeSureUserIsCorrectAgent(){
        extentTest=extentReports.createTest("testMakeSureUserIsCorrectAgent","testMakeSureUserIsCorrectAgent");

        UserHomepage userHomepage = new UserHomepage();
        UserDashboard userDashboard = new UserDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Verify that the home page is visible
        Assert.assertTrue(userHomepage.searchForALocation.isDisplayed());
        extentTest.pass("Verify that the home page is visible");
        //Click Sign in button
        userHomepage.linkSignIn.click();
        extentTest.info("Click Sign in button");
        //Verify that you are in sign in page
        ReusableMethods.wait(1);
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        extentTest.pass("Verify that you are in sign in page");
        //Fill in your acoount information and Click 'Login'
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        extentTest.info("Fill in your acoount information and Click 'Login'");
        //Verify that logged user name contains your agent user name
        ReusableMethods.wait(1);
        String expectedResult = ConfigReader.getProperty("firstName");
        String actualResult =userDashboard.labelUserName.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("Verify that logged user name contains your agent user name");
        //Log out from the agent account
        userDashboard.headerLogOutButton.click();
        extentTest.info("Log out from the agent account");
        //Verify that you are logged out
        Assert.assertTrue(userHomepage.linkSignIn.isDisplayed());
        extentTest.pass("Verify that you are logged out");

    }
}

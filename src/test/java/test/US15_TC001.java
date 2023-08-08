package test;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US15_TC001 extends TestBaseReport {

    @Test
    public void testLoginAndNewAddsOnDashboard () {
        extentTest=extentReports.createTest("testLoginAndNewAddsOnDashboard","testLoginAndNewAddsOnDashboard");
        UserHomepage userHomepage = new UserHomepage();
        Actions actions = new Actions(Driver.getDriver());

        //1-Open browser
        UserDashboard userDashboard = new UserDashboard();
        //2-Navigate to "qa.hausehaven.com"
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Navigate to url 'https://qa.hauseheaven.com/'");
        //3-Cookies
        userDashboard.allowCookiesButton.click();

        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();

        //6-Enter correct email/username, password and click login
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.pass("Username is visible");
        ReusableMethods.sleep(3);
    }


}
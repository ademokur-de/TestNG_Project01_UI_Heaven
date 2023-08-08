package test;

import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US24_TC001 extends TestBaseReport {
    @Test
    public void loginSuccesfullyAsUser() {
        extentTest=extentReports.createTest("loginSuccesfullyAsUser","The user should be able to login to the qa.hauseheaven.com successfully");
        //1. Open browser
        //Navigate to url 'https://qa.hauseheaven.com/'

        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //Login the page successfully
        userDashboard.headerSignIn.click();
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        //3. Click on "Blog" page link
        userDashboard.clickOnBlog.click();

    }
}

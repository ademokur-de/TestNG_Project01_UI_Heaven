package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US13_TC01_Vysl extends TestBaseReport {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Account Dashboard in successfully visibility","After the user logs in, it is verified that the Dashboard is visible");

    //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

    //Click on the Sign In button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.clickOnSignup.click();

    //Enter your account details and click on the 'Login' button
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.allowCookiesButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        userDashboard.clickSignUpLogin.click();

        userDashboard.clickOnSignup.click();

        //Verify that you are logged in as a member
        String expectedTitle = "Team1 Project";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.info("Verify that you are logged in as a member");

        Driver.closeDriver();
    }

}

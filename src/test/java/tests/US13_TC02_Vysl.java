package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US13_TC02_Vysl extends TestBaseReport {

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Update in Account Information section","Verify that an update has been made in the Account Information section");

        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //Click on the Login button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.headerSignIn.click();

        //Enter your account details and click on the 'Login' button
        userDashboard.emailInput.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.allowCookiesButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        userDashboard.clickSignUpLogin.click();
        userDashboard.clickOnSignup.click();

        //Click on the Settings button
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        userDashboard.settings.click();

        ReusableMethods.wait(1);

        //Verify that page is visible successfully
        Assert.assertTrue(userDashboard.settingsPageVisible.isDisplayed());

        //Update the Account Information section and click on the save button

        userDashboard.phoneInput.clear();
        userDashboard.phoneInput.sendKeys("+4912345678");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        userDashboard.ContactSendMessageButton.click();

        //Verify that the page has been successfully registered

        Assert.assertTrue(userDashboard.settingsRegisteredVisible.isDisplayed());
        extentTest.info("Verify that the page has been successfully registered");

        Driver.closeDriver();

    }
}


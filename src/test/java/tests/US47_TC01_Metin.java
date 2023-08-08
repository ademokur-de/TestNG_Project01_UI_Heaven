package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US47_TC01_Metin extends TestBaseReport {
    @Test
    public void testLoginAndFindLocations(){
        extentTest=extentReports.createTest("testLoginAndFindLocations","testLoginAndFindLocations");

        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to url 'https://qa.hauseheaven.com/admin/login'");

        //Verify that the admin login page is visible
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that the admin login page is visible");

        //Fill in admin information and Click 'Sign in' button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin02"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("Fill in admin information and Click 'Sign in' button");

        //Verify that you are loged in admin dashboard
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserButtonOnHeader.isDisplayed());
        extentTest.pass("Verify that you are loged in admin dashboard");
        //Click 'Side bar switch'
        adminDashboard.sideBarButton.click();
        extentTest.info("Click 'Side Bar Switch'");

        //Verify that 'Locations' button is enabled
        Assert.assertTrue(adminDashboard.locationsButton.isEnabled());
        extentTest.pass("Verify that 'Locations' button is enabled");
    }
}

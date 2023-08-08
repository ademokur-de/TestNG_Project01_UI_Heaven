package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US50_TC01_Metin extends TestBaseReport {
    @Test
    public void testReachingCitiesPage(){
        extentTest=extentReports.createTest("testReachingCitiesPage","testReachingCitiesPage");

        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("//Navigate to url 'https://qa.hauseheaven.com/admin/login'");
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
        extentTest.info("Click 'Side bar switch'");
        //Click 'Locations'
        ReusableMethods.sleep(3);
        adminDashboard.locationsButton.click();
        extentTest.info("Click 'Locations'");
        //Click Cities' under Locations
        ReusableMethods.sleep(3);
        adminDashboard.locationsCitiesButton.click();
        extentTest.info("Click Cities' under Locations");
        //Verify that you are in cities page
        ReusableMethods.sleep(3);
        Assert.assertTrue(adminDashboard.labelCitiesText.isDisplayed());
        extentTest.info("Verify that you are in cities page");
        //Click log out
        ReusableMethods.sleep(3);
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.sleep(8);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Click log out");
        ReusableMethods.sleep(3);
        //Verify that you are loged out
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("Verify that you are loged out");
    }
}

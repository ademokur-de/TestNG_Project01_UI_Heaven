package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US29_TC01_Metin extends TestBaseReport {
    @Test
    public void testReachPostPageAndVerify(){
        extentTest=extentReports.createTest("testReachPostPageAndVerify","testReachPostPageAndVerify");

        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to url 'https://qa.hauseheaven.com/admin/login'");
        //Verify that the admin login page is visible
        Assert.assertTrue(adminDashboard.adminLogInButton.isDisplayed());
        extentTest.pass("Verify that the admin login page is visible");
        //Fill in admin information and Click 'Sign in' button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin02"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("Fill in admin information and Click 'Sign in' button");
        //Click 'Side Bar Switch'
        ReusableMethods.wait(2);
        adminDashboard.sideBarButton.click();
        extentTest.info("Click 'Side Bar Switch'");
        //Click 'Blog'
        ReusableMethods.sleep(5);
        adminDashboard.blogButton.click();
        extentTest.info("Click 'Blog'");
        //Click 'Post'
        ReusableMethods.sleep(4);
        adminDashboard.postButton.click();
        extentTest.info("Click 'Post'");
        //Verify that the admin post page is visible
        ReusableMethods.sleep(6);
        Assert.assertTrue(adminDashboard.blogPostCreateButton.isDisplayed());
        extentTest.pass("Verify that the admin post page is visible");

    }
}

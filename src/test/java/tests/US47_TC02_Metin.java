package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US47_TC02_Metin extends TestBaseReport {
    @Test
    public void testSideBarButtonsAreEnabled(){
        extentTest=extentReports.createTest("testSideBarButtonsAreEnabled","testSideBarButtonsAreEnabled");

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

        //Verify that all buttons on side bar is enabled
        int counter =0;
        try {
            for (int i = 1; i <=12 ; i++) {
                String sideBarListDynamic = "//ul[@class='page-sidebar-menu page-header-fixed ']/li["+i+"]/a";
                Assert.assertTrue(Driver.getDriver().findElement(By.xpath(sideBarListDynamic)).isDisplayed());
                 counter++;
            }
        }catch(RuntimeException e) {
            System.out.println(counter + ". button is not enabled");
            Assert.fail();
            extentTest.fail(counter+". button is not enabled");
        }
        //Click 'Log out'
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.wait(1);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Click 'Log out'");
        //Verify that you are logged out
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("Verify that you are logged out");

    }
}

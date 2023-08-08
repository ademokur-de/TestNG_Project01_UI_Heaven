package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US46_TC002_Sevda extends TestBaseReport {
    @Test
    public void viewPaymentOnAdminPage() {
        extentTest=extentReports.createTest("viewPaymentOnAdminPage","viewPaymentOnAdminPage");
        //1. Open browser
        //2. Navigate to admin login page

        AdminDashboard adminDashboard=new AdminDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        //3. Log in as admin
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("Fill in admin information and Click 'Sign in' button");

        //4. Click on "payments" button in left panel
        adminDashboard.payments.click();
        adminDashboard.transactionsUnderPayments.click();

        //5. Verify displayed payments
        Assert.assertTrue(adminDashboard.transactionsConfirm.isDisplayed());
        Assert.assertTrue(adminDashboard.transactionsConfirm.isEnabled());

        //6. Click 'Log out'
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.wait(1);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Click 'Log out'");

        //7. Verify that you are logged out
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("Verify that you are logged out");

    }
}

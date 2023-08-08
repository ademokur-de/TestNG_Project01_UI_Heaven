package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US42_TC01_Firdevs extends TestBaseReport {


    @Test
    public void test01() {
        extentTest=extentReports.createTest("Admin Dashboard Packages Test","Admin should be able to access the packages page and verify that the new packages can be added,viewed,editted and deleted. ");

        AdminDashboard adminDashboard = new AdminDashboard();
        UserDashboard userDashboard = new UserDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());

        //The user logins to "https://qa.hauseheaven.com/admin/login" page.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        ReusableMethods.wait(2);

        //Admin logs to the system with its user name and password.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        extentTest.info("Admin accesses the Admin page");

        ReusableMethods.wait(2);
        //It is successfully directed to Dashboard.
        Assert.assertTrue(adminDashboard.adminDasboardButton.isDisplayed());
        extentTest.pass("Admin accesses the Admin Packages Page");

        //It accesses the "Packages" page via menu or links on the page.
        adminDashboard.dashboardPackageslinkButton.click();

        ReusableMethods.wait(2);

        //It is successfully directed to Dashboard.
        Assert.assertTrue(adminDashboard.adminDasboardButton.isDisplayed());
        extentTest.pass("It is verified that Admin Dashboard Packages Page has been successfully accessed.");

        //It accesses the "Packages" page via menu or links on the page.
        adminDashboard.adminDasboardButton.click();
        adminDashboard.dashboardPackageslinkButton.click();

        ReusableMethods.wait(2);

        Assert.assertTrue(adminDashboard.dashboardPackagesIlkElement.isEnabled());
        extentTest.pass("It is verified that First Element in Packages Pages has been enabled.");

        //Enter the package information and click the "Save&Exit" button.
        actions.moveToElement(adminDashboard.tagsCrateButton).click().perform();

        ReusableMethods.wait(3);

        actions.moveToElement(adminDashboard.packagesCreateName).click().perform();

        actions.moveToElement(adminDashboard.packagesCreateName).sendKeys("House"+ Keys.TAB)
                .sendKeys("3000"+Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10"+ Keys.TAB)
                .sendKeys("4"+Keys.TAB)
                .sendKeys("1").perform();

        WebElement SaveExitButton = Driver.getDriver().findElement(By.xpath("(//*[@class='btn btn-info'])[2]"));
        //Click Save&Exit Button
        actions.moveToElement(SaveExitButton).click().perform();

        //Verify that the new package is succesfully added.
        Assert.assertTrue(userDashboard.labelSuccessfullyMessage.isDisplayed());
        extentTest.pass("It is verified that the new package is successfully added.");

        //Click the package he wants to edit.
        actions.moveToElement(adminDashboard.packagesEditButon).click().perform();

        ReusableMethods.wait(3);

        //Updates the package information and click the "Update" button.

        actions.moveToElement(adminDashboard.packagesCreateName).doubleClick().perform();

        actions.moveToElement(adminDashboard.packagesCreateName).sendKeys("Villa"+ Keys.TAB)
                .sendKeys("0"+Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys("15"+ Keys.TAB).sendKeys(Keys.BACK_SPACE)
                .sendKeys("1"+Keys.TAB).sendKeys(Keys.BACK_SPACE)
                .sendKeys("2"+Keys.TAB)
                .sendKeys("1"+Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

        ReusableMethods.wait(3);

        //Verify that the new package is succesfully updated.
        Assert.assertTrue(userDashboard.labelSuccessfullyMessage.isDisplayed());
        extentTest.pass("It is verified that the new package is successfully updated. ");

        //He clicks on the package he wants to delete.
        actions.moveToElement(adminDashboard.packagesDeleteButton).click().perform();
        ReusableMethods.wait(2);

        //Confirm the package deletion.
        actions.click(userDashboard.buttonDeleteConfirm).perform();

        //Verify that the package has been removed from the list.
        Assert.assertTrue(userDashboard.labelSuccessfullyMessage.isDisplayed());
        extentTest.pass("It is verified thar the deletion process is successfully done.");

        Driver.quitDriver();

    }


}

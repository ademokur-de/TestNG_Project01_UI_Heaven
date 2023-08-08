package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;
import java.util.List;

public class US28_TC002_Sevda extends TestBaseReport{
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
        ReusableMethods.wait(2);

        // Blog baslıgını tikla ve menüde baslıgin altında beliren itemlerinin gorunurlugunu kontrol
        adminDashboard.blogButtonCorrection.click();

        // Posts'un gorunur oldugunu dogrula
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.blogPostsButton.isDisplayed());

        // Categories'in gorunur oldugunu dogrula

        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.blogCategoriesButton.isDisplayed());

        // Tags'in gorunur oldugunu dogrula

        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.blogTagsButton.isDisplayed());

/*
        //Blog baslıgını tikla ve menüde baslıgin altında beliren itemlerinin aktifligini kontrol et
        // Blog baslıgınin altindaki Post'u tikla ve aktif oldugunu dogrula
        adminDashboard.blogPostsButton.click();
        ReusableMethods.wait(2);

        //gorunurlulugunu dogrula
        adminDashboard.blogCategoriesButton.getText();
        Assert.assertTrue(adminDashboard.blogCategoriesButton.isDisplayed());

        // Blog baslıgı altindaki Posts tikla aktif oldugunu dogrula
        adminDashboard.blogPostsButton.click();
        ReusableMethods.wait(2);
*/
        // Blog baslıgı altindaki menülerin görüntülenebilir ve aktif oldugunu dogrula
        List<WebElement> tagsList = Driver.getDriver().findElements(By.xpath("//*[@id='cms-plugins-blog']"));
        Assert.assertFalse(tagsList.isEmpty());

        for (WebElement eachTag : tagsList) {
            Assert.assertTrue(eachTag.isDisplayed());
            Assert.assertTrue(eachTag.isEnabled());
        }

/*
        //Click 'Log out'
    //    adminDashboard.adminUserButtonOnHeader.click();
    //    ReusableMethods.wait(1);
    //    adminDashboard.adminLogOutButton.click();
    //    extentTest.info("Click 'Log out'");
    //    //Verify that you are logged out
    //    Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
    //    extentTest.pass("Verify that you are logged out");
    */

    }
}


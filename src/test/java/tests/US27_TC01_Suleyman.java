package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US27_TC01_Suleyman extends TestBaseReport {

    // US027
    // admin dashoboard sayfasında Header bölümünden, sitenin anasayfasına gidebildiğimi,
    // kenardaki menüyü açıp kapatabildiğimi,
    // notification bölümüne ulaşabildiğimi,
    // profil bilgileri sayfasına gidebildiğimi,
    // kullanıcı bilgilerimi düzenleyebildiğimi,
    // şifremi değiştirebildiğimi,
    // çıkış yaparak admin giriş sayfasına ulaşabildiğimi doğrulayabilmeliyim


    @Test
    public void test() {
    extentTest = extentReports.createTest("admin dashboard tests", "Check that the test works correctly");

        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Verify that the admin login page is visible
        Assert.assertTrue(adminDashboard.adminLogInButton.isDisplayed());
        //Fill in admin information and Click 'Sign in' button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin02"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Click 'Side Bar Switch'
        ReusableMethods.sleep(5);
        adminDashboard.sideBarButton.click();

        //Header bölümünden, sitenin anasayfasına gidebildiğimi

        Assert.assertTrue(adminDashboard.viewWebsiteButton.isEnabled());
        extentTest.pass("I can go to the homepage of the site from the Header section");
        //adminDashboard.viewWebsiteButton.click();

// ----------------Sol Menu gizlenme Testi----------------------------

        Assert.assertTrue(adminDashboard.realEstateButton.isDisplayed());
        extentTest.pass("Leftside menu is showing");
        adminDashboard.navigateMenuIcon.click();
        Assert.assertFalse(adminDashboard.smallMenuIcon.isDisplayed());
        extentTest.pass("Leftside menu is not show");



// -------------------------------------------------------------------
// --------------- notification bölümüne ulaşabildiğimi,--------------

        // notification bölümü ???? anlamadim
// -------------------------------------------------------------------


//------------------ profil bilgileri sayfasına gidebildiğimi,--------

        adminDashboard.adminUserNameAdminHeader.click();
        adminDashboard.adminUserProfileButton_SI.click();
        ReusableMethods.wait(3);


        String expectedProfilText = "User profile";
        String actualProfilText = adminDashboard.profilPageSectionName.getText();
        // Assert.assertTrue() yöntemi ile User profile  da oldugumuzu doğrulayalım
        Assert.assertTrue(actualProfilText.contains(expectedProfilText));
        extentTest.pass("can go to admin profil page");


// kullanıcı bilgilerimi düzenleyebildiğimi,

        String oldUserFirstName = adminDashboard.textBoxAdminFirstName.getText();
        adminDashboard.textBoxAdminFirstName.sendKeys(" Changed");
        String oldUserLastName = adminDashboard.textBoxAdminLastName.getText();
        adminDashboard.textBoxAdminLastName.sendKeys(" Changed");

        String expectedFirstName = oldUserFirstName+" Changed";
        String expectedLastName = oldUserLastName+" Changed";
        String actualFirstName =  adminDashboard.textBoxAdminFirstName.getText();
        String actualLastName =  adminDashboard.textBoxAdminLastName.getText();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", adminDashboard.adminUpDateButton);

        //   adminDashboard.adminUpDateButton.click();
        ReusableMethods.wait(5);

        // Degisiklik yapilamiyor BUG !!!
        Assert.assertFalse(actualFirstName.contains(expectedFirstName));
        Assert.assertFalse(actualLastName.contains(expectedLastName));
        extentTest.pass("Admin user information is not changeable, there is BUG !");


        //--------------- Degisiklik yapilmasina izin verilmiyor


        // şifremi değiştirebildiğimi,

        Driver.getDriver().switchTo().alert().accept();  //Alert kabul edildi

        jse.executeScript("arguments[0].click();", adminDashboard.adminChangePassword);
        ReusableMethods.wait(2);

        //Driver.getDriver().switchTo().alert().accept(); alert tiklama gerekirse

        adminDashboard.textBoxAdminCurrentPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.textBoxAdminNewtPassword.sendKeys("123456");
        adminDashboard.textBoxAdminConfirmNewPassword.sendKeys("123456");

        adminDashboard.adminUpDateButton.click();
        ReusableMethods.wait(20);




        // çıkış yaparak admin giriş sayfasına ulaşabildiğimi doğrulayabilmeliyim

        Driver.getDriver().navigate().back();
        ReusableMethods.wait(3);

        adminDashboard.adminUserNameAdminHeader.click();
        adminDashboard.adminLogOutButton.click();
        ReusableMethods.wait(3);



        // ----------------- Leave e nasil tiklamaliyiz -------------------



        Assert.assertTrue(adminDashboard.adminLoginBox_SI.isDisplayed());
        extentTest.pass("Admin user login page is show");

        Driver.quitDriver();
    }
}
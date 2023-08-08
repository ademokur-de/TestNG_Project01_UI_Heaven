package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US36_TC001_Sule extends TestBaseReport {

    //US 036
    // admin dahsboarda giriş yapıp
    // Real Estate başlığının altındaki Facilities sayfasına ulşabildiğimi ve
    // bu sayfadaki Facilities 'lerin görüntülenebildiğini,
    // Facilities sayısının görüntülenebilidiğini,
    // sayfadaki öğelerin görüntülenebilir ve
    // aktif olduğunu,
    // yeni Facilities ekleyip,
    // düzeneleyip
    // silebildiğimi doğrulayabilmeliyim








    @Test

    public void test01() {

    extentTest = extentReports.createTest("admin Dasboard Entry test", "User should be entry admin dashboard");

        AdminDashboard adminDashboard = new AdminDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();



        //The user logins to "https://qa.hauseheaven.com/admin/login" page.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        //Admin logs to the system with its user name and password.

        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();


        //It is successfully directed to Dashboard.
        ReusableMethods.wait(3);

        Assert.assertTrue(adminDashboard.adminDasboardButton.isDisplayed());
        extentTest.pass("Login to Admin Dashboard");


    }
    @Test

    public void test02() {
        extentTest = extentReports.createTest("admin Dasboard Entry test", "User should be entry admin dashboard");
        AdminDashboard adminDashboard = new AdminDashboard();
        //The user logins to "https://qa.hauseheaven.com/admin/login" page.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        //Admin logs to the system with its user name and password.

        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();

        //It accesses the "Facilities" page under the Real Estate.
        // Click the Real Estate button.
        ReusableMethods.wait(2);
        adminDashboard.sideBarButton.click();
        ReusableMethods.sleep(4);
        adminDashboard.realEstateButton.click();
        ReusableMethods.sleep(5);
        Assert.assertTrue(adminDashboard.realEstateFacilityButton.isEnabled());




        ReusableMethods.wait(2);
        adminDashboard.realEstateFacilityButton.click();
        Assert.assertTrue(adminDashboard.facilitiesCreatDate.isEnabled());
        extentTest.pass("Facilities Menu is available");
        ReusableMethods.wait(2);
//----------Facilities sayısının görüntülenebilidiğini ----------------------
//---------- Liste altindaki record sayisini kontrol ederek SIFIR dan buyukse kayitlarin oldugu dogrulanir
        Assert.assertTrue(adminDashboard.labelPropertiesRecords.isDisplayed());
        extentTest.pass("Real Estate Records showed");
        String records = adminDashboard.labelPropertiesRecords.getText();
        int recordCount = Integer.parseInt(records);

        Assert.assertTrue(recordCount > 0, "Kayıt sayısı sıfır veya negatif: " + recordCount);
        extentTest.pass("There are Real Estate Records Showing");
//---------------------------------------------------------------------------

// ------------   // sayfadaki öğelerin görüntülenebilir ve------------------

        Assert.assertTrue(adminDashboard.facilitiesListOgeId.isDisplayed());
        Assert.assertTrue(adminDashboard.facilitiesName.isDisplayed());
        Assert.assertTrue(adminDashboard.facilitiesCreatDate.isDisplayed());
        extentTest.pass("Records are visible");

//----------------------------------------------------------------------------
// ---------------- aktif olduğunu--------------------------------------------

        Assert.assertTrue(adminDashboard.facilitiesName.isEnabled());
        extentTest.pass("Facilities Record Link is active");

//----------------------------------------------------------------------------


//------------------- yeni Facilities ekleyip---------------------------------
        adminDashboard.propertiesCreateButton.click();
        ReusableMethods.wait(2);
        adminDashboard.textBoxFacilitiesName.sendKeys("Test Facilities Name");

        adminDashboard.facilitiesIconSelector.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.sleep(100);

        ReusableMethods.wait(3);
        adminDashboard.facilitiesSaveButton.click();

        String actualFacilityName = adminDashboard.facilitiesName.getText();
        String expectedFacilityName = "Test Facilities Name";
        Assert.assertEquals(actualFacilityName, expectedFacilityName);
        extentTest.pass("Check that new Facilities can be added");


//----------------------------------------------------------------------------

//--- düzeneleyip silebildiğimi doğrulayabilmeliyim---------------------------

        adminDashboard.editButton.click();
        ReusableMethods.wait(2);


        adminDashboard.textBoxFacilitiesName.sendKeys(" Changed");

        adminDashboard.facilitiesIconSelector.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.sleep(100);

        ReusableMethods.wait(3);
        adminDashboard.facilitiesSaveButton.click();

        actualFacilityName = adminDashboard.facilitiesName.getText();
        expectedFacilityName = "Test Facilities Name Changed";
        Assert.assertEquals(actualFacilityName, expectedFacilityName);
        extentTest.pass("Facilities record can be edited is controlled");

//----------------- silebildiğimi doğrulayabilmeliyim-------------------------


        String actualFacilityIDBefore = adminDashboard.facilitiesListOgeId.getText();
        System.out.println("Before Deletion: " + actualFacilityIDBefore);

        adminDashboard.deleteButton.click();
        ReusableMethods.wait(2);

        //silme islemi onayla
        adminDashboard.deleteConfirmButtonYusuf.click();
        // silme islemi basarili olarak gerceklesti
        String succesfullyYazis=adminDashboard.deleteSuccessfullyText.getText();
        System.out.println(succesfullyYazis);
        Assert.assertTrue(adminDashboard.deleteSuccessfullyText.isDisplayed());
        extentTest.pass("Facilities record can be deleted is controlled");
        ReusableMethods.wait(3);


        String actualFacilityIDAfter = adminDashboard.facilitiesListOgeId.getText();
        System.out.println("After Deletion: " + actualFacilityIDAfter);

// Assert.assertFalse() yöntemi ile kaydin silindiğini doğrulayalım
        Assert.assertFalse(actualFacilityIDAfter.contains(actualFacilityIDBefore));
        extentTest.pass("tested and checked that the previous data is no longer available");




Driver.quitDriver();


    }


}








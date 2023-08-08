package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;


public class US35_TC01_Enver extends TestBaseReport {
    //admin dahsboarda giriş yapıp
    // Real Estate başlığının altındaki properties sayfasına ulşabildiğimi
    // bu sayfadaki Feautres sayfasina git
    // bu features sayfasinin görüntülenebildiğini dogrula
    // yeni features ekle
    // features düzenele
    // features sil




    @Test
    public void adminDahsboardTesti2() throws InterruptedException {
        AdminDashboard adminDashboard=new AdminDashboard();

        Actions actions= new Actions(Driver.getDriver());


        //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest = extentReports.createTest("sf.ya ulasma-modul ekle ve kaldir", "testin dogru olarak calistigi konrol edilir");

        // admin dahsboard anasayfa Email/Username kutusuna
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(((ConfigReader.getProperty("admin01")+ Keys.TAB)));
        ReusableMethods.wait(1);
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));
        ReusableMethods.wait(1);
        adminDashboard.adminLogInButton.click();
        extentTest.pass("AdminDashboard a login olunur");

        // Dashboard altindaki realestate butonuna tiklanir ve onun da altindaki propertiese gidilir/
        adminDashboard.realEstateButton.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki realstates e gidilir");

        // Realestate altindaki properties butonuna tikla
        adminDashboard.realEstatePropertiesButton.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki realstates in altindaki propertiese gidilir");

        //properties sayfasina gidilebildigini dogrula
        String properties=adminDashboard.realEstatePropertiesButton.getText();
        System.out.println(properties);
        Assert.assertTrue(adminDashboard.realEstatePropertiesButton.isDisplayed());
        extentTest.pass("AdminDashboard un altindaki realstates in altindaki properties sayfasi dogrulanir");

        //propertiesin altindaki Features butonuna tikla
        adminDashboard.realEstateFeatureButton.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki realstates in altindaki propertiese in altindaki featurese gidilir");

        //properties sayfasina gidilebildigini dogrula
        String featuresDogrula=adminDashboard.realEstateFeatureButton.getText();
        System.out.println(featuresDogrula);
        Assert.assertTrue(adminDashboard.realEstateFeatureButton.isDisplayed());
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki realstates in altindaki properties gidildigi dogrulanir");

        //yeni features ekle
        adminDashboard.propertiesCreateButton.click();
        adminDashboard.textBoxPropertiesTitle.sendKeys(ConfigReader.getProperty("null")+ Keys.TAB);
        adminDashboard.saveExitButton.click();
        ReusableMethods.wait(2);
        extentTest.pass("AdminDashboard un altindaki realstates in altindaki propertiese ekleme ve silme yapilir");

        //fetureslerden birini sil
        adminDashboard.deleteButton.click();
        ReusableMethods.wait(1);







}
}
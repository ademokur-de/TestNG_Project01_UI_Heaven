package test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US33_TC001_Yusuf extends TestBaseReport {

   //1-Browser acilirhttps://qa.hauseheaven.com/admin/login url gidilir
   //2-Kullanıcı, admin yetkileriyle sisteme giris yaptigi dogrulanir
   //3-Admin dahsboarda tiklanarak dogru giriş yaptigi dogrulanir
   //4-Real Estate başlığının altındaki menülerin görüntülenebilir ve aktif olduğunu doğrulanir






    @Test
    public void test01() throws InterruptedException {
        AdminDashboard adminDashboard=new AdminDashboard();
        extentTest = extentReports.createTest("gorunurluluk test", "testin dogru olarak calistigi konrol edilir");


        //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // cookies butonu tiklanir
        //userHomepage.cookiesButtonyusuf.click();


        // admin dahsboard anasayfa Email/Username kutusuna amin gonder
        Thread.sleep(3000);
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys((ConfigReader.getProperty("admin01")+ Keys.TAB));
        Thread.sleep(1000);

        // password kutusuna password gonder
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));
        Thread.sleep(1000);

        // radio buton remember click
        adminDashboard.radioButtonRememberMe.click();

        // sign in butonuna tikla
        adminDashboard.adminLogInButton.click();

        ReusableMethods.wait(3);
        // admin Dahsboard sayfasina basarili ulastigı dogrula
        String dahsboardYazisi= adminDashboard.dahsboardYazisiYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(dahsboardYazisi);
        Assert.assertTrue(adminDashboard.dahsboardYazisiYusuf.isDisplayed());
        extentTest.pass("admin Dahsboard sayfasina basarili ulastigi dogrulanir");



        //4-Real Estate başlığının altındaki menülerin görüntülenebilir ve aktif olduğunu doğrulanir

        //a- Real Estate baslıgını tikla ve baslık altındaki butonlarin(menülerin) gorunurlugunu kontrol
        adminDashboard.realEstateButton.click();
        Thread.sleep(1000);


        // properties gorunur oldugunu dogrula
        String propertiesYazisi= adminDashboard.realEstatePropertiesButton.getText();
        // yazdir kontrol et
        System.out.println(propertiesYazisi);
        Assert.assertTrue(adminDashboard.realEstatePropertiesButton.isDisplayed());
        extentTest.pass("properties butonun gorunur oldugunu dogrulanir");


        // feature gorunur oldugunu dogrula
        String featureYazisi = adminDashboard.realEstateFeatureButton.getText();
        // yazdir kontrol et
        System.out.println(featureYazisi);
        Assert.assertTrue(adminDashboard.realEstateFeatureButton.isDisplayed());
        extentTest.pass("feature butonun gorunur oldugunu dogrulanir");



        // facility gorunur oldugunu dogrula
        String facilityYazisi = adminDashboard.realEstateFacilityButton.getText();
        // yazdir kontrol et
        System.out.println(facilityYazisi);
        Assert.assertTrue(adminDashboard.realEstateFacilityButton.isDisplayed());
        extentTest.pass("facility butonun gorunur oldugunu dogrulanir");



        // categories gorunur oldugunu dogrula
        String categoriesYazisi = adminDashboard.realEstateCategoryButton.getText();
        // yazdir kontrol et
        System.out.println(categoriesYazisi);
        Assert.assertTrue(adminDashboard.realEstateCategoryButton.isDisplayed());
        extentTest.pass("categories butonun gorunur oldugunu dogrulanir");



        // types gorunur oldugunu dogrula
        String typesYazisi = adminDashboard.realEstateTypeButton.getText();
        // yazdir kontrol et
        System.out.println(typesYazisi);
        Assert.assertTrue(adminDashboard.realEstateTypeButton.isDisplayed());
        extentTest.pass("types butonun gorunur oldugunu dogrulanir");



        //b- Real Estate baslıgını tikla ve baslık altındaki butonlarin(menülerin) aktifligini kontrol

        // Real Estate baslıgı altindaki properties tikla aktif oldugunu dogrula
        adminDashboard.realEstatePropertiesButton.click();
        Thread.sleep(2000);



        String propertiesYazisi2= adminDashboard.realEstatePropertiesButton.getText();
        // yazdir gorunurlulugunu kontrol et
        System.out.println(propertiesYazisi2);
        Assert.assertTrue(adminDashboard.realEstatePropertiesButton.isDisplayed());
        extentTest.pass("Real Estate basligi altindaki properties tiklanarak aktif oldugu dogrulanir");




        // Real Estate baslıgı altindaki features tikla aktif oldugunu dogrula
        adminDashboard.realEstateFeatureButton.click();
        Thread.sleep(1000);

        String featuresYazisi2= adminDashboard.realEstateFeatureButton.getText();
        // yazdir gorunurlulugunu kontrol et
        System.out.println(featuresYazisi2);
        Assert.assertTrue(adminDashboard.realEstateFeatureButton.isDisplayed());
        extentTest.pass("Real Estate basligi altindaki features tiklanarak aktif oldugu dogrulanir");



        // Real Estate baslıgı altindaki facilities tikla aktif oldugunu dogrula
        adminDashboard.realEstateFacilityButton.click();
        Thread.sleep(1000);

        String facilitiesYazisi2= adminDashboard.realEstateFacilityButton.getText();
        // yazdir gorunurlulugunu kontrol et
        System.out.println(facilitiesYazisi2);
        Assert.assertTrue(adminDashboard.realEstateFacilityButton.isDisplayed());
        extentTest.pass("Real Estate basligi altindaki facilities tiklanarak aktif oldugu dogrulanir");



        // Real Estate baslıgı altindaki categories tikla aktif oldugunu dogrula
        adminDashboard.realEstateCategoryButton.click();
        Thread.sleep(1000);

        String categoriesYazisi2= adminDashboard.realEstateCategoryButton.getText();
        // yazdir gorunurlulugunu kontrol et
        System.out.println(categoriesYazisi2);
        Assert.assertTrue(adminDashboard.realEstateCategoryButton.isDisplayed());
        extentTest.pass("Real Estate basligi altindaki facilities tiklanarak aktif oldugu dogrulanir");



        // Real Estate baslıgı altindaki types tikla aktif oldugunu dogrula
        adminDashboard.realEstateFacilityButton.click();
        Thread.sleep(1000);

        String typesYazisi2= adminDashboard.realEstateTypeButton.getText();
        // yazdir gorunurlulugunu kontrol et
        System.out.println(typesYazisi2);
        Assert.assertTrue(adminDashboard.realEstateTypeButton.isDisplayed());
        extentTest.pass("Real Estate basligi altindaki types tiklanarak aktif oldugu dogrulanir");

        Driver.quitDriver();

    }
}



package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US37_TC01_Yusuf extends TestBaseReport {

   //1- Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
   //2- Kullanıcı, admin yetkileriyle sisteme giris yaptigi dogrulanir
   //3- Real Estate başlığının altındaki Categories sayfasına ulaşabildiği
    //  ve bu sayfada Categories 'lerin görüntülenebildiğini,
    //  Categories sayısının görüntülenebildigi dogrulanir
   //4- Categories sayfasındaki öğelerin görüntülenebilir ve aktif olduğu dogrulanir
   //5- Categories'e yeni categories eklenip, duzenlendigini ve silinebildigi dorulanir






    @Test
    public void Test01() throws InterruptedException {
        AdminDashboard adminDashboard=new AdminDashboard();
        Actions actions= new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("gorunurluluk test", "testin dogru olarak calistigi konrol edilir");


        //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));



        // admin dahsboard anasayfa Email/Username kutusuna amin gonder

        ReusableMethods.wait(2);
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));

        // password kutusuna password gonder
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));

        Thread.sleep(3000);
        adminDashboard.radioButtonRememberMe.click();

        // sign in butonuna tikla
        adminDashboard.adminLogInButton.click();

        ReusableMethods.wait(3);
        // admin Dahsboard sayfasina basarili ulastigı dogrula
        String dahsboardYazisi= adminDashboard.dahsboardYazisiYusuf.getText();
        // yazdirarark giris yaptigini kontrol et
        System.out.println(dahsboardYazisi);
        // basarili bir sekilde ulasildigi dogrulanir
        Assert.assertTrue(adminDashboard.dahsboardYazisiYusuf.isDisplayed());
        extentTest.pass("admin Dahsboard sayfasina basarili ulastigi dogrulanir");




        //3-Admin dahsboarda tiklayarak Real Estate başlığının altındaki Categories sayfasına ulaşabildiği dogrulanir
        adminDashboard.adminDasboardButton.click();
        Thread.sleep(2000);

        //a- Real Estate baslıgını tikla ve baslık altındaki Categories sayfasına ulaşabildiği dogrulanir
        adminDashboard.realEstateButton.click();
        Thread.sleep(1000);

        // başlığın altındaki Categories sayfasına ulaşabildiği dogrulanir
        // categories ulaşabildiği yazarak dogrulanir
        String categoriesYazisi = adminDashboard.realEstateCategoryButton.getText();
        // yazdir kontrol et
        System.out.println(categoriesYazisi);
        Assert.assertTrue(adminDashboard.realEstateCategoryButton.isDisplayed());
        extentTest.pass("Real Estate başlığının altındaki Categories sayfasına ulasilabildigi dogrulanir");


        // categories ulaşabildiği tiklanarak dogrulanir
        adminDashboard.realEstateCategoryButton.click();
        Thread.sleep(2000);


        //4-Categories sayfasında Categories'lerin görüntülenebildiğini,
        // Categories sayısının görüntülenebildigi dogrulanir

        // a- Categories 'lerin görüntülenebildiği dogrulanir
        // id category dogrulanir
        String idcategoryYazisi=adminDashboard.idCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(idcategoryYazisi);
        Assert.assertTrue(adminDashboard.idCategoryYusuf.isDisplayed());
        extentTest.pass("Categories'lerden id category gorunurlulugu dogrulanir");


        // name category dogrulanir
        String namecategoryYazisi=adminDashboard.nameCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(namecategoryYazisi);
        Assert.assertTrue(adminDashboard.nameCategoryYusuf.isDisplayed());
        extentTest.pass("Categories'lerden name category gorunurlulugu dogrulanir");



        // parent category dogrulanir
        String parentcategoryYazisi=adminDashboard.parentCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(parentcategoryYazisi);
        Assert.assertTrue(adminDashboard.parentCategoryYusuf.isDisplayed());
        extentTest.pass("Categories'lerden parent category gorunurlulugu dogrulanir");



        // Created At category dogrulanir
        String createdAtcategoryYazisi=adminDashboard.createdAtCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(createdAtcategoryYazisi);
        Assert.assertTrue(adminDashboard.createdAtCategoryYusuf.isDisplayed());
        extentTest.pass("Categories'lerden Created At category gorunurlulugu dogrulanir");



        // Status category dogrulanir
        String statuscategoryYazisi=adminDashboard.statusCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(statuscategoryYazisi);
        Assert.assertTrue(adminDashboard.statusCategoryYusuf.isDisplayed());
        extentTest.pass("Categories'lerden Status category gorunurlulugu dogrulanir");


        // Operations category dogrulanir
        String operationscategoryYazisi=adminDashboard.operationsCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(operationscategoryYazisi);
        Assert.assertTrue(adminDashboard.operationsCategoryYusuf.isDisplayed());
        extentTest.pass("Categories'lerden Operations category gorunurlulugu dogrulanir");



        // b- Categories sayısının görüntülenebildigi dogrulanir

        // JavaScriptExecutor nesnesini oluşturun.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Sayfayı 300 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 300 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 300);");

        // 1 saniye bekle
        Thread.sleep(1000);

        // sonuclar dinamik yapilir
        String expectedResult1=ConfigReader.getProperty("categoriesresult");
        String actualResult1= adminDashboard.categoriesResultYusuf.getText();
        // yazdir kontrol et
        System.out.println(actualResult1);

        Thread.sleep(1000);

        //4- Categories sayfasındaki öğelerin görüntülenebilir ve aktif olduğu dogrulanir
        // Sayfayı -300 piksel yukari kaydırın.
        // Sayfanın aşağı doğru -300 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0,-300);");
        // 3 saniye bekle
        Thread.sleep(2000);


        // creat butonun aktif oldugu dogrulanir
        adminDashboard.propertiesCreateButton.click();
        Thread.sleep(2000);
        // Status category dogrulanir
        String newCategoryYazisi=adminDashboard.newCategoryYazisiYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(newCategoryYazisi);
        Assert.assertTrue(adminDashboard.newCategoryYazisiYusuf.isDisplayed());
        extentTest.pass("Status category gorunurlulugu dogrulanir");


        // reload butonun aktif oldugu dogrulanir
        Driver.getDriver().navigate().back();
        // bekle  2 saniye
        Thread.sleep(2000);
        adminDashboard.reloadButtonYusuf.click();


        //5- Categories'e yeni categories eklenip, duzenlendigini ve silinebildigi dorulanir

        // yeni categoriesler icin creat butonun tiklanir
        adminDashboard.propertiesCreateButton.click();

        Thread.sleep(1000);
        //isim ekle, description, order ekle

        adminDashboard.nameTexyBoxYusuf.click();
        actions.sendKeys("yusuf"+Keys.TAB)
                .sendKeys("cok uzakta bir koy var")
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .perform();
        Thread.sleep(5000);

        // status sec
        Select select= new Select(adminDashboard.statusSelectPendingYusuf);
        select.selectByVisibleText("Draft");
        Thread.sleep(2000);

        // save&exit butonu
        adminDashboard.saveExitButton.click();
        Thread.sleep(2000);

        // successful buton
        adminDashboard.deleteSuccessfullyText.click();

        Thread.sleep(2000);

        // edit
        adminDashboard.editButton.click();
        actions.sendKeys("ahmet"+Keys.TAB)
                .sendKeys("koy yakindir")
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .perform();

        // save&exit butonu
        adminDashboard.saveExitButton.click();

        Thread.sleep(2000);
        // kayir islemini sil
        adminDashboard.deleteButtonYusuf.click();
        Thread.sleep(2000);
        //silme islemi onayla
        adminDashboard.deleteConfirmButtonYusuf.click();
        // silme islemi basarili olarak gerceklesti
        String succesfullyYazis=adminDashboard.deleteSuccessfullyText.getText();
        System.out.println(succesfullyYazis);
        Assert.assertTrue(adminDashboard.deleteSuccessfullyText.isDisplayed());
        extentTest.pass("silme islemi basarili olarak gerceklestigi dogrulanir");

        Driver.closeDriver();

    }


}


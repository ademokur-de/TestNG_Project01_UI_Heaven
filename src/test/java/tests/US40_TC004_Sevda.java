package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US40_TC004_Sevda extends TestBaseReport {
    @Test
    public void numberOfRecordsAndAddedItemVisibleOnConsultPage() throws InterruptedException {

        extentTest=extentReports.createTest("numberOfRecordsAndAddedItemVisibleOnConsultPage","The total number of records and the item added should be visible on the Consults page.");

        AdminDashboard adminDashboard = new AdminDashboard();
        Actions actions = new Actions(Driver.getDriver());

        // 2-admin dashboarda giriş yapıp, header kısmında yeni consults başvuru sayısının görüntülenebilir olduğunu,
        // a- admin dashboarda giriş yapıp,
        //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        Thread.sleep(3000);
        // admin dahsboard anasayfa Email/Username kutusuna amin gonder
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(((ConfigReader.getProperty("admin01") + Keys.TAB)));

        // password kutusuna password gonder
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));

        Thread.sleep(3000);
        adminDashboard.radioButtonRememberMe.click();

        // sign in butonuna tikla
        adminDashboard.adminLogInButton.click();
        Thread.sleep(2000);
        adminDashboard.consultsButton.click();

        // 4- consults kayıt sayısını ve burda eklediğim öğenin  görüntülenebilir,
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // Sayfayı 1000 piksel aşağı kaydırılir
        js.executeScript("window.scrollBy(0, 1000);");


        String consultRecords= adminDashboard.consultrecords.getText();
        System.out.println(consultRecords);
        Assert.assertTrue(adminDashboard.consultrecords.isDisplayed());

        // Sayfayı 500 piksel yukari kaydırılir
        js.executeScript("window.scrollBy(0, -500);");

        // consult search
        adminDashboard.consultsearch.click();
        actions.sendKeys("ahmet@nehaber.com").perform();
        Thread.sleep(8000);

        Driver.closeDriver();
    }
}
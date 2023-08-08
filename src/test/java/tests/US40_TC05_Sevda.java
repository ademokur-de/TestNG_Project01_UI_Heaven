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
import utilities.TestBaseReport;

public class US40_TC05_Sevda extends TestBaseReport {
    @Test
    public void consultsRecordsManageable() throws InterruptedException {
        extentTest = extentReports.createTest("consultsRecordsManageable", "Consults records should be manageable (update, edit, delete).");

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


        // 5-status durumunun güncellenebilidğini,düzenlenebilir ve silinebilir durumda olduğunu doğrulayabilmeliyim
        adminDashboard.consultEdit.click();

        Thread.sleep(2000);
        String colsultinformationYazisi = adminDashboard.consultinformation.getText();
        System.out.println(colsultinformationYazisi);
        Assert.assertTrue(adminDashboard.consultinformation.isDisplayed());

        Thread.sleep(2000);

        Select select = new Select(adminDashboard.textBoxCategorySelectStatus);
        select.selectByVisibleText("Read");

        Thread.sleep(1000);

        adminDashboard.saveExitButton.click();

        // aranan delete ve creat butonlari olmadigi icin
        // status durumununun güncellenebilir,düzenlenebilir ve silinebilir durumu yapilamiyor
        // sayfanin bu kis mında bug bulunmaktadir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();"); //There isn't link named 'Recent Posts' in the page

        Driver.closeDriver();



    }
}

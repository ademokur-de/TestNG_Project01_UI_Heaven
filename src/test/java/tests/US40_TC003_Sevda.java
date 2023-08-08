package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US40_TC003_Sevda extends TestBaseReport {

    @Test
    public void itemsViewableAndActiveOnConsultsPage() throws InterruptedException {

        extentTest=extentReports.createTest("itemsViewableAndActiveOnConsultsPage","Items must be viewable and active on the Consults page");

        AdminDashboard adminDashboard = new AdminDashboard();
        Actions actions = new Actions(Driver.getDriver());

        // Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
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

        // Consults sayfasına ulaşabildiğimi,sayfadaki öğelerin görüntülenebilir ve aktif olduğunu,
        adminDashboard.consultResult.click();
        Thread.sleep(2000);

        // id category dogrulanir
        String idcategoryYazisi = adminDashboard.idCategoryYusuf.getText();

        // yazdirilarak kontrol edilir
        System.out.println(idcategoryYazisi);
        Assert.assertTrue(adminDashboard.idCategoryYusuf.isDisplayed());

        adminDashboard.idCategoryYusuf.click();
        Thread.sleep(1000);


        // name category dogrulanir
        String namecategoryYazisi = adminDashboard.nameCategoryYusuf.getText();

        // yazdirilarak kontrol edilir
        System.out.println(namecategoryYazisi);
        Assert.assertTrue(adminDashboard.nameCategoryYusuf.isDisplayed());

        adminDashboard.nameCategoryYusuf.click();
        Thread.sleep(1000);

        // Email category dogrulanir
        String emailcategoryYazisi = adminDashboard.consultEmail.getText();

        // yazdirilarak kontrol edilir
        System.out.println(emailcategoryYazisi);
        Assert.assertTrue(adminDashboard.consultEmail.isDisplayed());

        adminDashboard.consultEmail.click();
        Thread.sleep(1000);

        // phone category dogrulanir
        String phonecategoryYazisi = adminDashboard.consultPhone.getText();

        // yazdirilarak kontrol edilir
        System.out.println(phonecategoryYazisi);
        Assert.assertTrue(adminDashboard.consultPhone.isDisplayed());

        adminDashboard.consultPhone.click();
        Thread.sleep(1000);

        // Status category dogrulanir
        String statuscategoryYazisi = adminDashboard.statusCategoryYusuf.getText();
        // yazdirilarak kontrol edilir
        System.out.println(statuscategoryYazisi);
        Assert.assertTrue(adminDashboard.statusCategoryYusuf.isDisplayed());

        adminDashboard.statusCategoryYusuf.click();
        Thread.sleep(1000);

        // Operations category dogrulanir
        String operationscategoryYazisi = adminDashboard.operationsCategoryYusuf.getText();

        // yazdirilarak kontrol edilir
        System.out.println(operationscategoryYazisi);
        Assert.assertTrue(adminDashboard.operationsCategoryYusuf.isDisplayed());

        adminDashboard.operationsCategoryYusuf.click();
        Thread.sleep(2000);

        Driver.closeDriver();

    }
}

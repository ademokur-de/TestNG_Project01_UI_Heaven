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

public class US45_TC03_Enver extends TestBaseReport {

    //Bu sayfadaki ogelerin goruntulenebilir oldugu dogrulanır





    @Test
    public void adminDahsboardTesti2() throws InterruptedException {
        AdminDashboard adminDashboard=new AdminDashboard();
        Actions actions= new Actions(Driver.getDriver());
        //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        ReusableMethods.wait(1);
        extentTest = extentReports.createTest("sf.ya ulasma ve goruntulenebilmesi", "testin dogru olarak calistigi konrol edilir");

        // admin dahsboard anasayfa Email/Username 'le login olunur
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(((ConfigReader.getProperty("admin01")+ Keys.TAB)));
        ReusableMethods.wait(1);
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));
        ReusableMethods.wait(1);
        adminDashboard.adminLogInButton.click();
        extentTest.pass("AdminDashboard e login olunur");

        // Dashboard altindaki payment butonuna tiklanir
        adminDashboard.payments.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki payment 'e gidilir");

        // Payment altindaki Transaction butonuna tikla
        adminDashboard.transactionsUnderPayments.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki payment 'n altindaki Transactiona gidilir");


        //Bu sayfadaki ogelerin goruntulenebilir oldugu dogrulanır
        String reload = adminDashboard.reloadButtonYusuf.getText();
        System.out.println(reload);
        Assert.assertTrue(adminDashboard.reloadButtonYusuf.isDisplayed());
        extentTest.pass("AdminDashboard un altindaki payment 'n altindaki Transactionin ogeleri dogrulanir");

        //String filters = adminDashboard.filterButton.getText();
        //System.out.println(filters);
        //Assert.assertTrue(adminDashboard.filterButton.isDisplayed());
        //extentTest.pass("AdminDashboard un altindaki payment 'n altindaki Transactionin ogeleri dogrulanir");

        Driver.closeDriver();



}
}
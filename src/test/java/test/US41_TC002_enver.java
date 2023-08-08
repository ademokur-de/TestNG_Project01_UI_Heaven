package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US41_TC002_enver extends TestBaseReport {

    @Test
    public void accountHesabiAcma() throws InterruptedException {
        AdminDashboard adminDashboard = new AdminDashboard();
        Actions actions= new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("account hesabi acilir ve dogrulanir", "testin dogru olarak calistigi konrol edilir");
        //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        //Admin Dashboarda gidilir
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(((ConfigReader.getProperty("admin01")+ Keys.TAB)));
        ReusableMethods.wait(1);
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));
        ReusableMethods.wait(1);
        adminDashboard.adminLogInButton.click();
        extentTest.pass("AdminDashBoarda login olunur");

        // admin dashbord a tiklanir
        adminDashboard.adminDasboardButton.click();
        extentTest.pass("AdminDashBoarda DashBoarda tiklanir");

        //accounta tiklanir
        adminDashboard.accountsButton.click();
        extentTest.pass("AdminDashBoarda da account butonuna tiklanir");
        ReusableMethods.wait(3);

        //arama yapmak icin searche tiklanir
        adminDashboard.adminSearch.click();
        ReusableMethods.wait(2);
        extentTest.pass("AdminDashBoardaki searce arama yapmak icin tiklanir");


        //serch de arama yapilacak kelime yazilir ve aratilir
        adminDashboard.adminSearch.sendKeys(ConfigReader.getProperty("adminSearch")+Keys.ENTER);
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashBoardaki searhde arama yapilacak kelime yazilir ve aratilir");

        //admin account hesabininacilmis oldugu dogrulanir
        String expectedEmail="tophane";
        String actuelEmail=adminDashboard.adminMaildenArama.getText();
        Assert.assertTrue(actuelEmail.contains(expectedEmail));
        extentTest.pass("AdminDashBoarda account hesabi acildigi dogrulanir");

        Driver.closeDriver();

    }
}
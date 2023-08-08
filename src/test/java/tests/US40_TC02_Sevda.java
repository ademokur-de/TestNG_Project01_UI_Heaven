package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US40_TC02_Sevda extends TestBaseReport {

    @Test
    public void newConsultApplicationOnAdminDashboard() throws InterruptedException {
        extentTest = extentReports.createTest("newConsultApplicationOnAdminDashboard", "The created new consult application  on the adminDashboard by logging in as an admin should be seen");

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


        // b- header kısmında yeni consults başvuru sayısının görüntülenebilir olduğunu,

        String consultresult = adminDashboard.consultResult.getText();
        System.out.println(consultresult);
        Assert.assertTrue(adminDashboard.consultResult.isDisplayed());
        Thread.sleep(2000);

        Driver.closeDriver();


    }
}

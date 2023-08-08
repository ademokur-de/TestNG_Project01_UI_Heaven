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

public class US45_TC01_Enver extends TestBaseReport {

    //AdminDashboard sayfasına gidilir.
    //Payment başlıgı altındaki Transaction sayfasının goruntulenebilir oldugu dogrulanır





    @Test
    public void adminDahsboardTesti2() throws InterruptedException {
        AdminDashboard adminDashboard=new AdminDashboard();
        Actions actions= new Actions(Driver.getDriver());

    //1-Browser acilir https://qa.hauseheaven.com/admin/login url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest = extentReports.createTest("sf.ya ulasma ve goruntulenebilmesi", "testin dogru olarak calistigi konrol edilir");

    // admin dahsboard anasayfa Email/Username 'le login olunur
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(((ConfigReader.getProperty("admin01")+ Keys.TAB)));
        ReusableMethods.wait(1);
        adminDashboard.textBoxAdminPassword.sendKeys((ConfigReader.getProperty("adminPassword")));
        ReusableMethods.wait(1);
        adminDashboard.adminLogInButton.click();
        extentTest.pass("AdminDashboard a login olunur");

        // Dashboard altindaki payment butonuna tiklanir
        adminDashboard.payments.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un altindaki payment e gidilir");

        // Payment altindaki Transaction butonuna tikla
        adminDashboard.transactionsUnderPayments.click();
        ReusableMethods.wait(3);
        extentTest.pass("AdminDashboard un payment altindaki Transaction e gidilir");

        //Payment altindaki Transaction sayfasini goruntulenebilir oldugu dogrulanir
        String transaction= adminDashboard.transactionsUnderPayments.getText();
        System.out.println(transaction);
        Assert.assertTrue(adminDashboard.transactionsUnderPayments.isDisplayed());
        extentTest.pass("AdminDashboard un payment altindaki Transaction in goruntulenebilirligi test edilir");
        ReusableMethods.wait(3);
        Driver.closeDriver();


}
}



package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US17_TS01_enver extends TestBaseReport {
    //Kayıtlı kullanıcı olarak Home page sayfasının body bölümündeki öğelerin görünür durumda oldugu dogrulanir
    // fonksiyonların aktif durumda olduğunu görüntüleyebildiğimi doğrulayabilmeliyim






    @Test
    public void test01() throws InterruptedException {
        UserHomepage userHomepage = new UserHomepage();
        Actions actions = new Actions(Driver.getDriver());


        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.wait(2);
        extentTest = extentReports.createTest("ogelerin gorunur olmasi dogrulanir", "testin dogru olarak calistigi konrol edilir");


        // cookies tiklanir
        userHomepage.cookiesAllowButton.click();
        extentTest.pass("cookies");

        ReusableMethods.wait(3);

        // sign in tiklanir
        userHomepage.linkSignIn.click();
        extentTest.pass("User Homepage link sayfasina gidilir");
        ReusableMethods.wait(2);

        UserDashboard userDashboard = new UserDashboard();

        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        ReusableMethods.wait(2);
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        ReusableMethods.wait(2);
        userDashboard.login.click();
        extentTest.pass("User Homepage de kayitli kullanici olarak login olunur");
        ReusableMethods.wait(2);


        //Dashboard sayfasinda headerusername tiklanir
        userDashboard.headerUserName.click();
        extentTest.pass("User Dashboard header username tiklanir");
        ReusableMethods.wait(3);

    //Dashboard daki elementlerin aktifligi dogrulanir
        String setting = userDashboard.settings.getText();
        boolean settingAktifmi= userDashboard.settings.isEnabled();
        Assert.assertTrue(settingAktifmi, "element aktif degil");
        System.out.println("Setting Aktif mi: "+settingAktifmi);
        extentTest.pass("Dashboarddaki elementlerin aktifligi dogrulanir");


        String buyCredis = userDashboard.buyCredits.getText();
        boolean buyCredisAktifmi= userDashboard.buyCredits.isEnabled();
        Assert.assertTrue(buyCredisAktifmi, "element aktif degil");
        System.out.println("Buy Credis Aktif mi: "+buyCredisAktifmi);
        extentTest.pass("Dashboarddaki elementlerin aktifligi dogrulanir");


        String properties = userDashboard.properties.getText();
        boolean propertiesAktifmi= userDashboard.properties.isEnabled();
        Assert.assertTrue(propertiesAktifmi, "element aktif degil");
        System.out.println("Properties Aktif mi: "+propertiesAktifmi);
        extentTest.pass("Dashboarddaki elementlerin aktifligi dogrulanir");


        String writeAProperty = userDashboard.writeAProperty.getText();
        boolean writeAPrtopertyAktifmi= userDashboard.writeAProperty.isEnabled();
        Assert.assertTrue(writeAPrtopertyAktifmi, "element aktif degil");
        System.out.println("Write A Properti Aktif mi: "+writeAPrtopertyAktifmi);
        extentTest.pass("Dashboarddaki elementlerin aktifligi dogrulanir");


        String security = userDashboard.security.getText();
        boolean securityAktifmi= userDashboard.security.isEnabled();
        Assert.assertTrue(securityAktifmi, "element aktif degil");
        System.out.println("Security Aktif mi: "+securityAktifmi);
        extentTest.pass("Dashboarddaki elementlerin aktifligi dogrulanir");


        String logout = userDashboard.logOut.getText();
        boolean logoutAktifmi= userDashboard.logOut.isEnabled();
        Assert.assertTrue(logoutAktifmi, "element aktif degil");
        System.out.println("Logout Aktif mi: "+logoutAktifmi);
        extentTest.pass("Dashboarddaki elementlerin aktifligi dogrulanir");



        ReusableMethods.wait(2);
        Driver.closeDriver();



    }
}

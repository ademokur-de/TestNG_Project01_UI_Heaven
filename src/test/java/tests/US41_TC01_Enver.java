package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US41_TC01_Enver extends TestBaseReport {
//Anasayfaya gidilir. Account acılabildigi dogrulanır.
//Dashboard a giriş yapılır. Accounts sayfasına gidilir ve dogrulanir.
//Bu sayfadaki ogelerin gorunurlugu dogrulanır
//Bu sayfadaki ogelerin aktif oldugu dogrulanır
//Account sayısı dogrulanır
//Buraya bir oge eklenir
//bu eklenen ogenin silinebilir oldugu dogrulanır

    @Test
    public void accountHesabiAcma() throws InterruptedException {
        extentTest = extentReports.createTest("account hesabi acilir ve dogrulanir", "testin dogru olarak calistigi konrol edilir");
        UserHomepage userHomepage = new UserHomepage();

        //Ziyaretci olarak url anasayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        userHomepage.signInButtonyusuf.click();

        // cookies tiklanir
        userHomepage.cookiesAllowButton.click();
        extentTest.pass("cookies");
        ReusableMethods.wait(3);
        extentTest.pass("cookies");

        userHomepage.RegisterANowAccount.click();

        userHomepage.firstName.sendKeys(((ConfigReader.getProperty("firstNameEnver")+ Keys.TAB)));
        ReusableMethods.wait(3);
        userHomepage.lastName.sendKeys(((ConfigReader.getProperty("lastName")+ Keys.TAB)));
        ReusableMethods.wait(3);
        userHomepage.registerEmail.sendKeys(ConfigReader.getProperty("emailEnver")+Keys.TAB);
        ReusableMethods.wait(3);
        userHomepage.userNameEnver.sendKeys(ConfigReader.getProperty("userNameEnver")+Keys.TAB);
        ReusableMethods.wait(3);
        userHomepage.pasWordEnver.sendKeys(ConfigReader.getProperty("passwordEnver")+Keys.TAB);
        ReusableMethods.wait(3);
        userHomepage.confirmPassword.sendKeys(ConfigReader.getProperty("confirmPassword")+Keys.TAB);
        ReusableMethods.wait(3);
        userHomepage.registerButton.click();
        extentTest.pass("bir kereye mahsus Register A Now Accounttab hesap acilir");
        ReusableMethods.wait(4);

        Driver.closeDriver();







}
}
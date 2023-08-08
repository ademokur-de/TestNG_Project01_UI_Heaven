package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;


public class US_021_SI extends TestBaseReport {

    // US021
    // Kayıtlı kullanıcı olarak sitedeki mülklerin bilgi ayrıntılarına ulaşıp
    // ilgili ilanın sosyal medyada paylaşılabilir durumda olduğunu,
    // wishliste eklenebildiğini,
    // puan verilebildiğini ve
    // yorum yazılabildiğini doğrulayabilmeliyim




    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Register User social media view and review test", "Check that the test works correctly");

// User olarak giris yapiyoruz --------------------------------
        UserHomepage userHomepage = new UserHomepage();

        //The user logins to "https://qa.hauseheaven.com/admin/login" page.

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userHomepage.linkSignIn.click();

        //Allow Cookies
        if (userHomepage.cookiesAllowButton.isDisplayed()) {
            userHomepage.cookiesAllowButton.click();
        }

        // Enter username, password and login click
        UserDashboard userDashboard = new UserDashboard();

        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        //Verify successful login by checking for username name in the header
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        extentTest.pass("Admin user page login successful");

        // Go to down 600pixel
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // Sayfayı 600 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 600 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 600);");

        /*
        // Click view Property
        //Ilan detaylarina javascript executor ile tiklayabildik !
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        // jsExecutor.executeScript("arguments[0].click();", userHomepage.propertyViewButton); // Normal view
        jsExecutor.executeScript("arguments[0].click();", userHomepage.propertyViewButton); // Normal view
*/
        userDashboard.clickOnListing.click();
        js.executeScript("window.scrollBy(0, 600);");

        js.executeScript("arguments[0].click();", userHomepage.propertyViewButton);
        // userDashboard.PropertyViewButton.click(); // Bu sekilde cliklenmedi
        ReusableMethods.wait(5);

//-------- Sosyal Media Sharing ---------------------------------------------------


// share this post
// facebook linkine tikla

        String HomeWHD = Driver.getDriver().getWindowHandle();

        Assert.assertTrue(userHomepage.shareButton.isEnabled());
        extentTest.pass("User can click a Share Button");
        userHomepage.shareButton.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(userHomepage.fbShareButton.isEnabled());
        extentTest.pass("User can click a Facebook Button");
        userHomepage.fbShareButton.click();
        ReusableMethods.switchToWindow("Facebook");
        // 2 saniye bekle
        ReusableMethods.wait(2);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Facebook";

        // Assert.assertTrue() yöntemi ile title Facebook icerdigini kontrol edelim
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.pass("User shared the property on Facebook");
        ReusableMethods.wait(1);

        // Facebook penceresinden başlangıç penceresine dönün
        Driver.getDriver().switchTo().window(HomeWHD);

// share this post
// LikedIn linkine tikla

        Assert.assertTrue(userHomepage.shareButton.isEnabled());
        extentTest.pass("User can click a Share Button");
        userHomepage.shareButton.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(userHomepage.linkedinShareButton.isEnabled());
        extentTest.pass("User can click a LikedIn Button");
        userHomepage.linkedinShareButton.click();
        ReusableMethods.wait(2);

        ReusableMethods.switchToWindowMetin("LinkedIn");
        // 2 saniye bekle
        ReusableMethods.wait(2);

        actualTitle = Driver.getDriver().getTitle();
        expectedTitle = "LinkedIn";

        // Assert.assertTrue() yöntemi ile title LikedIn icerdigini kontrol edelim
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.pass("User shared the property on LikedIn");
        ReusableMethods.wait(1);

        // LinkedIn penceresinden başlangıç penceresine dönün
        Driver.getDriver().switchTo().window(HomeWHD);

/*
        String hauseHeavenWH = Driver.getDriver().getWindowHandle();  // Mevcut window handle degeri alinir
        ReusableMethods.switchToWindowMetin(Driver.getDriver().getWindowHandle());  // tum window handle degerlerini topluyoruz
        ......
        ......
        Driver.getDriver().switchTo().window(hauseHeavenWH); // ilk window a donuyoruz
*/


// share this post
// Twitter linkine tikla

        Assert.assertTrue(userHomepage.shareButton.isEnabled());
        extentTest.pass("User can click a Share Button");
        userHomepage.shareButton.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(userHomepage.twitterShareButton.isEnabled());
        extentTest.pass("User can click a LikedIn Button");
        userHomepage.twitterShareButton.click();
        ReusableMethods.wait(2);

        ReusableMethods.switchToWindowMetin("LinkedIn");
        // 2 saniye bekle
        ReusableMethods.wait(2);

        actualTitle = Driver.getDriver().getTitle();
        expectedTitle = "Twitter";


        // Assert.assertTrue() yöntemi ile title Twitter icerdigini kontrol edelim
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.pass("User shared the property on Twitter");
        ReusableMethods.wait(1);

        // LinkedIn penceresinden başlangıç penceresine dönün
        Driver.getDriver().switchTo().window(HomeWHD);


// wishliste eklenebildiğini -----------------------------------------

        userHomepage.listingSaveButonu.click();
        Assert.assertTrue(userHomepage.wishlistAlert.isDisplayed());
        extentTest.pass("User add to wishlist");

//---------------------------------------------------------------------

// puan verilebildiğini ve -------------------bir defa puan verilmisse ikinciye verilemiyor------------

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.sleep(100);

        // Sayfayı 500 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(2);
        //js.executeScript("window.scrollBy(0, -900);");
        //userDashboard.starPoint1.click();
        ReusableMethods.wait(2);
/*
        if (userDashboard.starPoint1.isEnabled()) {
            Assert.assertTrue(true);
            System.out.println("TRUE STAR POINT");
        } else {
            Assert.fail("starPoint1 is not enabled.");
            System.out.println("FALSE STAR POINT");
        }
*/
/*
        Assert.assertTrue(userDashboard.starPoint1.isEnabled());
        extentTest.pass("User add to review star");
        ReusableMethods.wait(2);
*/
/* yorum yazılabildiğini doğrulayabilmeliyim----------bir defa yorum yapilmissa tekrar yapilamiyor ------------------

        userHomepage.yorumTextBoxInput.click();
        userHomepage.yorumTextBoxInput.sendKeys("Test Message");
        ReusableMethods.wait(3);
        Assert.assertTrue(userHomepage.yorumTextBoxInput.isEnabled());
        extentTest.pass("User add to review text");

        userDashboard.submitReviewButton.click();
        Assert.assertTrue(userDashboard.submitReviewButton.isEnabled());
        extentTest.pass("User send to review text");

        Assert.assertTrue(userHomepage.wishlistAlert.isDisplayed());
        extentTest.pass("Review sended message is showing");

        ------------------------------------------------------------------------
        */

Driver.quitDriver();


    }
}
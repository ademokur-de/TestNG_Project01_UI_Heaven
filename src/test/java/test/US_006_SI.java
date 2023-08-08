package test;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;
import java.util.Set;


public class US_006_SI extends TestBaseReport {

// US006
// Bir ziyaretçi olarak sitedeki mülklerin bilgi ayrıntılarına ulaşıp
// ilgili ilanın sosyal medyada paylaşılabilir durumda olduğunu,
// wishliste eklenebildiğini,
// emlakçısına mesaj gönderebildiğimi doğrulayabilmeliyim




    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Guest user view, share, message test ",
                "User should be viewing a property and share to social media and add to wishlist and send a message");


// User olarak siteye gidiyoruz --------------------------------
        UserHomepage userHomepage = new UserHomepage();
//The user logins to "https://qa.hauseheaven.com/admin/login" page.

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

//Allow Cookies
        if (userHomepage.cookiesAllowButton.isDisplayed()) {
            userHomepage.cookiesAllowButton.click();
        }

// Go to down 600pixel
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
// Sayfayı 600 piksel aşağı kaydırın.
// Sayfanın aşağı doğru 600 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 600);");


// Click view Property
//Ilan detaylarina javascript executor ile tiklayabildik !
        Assert.assertTrue(userHomepage.propertyViewButton.isEnabled());
        extentTest.pass("User view a property");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", userHomepage.propertyViewButton);

//-----------------------------------------------------------


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

        // yorum yazılabildiğini doğrulayabilmeliyim----------------------------

        userHomepage.nameInput.sendKeys("Adi Soyadi");
        userHomepage.phoneInput.sendKeys("0 90 555 990 88 66");
        userHomepage.emailInput.sendKeys("Test@test.com");
        userHomepage.messageInput.sendKeys("Message Test");

        // Sayfayı 500 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 500);");

        //userHomepage.sendMessageButton_SI.click();  // TIKLAMA BASARILAMADI
        jsExecutor.executeScript("arguments[0].click();", userHomepage.sendMessageButton_SI);

        Assert.assertTrue(userHomepage.sendMessageButton_SI.isEnabled()); //sendMessageSuccessfully
        ReusableMethods.wait(1);
        Assert.assertTrue(userHomepage.wishlistAlert.isDisplayed());
        System.out.println(userHomepage.wishlistAlert.getText());
        extentTest.pass("Send message");

//------------------------------------------------------------------------

        Driver.quitDriver();
    }
}































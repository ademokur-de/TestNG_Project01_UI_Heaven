package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US04_TC001_Adm extends TestBaseReport {

    @Test
    public void visitorHomepageFooterVerifyTest(){
        extentTest=extentReports.createTest("Visitor Home Page Footer Section Test","Items and functions in the Visitor Home Page Footer should be visible and active.");
        UserHomepage visitorPage= new UserHomepage();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Actions actions =new Actions(Driver.getDriver());

        //go to qa.hauseheaven.com page
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        if (visitorPage.copyrightInFooter.isDisplayed()){
            visitorPage.cookiesAllowButton.click();
        }

        //Located in the footer section;

        //Contact Info, About us, Contact us, Terms & Conditions,  are "visible" and "active".

        // Contact Info Visibility Check
        Assert.assertTrue(visitorPage.footerContactInfo.isDisplayed());

        // About us link Visibility and is link active Check
        Assert.assertTrue(visitorPage.aboutUsButtonInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.aboutUsButtonInFooter);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.hauseheaven.com/about-us"));
        Driver.getDriver().navigate().back();

        // Contact us link Visibility and is link active Check
        Assert.assertTrue(visitorPage.contactUsButtonInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.contactUsButtonInFooter);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.hauseheaven.com/contact"));
        Driver.getDriver().navigate().back();

        // TermsAndConditions link Visibility and is link active Check
        Assert.assertTrue(visitorPage.TermsAndConditionsButtonInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.TermsAndConditionsButtonInFooter);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.hauseheaven.com/terms-amp-conditions"));
        Driver.getDriver().navigate().back();
        extentTest.pass("Contact Info, About Us, Contact Us, Terms & Conditions, Are \"Visible\" and \"Active\".");

        //All properties,Houses for sale,Houses for rent Blog,  are "visible" and "active".

        // allProperties link Visibility and is link active Check
        Assert.assertTrue(visitorPage.allPropertiesButtonInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.allPropertiesButtonInFooter);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.hauseheaven.com/properties"));
        Driver.getDriver().navigate().back();

        // housesForSale link Visibility and is link active Check
        Assert.assertTrue(visitorPage.housesForSaleButtonInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.housesForSaleButtonInFooter);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.hauseheaven.com/properties?type=sale"));
        Driver.getDriver().navigate().back();

        // housesForRent link Visibility and is link active Check
        Assert.assertTrue(visitorPage.housesForRentButtonInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.housesForRentButtonInFooter);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa.hauseheaven.com/properties?type=rent"));
        Driver.getDriver().navigate().back();
        extentTest.pass("All Properties, Houses for Sale, Houses for Rent Blog, Are \"Visible\" and \"Active\".");

        //News-1,News-2,News-3,News-4,News-5,  are "visible" and "active".
        String mainWHD=Driver.getDriver().getWindowHandle();

        //  News - 1 link Visibility and is link active Check
        Assert.assertTrue(visitorPage.newsOneButtonInFooter.isDisplayed());
        Boolean news1_Check=ReusableMethods.linkCheck(visitorPage.newsOneButtonInFooter,"benefit-of-investing",mainWHD);
        Assert.assertTrue(news1_Check);

        //  News - 2 link Visibility and is link active Check
        Assert.assertTrue(visitorPage.newsTwoButtonInFooter.isDisplayed());
        Boolean news2_Check=ReusableMethods.linkCheck(visitorPage.newsTwoButtonInFooter,"negotiating",mainWHD);
        Assert.assertTrue(news2_Check);

        //  News - 3 link Visibility and is link active Check
        Assert.assertTrue(visitorPage.newsThreeButtonInFooter.isDisplayed());
        Boolean news3_Check=ReusableMethods.linkCheck(visitorPage.newsThreeButtonInFooter,"sutainable",mainWHD);
        Assert.assertTrue(news3_Check);

        //  News - 4 link Visibility and is link active Check
        Assert.assertTrue(visitorPage.newsFourButtonInFooter.isDisplayed());
        Boolean news4_Check=ReusableMethods.linkCheck(visitorPage.newsFourButtonInFooter,"stage",mainWHD);
        Assert.assertTrue(news4_Check);

        //  News - 5 link Visibility and is link active Check
        Assert.assertTrue(visitorPage.newsFiveButtonInFooter.isDisplayed());
        Boolean news5_Check=ReusableMethods.linkCheck(visitorPage.newsFiveButtonInFooter,"investing",mainWHD);
        Assert.assertTrue(news5_Check);
        extentTest.pass("News-1, News-2, News-3, News-4, News-5, Are \"Visible\" and \"Active\".");

        ReusableMethods.wait(2);

        //Copyright,Facebook,Twitter,Instagram,LinkedIn,Pinterest are "visible" and "active".

        //Copyright Visibility Check
        String copyrightText=visitorPage.copyrightInFooter.getText();
        Assert.assertTrue(copyrightText.contains("2023 Hause Heaven"));

        //Facebook link Visibility and is link active Check,
        Assert.assertTrue(visitorPage.linkFacebookInFooter.isDisplayed());
        Boolean facebook_Check=ReusableMethods.linkCheck(visitorPage.linkFacebookInFooter,"facebook",mainWHD);
        Assert.assertTrue(facebook_Check);

        //Twitter link Visibility and is link active Check,
        Assert.assertTrue(visitorPage.linkFacebookInFooter.isDisplayed());
        Boolean twitter_Check=ReusableMethods.linkCheck(visitorPage.linkTwitterInFooter,"twitter",mainWHD);
        Assert.assertTrue(twitter_Check);

        //Instagram link Visibility and is link active Check,
        Assert.assertTrue(visitorPage.linkInstagramInFooter.isDisplayed());
        Boolean instagram_Check=ReusableMethods.linkCheck(visitorPage.linkInstagramInFooter,"instagram",mainWHD);
        Assert.assertTrue(instagram_Check);

        //linkedIn link Visibility and is link active Check,
        Assert.assertTrue(visitorPage.linkLinkedInInFooter.isDisplayed());
        Boolean linkedin_Check=ReusableMethods.linkCheck(visitorPage.linkLinkedInInFooter,"linkedin",mainWHD);
        Assert.assertTrue(linkedin_Check);

        //Pinterest link Visibility and is link active Check,
        Assert.assertTrue(visitorPage.linkPinterestInFooter.isDisplayed());
        Boolean pinterest_Check=ReusableMethods.linkCheck(visitorPage.linkPinterestInFooter,"pinterest",mainWHD);
        Assert.assertTrue(pinterest_Check);
        extentTest.pass("Copyright, Facebook, Twitter, Instagram, LinkedIn, Pinterest Are \"Visible\" and \"Active\".");

        //Apple Store,Subscribe,Google Play Store, are "visible" and "active".

        //Apple link Visibility and is link active Check
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", visitorPage.appleStoreIconInFooter);
        Assert.assertTrue(visitorPage.appleStoreIconInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.appleStoreIconInFooter);
        ReusableMethods.wait(1);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("apple"));
        Driver.getDriver().navigate().back();

        ReusableMethods.wait(1);

        // Newsletter Subscribe Visibility and is link active Check
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", visitorPage.buttonSubscribeInFooter);
        ReusableMethods.wait(1);
        Assert.assertTrue(visitorPage.buttonSubscribeInFooter.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.buttonSubscribeInFooter);
        ReusableMethods.wait(2);
        Assert.assertTrue(visitorPage.labelSubscribeFalseMessageInFooter.isDisplayed());

        //  Google Play link Visibility and is link active Check
        Assert.assertTrue(visitorPage.googlePlayIconInFooter.isDisplayed());
        ReusableMethods.wait(1);
        jsExecutor.executeScript("arguments[0].click();",visitorPage.googlePlayIconInFooter);
        ReusableMethods.wait(1);
        Boolean pageGoogle=Driver.getDriver().getCurrentUrl().contains("google");
        if (!pageGoogle){
            System.out.println("\n### ============ ### ATTENTION ### ============ ###");
            System.out.println("\nGoogle Play link isn't correct\n");
            System.out.println("### ============ ### ATTENTION ### ============ ###\n");
            extentTest.fail("Google Play Store, Apple Store, Subscribe, Are \"Visible\" and \"Active\".");
            ReusableMethods.wait(2);

            Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://play.google.com/store/games");
        }else{
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("google"));
            extentTest.pass("Google Play Store, Apple Store, Subscribe, Are \"Visible\" and \"Active\".");        }

        //The page is closed
        Driver.quitDriver();

    }
}
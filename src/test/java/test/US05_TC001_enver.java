package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US05_TC001_enver extends TestBaseReport {


    //Ziyaretci olarak siteye gidilir ve sitedeki mulklerin listelendigi list sayfasına ulasılabildigi dogrulanır
    //Sitedeki mulklerin listelendigi mulk sayfasındaki mulk sayısının goruntulendigi dogrulanır
    //Ve goruntulenen ilanların ayrıntılarına ulasılabilinmesi dogrulanır
    //Mulklerin lstelendigi mulk sayfasında arama yaparak sonuc alındıgı dogrulanır
    //Ve alınan sonuc sayısının goruntulendigi dogrulanır
    //Alınan sonucların ayrıntılarına ulasılabildigi dogrulanır





    //Ziyaretci olarak siteye gidilir ve sitedeki mulklerin listelendigi list sayfasına ulasılabildigi dogrulanır
    @Test
    public void listSayfasinaUlasilmasi() {
        UserHomepage listingPage = new UserHomepage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.wait(2);
        extentTest = extentReports.createTest("list sayfasina ulasma", "testin dogru olarak calistigi konrol edilir");

        //listinge tıklanır
        listingPage.linkMenuListing.click();
        ReusableMethods.wait(3);
        extentTest.pass("User Homepage de list sayfasina gidilir");
        ReusableMethods.wait(2);

        // cookies tiklanir
        listingPage.cookiesAllowButton.click();
        extentTest.pass("cookies");

        ReusableMethods.wait(3);


        //listing sayfasının goronorlugu test edilir
            String listings = listingPage.linkMenuListing.getText();
            Assert.assertTrue(listingPage.linkMenuListing.isDisplayed());
            System.out.println(listings);
            ReusableMethods.wait(3);
            extentTest.pass("User Homepage de list sayfasinin gorunurlugu test edilir");

            //mulk sayısının goruntulendigi dogrulanır
            String expectedResult= ConfigReader.getProperty("Found");
            String actualResult=listingPage.foundResultListing.getText();
            System.out.println(actualResult);
            Assert.assertNotEquals(expectedResult,actualResult);
            ReusableMethods.wait(3);
            extentTest.pass("User Homepage de list sayfasindaki mulk sayisi test edilir");

            //ilanların ayrıntılarına ulasılabildigi dogrulanır
            listingPage.projectOneProjectsPage.click();
            String ilanName= listingPage.projectOneProjectsPage.getAccessibleName();
            Assert.assertTrue(listingPage.projectOneProjectsPage.isDisplayed());
            System.out.println(ilanName);
            ReusableMethods.wait(3);
            extentTest.pass("User Homepage de list sayfasinda ilanlarin ayrintilarina ulasilabildigi test edilir");

            String ilan2= listingPage.projectOneProjectsPage.getAriaRole();
            Assert.assertTrue(listingPage.projectOneProjectsPage.isDisplayed());
            System.out.println(ilan2);

            ReusableMethods.wait(2);
            Driver.closeDriver();




        }
}

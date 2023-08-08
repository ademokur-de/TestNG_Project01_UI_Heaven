package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US03_TC001_enver extends TestBaseReport {
    UserHomepage userHomepage = new UserHomepage();

    //Ziyaretci olarak url anasayfaya gidilerek (Home page sayfasının) body bolumundeki ogelerin gorunur oldugu test edilir
    //Ziyaretci olarak Home page sayfasındaki ogelerin aktif durumda oldukları dogrulanır
    //Yine ziyaretci olarak Home page saysasındaki search bolumunde arama yapılır
    //Search bolumunde yapılan aramamadan sonra sonuc sayısının goruntulenebildigi dogrulanır.

    @Test
    public void bodylerinGorunurlugu() throws InterruptedException {
        extentTest = extentReports.createTest("gorunurluluk test", "testin dogru olarak calistigi konrol edilir");
        //Ziyaretci olarak url anasayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //(Home page sayfasının) body bolumundeki ogelerin gorunur oldugu test edilir
        String Listing = userHomepage.linkMenuListing.getText();
        System.out.println(Listing);
        Assert.assertTrue(userHomepage.linkMenuListing.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");

        String Projects = userHomepage.linkMenuProjects.getText();
        System.out.println(Projects);
        Assert.assertTrue(userHomepage.linkMenuProjects.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");

        String Agents = userHomepage.linkMenuAgents.getText();
        System.out.println(Agents);
        Assert.assertTrue(userHomepage.linkMenuAgents.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");

        String Blog = userHomepage.linkMenuBlog.getText();
        System.out.println(Blog);
        Assert.assertTrue(userHomepage.linkMenuBlog.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");

        String Contact = userHomepage.linkMenuContact.getText();
        System.out.println(Contact);
        Assert.assertTrue(userHomepage.linkMenuContact.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");

        String SignUp = userHomepage.linkMenuSingUp.getText();
        System.out.println(SignUp);
        Assert.assertTrue(userHomepage.linkMenuSingUp.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");

        ReusableMethods.sleep(2);
        Driver.closeDriver();



    }


}
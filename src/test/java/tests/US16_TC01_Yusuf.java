package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US16_TC01_Yusuf extends TestBaseReport {


   //1-Kayitli kullanici olarak https://qa.hauseheaven.com/ url gidilir
   //2-Home page sayfasının header bölümündeki menülerin görünür oldugu dogrulanir
   //3-Menü öğelerinin tıklandiginda aktif oldugu ve ilgili sayfalara ulasildigi dogrulanir



    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("gorunurluluk test", "testin dogru olarak calistigi konrol edilir");

        UserHomepage userHomepage = new UserHomepage();
        Actions actions = new Actions(Driver.getDriver());

        //1- Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));


        // cookies tiklanir
        userHomepage.cookiesButtonyusuf.click();

        Thread.sleep(2000);
        // sign in tiklanir
        userHomepage.signInButtonyusuf.click();

        Thread.sleep(2000);


        // userName kutusuna gonder user name gonder
        userHomepage.emailTextBoxyusuf.sendKeys((ConfigReader.getProperty("userName") + Keys.TAB));

        Thread.sleep(1000);

        // password kutusuna password gonder
        userHomepage.passwordTextBoxyusuf.sendKeys((ConfigReader.getProperty("userPassword") + Keys.ENTER));


        //2-Home page sayfasının header bölümündeki menülerin görünür oldugu dogrulanir

        // User Homepage Home link
        String userHomeLink = userHomepage.linkMenuHome.getText();
        // yazdirarak kontol edilir
        System.out.println(userHomeLink);
        Assert.assertTrue(userHomepage.linkMenuHome.isDisplayed());
        extentTest.pass("User Homepage Home linkin gorunurlulugu dogrulanir");



        // User Homepage Listing link gorunurlugunu dogrula
        String userHomeListing = userHomepage.linkMenuListing.getText();
        // yazdirarak kontol edilir
        System.out.println(userHomeListing);
        Assert.assertTrue(userHomepage.linkMenuListing.isDisplayed());
        extentTest.pass("User Homepage Home link gorunurlulugu dogrulanir");



        // User Homepage Projects link gorunurlugunu dogrula
        String userHomeProjects = userHomepage.linkMenuProjects.getText();
        // yazdirarak kontol edilir
        System.out.println(userHomeProjects);
        Assert.assertTrue(userHomepage.linkMenuProjects.isDisplayed());
        extentTest.pass("User Homepage Projects link gorunurlulugu dogrulanir");



        // User Homepage Agents link gorunurlugunu dogrula
        String userHomeAgents = userHomepage.linkMenuAgents.getText();
        // yazdirarak kontol edilir
        //System.out.println(userHomeAgents);
        Assert.assertTrue(userHomepage.linkMenuAgents.isDisplayed());
        extentTest.pass("User Homepage Agents link gorunurlulugu dogrulanir");



        // User Homepage Blog link gorunurlugunu dogrula
        String userHomeBlog = userHomepage.linkMenuBlog.getText();
        // yazdirarak kontol edilir
        System.out.println(userHomeBlog);
        Assert.assertTrue(userHomepage.linkMenuBlog.isDisplayed());
        extentTest.pass("User Homepage Blog link gorunurlulugu dogrulanir");



        // User Homepage Contact link gorunurlugunu dogrula
        String userHomeContact = userHomepage.linkMenuContact.getText();
        // yazdirarak kontol edilir
        System.out.println(userHomeContact);
        Assert.assertTrue(userHomepage.linkMenuContact.isDisplayed());
        extentTest.pass("User Homepage Contact link gorunurlulugu dogrulanir");



        // User Homepage Sign Up link gorunurlugunu dogrula
        String userHomeSign = userHomepage.linkMenuSingUp.getText();
        // yazdirarak kontol edilir
        System.out.println(userHomeSign);
        Assert.assertTrue(userHomepage.linkMenuSingUp.isDisplayed());
        extentTest.pass("User Homepage Sign Up link gorunurlulugu dogrulanir");
        Thread.sleep(2000);

        Driver.closeDriver();

    }


    @Test
    public void test02() throws InterruptedException {
        extentTest = extentReports.createTest("gorunurluluk test", "testin dogru olarak calistigi konrol edilir");

        UserHomepage userHomepage=new UserHomepage();
        Actions actions=new Actions(Driver.getDriver());

        //1- Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));


        // cookies tiklanir
        userHomepage.cookiesButtonyusuf.click();

        Thread.sleep(2000);

        //3-Menü öğelerinin tıklandiginda aktif oldugu ve ilgili sayfalara ulasildigi dogrulanir

        // home page sayfasi Home ogesi
        userHomepage.linkMenuHome.click();
        String findAccessibleYazi = userHomepage.findAccessibleYaziyusuf.getText();
        System.out.println(findAccessibleYazi);
        Assert.assertTrue(userHomepage.findAccessibleYaziyusuf.isDisplayed());
        extentTest.pass("Home sayfasına ulasildigi Find Accessible Homes To Rent yazisi alinarak dogrulanir");
        Thread.sleep(1000);

        // home page sayfasi Listing ogesi
        userHomepage.linkMenuListing.click();
        String propertiesYazi = userHomepage.propertiesYaziyusuf.getText();
        System.out.println(propertiesYazi);
        Assert.assertTrue(userHomepage.propertiesYaziyusuf.isDisplayed());
        extentTest.pass("Listing sayfasına ulasildigi Properties yazisi alinarak dogrulanir");
        Thread.sleep(1000);

        // home page sayfasi Projects ogesi
        userHomepage.linkMenuProjects.click();
        String allProjectsYazi = userHomepage.allProjectsYazisiyusuf.getText();
        System.out.println(allProjectsYazi);
        Assert.assertTrue(userHomepage.allProjectsYazisiyusuf.isDisplayed());
        extentTest.pass("Projects sayfasına ulasildigi All Projects yazisi alinarak dogrulanir");
        Thread.sleep(1000);


        // home page sayfasi Agents ogesi
        userHomepage.linkMenuAgents.click();
        String agentYazi = userHomepage.allAgentsYaziyusuf.getText();
        System.out.println(agentYazi);
        Assert.assertTrue(userHomepage.allAgentsYaziyusuf.isDisplayed());
        extentTest.pass("Agents sayfasına ulasildigi All Agents yazisi alinarak dogrulanir");
        Thread.sleep(1000);


        // home page sayfasi Blog ogesi
        userHomepage.linkMenuBlog.click();
        String blogYazi = userHomepage.blogLogoYazisiyusuf.getText();
        System.out.println(blogYazi);
        Assert.assertTrue(userHomepage.blogLogoYazisiyusuf.isDisplayed());
        extentTest.pass("Blog sayfasına ulasildigi blog yazisi alinarak dogrulanir");
        Thread.sleep(1000);


        // home page sayfasi contact ogesi
        userHomepage.linkMenuContact.click();
        String contactYazi = userHomepage.contactYaziyusuf.getText();
        System.out.println(contactYazi);
        Assert.assertTrue(userHomepage.contactYaziyusuf.isDisplayed());
        extentTest.pass("contact sayfasına ulasildigi contact yazisi alinarak dogrulanir");
        Thread.sleep(1000);


        // home page sayfasi Sign Up ogesi
        userHomepage.linkMenuSingUp.click();
        Thread.sleep(1000);
        String signYazi = userHomepage.signUpLoginYazisiyusuf.getText();
        System.out.println(signYazi);
        Assert.assertTrue(userHomepage.signUpLoginYazisiyusuf.isDisplayed());
        extentTest.pass("Sign Up sayfasına ulasildigi login yazisi alinarak dogrulanir");


        Driver.quitDriver();

    }


    @Test
    public void test03() throws InterruptedException {
        extentTest = extentReports.createTest("gorunurluluk test", "testin dogru olarak calistigi konrol edilir");

        UserHomepage userHomepage=new UserHomepage();
        Actions actions=new Actions(Driver.getDriver());

        //1- Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrldashboard"));

        // cookies tiklanir
        userHomepage.cookiesButtonyusuf.click();

        // sign in tiklanir
        userHomepage.signInButtonyusuf.click();
        Thread.sleep(2000);

        // userName kutusuna gonder user name gonder
        userHomepage.emailTextBoxyusuf.sendKeys((ConfigReader.getProperty("userName") + Keys.TAB));

        Thread.sleep(1000);

        // password kutusuna password gonder
        userHomepage.passwordTextBoxyusuf.sendKeys((ConfigReader.getProperty("userPassword") + Keys.ENTER));

        Thread.sleep(1000);

        // blog sayfasinda kayitli kullanici sayisi gorundugu dogrulanir
        String sonucSayisi= userHomepage.yourCurrentCreditsYaziyusuf.getText();
        System.out.println(sonucSayisi);
        Assert.assertTrue(userHomepage.yourCurrentCreditsYaziyusuf.isDisplayed());
        extentTest.pass("blog sayfasinda kayitli kullanici sayisi gorundugu dogrulanir");

        Thread.sleep(1000);

        Driver.closeDriver();




    }

}

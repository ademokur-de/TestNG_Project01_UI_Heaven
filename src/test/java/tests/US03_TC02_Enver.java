package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US03_TC02_Enver extends TestBaseReport {


//Ziyaretci olarak Home page sayfasındaki ogelerin aktif durumda oldukları dogrulanır
    //Yine ziyaretci olarak Home page saysasındaki search bolumunde arama yapılır
    //Search bolumunde yapılan aramamadan sonra sonuc sayısının goruntulenebildigi dogrulanır.

    @Test
    public void ogelerinAktifOlmasi() {
        UserHomepage userHomepage = new UserHomepage();
        extentTest = extentReports.createTest("aktiflik test", "testin dogru olarak calistigi konrol edilir");
        //Ziyaretci olarak url anasayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.wait(2);

        // cookies tiklanir
        userHomepage.cookiesAllowButton.click();
        extentTest.pass("cookies");

        String SingUp = userHomepage.linkMenuSingUp.getText();
        boolean SingUpaktifMi= userHomepage.linkMenuSingUp.isEnabled();
        Assert.assertTrue(SingUpaktifMi, "element aktif degil");
        System.out.println("SingUpAktif mi: "+SingUpaktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String listing = userHomepage.linkMenuListing.getText();
        boolean listingAktifMi= userHomepage.linkMenuListing.isEnabled();
        Assert.assertTrue(listingAktifMi, "element aktif degil");
        System.out.println("listing aktif mi: "+listingAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String contact = userHomepage.linkMenuContact.getText();
        boolean AktifMi= userHomepage.linkMenuContact.isEnabled();
        Assert.assertTrue(AktifMi, "element aktif degil");
        System.out.println("contact aktif mi: "+AktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String blog = userHomepage.linkMenuBlog.getText();
        boolean blogAktifMi= userHomepage.linkMenuBlog.isEnabled();
        Assert.assertTrue(blogAktifMi, "element aktif degil");
        System.out.println("blog aktif mi: "+blogAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String agent = userHomepage.linkMenuAgents.getText();
        boolean agentAktifMi= userHomepage.linkMenuAgents.isEnabled();
        Assert.assertTrue(agentAktifMi, "element aktif degil");
        System.out.println("agent aktif mi: "+agentAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String projects = userHomepage.linkMenuProjects.getText();
        boolean projectsAktifMi= userHomepage.linkMenuProjects.isEnabled();
        Assert.assertTrue(projectsAktifMi, "element aktif degil");
        System.out.println("Projects aktif mi: "+projectsAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String sign = userHomepage.linkSignIn.getText();
        boolean singInAktifMi= userHomepage.linkSignIn.isEnabled();
        Assert.assertTrue(singInAktifMi, "element aktif degil");
        System.out.println("SingIn aktif mi: "+singInAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String addProperty= userHomepage.linkAddProperty.getText();
        boolean addPropertyAktifMi= userHomepage.linkAddProperty.isEnabled();
        Assert.assertTrue(addPropertyAktifMi, "element aktif degil");
        System.out.println("add property aktif mi: "+addPropertyAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String home = userHomepage.linkMenuHome.getText();
        boolean homeAktifMi= userHomepage.linkMenuHome.isEnabled();
        Assert.assertTrue(homeAktifMi, "element aktif degil");
        System.out.println("Home aktif mi: "+homeAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String searchResultButton = userHomepage.searchResultButton.getText();
        boolean searchAktifMi= userHomepage.searchResultButton.isEnabled();
        Assert.assertTrue(searchAktifMi, "element aktif degil");
        System.out.println("search result aktif mi: "+searchAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");


        String searchForALocation = userHomepage.searchForALocation.getText();
        boolean searchForAktifMi= userHomepage.searchForALocation.isEnabled();
        Assert.assertTrue(searchForAktifMi, "element aktif degil");
        System.out.println("SearchForLocation aktif mi: "+searchForAktifMi);
        extentTest.pass("User Homepage da ogelerin aktif oldugu dogrulanir");

        ReusableMethods.sleep(2);
        Driver.closeDriver();
    }
}

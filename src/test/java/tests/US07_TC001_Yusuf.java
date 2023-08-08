package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US07_TC001_Yusuf extends TestBaseReport {

   //1- Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
   //2- Anasayfada Projeler baglantısına tıklandıgında projeler sayfasına ulasildigi dogrulanir
   //3- Projeler sayfasında, projelerin toplam sayısı ve proje ilanlarının gorundugu dogrulanir
   //4- Projeler sayfasında, herhangi bir proje ilanına tıklandığında, proje ayrıntıları ulasildigi dogrulanir.
   //5- Projeler sayfasında arama cubugunda yapılan aramada, girilen anahtar kelimeye uygun sonuçlara ulasildigi dogrulanir
   //6- Arama sonuçları sayfasında, herhangi bir proje ilanına tıklandığında, proje ayrıntıları dogrulanir.


    @Test
    public void test01() throws InterruptedException {

        extentTest = extentReports.createTest("gorunurluluk test","testin dogru olarak calistigi konrol edilir");

        UserHomepage userHomepage = new UserHomepage();
        Actions actions = new Actions(Driver.getDriver());



        //1- Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        // cookies tiklanir
        userHomepage.cookiesButtonyusuf.click();

        //2- Anasayfada Projeler baglantısına tıklandıgında projeler sayfasına ulasildigi dogrulanir
        // projects buton tiklanir
        userHomepage.linkMenuProjects.click();
        //  projeler sayfasina ulasildigi ornek proje yazisi alinarak dogrulanir
        String allProjectsYazisi = userHomepage.allProjectsYazisiyusuf.getText();


        // all projects yaizisi yazdirilir kontrol amacli
        System.out.println(allProjectsYazisi);
        Assert.assertTrue(userHomepage.allProjectsYazisiyusuf.isDisplayed());
        extentTest.pass("// all projects yaizisi yazdirilir kontrol amacli");


        //3- Projeler sayfasında, projelerin toplam sayısı ve proje ilanlarının gorundugu dogrulanir
        String expectedResult = ConfigReader.getProperty("projectFoundResult");
        String actualResult = userHomepage.numberofProjectyusuf.getText();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
        extentTest.pass("Projeler sayfasında, projelerin toplam sayısı ve proje ilanlarının gorundugu dogrulanir");


        // 4. Projeler sayfasında, herhangi bir proje ilanına tıklandığında, proje ayrıntıları ulasildigi dogrulanir.

        // JavaScriptExecutor nesnesini oluşturun.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Sayfayı 500 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 500);");

        // 3 saniye bekle
        Thread.sleep(2000);

        // ornek bir proje tiklanir(2.proje)
        userHomepage.projectTwoProjectsPage.click();

        // 3 saniye beklenir
        Thread.sleep(2000);

        // scroll tusu ile Sayfayı 500 piksel aşağı kaydır
        js.executeScript("window.scrollBy(0,1000);");

        // 3 saniye bekler
        Thread.sleep(3000);

        // project two details yaizisi yazdirilir yani proje ayrıntılarına ulasildigi dogrulanir.

        String projecttwodetailYazisi = userHomepage.projecttwoDetailFeaturesYazisiyusuf.getText();
        System.out.println(projecttwodetailYazisi);
        Assert.assertTrue(userHomepage.projecttwoDetailFeaturesYazisiyusuf.isDisplayed());
        extentTest.pass("project two details yaizisi yazdirilir yani proje ayrıntılarına ulasildigi dogrulanir");

        // Related Projects text yazisinin gorunurlulugu icin 2500 piksel asagı kaydir
        js.executeScript("window.scrollBy(0,2500);");

        String relatedProjectsYazisi = userHomepage.relatedProjectsyusuf.getText();
        System.out.println(relatedProjectsYazisi);
        Assert.assertTrue(userHomepage.relatedProjectsyusuf.isDisplayed());
        extentTest.pass("related Projects Yazisina ulasildigi dogrulanir");

        Thread.sleep(2000);


        //5- Projeler sayfasında arama cubugunda yapılan aramada,
        // girilen anahtar kelimeye uygun sonuçlara ulasildigi dogrulanir

        // onceki sayfaya geri don
        Driver.getDriver().navigate().back();

        // 3 saniye bekle
        Thread.sleep(2000);

        // scroll tusu ile Sayfayı -1000 piksel yukarı kaydır
        js.executeScript("window.scrollBy(0,-1000);");
        Thread.sleep(5000);

        Driver.closeDriver();
    }


    @Test
    public void test02() throws InterruptedException {
        extentTest = extentReports.createTest("gorunurluluk test","testin dogru olarak calistigi konrol edilir");

        UserHomepage userHomepage = new UserHomepage();
        Actions actions = new Actions(Driver.getDriver());

        //1- Ziyaretci olarak https://qa.hauseheaven.com/projects url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrlProject"));
        // cookies tiklanir

        userHomepage.cookiesButtonyusuf.click();


        Thread.sleep(3000);
        // ziyaretci sayfasinda Projects tiklanir ve categoryler sirayla secilerek search yapilir


        // ulke secimi icin
        Select select=new Select(userHomepage.ulkesecimiyusuf);
        select.selectByVisibleText("Canada");
        Thread.sleep(1000);


        // state secimi
        select=new Select(userHomepage.statesecimiyusuf);
        select.selectByIndex(0);
        Thread.sleep(1000);


        // city secimi
        select=new Select(userHomepage.citysecimiyusuf);
        select.selectByIndex(0);
        Thread.sleep(1000);


        // cayegory secimi
        select=new Select(userHomepage.categorysecimiyusuf);
        select.selectByVisibleText("Villa");
        Thread.sleep(1000);


        // search ile arama yap
        userHomepage.searchResultButton.click();


        //6- Arama sonuçları sayfasında, herhangi bir proje ilanına tıklandığında, proje ayrıntıları dogrulanir.

        // 2 saniye bekle
        Thread.sleep(2000);


        // JavaScriptExecutor nesnesini oluşturun.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // scroll tusu ile Sayfayı -500 piksel asagı kaydır
        js.executeScript("window.scrollBy(0,500);");

        // 3 uncu projeyi tikla
        userHomepage.projectThreeProjectsPage.click();

        // 3 saniye beklenir
        Thread.sleep(3000);

        // scroll tusu ile // Sayfayı 1000 piksel aşağı kaydırır
        js.executeScript("window.scrollBy(0,1000);");

        // 3 saniye bekler
        Thread.sleep(3000);


        // project three details yaizisi yazdirilir kontrol amacli
        String projectthreedetailYazisi=userHomepage.projecttwoDetailFeaturesYazisiyusuf.getText();
        System.out.println(projectthreedetailYazisi);
        Assert.assertTrue(userHomepage.projectthreeDetailFeaturesYazisiyusuf.isDisplayed());
        extentTest.pass("project three details yaizisi yazdirilir kontrol amacli");

    Driver.closeDriver();

    }
}


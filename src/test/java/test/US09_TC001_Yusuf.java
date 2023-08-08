package test;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;
import java.util.Set;

public class US09_TC001_Yusuf extends TestBaseReport {

    //1- Bir ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
    //2- Anasayfada Blog baglantısına tıklandıgında blog sayfasına basariyla yönlendirildigi dogrulanir.
    //3- Blog sayfasinda blog yazi aytrıntılarına ulasildigi dogrulanir
    //4- Blog yazıları sayfasında, Categories, Recent Posts, Featured Properties ve paylaşım butonlarınin
    // görünür ve aktif olduğu dogrulanir






    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("gorunurluluk test","testin dogru olarak calistigi konrol edilir");


        UserHomepage userHomepage = new UserHomepage();

        //1- Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        // cookies tiklanir
        userHomepage.cookiesButtonyusuf.click();
        Thread.sleep(2000);


        //2- Anasayfada Blog baglantısına tıklandıgında blog sayfasına basariyla yönlendirildigi dogrulanir.
        userHomepage.linkMenuBlog.click();
        Thread.sleep(2000);

        //  blog sayfasına ulasildigi blog logo yazisi alinarak dogrulanir
        String allProjectsYazisi = userHomepage.blogLogoYazisiyusuf.getText();
        // blog logo yaizisi yazdirilir kontrol amacli
        System.out.println(allProjectsYazisi);
        Assert.assertTrue(userHomepage.blogLogoYazisiyusuf.isDisplayed());
        extentTest.pass("blog sayfasına ulasildigi blog logo yazisi alinarak dogrulanir");



        //3- Blog sayfasinda blog yazi aytrıntılarına ulasildigi dogrulanir

        // JavaScriptExecutor nesnesini oluşturun.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        // Sayfayı 500 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 500);");

        // 3 saniye bekle
        Thread.sleep(2000);

        // continue butonu tıklanir
        userHomepage.BlogMenuContinueButton.click();
        // 2 saniye bekle
        Thread.sleep(2000);

        //4- Blog yazıları sayfasında, Categories, Recent Posts, Featured Properties ve paylaşım butonlarınin
        // görünür ve aktif olduğu dogrulanir


        // Sayfayı 150 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 150 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 200);");

        // 2 saniye bekle
        Thread.sleep(2000);

        // Blog sayfası yazi tedaylari altindaki
        // öğelerin görünürlüğünü ve aktif durumunu kontrol et
        // categories ogesinin gorunur ve aktif oldugunu kontrol et
        List<WebElement> categoriesList = Driver.getDriver().findElements(By.xpath("//div[@class='single-widgets widget_category']"));
        Assert.assertFalse(categoriesList.isEmpty());
        extentTest.pass("categories listenin bos olmadigini kontrol et");



        for (WebElement eachcategory : categoriesList) {
            // list yazdir kontrol et
            System.out.println(eachcategory.getText());
            Assert.assertTrue(eachcategory.isDisplayed());
            extentTest.pass("categories listesinin gorunur oldugunu kontrol et");
            Assert.assertTrue(eachcategory.isEnabled());
            extentTest.pass("categories listesinin aktif oldugunu kontrol et");

        }


        // Sayfayı 500 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 500);");

        // 2 saniye bekle
        Thread.sleep(2000);

        // Blog sayfası yazi tedaylari altindaki
        // öğelerin görünürlüğünü ve aktif durumunu kontrol et
        // Featured properties ogesinin gorunur ve aktif oldugunu kontrol et

        List<WebElement> featuredPropertiesList = Driver.getDriver().findElements(By.xpath("//div[@class='sidebar_featured_property']"));
        Assert.assertFalse(featuredPropertiesList.isEmpty());
        extentTest.pass(" Featured properties listenin bos olmadigini kontrol et");



        for (WebElement eachFetured : featuredPropertiesList) {
            // list yazdir kontrol et
            System.out.println(eachFetured.getText());
            Assert.assertTrue(eachFetured.isDisplayed());
            extentTest.pass("Featured properties listesinin gorunur oldugunu kontrol et");
            Assert.assertTrue(eachFetured.isEnabled());
            extentTest.pass("Featured properties listesinin gorunur oldugunu kontrol et");



            // 2 saniye bekle
            Thread.sleep(2000);

            // Sayfayı 500 piksel aşağı kaydırın.
            // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
            js.executeScript("window.scrollBy(0, 500);");

            // 2 saniye bekle
            Thread.sleep(2000);
            Driver.closeDriver();

        }
    }



        @Test
        public void test02() throws InterruptedException {
            extentTest = extentReports.createTest("gorunurluluk test","testin dogru olarak calistigi konrol edilir");

            // https://qa.hauseheaven.com/news/now-its-easy-to-get-the-house-of-your-dreams url gidilir
            UserHomepage userHomepage = new UserHomepage();
            Driver.getDriver().get(ConfigReader.getProperty("userUrlBlogNews"));

            // cookies tiklanir
            userHomepage.cookiesButtonyusuf.click();
            Thread.sleep(2000);

            // JavaScriptExecutor nesnesini oluşturun.
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            // Sayfayı 1000 piksel aşağı kaydırılir
            js.executeScript("window.scrollBy(0, 1000);");

            // 3 saniye bekle
            Thread.sleep(3000);

            // Blog sayfası yazi tedaylari altindaki Recent Posts ogesinin gorunur ve aktif oldugunu kontrol et
            String recentPostsYazisi = "Recent Posts";
            String pageTextYazisi = userHomepage.bodyTextyusuf.getText();
            // tum Web Elementler yazdirilarak gorunur oldugu kontrol edilir.
            System.out.println(pageTextYazisi);
            Assert.assertTrue(pageTextYazisi.contains(recentPostsYazisi), " Aranan " + recentPostsYazisi + " yazisi sayfada bulunmuyor ");
            extentTest.pass("Recent Posts listesinin gorunur oldugunu kontrol et");

            Driver.closeDriver();
        }


        @Test
        public void test03() throws InterruptedException {
            extentTest = extentReports.createTest("gorunurluluk test","testin dogru olarak calistigi konrol edilir");

            UserHomepage userHomepage = new UserHomepage();
            Driver.getDriver().get(ConfigReader.getProperty("userUrlBlogNews"));
            // cookies tiklanir
            userHomepage.cookiesButtonyusuf.click();
            Thread.sleep(2000);

            // JavaScriptExecutor nesnesini oluşturun.
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            // Sayfayı 500 piksel aşağı kaydırın.
            // Sayfanın aşağı doğru 500 piksel kaydırmasını sağlar.
            js.executeScript("window.scrollBy(0, 500);");
            // 2 saniye bekle
            Thread.sleep(3000);

            // share this post
            // facebook linkine tiklanir
            userHomepage.shareThisPostFacebook.click();

            // 2 saniye bekle
            Thread.sleep(2000);

            // linkedin sayfasina git
            Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com/uas/login");

            // Handle değerlerini al
            Set<String> handles = Driver.getDriver().getWindowHandles();
            String facebookWHD = Driver.getDriver().getWindowHandle();
            String linkedinWHD = "";

            for (String handle : handles) {
                if (!handle.equals(facebookWHD)) {
                    linkedinWHD = handle;
                    break;

                }
            }

            Driver.getDriver().switchTo().window(linkedinWHD);
            Thread.sleep(1000);


            // twitter sayfasina git
            Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://twitter.com/i/flow/login");

            // handle degerlerini alalim
            Set<String> handles1 = Driver.getDriver().getWindowHandles();
            String linkedinWHD1 = Driver.getDriver().getWindowHandle();
            String twitterWHD = "";

            for (String handle1 : handles1) {
                if (!handle1.equals(linkedinWHD1)) {
                    twitterWHD = handle1;
                    break;

                }

            }

            Driver.getDriver().switchTo().window(twitterWHD);
            Thread.sleep(2000);

            Driver.quitDriver();

        }
}
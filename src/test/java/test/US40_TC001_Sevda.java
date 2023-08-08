package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US40_TC001_Sevda extends TestBaseReport {

            @Test
        public void addConsultOnHomePage() throws InterruptedException {
        extentTest=extentReports.createTest("addConsultOnHomePage","Ability to add consult reference on the homepage");

            UserHomepage userHomepage = new UserHomepage();
            Actions actions = new Actions(Driver.getDriver());

            //Ziyaretci olarak https://qa.hauseheaven.com/ url gidilir
            Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

            // Allow Cookies
            userHomepage.cookiesButtonyusuf.click();

            // JavaScriptExecutor nesnesini oluşturun.
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            // Sayfayı 1500 piksel aşağı kaydırılir
            js.executeScript("window.scrollBy(0, 1500);");
            Thread.sleep(2000);

            //User Listing Page 1.Result's View Button
            userHomepage.listingViewButton.click();
            Thread.sleep(2000);

            // Sayfayı 400 piksel aşağı kaydırılir
            js.executeScript("window.scrollBy(0, 200);");
            Thread.sleep(2000);

            // Bilgileri girip mesaj gonderme
            userHomepage.nameInput.click();
            actions.sendKeys("Name Surname"+ Keys.TAB)
                    .sendKeys("0555 555 55 55"+Keys.TAB)
                    .sendKeys("ahmet@nehaber.com"+Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys("mesaj iletiliyor"+Keys.TAB)
                    .perform();

            // Sayfayı 500 piksel aşağı kaydırın.
            // Sayfanın aşağı doğru 300 piksel kaydırmasını sağlar.
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(2000);

            userHomepage.sendMessageButton_SI.click();

            Driver.closeDriver();
        }
    }
package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US03_TC03_Enver extends TestBaseReport {



    //Yine ziyaretci olarak Home page saysasındaki search bolumunde arama yapılır

    @Test
    public void searchAramaYapilmasi() {
        UserHomepage userHomepage = new UserHomepage();
        extentTest = extentReports.createTest("arama testi", "testin dogru olarak calistigi konrol edilir");
        //Ziyaretci olarak url anasayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        // cookies tiklanir
        userHomepage.cookiesAllowButton.click();
        extentTest.pass("cookies");
        ReusableMethods.wait(3);


        userHomepage.searchForALocation.sendKeys("Albany");
        ReusableMethods.wait(2);

        userHomepage.dropDownMinPrice.click();
        Select select = new Select(userHomepage.dropDownMinPrice);
        userHomepage.dropDownMinPrice.click();
        select.selectByValue("500");
        System.out.println("value ile sectigimiz 1.sıradaki fiyat : "+select.getFirstSelectedOption().getText());
        userHomepage.dropDownMinPrice.click();
        ReusableMethods.wait(5);
        extentTest.pass("User Homepage de searcda min fiyat secilir");


        userHomepage.dropDownMaxPrice.click();
        Select select2 = new Select(userHomepage.dropDownMaxPrice);
        select2.selectByValue("50000");
        System.out.println("value ile secilen 5.sıradaki fiyat : "+select2.getFirstSelectedOption().getText());
        ReusableMethods.wait(3);
        extentTest.pass("User Homepage da searc de max fiyat secilir");


        userHomepage.dropDownPropertyType.click();
        Select select3 = new Select(userHomepage.dropDownPropertyType);
        select3.selectByValue("Villa");
        System.out.println("value ile secilen villa : "+select3.getFirstSelectedOption().getText());
        ReusableMethods.wait(3);
        extentTest.pass("User Homepage da searcde konut tipi secilir");


        userHomepage.dropDownBedRooms.click();
        Select select4 = new Select(userHomepage.dropDownBedRooms);
        select3.selectByValue("1");
        System.out.println("value ile secilen 1. : "+select4.getFirstSelectedOption().getText());
        ReusableMethods.wait(3);
        extentTest.pass("User Homepage searcde rakam secilir");


        userHomepage.dropDownPropertyLocation.click();
        Select select5 = new Select(userHomepage.dropDownPropertyLocation);
        select3.selectByValue("city");
        System.out.println("value ile secilen city : "+select5.getFirstSelectedOption().getText());
        extentTest.pass("User Homepage da searcde cty secilir");

        ReusableMethods.wait(3);





    }
}
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US01_TC01_Vysl extends TestBaseReport {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Login Successfully on qa.hauseheaven.com","The user should be able to login to the qa.hauseheaven.com successfully");

        //Launch browser
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //Verify that home page is visible successfully
        String expectedTitle = "Hause Heaven";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        extentTest.info("Siteye basarili bir sekilde gidildigi dogrulanir");

        //The page is closed

        Driver.closeDriver();

    }
}

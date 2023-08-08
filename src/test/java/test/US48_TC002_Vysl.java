package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;

public class US48_TC002_Vysl extends TestBaseReport {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Number of countries","Confirmation of the number of countries, that the elements on the page are visible and active");
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Enter Email/Username, Password and click on the Sign in Button
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.adminLogInButton);
        jsExecutor.executeScript("arguments[0].click();", adminDashboard.adminLogInButton);

        //Click on the Locations button
        adminDashboard.locationsButton.click();

        //Click on the Countries button
        adminDashboard.locationsCountriesButton.click();


        //Number of registered Countries, view ability and active status of items on the page are verified
        Assert.assertTrue(adminDashboard.numberOfStatesRecord.isDisplayed());
        extentTest.info("Verification of country numbers");

        List<WebElement> countriesList = Driver.getDriver().findElements(By.xpath("//td[@class=' text-start column-key-name']"));
        Assert.assertFalse(countriesList.isEmpty());
        for (WebElement eachCountries : countriesList) {
            Assert.assertTrue(eachCountries.isDisplayed());
            Assert.assertTrue(eachCountries.isEnabled());
        }
         extentTest.info("verifying that the elements on the page are visible");

        adminDashboard.firstcountriesClick.click();

        Assert.assertTrue(adminDashboard.firstcountriesClick.isDisplayed());

        extentTest.info("verifying that the items on the page are active");


        //The page is closed
        Driver.closeDriver();


    }
}

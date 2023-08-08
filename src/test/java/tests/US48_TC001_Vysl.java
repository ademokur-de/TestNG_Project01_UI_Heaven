package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US48_TC001_Vysl extends TestBaseReport {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Countries from Locations as Administrator","To verify the visibility of countries and the visibility of entry");
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

        //Confirms the visibility of the Countries button
        Assert.assertTrue(adminDashboard.locationsCountriesButton.isEnabled());
        extentTest.info("Confirms the visibility of the Countries button");

        //Click on the Countries button
        adminDashboard.locationsCountriesButton.click();

        //Verifiy the visibility of the opened page
        String expectedText ="Countries";
        String actualText = adminDashboard.labelCountriesText.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        extentTest.info("Verifiy the visibility of the opened page");


        //The page is closed
        Driver.closeDriver();


    }
}

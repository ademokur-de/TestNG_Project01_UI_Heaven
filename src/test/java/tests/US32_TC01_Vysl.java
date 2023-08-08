package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US32_TC01_Vysl extends TestBaseReport {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Admin login","Log in as administrator and verify that the admin page is visible");
       //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

       //Enter Email/Username, Password
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));

        //Click on the Sign in button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.adminLogInButton);
        jsExecutor.executeScript("arguments[0].click();", adminDashboard.adminLogInButton);

       //Verify that page is visible successfully
        System.out.println("****************" + Driver.getDriver().getTitle()); //Dashboard | Hause Heaven

        String expectedTitle = "Dashboard | Hause Heaven";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        extentTest.info("Admin admin page confirmed to be visible");

        //The page is closed

        Driver.closeDriver();





    }
}

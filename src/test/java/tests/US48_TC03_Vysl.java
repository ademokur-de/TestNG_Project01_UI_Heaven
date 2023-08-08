package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US48_TC03_Vysl extends TestBaseReport {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Create a new country in Location Countries","Create new countries and verify visibility in countries");
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
        ReusableMethods.wait(3);
        adminDashboard.locationsButton.click();

        //Click on the Countries button
        ReusableMethods.sleep(10);
        adminDashboard.locationsCountriesButton.click();

        //Click on the Creative button
        ReusableMethods.wait(2);
        adminDashboard.createOnCountriesPage.click();


        //New Country is added by entering information on the new page
        adminDashboard.nameRegister.sendKeys("Türkmenistan");
        adminDashboard.nationalityRegister.sendKeys("Türkmen");
        adminDashboard.codeRegister.sendKeys("795");
        adminDashboard.dialCodeRegister.sendKeys("+993");
        adminDashboard.orderRegister.sendKeys("1");
        adminDashboard.saveButton.click();
        ReusableMethods.wait(1);
        adminDashboard.saveExitButton.click();
        ReusableMethods.wait(3);

        //Click on the save&exit button and confirm the save

        Assert.assertTrue(adminDashboard.countriesTurkmenistanVisibility.isDisplayed());

        extentTest.info("Confirmed creation of new countries");


        adminDashboard.deleteButton.click();
        ReusableMethods.sleep(3);
        adminDashboard.confirmDeleteButton.click();

        //The page is closed
        Driver.closeDriver();









    }
}

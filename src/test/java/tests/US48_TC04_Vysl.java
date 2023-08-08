package tests;

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

public class US48_TC04_Vysl extends TestBaseReport{

    @Test
    public void test1(){
        extentTest=extentReports.createTest("Edits and deletes in countries","Verify that the edit and delete buttons work on the Saved Country");
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Enter Email/Username, Password and click on the Sign in Button
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.adminLogInButton);
        jsExecutor.executeScript("arguments[0].click();", adminDashboard.adminLogInButton);

        ReusableMethods.wait(1);
        //Click on the Locations button
        adminDashboard.locationsButton.click();

        //Click on the Countries button
        adminDashboard.locationsCountriesButton.click();

        adminDashboard.createOnCountriesPage.click();

        adminDashboard.nameRegister.sendKeys("Türkmenistan");
        adminDashboard.nationalityRegister.sendKeys("Türkmen");
        adminDashboard.codeRegister.sendKeys("795");
        adminDashboard.dialCodeRegister.sendKeys("+993");
        adminDashboard.orderRegister.sendKeys("1");
        adminDashboard.saveExitButton.click();
        ReusableMethods.wait(1);

        //1. Click on the country's edit button
        adminDashboard.editButtonTurkmenistan.click();

        //Verify that the opened page is visible
        Assert.assertTrue(adminDashboard.editTurkmenistanVisibility.isDisplayed());

        extentTest.info("Verifying that the edit button works on the saved Country");

        adminDashboard.saveExitButton.click();

        ReusableMethods.wait(1);

        //1. Click on the country's delete button
        adminDashboard.deleteButton.click();

        ReusableMethods.wait(1);

        //verify that the delete button works
        adminDashboard.confirmDeleteButton.click();
        ReusableMethods.wait(1);

        List<WebElement> countriesList = Driver.getDriver().findElements(By.xpath("//td[@class=' text-start column-key-name']"));
        Boolean ulkeVarmi=false;
        for (WebElement eachCountries : countriesList) {

            if (eachCountries.getText().contains("Türkmenistan")){
                ulkeVarmi = true;
            }

        }
        Assert.assertFalse(ulkeVarmi);

        extentTest.info("Verification of the visibility that the delete button works on the Saved Country");

        //The page is closed
        Driver.closeDriver();

    }
}

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

public class US44_TC001_Adm extends TestBaseReport {


    @Test
    public void adminPaymentsMenuTest(){
        AdminDashboard adminDashboard=new AdminDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        extentTest=extentReports.createTest("Payment menu test","In the admin dashboard, the menu under the title of payments can be displayed and they are active.");

        // Mazlumu Getir! : jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webelement_hier);
        // Go to qa.hauseheaven.com/admin/login
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        ReusableMethods.wait(3);

        ReusableMethods.wait(3);

        //Enters valid username and password, presses the login button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        extentTest.info("It is accesed in Admin Page");

        ReusableMethods.wait(1);

        // Payments menu link click
        adminDashboard.payments.click();
        ReusableMethods.wait(2);

        WebElement transaction=Driver.getDriver().findElement(By.xpath("(//a[@class='nav-link'])[9]"));

        //Verify to Transactions menu visible
        Assert.assertTrue(transaction.isEnabled());
        extentTest.pass("Verify to Transactions menu visible");

        // Transactions menu link click
        transaction.click();
        ReusableMethods.wait(2);

        // Verify Payments menu  (labelAccountsText)
        Assert.assertTrue(adminDashboard.labelAccountsText.getText().contains("Payments"));
        extentTest.pass("Verify Payments menu visible");

        // Close driver.
        Driver.closeDriver();
    }

}

package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US25_TC01_Vysl extends TestBaseReport {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("User Contact page","Go to the Contact page and verify that it can be seen");
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Click on the Sign In button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.clickOnSignup.click();


        //Enter your account details and click on the 'Login' button
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.allowCookiesButton.click();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickSignUpLogin);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickSignUpLogin);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickOnSignup);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickOnSignup);

        //Click on the Contact button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickOnContact);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickOnContact);

        //Verify that page is visible successfully

        Assert.assertTrue(userDashboard.allAgentTitleText.isDisplayed());
        extentTest.pass("Verify that page is visible successfully");

        //The page is closed

        Driver.closeDriver();


    }
}

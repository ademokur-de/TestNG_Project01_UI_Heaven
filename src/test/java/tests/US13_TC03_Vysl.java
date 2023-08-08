package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US13_TC03_Vysl extends TestBaseReport {
    @Test
    public void purchase_01(){
        extentTest=extentReports.createTest("purchase by entering credit card information","Verification of purchase by entering credit card information");
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Click on the Login button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.headerSignIn.click();

        //Enter your account details and click on the 'Login' button
        userDashboard.emailInput.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.allowCookiesButton.click();

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickSignUpLogin);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickSignUpLogin);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickOnSignup);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickOnSignup);

        //Click on the Buy credits button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.buyCredits);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.buyCredits);

        //Verify that page is visible successfully
        Assert.assertTrue(userDashboard.buyCreditsPageVisible.isDisplayed());

        //Buy by entering credit card details
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.purchaseButton1);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.purchaseButton1);

        ReusableMethods.wait(1);
        userDashboard.cardNumber.sendKeys("4242424242424242");
        ReusableMethods.wait(1);
        userDashboard.fullName.sendKeys("WISE QUARTER");
        ReusableMethods.wait(1);
        userDashboard.mMYY.sendKeys("12/34");
        ReusableMethods.wait(1);
        userDashboard.cVC.sendKeys("567");
        ReusableMethods.wait(1);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.checkOut);
        ReusableMethods.wait(2);

        //Verify the purchase and the page is closed
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.transactionsText);
        Assert.assertTrue(userDashboard.transactionsText.isDisplayed());

        extentTest.info("Verify the purchased");

        Driver.closeDriver();

    }

}

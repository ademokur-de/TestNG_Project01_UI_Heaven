package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US13_TC004_Vysl extends TestBaseReport {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("User password change","Confirms that the password change was successful");
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Click on the Login button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.headerSignIn.click();

        //Enter your account details and click on the 'Login' button
        userDashboard.emailInput.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        //userDashboard.passwordInput.sendKeys("Veysel_team01");
        userDashboard.allowCookiesButton.click();
        userDashboard.clickSignUpLogin.click();
        userDashboard.clickOnSignup.click();

        //Click on the Buy Security button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.security);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.security);

        //Verify that page is visible successfully
        Assert.assertTrue(userDashboard.settingsPageVisible.isDisplayed());

        //Enter password information and Update
        userDashboard.passwordInput.sendKeys("Veysel_team01");
        userDashboard.confirmationPasswordInput.sendKeys("Veysel_team01");
        userDashboard.updatePasswordButton.click();
        userDashboard.logOut.click();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.wait(1);
        userDashboard.headerSignIn.click();
        ReusableMethods.wait(1);
        userDashboard.emailInput.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.passwordInput.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.clickSignUpLogin.click();
        ReusableMethods.wait(1);

        //Verify that the password information has been updated
        Assert.assertTrue(userDashboard.invalidLoginText.isDisplayed());
        extentTest.info("Verify that the password information has been updated");

        userDashboard.headerSignIn.click();
        userDashboard.emailInput.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.passwordInput.sendKeys("Veysel_team01");
        ReusableMethods.wait(1);
        userDashboard.clickSignUpLogin.click();
        ReusableMethods.wait(1);
        userDashboard.clickOnSignup.click();
        ReusableMethods.wait(2);

         //Verify that the password information has been updated and the page is closed
        Assert.assertTrue(userDashboard.headerLogOutButton.isDisplayed());



        //Tekrar Password u eski haline getir

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.security);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.security);

        ReusableMethods.wait(1);

        userDashboard.passwordInput.sendKeys("Teamproject1*");
        userDashboard.confirmationPasswordInput.sendKeys("Teamproject1*");
        userDashboard.updatePasswordButton.click();

        Driver.closeDriver();

    }
}

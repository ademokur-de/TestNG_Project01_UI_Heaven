package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.io.IOException;
import java.time.Duration;

public class US11_TC01_Metin extends TestBaseReport {

    @Test
    public void testMakeRegistrationWithCorrectButton(){
        extentTest=extentReports.createTest("testMakeRegistrationWithCorrectButton","testMakeRegistrationWithCorrectButton");
        UserHomepage userHomepage = new UserHomepage();
        UserDashboard userDashboard = new UserDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Verify that the home page is visible
        Assert.assertTrue(userHomepage.searchForALocation.isDisplayed());
        extentTest.pass("Home page is visible");
        //Click first sign up button
        userDashboard.clickOnSignup.click();
        //Verify that the register text is not visible
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(3));
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userDashboard.labelRegister)).isDisplayed());
            extentTest.pass("Register page first try");
        } catch (Exception e) {
            System.out.println("Sign up button didnt work");
            try {
                ReusableMethods.getScreenshot("signUpPageDidntComeAtHere");
            } catch (IOException ex) {

            }
            //Verify that 'Don't have an account? Register a new account'
            Assert.assertTrue(userDashboard.labelDontYouHaveAnAccountText.isDisplayed());
            extentTest.pass("register page second try");
            //Click 'Register a new account'
            userDashboard.labelRegisterButton.click();
        }
        //Verify that the register text is visible
        Assert.assertTrue(userDashboard.labelRegister.isDisplayed());
        extentTest.pass("registration process");
        //fill in all information for registration and click register button
        Faker faker = new Faker();
        userDashboard.textBoxFirstName.sendKeys(faker.name().firstName());
        userDashboard.textBoxLastName.sendKeys(faker.name().lastName());
        userDashboard.textBoxEmail.sendKeys(faker.internet().emailAddress());
        userDashboard.textBoxUserName.sendKeys(faker.name().username());
        String password = ConfigReader.getProperty("passwordForRegistration");
        userDashboard.textBoxRegisterationPassword.sendKeys(password);
        userDashboard.textBoxConfirmRegisterationPassword.sendKeys(password);
        userDashboard.registerButton.click();
        //verify that you logged in as a agent
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        extentTest.pass("agent name is visible");
        //Click log out and verify your are logged out
        userDashboard.headerLogOutButton.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(userDashboard.headerSignIn.isDisplayed());
        extentTest.pass("Click log out and verify your are logged out");
    }

}

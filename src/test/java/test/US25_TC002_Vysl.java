package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US25_TC002_Vysl extends TestBaseReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("User Contact page message","Write and send a message on the User Contact page");
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Actions actions=new Actions(Driver.getDriver());

        //Click on the Sign Up button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.clickOnSignup.click();

        //Enter your account details and click on the 'Contact' button
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

        //Enter your account details and message
        userDashboard.contactName.sendKeys("veysel");
        userDashboard.contactEmail.sendKeys("ensmrt2012@gmail.com");
        userDashboard.contactSubject.sendKeys("Merhaba");
        userDashboard.contactPhone.sendKeys("+49123456789");
        actions.sendKeys(Keys.TAB,"Merhaba Hause Heaven :)").perform();
        ReusableMethods.wait(1);

        //Click on the 'Send Message' button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.contactSendMessageButton);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.contactSendMessageButton);

        //Verify that page is visible successfully
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.contactSendMessageVisible);
        Assert.assertTrue(userDashboard.contactSendMessageVisible.isDisplayed());

        extentTest.info("Message sent successfully verified");

        //The page is closed
        Driver.closeDriver();

    }
}
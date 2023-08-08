package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US15_TC002 extends TestBaseReport {

    @Test
    public void VerifyNewAdsOnAccountPage() {
        extentTest=extentReports.createTest("VerifyNewAdsOnAccountPage","Verify that I can add new ads on the account page");
        UserDashboard userDashboard = new UserDashboard();
        //1-Click add Property button
        ReusableMethods.wait(3);

        //1-Open browser
        //2-Navigate to "qa.hausehaven.com"
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Navigate to url 'https://qa.hauseheaven.com/'");
        //3-Cookies
        userDashboard.allowCookiesButton.click();

        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();

        //6-Enter correct email/username, password and click login
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.pass("Username is visible");
        ReusableMethods.sleep(3);

        userDashboard.addProperty.click();
        //2-Verify add Property is enabled
        Assert.assertTrue(userDashboard.propertiesPageVisible.isDisplayed());
        userDashboard.titleInput.sendKeys("Apartment");
        ReusableMethods.wait(2);
        userDashboard.descriptionInput.sendKeys("Welcome to the Wunderfull Residences");
        userDashboard.contentTextInput.sendKeys("Beautiful Apartment");

        //Sayfayi 500 pixel asagiya kaydir
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 500);");

        ReusableMethods.wait(2);

        Select select = new Select(userDashboard.citySelect);
        select.selectByVisibleText("Newark");

        userDashboard.propertyInput.sendKeys("Kansas City");

        //Sayfayi 1000 pixel asagiya kaydir
        js.executeScript("window.scrollBy(0, 1000);");
        ReusableMethods.wait(2);
        select = new Select(userDashboard.typexSelect);
        select.selectByVisibleText("For Sale");


        //   actions.sendKeys(Keys.PAGE_UP).perform();

        js.executeScript("window.scrollBy(0, -3000);");
        ReusableMethods.wait(5);
        userDashboard.saveAndExitButton.click();

        //Verify that I can add new ads on the account page
        Assert.assertTrue(userDashboard.firstRowOfAddOnAccountPage.isDisplayed());

        //Close driver
        Driver.closeDriver();
    }
}

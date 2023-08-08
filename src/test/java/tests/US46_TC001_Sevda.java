package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US46_TC001_Sevda extends TestBaseReport {
    @Test
    public void payForNewCreditOnUserDashboard() {
        extentTest=extentReports.createTest("payForNewCreditOnUserDashboard","payForNewCreditOnUserDashboard");

        //1. Open browser
        //2. Navigate to "https://qa.hauseheaven.com"
        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //3. Log in to the account
        userDashboard.headerSignIn.click();
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        userDashboard.headerUserName.click();
        ReusableMethods.wait(2);

        //4. Click on "Buy credits" button on left panel
        userDashboard.buyCredits.click();

        //5. Select payment option and enter credit card information
        userDashboard.purchaseButton1.click();
        ReusableMethods.wait(2);
                userDashboard.cardNumber.sendKeys(ConfigReader.getProperty("creditCarNumver"));
        ReusableMethods.wait(1);
        userDashboard.mMYY.sendKeys(ConfigReader.getProperty("creditCardValidMonthYear"));
        ReusableMethods.wait(1);
        userDashboard.fullName.sendKeys(ConfigReader.getProperty("creditCartFullName"));
        ReusableMethods.wait(1);
        userDashboard.cVC.sendKeys(ConfigReader.getProperty("creditCardCVC"));

        //Allow Cookies
        userDashboard.allowCookiesButton.click();
        ReusableMethods.wait(1);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //6. Click "Checkout" button
        userDashboard.checkOut.click();

        Driver.getDriver().switchTo().defaultContent();

    }
}
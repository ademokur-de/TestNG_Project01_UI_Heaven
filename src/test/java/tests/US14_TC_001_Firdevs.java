package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US14_TC_001_Firdevs extends TestBaseReport {

    @Test
    public void US_14_TC_01_Test(){

        extentTest=extentReports.createTest("User Page Property Test","Registered user should be able add,edit and delete  new property.");

        UserHomepage userHomepage= new UserHomepage();

        //The user logins to "https://qa.hauseheaven.com/login" page.
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userHomepage.linkSignIn.click();

        //Allow Cookies
        if (userHomepage.cookiesAllowButton.isDisplayed()){
            userHomepage.cookiesAllowButton.click();
        }

        // Enter username, password and login click
        UserDashboard userDashboard = new UserDashboard();

        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();
        extentTest.info("The user accesses the page");

        ReusableMethods.wait(2);

        //It is directed to the account page.
        userDashboard.headerUserName.click();

        ReusableMethods.wait(2);

        //Click on the relevant section to view property ads.
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.dashBoard);

        ReusableMethods.wait(2);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.properties);

        //Click the "Add Property" button.
        userDashboard.addProperty.click();

        //Enters the advertisement information (eg title, description, content, location).

        String expectedUrl = "https://qa.hauseheaven.com/account/properties/create";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedUrl);
        extentTest.pass("It is verified that Admin Property page has been accessed. ");

        String expectedTitle="House for Sale";

        userDashboard.titleInput.sendKeys(expectedTitle);
        userDashboard.descriptionInput.sendKeys("deneme");
        userDashboard.contentTextInput.sendKeys("deneme");
        userDashboard.propertyInput.sendKeys("Canada");

        //Click the "Save" button to publish the ad.
        userDashboard.saveAndExitButton.click();

        // Verify the process.
        String actualTitle = userDashboard.nameRecord1.getText();
        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("The new ad is added");

        //Click on the relevant advertisement to edit property ads.
        userDashboard.editButton1.click();
        //Updates the advertisement information (eg title, description, price, location).
        expectedTitle="House for Sale1";
        userDashboard.titleInput.sendKeys("1");

        //Click the "Update" button to save the changes.
        userDashboard.saveAndExitButton.click();

        //Verify the process.
        actualTitle = userDashboard.nameRecord1.getText();
        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("The Property is editted.");

        ReusableMethods.wait(2);

        //Click on the advertisement he wants to delete.
        userDashboard.deleteButton1.click();

        ReusableMethods.wait(2);

        //Click the "Delete" button and confirm the process.
        userDashboard.buttonDeleteConfirm.click();

        ReusableMethods.wait(2);

        //Verify that the property is deleted.
        actualTitle = userDashboard.nameRecord1.getText();
        Assert.assertNotEquals(actualTitle,expectedTitle);
        extentTest.pass("The Property is deleted.");

        //Close driver
        Driver.closeDriver();
    }

}
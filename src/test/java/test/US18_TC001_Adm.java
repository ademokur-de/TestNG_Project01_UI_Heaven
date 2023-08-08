package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US18_TC001_Adm extends TestBaseReport {

    @Test
    public void userHomepageBodySearchTest(){
        extentTest=extentReports.createTest("User Page search test", "It should be possible to make a search by making a registered user login.");

        UserHomepage visitorPage=new UserHomepage();
        UserDashboard userPage=new UserDashboard();

        //Go to qa.hauseheaven.com
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //Clicking on the Sign In link opens the login page.
        visitorPage.linkSignIn.click();
        if (visitorPage.copyrightInFooter.isDisplayed()){
            visitorPage.cookiesAllowButton.click();
        }

        //Enter the valid username and userpassword and click the login button.
        userPage.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userPage.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userPage.login.click();

        //The registered username is displayed
        Assert.assertTrue(userPage.headerUserName.isDisplayed());
        extentTest.pass("Registered user login verified");

        //Search is done in the search section on the home page
        userPage.searchForLocation.sendKeys("Germany");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", userPage.searchResult);

        //userPage.searchResult.click();
        ReusableMethods.wait(2);

        //Verify that the result text is displayed
        Assert.assertTrue(userPage.foundResults.isDisplayed());
        Assert.assertTrue(userPage.foundResults.getText().contains("Results"));
        extentTest.pass("Search was possible");

        //page is closed
        Driver.quitDriver();



    }


}
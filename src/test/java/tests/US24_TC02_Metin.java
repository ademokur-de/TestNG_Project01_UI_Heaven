package tests;

import org.openqa.selenium.By;
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

import java.util.List;

public class US24_TC02_Metin extends TestBaseReport {

    @Test
    public void blogDetailsEnabledForRegisteredUser() {
        extentTest=extentReports.createTest("blogDetailsEnabledForRegisteredUser","blogDetailsEnabledForRegisteredUser");

        //1. Open browser
        //Navigate to url 'https://qa.hauseheaven.com/'

        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        //2. Login the page successfully
        userDashboard.headerSignIn.click();
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        //3. Click on "Blog" page link
        userDashboard.clickOnBlog.click();

        userDashboard.allowCookiesButton.click();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", userDashboard.continue5);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);

        List<WebElement> blogCategoriesList = Driver.getDriver().findElements(By.xpath("//div[@class='single-widgets widget_category']"));
        Assert.assertFalse(blogCategoriesList.isEmpty());

        for (WebElement each : blogCategoriesList) {
            Assert.assertTrue(userDashboard.blogCategoriesList.isDisplayed());
            Assert.assertTrue(userDashboard.blogCategoriesList.isEnabled());
        }
        extentTest.pass("Buttons under Blog is visible");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);

        List<WebElement> featurePropertiesList = Driver.getDriver().findElements(By.xpath("//div[@class='sidebar_featured_property']"));
        Assert.assertFalse(featurePropertiesList.isEmpty());

        for (WebElement each : featurePropertiesList) {
            Assert.assertTrue(userDashboard.featuredPropertiesList.isDisplayed());
            Assert.assertTrue(userDashboard.featuredPropertiesList.isEnabled());
        }
    }
}

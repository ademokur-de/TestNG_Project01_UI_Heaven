package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;

public class US32_TC002_Vysl extends TestBaseReport {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Testimonials button on admin page","Verify the visibility of the page and the number of comments registered on the page and the visibility of comments");
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Enter Email/Username, Password and click on the Sign in Button
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.adminLogInButton);
        jsExecutor.executeScript("arguments[0].click();", adminDashboard.adminLogInButton);

        //Click on the Testimonials button
        adminDashboard.testimonialsButton.click();

        //Verify that page is visible successfully
        Assert.assertTrue(adminDashboard.labelCategories.isDisplayed());
        extentTest.info("Verify that page is visible successfully");

        //Verifies the number of recorded comments on the page and the visibility of comments
        ReusableMethods.wait(1);
        List<WebElement> commentsList = Driver.getDriver().findElements(By.xpath("//table[@class='table table-striped table-hover vertical-middle dataTable no-footer dtr-inline']"));
        Assert.assertFalse(commentsList.isEmpty());

        for (WebElement eachComment : commentsList) {
            Assert.assertTrue(eachComment.isDisplayed());
            Assert.assertTrue(eachComment.isEnabled());
        }

        Assert.assertTrue(adminDashboard.labelTestimonialsRecords.isDisplayed());

        Assert.assertTrue(adminDashboard.testimonialsPageVerifiy.isDisplayed());

        extentTest.info("Verified the number of registered comments on the page and the visibility of comments");

        //The page is closed
        Driver.closeDriver();

    }
}

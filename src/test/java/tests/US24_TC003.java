package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US24_TC003 extends TestBaseReport {

    @Test
    public void buttonsVisibilityUnderBlogOnUserDashPage() {
        extentTest=extentReports.createTest("buttonsVisibilityUnderBlogOnUserDashPage","Buttons visibility at the bottom of the blog on the user page");

        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userDashboard.headerSignIn.click();
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();
        userDashboard.clickOnBlog.click();
        userDashboard.allowCookiesButton.click();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", userDashboard.continue5);
        jse.executeScript("arguments[0].scrollIntoView(true);", userDashboard.blogFacebook);
        WebElement textRelatedPost = Driver.getDriver().findElement(By.xpath("//*[text()='Related posts:']"));

        ReusableMethods.wait(2);

        System.out.println("actualText: "+ textRelatedPost.getText());
        // Verify that items can be deleted
        try {
            Assert.assertTrue(textRelatedPost.getText().contains("Recent"));
        } catch (Exception e) {
            extentTest.fail("It is seen that Related Post instead of Recent Post!!!");
        }
        Driver.closeDriver();
    }
}

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

public class US24_TC004 extends TestBaseReport {


    @Test
    public void VisibilityAndActiveUnderBlogOnUserDashPage(){
        extentTest=extentReports.createTest("VisibilityAndActiveUnderBlogOnUserDashPage","Visibility and active of the buttons on the blog on the UserDashboardPage");

        //Visibility and active of the buttons on the blog on the UserDashboardPage
        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userDashboard.headerSignIn.click();
        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();


        userDashboard.clickOnBlog.click();

        userDashboard.allowCookiesButton.click();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();",userDashboard.continue5);

        System.out.println(Driver.getDriver().getWindowHandle());

        WebElement infoText=Driver.getDriver().findElement(By.xpath("//div[@class='post-details']"));//Location of the first ad

        //The name of the ad was manipulated by using small letters and spaces.String manipulation was applied here.
        String expectedText=infoText.getText().toLowerCase().replace(" ","-");
        //linklerde aranacak text'i yazdir

        //Actual WHD save - method(linkCheck) :necessary for method
        String WHD=Driver.getDriver().getWindowHandle();
        //Verify that the sale ad's can be shared on facebook, twitter and linkedin


        //Link is checked by with LinkCheck() method to check if there is any content
        Boolean socialShared= ReusableMethods.linkCheck(userDashboard.blogFacebook,"facebook",WHD);
        Assert.assertTrue(socialShared);
        System.out.println("Facebook Shared : " + socialShared);

        //userDashboard.firstAgentPageTwitter.click();
        socialShared=ReusableMethods.linkCheck(userDashboard.blogTwitter,"twitter",WHD);
        Assert.assertTrue(socialShared);
        System.out.println("Twitter Shared : " + socialShared);

        //userDashboard.firstAgentPageLinkedin.click();
        socialShared=ReusableMethods.linkCheck(userDashboard.blogLinkedin,"linkedin",WHD);
        Assert.assertTrue(socialShared);
        System.out.println("LinkedIn Shared : " + socialShared);

        Driver.closeDriver();
    }
}

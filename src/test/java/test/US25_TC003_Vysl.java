package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US25_TC003_Vysl extends TestBaseReport {

    @Test

    public void test01(){
        extentTest=extentReports.createTest("Address verification","Verifies that the address matches the address on the map");
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Click on the Sign Up button
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.clickOnSignup.click();
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickSignUpLogin);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickSignUpLogin);

        //Click on the Contact button
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.clickOnContact);
        jsExecutor.executeScript("arguments[0].click();", userDashboard.clickOnContact);
        userDashboard.allowCookiesButton.click();

        //Verify that the address in Reach us matches the address on the map
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userDashboard.iFrameMapContact);
        Driver.getDriver().switchTo().frame(userDashboard.iFrameMapContact);


        String actualAdress = userDashboard.adressOnMap.getText();
        Driver.getDriver().switchTo().defaultContent();
        String expectedAdress = userDashboard.contactInfoOnContacPage.getText();
        Assert.assertFalse(actualAdress.contains(expectedAdress), "Adresler eşleşmiyor!");

        System.out.println("!!!ADRESLER ESLESMIYOR!!!");

        extentTest.info("Verify that the address in Contact Us does not match the address on the map");

        //The page is closed

        Driver.quitDriver();
    }

}

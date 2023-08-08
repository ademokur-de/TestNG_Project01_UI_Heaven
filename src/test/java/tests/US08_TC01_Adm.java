package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US08_TC01_Adm extends TestBaseReport {







    @Test
    public void test01() {
        UserHomepage visitorPage = new UserHomepage();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        extentTest = extentReports.createTest("Agents Page verify test", "We are verified to be on the Agents page");
        //Go to qa.hauseheaven.com
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.wait(2);

        //Cookies allow

        ReusableMethods.wait(3);
        try {
            if (visitorPage.cookiesAllowButton.isDisplayed()) {
                visitorPage.cookiesAllowButton.click();
            }
        } catch (Exception e) {
            System.out.println("There is no cookies to click");

        /*
        if (visitorPage.copyrightInFooter.isDisplayed()) {

            visitorPage.cookiesAllowButton.click();

        }
        */
            //Click on the Agents link
            visitorPage.linkMenuAgents.click();

            //We are verified to be on the Agents page
            Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa.hauseheaven.com/agents");
            extentTest.pass("We are verified to be on the Agents page");

            //It is verified that the number of registered postings of the first real estate agent is displayed
            Assert.assertTrue(visitorPage.linkFirstAgent.isDisplayed());
            extentTest.pass("First Agent is displayed");

            Assert.assertTrue(visitorPage.labelFirstAgentNumberOfProperties.isDisplayed());
            extentTest.pass("the first real estate agent's posting number could be displayed");
            System.out.println("Ilk emlakci ilan sayi : " + visitorPage.labelFirstAgentNumberOfProperties.getText());

            //Verify that the first real estate agent's name, email and phone number appear
            System.out.println("Ilk emlakci adi : " + visitorPage.linkFirstAgent.getText());
            System.out.println("Ilk emlakci detay-2 : " + visitorPage.labelFirstAgentContactInfo.getText());

            Assert.assertTrue(visitorPage.labelFirstAgentContactInfo.isDisplayed());
            extentTest.pass("The first real estate agent's name, email and phone number appear to be verified");

            //We verify that the For Sale link is visible and active
            jsExecutor.executeScript("arguments[0].click();", visitorPage.buttonFirstAgentDetail);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", visitorPage.headerFirstAgentDetail);
            ReusableMethods.wait(1);
            jsExecutor.executeScript("arguments[0].click();", visitorPage.linkFirstAgentForRent);
            ReusableMethods.wait(1);
            Assert.assertTrue(visitorPage.linkFirstAgentForRent.isEnabled());
            extentTest.pass("real estate agent's rental ads could be viewed");

            //We verify that the For Rent link is visible and active
            jsExecutor.executeScript("arguments[0].click();", visitorPage.linkFirstAgentForSale);
            ReusableMethods.wait(1);
            Assert.assertTrue(visitorPage.linkFirstAgentForSale.isEnabled());
            extentTest.pass("real estate agent's sale ads could be displayed");

            // The page is close
            Driver.quitDriver();

        }
    }
}
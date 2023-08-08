package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US02_TC001_Adm extends TestBaseReport {


    @Test
    public void visitorHomepageHeaderMenuVerifyTest(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Actions actions =new Actions(Driver.getDriver());
        extentTest=extentReports.createTest("Verifying of visitor home page menus","The menus in the Header section of the Home page should be visible and active.");

        //go to qa.hauseheaven.com page

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        UserHomepage visitorPage= new UserHomepage();

        try {
            if (visitorPage.cookiesAllowButton.isDisplayed()){
                visitorPage.cookiesAllowButton.click();
            }
        } catch (Exception e) {

        }

        //Located in the header section;
        //Home, Listing, Projects, Agents, Blog, Contact, Sign Up menus are "visible".
        //Home, Listing, Projects, Agents, Blog, Contact, Sign Up menus are "active".

        ReusableMethods.wait(2);

        // Logo link Visibility and is link active Check
        ReusableMethods.wait(3);
        Assert.assertTrue(visitorPage.logoHome.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.logoHome);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://qa.hauseheaven.com"));
        extentTest.pass("The Logo in the Header section of the Home page must be visible and active.");

        // Home link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuHome.isDisplayed());
        actions.moveToElement(visitorPage.linkMenuHome).build().perform();
        visitorPage.linkMenuHome.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://qa.hauseheaven.com"));
        extentTest.pass("The Home menu in the Header section of the Home page should be visible and active.");

        // Listing link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuListing.isDisplayed());
        //jsExecutor.executeScript("arguments[0].click();",visitorPage.linkMenuListing);
        actions.moveToElement(visitorPage.linkMenuListing).build().perform();
        visitorPage.linkMenuListing.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("properties"));
        extentTest.pass("The Listing menu in the Header section of the Home page should be visible and active.");

        // Projects link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuProjects.isDisplayed());
        actions.moveToElement(visitorPage.linkMenuProjects).build().perform();
        visitorPage.linkMenuProjects.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("projects"));
        extentTest.pass("The Project menu in the Header section of the Home page should be visible and active.");

        // Agents link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuAgents.isDisplayed());
        actions.moveToElement(visitorPage.linkMenuAgents).build().perform();
        visitorPage.linkMenuAgents.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("agents"));
        extentTest.pass("The Agents menu in the Header section of the Home page should be visible and active.");

        // Blog link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuBlog.isDisplayed());
        actions.moveToElement(visitorPage.linkMenuBlog).build().perform();
        visitorPage.linkMenuBlog.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("blog"));
        extentTest.pass("The Blog menu in the Header section of the Home page should be visible and active.");

        // Contact link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuContact.isDisplayed());
        actions.moveToElement(visitorPage.linkMenuContact).build().perform();
        visitorPage.linkMenuContact.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("contact"));
        extentTest.pass("The Blog menu in the Header section of the Home page should be visible and active.");

        // AddProperty link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkAddProperty.isDisplayed());
        actions.moveToElement(visitorPage.linkAddProperty).build().perform();
        visitorPage.linkAddProperty.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
        extentTest.info("Add Property goes to login page when not logged in");
        extentTest.pass("The Add Property menu in the Header section of the Home page should be visible and active.");

        // SignIn link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkSignIn.isDisplayed());
        actions.moveToElement(visitorPage.linkSignIn).build().perform();
        visitorPage.linkSignIn.click();
        jsExecutor.executeScript("arguments[0].click();",visitorPage.linkSignIn);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
        extentTest.pass("The Sign In menu in the Header section of the Home page should be visible and active.");

        ReusableMethods.wait(1);
        // Wishlist link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkWishlist.isDisplayed());
        jsExecutor.executeScript("arguments[0].click();",visitorPage.linkWishlist);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("wishlist"));
        extentTest.pass("The Wishlist menu in the Header section of the Home page should be visible and active.");

        // SingUp link Visibility and is link active Check
        Assert.assertTrue(visitorPage.linkMenuSingUp.isDisplayed());
        actions.moveToElement(visitorPage.linkMenuSingUp).build().perform();
        visitorPage.linkMenuSingUp.click();

            if (!Driver.getDriver().getCurrentUrl().contains("register")){

            extentTest.info("The Sign Up menu in the Header section of the Home page should be directed to the \"Register\" page.");
            extentTest.fail("The Sign Up menu in the Header section of the Home page should be visible and active.");
                Assert.assertTrue(false);
        }else{
                Assert.assertTrue(true);
                extentTest.pass("The Sign Up menu in the Header section of the Home page should be visible and active.");
            }
                    ReusableMethods.wait(1);

        // Close the page
        Driver.quitDriver();

    }

}

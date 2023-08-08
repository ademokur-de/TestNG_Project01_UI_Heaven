package test;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US23_Elif extends TestBaseReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Login Successfully on qa.hauseheaven.com","The user should be able to login to the qa.hauseheaven.com successfully");
        //Test Case 1: Login the page successfully

        //1-Open browser
        UserDashboard userDashboard = new UserDashboard();
        //2-Navigate to "qa.hausehaven.com"
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("The user navigates to the qa.hauseheaven.com home page");
        //3-Verify that the home page is displayed successfully
        String expectedTitle = "Hause Heaven";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();
        //5-Verify "Login" is visible
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        //6-Enter correct email/username, password and click login
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();
        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.info("The user logins the qa.hauseheaven.com page successfully");

    }

    @Test
    public void test02() {
        extentTest=extentReports.createTest("Access the Agents page","The user should be able to acces the agents page successfully");
        //Test Case 2: Navigate to the relevant page
        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("The user navigates to the qa.hauseheaven.com home page");
        //3-Verify that the home page is displayed successfully
        String expectedTitle="Hause Heaven";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();
        //5-Verify "Login" is visible
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        //6-Enter correct email/username, password and click login
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.info("The user logins the qa.hauseheaven.com page successfully");


        //Navigate to the agents page.
        userDashboard.clickOnAgents.click();

        //Confirm that the page title correctly identifies as the agents page.
        String expectedAgentsPageTitle = "Agents";
        String actualAgentsPageTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualAgentsPageTitle, expectedAgentsPageTitle);
        extentTest.info("The user is able to acces the agents page");
    }

    @Test
    public void test03() {
        extentTest=extentReports.createTest("Access the registered listings","The user should be able to access the registered listings of the agents");
        //Test Case 3: Check the Registered Listings

        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("The user navigates to the qa.hauseheaven.com home page");
        //3-Verify that the home page is displayed successfully
        String expectedTitle="Hause Heaven";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();
        //5-Verify "Login" is visible
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        //6-Enter correct email/username, password and click login
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.info("The user logins the qa.hauseheaven.com page successfully");


        //While on the agents page, verify that the number of registered listings for the first agent is displayed.
        //Click on Agents
        userDashboard.clickOnAgents.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(userDashboard.numberOfRegisteredProperties1.isDisplayed());
        extentTest.info("The user is able to see the registered listing of the agent");

        //Verify that first agent's email box in the agents page is displayed and enabled
        Assert.assertTrue(userDashboard.eachAgentMailBox1.isDisplayed());
        extentTest.info("The user is able to see the mailbox on the registered agent's page");
        Assert.assertTrue(userDashboard.eachAgentMailBox1.isEnabled());
        extentTest.info("The user is able to access the mailbox of the agent on the registered agent's page");

    }

    @Test
    public void test04() {
        extentTest=extentReports.createTest("Access the agent's contact information","The user should be able to access the agent's contact information");

        //Test Case 4: Check The Agents' Information
        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("The user navigates to the qa.hauseheaven.com home page");
        //3-Verify that the home page is displayed successfully
        String expectedTitle="Hause Heaven";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();
        //5-Verify "Login" is visible
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        //6-Enter correct email/username, password and click login
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.info("The user logins the qa.hauseheaven.com page successfully");


        //On the agents page, check sections where other agent information (such as name, contact details, bio, etc.)
        // are obtained
        //Click on Agents
        Actions actions = new Actions(Driver.getDriver());
        userDashboard.clickOnAgents.click();
        ReusableMethods.wait(2);
        userDashboard.allowCookiesButton.click();
        ReusableMethods.wait(4);
        userDashboard.agentsView1.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        userDashboard.clickOnAgents.click();

        //Confirm that this information is visible
        Assert.assertTrue(userDashboard.agentsView1.isDisplayed());
        extentTest.info("The user is able to access the contact information of the agent");


    }

    @Test
    public void test05() {
        extentTest=extentReports.createTest("Access Sale Ads","The user should be able to access the sale ads of the registered agent");


        //Test Case 5: Access Sale Ads
        UserDashboard userDashboard = new UserDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("The user navigates to the qa.hauseheaven.com home page");
        //3-Verify that the home page is displayed successfully
        String expectedTitle="Hause Heaven";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        //4-Click on Sign In button in the header section
        userDashboard.headerSignIn.click();
        //5-Verify "Login" is visible
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        //6-Enter correct email/username, password and click login
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        //7-Verify the username is visible in the header section
        Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
        extentTest.info("The user logins the qa.hauseheaven.com page successfully");

        //Choose a real estate agent from the list and navigate to their personal page or listings.
        //Click on Agents
        userDashboard.clickOnAgents.click();
        ReusableMethods.wait(3);
        userDashboard.agentsView1.click();
        //Identify the section where the sale ads are displayed.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        userDashboard.firstAgentForSaleButton.click();
        //Verify that the sale ads are visible
        Assert.assertTrue(userDashboard.firstAgentForSaleAd.isDisplayed());
        extentTest.info("The user is able to see the sale property");
        //Click on a sale ad to ensure it can be accessed and loads correctly!
        ReusableMethods.wait(3);
        userDashboard.firstAgentForSaleAd.click();

        //Verify that for sale ad's info is displayed when clicked on ad
        Assert.assertTrue(userDashboard.firstAgentForSaleAdInfo.isDisplayed());
        System.out.println(Driver.getDriver().getWindowHandle());

        WebElement infoText=Driver.getDriver().findElement(By.xpath("//h3[@class='text-light']"));//Location of the first ad

        //The name of the ad was manipulated by using small letters and spaces.String manipulation was applied here.
        String expectedText=infoText.getText().toLowerCase().replace(" ","-");
        //linklerde aranacak text'i yazdir
        System.out.println(expectedText);

        //Actual WHD save - method(linkCheck) :necessary for method
        String WHD=Driver.getDriver().getWindowHandle();
        //Verify that the sale ad's can be shared on facebook, twitter and linkedin

        // userDashboard.firstAgentPageFacebook.click();

        //Link is checked by with LinkCheck() method to check if there is any content
        Boolean socialShared=ReusableMethods.linkCheck(userDashboard.firstAgentPageFacebook,expectedText,WHD);
        Assert.assertTrue(socialShared);
        System.out.println("Facebook Shared : " + socialShared);

        //userDashboard.firstAgentPageTwitter.click();
        socialShared=ReusableMethods.linkCheck(userDashboard.firstAgentPageTwitter,expectedText,WHD);
        Assert.assertTrue(socialShared);
        System.out.println("Twitter Shared : " + socialShared);

        //userDashboard.firstAgentPageLinkedin.click();
        socialShared=ReusableMethods.linkCheck(userDashboard.firstAgentPageLinkedin,expectedText,WHD);
        Assert.assertTrue(socialShared);
        System.out.println("LinkedIn Shared : " + socialShared);

        // Driver.getDriver().switchTo().defaultContent();

        //Navigate to the new tab
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Click on Agents
        userDashboard.clickOnAgents.click();
        ReusableMethods.wait(3);
        extentTest.info("The user is able to access the sale ads and social media links are accessed");
    }

        @Test
        public void test06 () {
        extentTest=extentReports.createTest("Access Rental Ads","The user should be able to access the rental ads of the registered agent");

        //Test Case 6: Access Rental Ads
            UserDashboard userDashboard = new UserDashboard();
            Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
            extentTest.info("The user navigates to the qa.hauseheaven.com home page");
            //3-Verify that the home page is displayed successfully
            String expectedTitle="Hause Heaven";
            String actualTitle=Driver.getDriver().getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);
            //4-Click on Sign In button in the header section
            userDashboard.headerSignIn.click();
            //5-Verify "Login" is visible
            Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
            //6-Enter correct email/username, password and click login
            userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
            userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
            userDashboard.loginButton.click();
            //7-Verify the username is visible in the header section
            Assert.assertTrue(userDashboard.userNameVisibleTest.isDisplayed());
            extentTest.info("The user logins the qa.hauseheaven.com page successfully");


            //Navigate back to the chosen real estate agent's listings.
            ReusableMethods.wait(2);
            userDashboard.clickOnAgents.click();
            ReusableMethods.wait(2);
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].click();", userDashboard.agentsView1);
            //Identify the section where the rental ads are displayed.
            ReusableMethods.wait(5);
            userDashboard.firstAgentForRentButton.click();
            //Verify if the rental ads are visible and legible
            Assert.assertTrue(userDashboard.firstAgentFirstAdRentalVisible.isDisplayed());
            extentTest.info("The user is not able to see any ads that is for rent");
           //Click on a rental ad to ensure it can be accessed and loads correctly.
            ReusableMethods.wait(2);
            userDashboard.firstAgentFirstRentalAddClick.click();
            //Verify that the rental ad's info is displayed on the header section when clicked on ad
            Assert.assertTrue(userDashboard.firstAgentForRentInfo.isDisplayed());
            extentTest.info("The user is able to see the information of the rental ad");

            /*
             When i first did the test I located 2 rental ads on the first agent's page. However, I see no rental ads
             I checked the other agents' pages and the result is the same. So I had to change
             my codes
             */

            //Close Browser
            Driver.closeDriver();


        }
    }





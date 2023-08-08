package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;

public class US22_Elif extends TestBaseReport {
    @Test

    public void test01() {
        extentTest=extentReports.createTest("Login Successfully on qa.hauseheaven.com","The user should be able to login to the qa.hauseheaven.com successfully");
        //Test case 1: Login the page successfully

        //1-Open browser
        UserDashboard userDashboard = new UserDashboard();
        //2-Navigate to "qa.hausehaven.com"
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

    }


    @Test
    public void test02() {
        extentTest=extentReports.createTest("Projects Verification Test","The user should be able to obtain the Projects List on Projects Page");
        //Test Case 2: Projects verification on Projects page
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


        //1-Click on Projects
        userDashboard.clickOnProjects.click();
        extentTest.info("The user navigates to the Projects Page");
        //2-Verify Projects page is enabled
        String expectedTitle1 = "All Projects";
        String actualTitle1 = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //3-Verify the number of project announcements and the projects are displayed
        Assert.assertTrue(userDashboard.numberOfProjectsVisibleTest.isDisplayed());
        extentTest.info("The user is able to access the number of Projects");

        //Verify all projects in the list are displayed and enabled
        List<WebElement> allProjectsList=Driver.getDriver().findElements(By.xpath("//div[@class='container mt-5']"));
        Assert.assertFalse(allProjectsList.isEmpty());

        for (WebElement eachList:allProjectsList) {
            Assert.assertTrue(eachList.isDisplayed());
            extentTest.info("The user is able to see the list of the Projects on the Projects page");
            Assert.assertTrue(eachList.isEnabled());
            extentTest.info("The user is able to access the list of the Projects on the Projects page");
        }
    }

    @Test
    public void test03() throws InterruptedException {
        extentTest=extentReports.createTest("Project Details Verification","The user should be able to access the project details");

        UserDashboard userDashboard = new UserDashboard();
        //Test Case 3: The Project Details Verification
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


        //1-Click on Projects
        userDashboard.clickOnProjects.click();
        //2-Verify Projects page is enabled
        String expectedTitle2 = "All Projects";
        String actualTitle2 = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //3-Verify the number of project announcements and the projects are displayed
        Assert.assertTrue(userDashboard.numberOfProjectsVisibleTest.isDisplayed());
        Assert.assertTrue(userDashboard.allProjectsList.isDisplayed());
        //4-Verify the details of the first project are visible
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);
        userDashboard.firstProject.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(userDashboard.firstProjectDetails.isDisplayed());
        extentTest.info("The user is able to access the projects details");


    }

    @Test
    public void test04 () {
        extentTest=extentReports.createTest("Search on projects Page","The user should be able to search on Projects on Projects Page");
        UserDashboard userDashboard=new UserDashboard();
        //Test Case 4: Search Projects By Filtering
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


        //Click on Projects
        userDashboard.clickOnProjects.click();
        ReusableMethods.wait(3);

        //Verify that the results are obtained when information is selected from country,state,city and category
        // buttons and click on Search
        Select select = new Select(userDashboard.countryOnProjects);
        select.selectByIndex(1);
        ReusableMethods.wait(3);


        select = new Select(userDashboard.stateOnProjects);
        select.selectByIndex(0);
        ReusableMethods.wait(2);


        select = new Select(userDashboard.cityOnProjects);
        select.selectByIndex(0);
        ReusableMethods.wait(2);


        select = new Select(userDashboard.categoryOnProjects);
        select.selectByIndex(2);
        ReusableMethods.wait(2);


        //2-Verify that the details of the results are displayed
        String expectedResult="Found 1 - 9 Of 9 Results";
        String actualResult=ConfigReader.getProperty("projectFoundResult");
        Assert.assertEquals(expectedResult,actualResult);
        extentTest.info("The user is able search on the Projects by filtering on Projects Page");

        Driver.closeDriver();
    }






    }

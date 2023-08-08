package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;

public class US49_TC01_Elif extends TestBaseReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Login admin dashboard","The user should be able to login admin dashboard successfully");
        //Test Case 1: Login succesfully
        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for username/admin name in the header
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access admin dashboard");
    }

    @Test
    public void test02() {
        extentTest=extentReports.createTest("Access the States list under Locations","The user should be able to access the states list");
        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for username/admin name in the header
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access admin dashboard");

        //Navigate to the Locations section in the admin dashboard.
        adminDashboard.locationsButton.click();
        //Click on the 'States' page under the Locations section.
        adminDashboard.locationsStatesButton.click();
        //Verify that the 'States' page opens successfully.
        String expectedTitle = "States | Hause Heaven";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        extentTest.info("The user is able to access States page under Locations");

        //Check the visibility and activity status of the items on the page.
        List<WebElement> statesList = Driver.getDriver().findElements(By.xpath("//table[@id='botble-location-tables-state-table']"));
        Assert.assertFalse(statesList.isEmpty());

        for (WebElement eachState : statesList) {
            Assert.assertTrue(eachState.isDisplayed());
            Assert.assertTrue(eachState.isEnabled());
        }
        //Verify that the number of registered states/provinces can be viewed on the page.
        Assert.assertTrue(adminDashboard.numberOfStatesRecord.isDisplayed());
        extentTest.info("The user is able to see the number of States");

    }

    @Test
    public void test03() {
        extentTest=extentReports.createTest("Adding new States","The user should be able to add new States on the States page");
        //Test Case: Adding New States:
        AdminDashboard adminDashboard = new AdminDashboard();

        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for username/admin name in the header
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access admin dashboard");
        //Click Locations on the admin dashboard
        adminDashboard.locationsButton.click();
        //Click States under Location
        adminDashboard.locationsStatesButton.click();
        //Click 'Create' button on the States page
        adminDashboard.locationsStatesCreateButton.click();
        //Enter  details for the new state/province (State/Province name, Description).
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        adminDashboard.locationsStatesCreateNameInput.click();
        actions.sendKeys(faker.name().firstName()).perform();
        adminDashboard.locationsStatesCreateAbbrInput.click();
        actions.sendKeys("AB").perform();
        Select select = new Select(adminDashboard.locationsStatesSelectCountry);
        select.selectByIndex(1);
       // adminDashboard.locationStatesOrder.click();
        actions.sendKeys("1").perform();
       //   int orderValue = Integer.parseInt(adminDashboard.locationStatesOrder.getAttribute("value"));
        //  Assert.assertTrue(adminDashboard.orderError.isEnabled());
        //Click the 'Save' or 'Save&Exit'  button.
        adminDashboard.locationsStatesSaveAndExit.click();
        //Verify that the new state is added by checking its presence in the states list.
        Assert.assertTrue(adminDashboard.statesAddedState.isDisplayed());
        extentTest.info("The user is able to add new state on the States page");

    }

    @Test
    public void test04() {
        extentTest=extentReports.createTest("Editing the Chosen State","The user should be able to edit the chosen State on the States page");
        //Test Case: Editing States:
        AdminDashboard adminDashboard = new AdminDashboard();

        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for username/admin name in the header
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access admin dashboard");
        //Click Location on admin dashboard
        adminDashboard.locationsButton.click();
        //Click states under Locations
        adminDashboard.locationsStatesButton.click();
        //Choose a state to edit from the list of existing states.
        ReusableMethods.wait(2);
        adminDashboard.tagsRadioButton.click();
        //Click on the 'Edit' button next to the chosen state.
        adminDashboard.editButton.click();
        //Modify the details of the state/province as required.
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        adminDashboard.locationsStatesCreateNameInput.click();
        actions.sendKeys(faker.name().firstName()).perform();
        adminDashboard.locationsStatesCreateAbbrInput.click();
        actions.sendKeys("CD").perform();
        Select select = new Select(adminDashboard.locationsStatesSelectCountry);
        select.selectByIndex(2);
        //Click the 'Save' or 'Save&Exit' button.
        adminDashboard.saveExitButton.click();
        //Verify that the state details are updated by checking the updated information in the states/provinces list.
        Assert.assertTrue(adminDashboard.statesAddedState.isDisplayed());
        extentTest.info("The user is able to edit the chosen state successfully");

    }

    @Test
    public void test05() {
        extentTest=extentReports.createTest("Deleting The Chosen State","The user should be able to delete the chosen state on teh states page");
        //Test Case: Deleting States/Provinces:
        AdminDashboard adminDashboard=new AdminDashboard();
        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for username/admin name in the header
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access admin dashboard");
        //Click location
        adminDashboard.locationsButton.click();
        //Click States under location
        adminDashboard.locationsStatesButton.click();
        //Choose a state to delete from the list of existing states.
        ReusableMethods.wait(2);
        adminDashboard.tagsRadioButton.click();
        //Click on the 'Delete' button next to the chosen state/province.
        adminDashboard.deleteButton.click();
        //Confirm the deletion if a confirmation box appears.
        ReusableMethods.wait(2);
        adminDashboard.blogPostDeleteConfirmButton.click();
        //Verify that the state is deleted by checking the successfully deleted text
        Assert.assertTrue(adminDashboard.deleteSuccessfullyText.isDisplayed());
        extentTest.info("The user is able to delete the chosen state successfully");
        //Close Browser
        Driver.closeDriver();
    }

}
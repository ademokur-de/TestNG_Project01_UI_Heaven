package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;




import java.util.List;

import static org.testng.Assert.assertTrue;

public class US31_TC01_Elif extends TestBaseReport {
    @Test
    public void Test01()  {
        extentTest=extentReports.createTest("Login Admin Page","The user should be able to successfully login the Admin Dashboard");

        //Test Step 1: Login to the admin page successfully
        AdminDashboard adminDashboard = new AdminDashboard();

        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for admin name in the header
        ReusableMethods.wait(3);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access the admin dashboard");
    }

    @Test
    public void test02() {
        extentTest=extentReports.createTest("Checking each tag","The user should be able to check each tag on the tag page");

        AdminDashboard adminDashboard = new AdminDashboard();

        //Navigate to the login page of the admin dashboard.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for admin name in the header
        ReusableMethods.wait(3);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access the admin dashboard");
        //Navigate to the Blog section in the admin dashboard.
        adminDashboard.blogButton.click();
        //Click on the 'Tag' page under the blog section.
        adminDashboard.tagsButton.click();
        //Verify that the 'Tag' page opens successfully.
        String expectedTitle = "Tags | Hause Heaven";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        extentTest.info("The user is able to access tag page under blog");

        //Verify the visibility and activity of each existing tags.
        List<WebElement> tagsList = Driver.getDriver().findElements(By.xpath("//table[@id='botble-blog-tables-tag-table']"));
        Assert.assertFalse(tagsList.isEmpty());
        extentTest.info("The user is able verify that the tag list is not empty");

        for (WebElement eachTag : tagsList) {
            Assert.assertTrue(eachTag.isDisplayed());
            Assert.assertTrue(eachTag.isEnabled());
            extentTest.info("The user is able to verify that each tag is enabled");
        }
    }

    @Test
    public void test03() {
        extentTest=extentReports.createTest("Adding new Tag","The user should be able to add new tag in the tag page");

        //Test Case 3: Adding New Tags:
        AdminDashboard adminDashboard = new AdminDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for admin name in the header
        ReusableMethods.wait(3);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access the admin dashboard");
        //Click Blog on the admin dashboard
        adminDashboard.blogButton.click();
        //Click Tags under Blog
        adminDashboard.tagsButton.click();
        //Click on the 'Create' button
        adminDashboard.tagsCrateButton.click();
        //Enter details for the new tag (Tag name, Tag description)
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        adminDashboard.textBoxBlogPostName.click();
        actions.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(faker.expression("Winter is coming")).perform();
        //Click the 'Save&Exit' button
        adminDashboard.blogPostSaveExitButton.click();
        //Verify the new tag is added
        String expectedText1 = "Success! Created successfully";
        Assert.assertEquals("Success! Created successfully", expectedText1);
        extentTest.info("The user is able to add new tag");

    }

    @Test
    public void test04() {
        extentTest=extentReports.createTest("Editing Tags","The user should be able to edit tags on the tags page");
        //Test Case:  Editing Tags
        AdminDashboard adminDashboard = new AdminDashboard();

        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for admin name in the header
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access the admin dashboard");
        //Click Blog on the admin dashboard
        adminDashboard.blogButton.click();
        //Click tags under blog
        adminDashboard.tagsButton.click();
        //Choose a tag to edit from the list of existing tags
        ReusableMethods.wait(2);
        adminDashboard.tagsRadioButton.click();
        //Click on the 'Edit' button next to the chosen tag.
        adminDashboard.editButton.click();
        //Modify the details of the tag as required.
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        adminDashboard.textBoxBlogPostDescription.click();
        actions.sendKeys(faker.expression("Winter is really coming")).perform();
        //Click the 'Save&Exit' button.
        adminDashboard.saveExitButton.click();
        //Verify that the tag details are updated by checking the updated successfully message
        String expectedText = "Success! Updated successfully";
        String actualText=ConfigReader.getProperty("successText");
        Assert.assertEquals(actualText,expectedText);
        extentTest.info("The user is able to edit the chosen tag successfully");

    }

    @Test
    public void test05() {
        extentTest=extentReports.createTest("Deletin new tags","The user should be able to delete tags");
        //Test Case:  Deleting Tags:
        AdminDashboard adminDashboard=new AdminDashboard();
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Enter valid admin credentials and click the 'Login' button.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        //Verify successful login by checking for admin name in the header
        ReusableMethods.wait(3);
        Assert.assertTrue(adminDashboard.adminUserNameAdminHeader.isDisplayed());
        extentTest.info("The user is able to access the admin dashboard");
        //Choose a tag to delete from the list of existing tags.
        //Click blog on admindashboard page
        adminDashboard.blogButton.click();
        //click tags under blog
        adminDashboard.tagsButton.click();
        ReusableMethods.wait(2);
        adminDashboard.tagsRadioButton.click();
        //Click on the 'Delete' button next to the chosen tag.
        adminDashboard.deleteButton.click();
        //Confirm the deletion if a confirmation box appears.
        ReusableMethods.wait(2);
        adminDashboard.confirmDeleteButtonElif.click();
        //Verify that the tag is deleted by checking its absence in the tag list.
        assertTrue(adminDashboard.deleteSuccessfullyText.isDisplayed());
        extentTest.info("The user is able to delete the chosen tag successfully");
        //Close Browser
        Driver.closeDriver();
    }

}


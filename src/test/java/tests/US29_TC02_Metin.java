package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US29_TC02_Metin extends TestBaseReport {


    @Test
    public void testFirstCreatePostThenSaveEditAndDelete(){
        Faker faker = new Faker();
        String titleName=faker.name().title();
        String titleNameAfterEdit = faker.name().title();
        String description = faker.lorem().sentence();
        String content = faker.lorem().paragraph();
        extentTest=extentReports.createTest("testMakeRegistrationWithCorrectButton","testMakeRegistrationWithCorrectButton");

        AdminDashboard adminDashboard = new AdminDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to url 'https://qa.hauseheaven.com/admin/login'");
        //Verify that the admin login page is visible
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that the admin login page is visible");
        //Fill in admin information and Click 'Sign in' button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin02"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("Fill in admin information and Click 'Sign in' button");
        //Click 'Side Bar Switch'
        ReusableMethods.wait(2);
        adminDashboard.sideBarButton.click();
        extentTest.info("Click 'Side Bar Switch'");
        //Click 'Blog'
        ReusableMethods.sleep(5);
        adminDashboard.blogButton.click();
        extentTest.info("Click 'Blog'");
        //Click 'Post'
        ReusableMethods.sleep(4);
        adminDashboard.postButton.click();
        extentTest.info("Click 'Post'");
        //Click 'Create' and verify that
        ReusableMethods.wait(1);
        adminDashboard.blogPostCreateButton.click();
        extentTest.info("Click 'Create' and verify that");
        //Fill in information for new blog post
        ReusableMethods.sleep(10);
        adminDashboard.textBoxBlogPostName.sendKeys(titleName);
        adminDashboard.textBoxBlogPostDescription.sendKeys(description);
        adminDashboard.switchInPostCreateButton.click();
        adminDashboard.textBoxBlogPostContent.sendKeys(content);
        ReusableMethods.sleep(5);

        ReusableMethods.sleep(4);
        Select select = new Select(adminDashboard.dropDownStatusInCreatePage);
        select.selectByIndex(2);
        ReusableMethods.sleep(2);


        adminDashboard.radioButtonHouseDesignInPostCreate.click();

        ReusableMethods.wait(2);
        extentTest.info("Fill in information for new blog post");

        //Click 'Save&Exit'
        adminDashboard.saveExitButton.click();
        extentTest.info("Click 'Save&Exit'");
        //Verify that new blog is saved successfuly
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("Verify that new blog is saved successfuly");
        //Click 'edit'
        adminDashboard.editButton.click();
        extentTest.info("Click 'edit'");
        //Delete all 'content' and Write down new one
        adminDashboard.textBoxBlogPostContent.clear();
        adminDashboard.textBoxBlogPostContent.sendKeys(faker.lorem().sentence());
        extentTest.info("Delete all 'content' and Write down new one");

        //Click 'Save'
        adminDashboard.saveButton.click();
        extentTest.info("Delete all 'content' and Write down new one");
        ReusableMethods.wait(2);

        //Delete all 'Name' and Write down new one
        adminDashboard.textBoxBlogPostName.clear();
        adminDashboard.textBoxBlogPostName.sendKeys(titleNameAfterEdit);
        extentTest.info("Delete all 'Name' and Write down new one");
        //Click 'Save&Exit'
        adminDashboard.saveExitButton.click();
        ReusableMethods.wait(2);
        extentTest.info("Click 'Save&Exit'");
        //Delete related post and Verify that the post is deleted
        for (int i = 1; i <=10 ; i++) {
            WebElement dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[4]"));
            if (titleNameAfterEdit.equals(dynamicTableWay.getText())) {
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[10]/div/a[2]")).click();
                ReusableMethods.wait(1);
                adminDashboard.confirmDeleteButton.click();
                ReusableMethods.wait(1);
                Assert.assertTrue(adminDashboard.labelSuccessfullDelete.isDisplayed());
                break;
            }
        }
        extentTest.info("Delete related post and Verify that the post is deleted");
        //Log out admin account
        adminDashboard.adminUserButtonOnHeader.click();
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Log out admin account");

        //verify that you are logged out from admin page
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("verify that you are logged out from admin page");


    }
}

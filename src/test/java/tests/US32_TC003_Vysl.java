package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US32_TC003_Vysl extends TestBaseReport {
    @Test

    public void test01(){
        extentTest=extentReports.createTest("Testimonials on the admin page also creative button","Verify that new comments can be added-edited-deleted");
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //Enter Email/Username, Password and click on the Sign in Button
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.adminLogInButton);
        jsExecutor.executeScript("arguments[0].click();", adminDashboard.adminLogInButton);

        ReusableMethods.wait(1);

        //Click on the Testimonials button
        adminDashboard.testimonialsButton.click();

        ReusableMethods.wait(1);

        //Click on the Creative button

      jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.propertiesCreateButton);
      jsExecutor.executeScript("arguments[0].click();", adminDashboard.propertiesCreateButton);

      ////Enter a new comment on the opened page (Name,Position/Company,AddMedia,Addimage..)
      adminDashboard.nameRegister.sendKeys("veysel");
      ReusableMethods.wait(1);
      adminDashboard.textBoxCompanyInput.sendKeys("dursun");
      ReusableMethods.wait(1);
      adminDashboard.testimonialsCreativeContentInput.sendKeys("Hallo Team");

      //Then click save&exit and confirm that it has been saved
      adminDashboard.saveExitButton.click();

        String expectedTestimonialsName ="veysel";
        String actualTestimonialsName = adminDashboard.testimonialsSaveExitVisibilitiy.getText();

       Assert.assertTrue(actualTestimonialsName.contains(expectedTestimonialsName));

       extentTest.info("Confirmation of the addition of a new comment");

        //Verify that it works by clicking the edit button on the saved comment
        adminDashboard.editButton.click();
        adminDashboard.nameRegister.clear();
        adminDashboard.nameRegister.sendKeys("enes");
        ReusableMethods.wait(1);

        adminDashboard.saveExitButton.click();

        String expectedTestimonialsEditName ="enes";
        String actualTestimonialsEditName = adminDashboard.testimonialsSaveExitVisibilitiy.getText();

       Assert.assertTrue(actualTestimonialsEditName.contains(expectedTestimonialsEditName));
       extentTest.info("Confirmation that the name of the comment has changed");

       ReusableMethods.wait(1);

       //Verify that it works by clicking the delete button on the saved comment
        adminDashboard.deleteButton.click();
        ReusableMethods.wait(1);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.confirmDeleteButton);
        jsExecutor.executeScript("arguments[0].click();", adminDashboard.confirmDeleteButton);

        Assert.assertFalse(adminDashboard.testimonialsSaveExitVisibilitiy.equals("enes"));

        extentTest.info("Confirmation of deletion of new comment");

       //The page is closed
       Driver.closeDriver();


    }
}

package test;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.List;

public class US39_TC001_Adm extends TestBaseReport {



    @Test
    public void newsletterAdditionTest() {
        extentTest = extentReports.createTest("Admin Page Newsletter Test", "Must be able to subscribe to Newsletter from the visitor page and be viewed and deleted from the admin page");

        UserHomepage userHomepage=new UserHomepage();
        AdminDashboard adminDashboard=new AdminDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Faker faker=new Faker();

        //Test Case-1:
        //        Guest page login
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        ReusableMethods.wait(3);
        // Subscribe to the newsletter from the footer section with fake mail
        String registerEmailForNewsletter = faker.internet().emailAddress();

        ReusableMethods.wait(2);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", userHomepage.textboxSubscribeInFooter);
        ReusableMethods.wait(1);
        userHomepage.textboxSubscribeInFooter.sendKeys(registerEmailForNewsletter);
        userHomepage.buttonSubscribeInFooter.click();
        ReusableMethods.wait(2);

        // Verify that it has been successfully added
        Assert.assertTrue(userHomepage.labelSubscribeTrueMessageInFooter.isDisplayed());
        extentTest.pass("The e-mail address is added from the visitor page. E-mail : " + registerEmailForNewsletter);

        //Go to qa.hauseheaven.com/admin/login
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        ReusableMethods.wait(2);

        //Enters valid username and password, presses the login button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();

        ReusableMethods.wait(3);
        // Click to Newsletter button
        adminDashboard.newsLettersButton.click();
        ReusableMethods.wait(2);

        // We are verified to be on the Newsletter page
        String pageHeaderText = adminDashboard.labelAccountsText.getText();
        Assert.assertTrue(pageHeaderText.contains("Newsletter"));
        extentTest.pass("It is verified to be on the Newsletter page");
        ReusableMethods.wait(2);

        // It is verified that the newsletters can be viewed
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.selectOptionsNewsletter);
        Select select = new Select(adminDashboard.selectOptionsNewsletter);
        select.selectByValue("-1");
        ReusableMethods.wait(2);
        List<WebElement> newsletterSubscribeList = Driver.getDriver().findElements(By.xpath("//td[@class=' text-start column-key-email']"));

        // Verifies that the number of newsletter and items are viewable
        System.out.println("This page records : " + newsletterSubscribeList.size());
        System.out.println("Total records : " + adminDashboard.labelPropertiesRecords.getText());
        System.out.println("Send Email : " + registerEmailForNewsletter);
        Boolean entryEmailIsFind = false;
        for (WebElement each : newsletterSubscribeList
        ) {
            if (each.getText().equals(registerEmailForNewsletter)) {
                entryEmailIsFind = true;
                registerEmailForNewsletter = each.getText();
                // Confirmation that the added items are visible
                System.out.println("Read Email : " + each.getText());
                break;
            }
        }
        Assert.assertTrue(entryEmailIsFind);
        extentTest.pass("The e-mail address added from the visitor page is verified. E-mail : " + registerEmailForNewsletter);
        //Records Check
        String records = adminDashboard.labelPropertiesRecords.getText();

        int nummer = Integer.parseInt(records) + 1;
        Boolean fakeMail = false;
        for (WebElement each : newsletterSubscribeList
        ) {
            if (!each.getText().substring(each.getText().indexOf("@")).contains(".")) {
                System.out.println("Record " + nummer + " (False): " + each.getText());
                fakeMail = true;
            } else {
                System.out.println("Record " + nummer + " : " + each.getText());
            }
            if (nummer == 3) {
                nummer--;
            }
            nummer--;
        }
        System.out.println("===============================================");
        if (fakeMail) {
            System.out.println("Attention. there are fake emails");
            System.out.println("===============================================");
        }

        // Verify that items can be deleted
        try {
            Assert.assertTrue(adminDashboard.deleteButton.isDisplayed());
        } catch (Exception e) {
            extentTest.fail("Delete button not found!!!");
        }
        try {
            if (!adminDashboard.deleteButton.isDisplayed()){
                Assert.assertTrue(false);
                extentTest.fail("Delete button not found!!!");
            }
        } catch (Exception e) {
            Assert.assertTrue(false);
            extentTest.fail("Delete button not found!!!");
        }
        // Close driver.
        Driver.closeDriver();
    }
}

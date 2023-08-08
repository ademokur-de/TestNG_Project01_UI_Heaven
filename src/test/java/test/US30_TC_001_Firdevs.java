package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class US30_TC_001_Firdevs extends TestBaseReport {


    @Test
    public void test01() {
        extentTest=extentReports.createTest("Admin Page Categories Test","Admin should be able to access the Admin Categories Page,he/she should be able to add,edit and delete a new category ");

        AdminDashboard adminDashboard = new AdminDashboard();
        UserDashboard userDashboard = new UserDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        //The user logins to "https://qa.hauseheaven.com/admin/login" page.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        ReusableMethods.wait(2);
        //Admin logs to the system with its user name and password.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();
        extentTest.info("Admin accesses the Admin Categories Page");

        ReusableMethods.wait(2);

        //It is successfully directed to Dashboard.
        Assert.assertTrue(adminDashboard.adminDasboardButton.isDisplayed());
        extentTest.pass("It is verified that The Admin Categories Page has been accessed. ");

        //It accesses the "Categories" page under the blog.
        // Click the Blog button.
        adminDashboard.blogButton.click();
        adminDashboard.categoriesButton.click();

        ReusableMethods.wait(2);

        List<WebElement> categoriesList = Driver.getDriver().findElements(By.xpath("//*[@class='fetch-data category-name']"));
        System.out.println("Eklemeden Onceki List sayisi : " + categoriesList.size());

        //Successfully accesses the "Categories" page.
        Assert.assertTrue(adminDashboard.categoriesCrateButton.isDisplayed());
        extentTest.pass("Existing Categories under the Categories Page are viewable and active.");

        String expectedUrl = "https://qa.hauseheaven.com/admin/blog/categories";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Categories Page Url is verified.");

        //Click the "Create New Category" button.
        adminDashboard.categoriesCrateButton.click();
        String newCategoryName = "Team1-Design";

        ReusableMethods.wait(1);
        //Enters the category information and click the "Save&Exit" button.
        adminDashboard.textBoxCategoryName.sendKeys(newCategoryName);
        ReusableMethods.wait(1);

        //dropdown secimi
        //WebElement dropDownElement = Driver.getDriver().findElement(By.xpath("//span[@role='combobox']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.dropdownSelectionBlogCategories);

        ReusableMethods.wait(2);
        Select select = new Select(adminDashboard.dropdownSelectionBlogCategories);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin.
        select.selectByValue("1");
        ReusableMethods.wait(2);

        //   adminDashboard.blogCategoriesWriteParent.sendKeys("Villa Design");
        adminDashboard.blogCategorieswriteDescription.sendKeys("Buyuk,guzel,dikdortgen bir havuz");
        ReusableMethods.wait(2);

        //adminDashboard.blogCategoriesPublishedButton.click();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.linkBlogCategoriesSaveExitButton);

        ReusableMethods.wait(2);

        adminDashboard.linkBlogCategoriesSaveExitButton.click();

        // Verify the new Category exists.
        Assert.assertTrue(userDashboard.labelSuccessfullyMessage.isDisplayed());
        Driver.getDriver().navigate().refresh();
        extentTest.pass("It is verfied that new category exists.");

        List<WebElement> categoriesList2 = Driver.getDriver().findElements(By.xpath("//*[@class='fetch-data category-name']"));
        System.out.println("Eklemeden Sonraki List sayisi : " + categoriesList2.size());

        //Click Expand Button if it is not selected
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.buttonBlogCollapseAll);

        ReusableMethods.wait(3);

        String visibleMenuTitle = adminDashboard.buttonBlogCollapseAll.getText();
        System.out.println(visibleMenuTitle);
        if (!visibleMenuTitle.equals("Collapse all")) {
            adminDashboard.buttonBlogCollapseAll.click();
        }

        ReusableMethods.wait(2);

       //To click on the category name we added under the Collapse All Button,we create its xpath dynamically over the text.
        String selectedMenuName = "//*[@class='fetch-data category-name']/span[text()='" + newCategoryName + "']";
        WebElement menuSelect = Driver.getDriver().findElement(By.xpath(selectedMenuName));
        menuSelect.click();
        ReusableMethods.wait(2);
        //Updates category information and click the "Save&Exit" button.
        newCategoryName = "Team1-Design++";
        adminDashboard.textBoxCategoryName.sendKeys("++");

        System.out.println(newCategoryName);
        ReusableMethods.wait(2);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.linkBlogCategoriesSaveExitButton);
        ReusableMethods.wait(2);
        adminDashboard.linkBlogCategoriesSaveExitButton.click();

        Assert.assertTrue(userDashboard.labelSuccessfullyMessage.isDisplayed());
        extentTest.pass("The Category is successfully updated.");

        Driver.getDriver().navigate().refresh();

        //Click on the category he wants to delete.
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", adminDashboard.buttonBlogCollapseAll);

        ReusableMethods.wait(2);

        visibleMenuTitle = adminDashboard.buttonBlogCollapseAll.getText();
        System.out.println(visibleMenuTitle);
        if (!visibleMenuTitle.equals("Collapse all")) {
            adminDashboard.buttonBlogCollapseAll.click();
        }

        // new category Edited name click
        selectedMenuName = "//*[@class='fetch-data category-name']/span[text()='" + newCategoryName + "']";
        menuSelect = Driver.getDriver().findElement(By.xpath(selectedMenuName));
        menuSelect.click();
        ReusableMethods.wait(2);

        //Confirm the category deletion process.
        WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("(//a[@data-bs-original-title='Delete'])[2]"));
        deleteIcon.click();
        userDashboard.buttonDeleteConfirm.click();
        List<WebElement> categoriesList3 = Driver.getDriver().findElements(By.xpath("//*[@class='fetch-data category-name']"));
        System.out.println("Silindikten Sonraki List sayisi : " + categoriesList3.size());

        Assert.assertTrue(userDashboard.labelSuccessfullyMessage.isDisplayed());
        extentTest.pass("The deletion process is succesfully done.");

        Driver.closeDriver();

    }

}
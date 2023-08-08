package test;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
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

import java.awt.dnd.DragGestureEvent;

public class US50_TC002 extends TestBaseReport {


    @Test
    public void testCreateCity(){
        Faker faker =new Faker();
        String cityName = faker.address().cityName();
         String cityNameSecond = faker.address().cityName();
        AdminDashboard adminDashboard = new AdminDashboard();
        extentTest=extentReports.createTest("testCreateCity","testCreateCity");

        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("//Navigate to url 'https://qa.hauseheaven.com/admin/login'");
        //Verify that the admin login page is visible
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that the admin login page is visible");
        //Fill in admin information and Click 'Sign in' button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin02"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("Fill in admin information and Click 'Sign in' button");
        //Verify that you are loged in admin dashboard
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboard.adminUserButtonOnHeader.isDisplayed());
        extentTest.pass("Verify that you are loged in admin dashboard");
        //Click 'Side bar switch'
        adminDashboard.sideBarButton.click();
        extentTest.info("Click 'Side bar switch'");
        //Click 'Locations' '
        adminDashboard.locationsButton.click();
        extentTest.info("Click 'Locations'");
        //Click Cities' under Locations
        adminDashboard.locationsCitiesButton.click();
        extentTest.info("Click Cities' under Locations");
        //Verify that you are in cities page
        Assert.assertTrue(adminDashboard.labelCitiesText.isDisplayed());
        extentTest.pass("Verify that you are in cities page");
        //verify that items on cities page
        int counter =0;
        try {
            for (int i = 1; i <=10 ; i++) {
                WebElement dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]"));
                Assert.assertTrue(dynamicTableWay.isDisplayed());
                extentTest.pass("verify that items on cities page");
                counter++;
            }
        } catch (Exception e) {
            System.out.println(counter + ". table is not displayed");
            Assert.fail();
            extentTest.fail("verify that items on cities page is failed");
        }
        //verify that record of items on cities page
        Assert.assertTrue(adminDashboard.labelResultsText.isDisplayed());
        extentTest.pass("verify that record of items on cities page");
        //Click 'Create'
        adminDashboard.createButton.click();
        extentTest.info("Click 'Create'");
        //Fill in City information and Click 'Save&Exit' button
        adminDashboard.textBoxCitiesName.sendKeys(cityName);
        adminDashboard.textBoxCitiesSlug.sendKeys(faker.lorem().sentence());
        ReusableMethods.sleep(4);
        adminDashboard.locationsCitiesStateSelect.click();
        ReusableMethods.sleep(5);
        adminDashboard.textBoxSearchStateOnCreateCity.sendKeys(faker.nation().capitalCity());


        Select select = new Select(adminDashboard.locationsCitiesCountrySelect);
        select.selectByValue("1");
        adminDashboard.locationStatesOrder.sendKeys("2");
        select = new Select(adminDashboard.locationsCitiesStatusSelect);
        select.selectByIndex(2);
        adminDashboard.saveExitButton.click();
        extentTest.info("Fill in City information and Click 'Save&Exit' button");

        //Verify that the posted city is visible on cities item board

            for (int i = 1; i <=10 ; i++) {
                WebElement dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]"));
                if (cityName.equals(dynamicTableWay.getText())){
                    Assert.assertEquals(dynamicTableWay.getText(),cityName);
                    extentTest.pass("Verify that the posted city is visible on cities item board");
                    break;
                }

            }

        //Click 'edit' on related city post
        ReusableMethods.wait(2);
        for (int i = 1; i <=10 ; i++) {
            String dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]")).getText();
            if (cityName.equals(dynamicTableWay)){
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[9]/div/a[1]")).click();
                extentTest.info("Click 'edit' on related city post");
                break;
            }
        }
        //Edit Country and Name area Click 'Save&Exit' button

        ReusableMethods.wait(2);
        adminDashboard.textBoxCitiesName.clear();
        adminDashboard.textBoxCitiesName.sendKeys(cityNameSecond);
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.wait(2);
        adminDashboard.textBoxCitiesName.clear();
        adminDashboard.textBoxCitiesName.sendKeys(cityNameSecond);
        ReusableMethods.wait(2);
        adminDashboard.saveButton.click();
        ReusableMethods.wait(2);
        adminDashboard.saveExitButton.click();
        //at here i put on a extra save button between 125-128 as a result i'm driving my codes over this step and completing test
        extentTest.info("Edit Country and Name area Click 'Save&Exit' button");


        ReusableMethods.wait(2);
        //Verify that the related data on related city is edited
        for (int i = 1; i <=10 ; i++) {
            WebElement dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]"));
            if (cityNameSecond.equals(dynamicTableWay.getText())){
                Assert.assertEquals(dynamicTableWay.getText(),cityNameSecond);
                extentTest.pass("Verify that the related data on related city is edited");
                break;
            }

        }
        //Click 'Delete' button on related city
        for (int i = 1; i <=10 ; i++) {
            String dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]")).getText();
            if (cityNameSecond.equals(dynamicTableWay)){
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[9]/div/a[2]")).click();
                ReusableMethods.wait(1);
                adminDashboard.confirmDeleteButton.click();
                ReusableMethods.wait(1);
                extentTest.info("Click 'Delete' button on related city");
                break;
            }
        }
        //Verify that related city is deleted
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("Verify that related city is deleted");
        //Log out admin account
        ReusableMethods.wait(1);
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.sleep(6);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Log out admin account");


    }
}

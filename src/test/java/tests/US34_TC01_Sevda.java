package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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


public class US34_TC01_Sevda extends TestBaseReport {


    @Test
    public void test001(){
        AdminDashboard  adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Verify that buttons are visible" , "Admin must able to use Real Estate on dashboard");
        //1. Navigate to "qa.hauseheaven.com/admin/login".
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to 'qa.hauseheaven.com/admin/login'.");

        ReusableMethods.wait(1);
        //2.Verify that you're logged in as a admin
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that you're logged in as a admin");
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin03"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("");

        ReusableMethods.wait(1);
        //3.Click side bar button on the left of the page
        adminDashboard.sideBarButton.click();
        extentTest.info("Click side bar button on the left of the page");

        ReusableMethods.wait(1);
        //4. Click 'Real Estate' button in the side bar
        adminDashboard.realEstateButton.click();
        extentTest.info("Click 'Real Estate' button in the side bar");

        ReusableMethods.sleep(2);
        //5. Verify That 'Real Estate' button is clickable
        Assert.assertTrue(adminDashboard.realEstateButton.isEnabled());
        extentTest.pass("Verify That 'Real Estate' button is clickable");

        ReusableMethods.wait(1);
        //6.Verify that the buttons under 'Real Estate' is visible
        Assert.assertTrue(adminDashboard.realEstatePropertiesButton.isDisplayed());
        ReusableMethods.sleep(1);
        Assert.assertTrue(adminDashboard.realEstateFacilityButton.isDisplayed());
        ReusableMethods.sleep(1);
        Assert.assertTrue(adminDashboard.realEstateFeatureButton.isDisplayed());
        ReusableMethods.sleep(1);
        Assert.assertTrue(adminDashboard.realEstateCategoryButton.isDisplayed());
        ReusableMethods.sleep(1);
        Assert.assertTrue(adminDashboard.realEstateTypeButton.isDisplayed());
        ReusableMethods.sleep(1);
        extentTest.pass("Verify that the buttons under 'Real Estate' is visible");

        //7. Click log out
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.sleep(2);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Log out admin account");


    }

    @Test
    public void test002(){

        AdminDashboard  adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Verify that properties is reachable" , "Admin must able to reach properties on dashboard");
        //1. Navigate to "qa.hauseheaven.com/admin/login".
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to 'qa.hauseheaven.com/admin/login'.");

        ReusableMethods.wait(1);
        //2.Verify that you're logged in as a admin
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that you're logged in as a admin");
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin03"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("");

        ReusableMethods.wait(1);
        //3.Click side bar button on the left of the page
        adminDashboard.sideBarButton.click();
        extentTest.info("Click side bar button on the left of the page");

        ReusableMethods.wait(1);
        //4. Click 'Real Estate' button in the side bar
        adminDashboard.realEstateButton.click();
        extentTest.info("Click 'Real Estate' button in the side bar");

        ReusableMethods.sleep(2);
        //5.Click 'Proerties' button
        adminDashboard.realEstatePropertiesButton.click();
        extentTest.info("Click 'Proerties' button");

        ReusableMethods.wait(1);
        //6.Verify that admin is in 'Properties' page
        Assert.assertTrue(adminDashboard.propertiesCreateButton.isDisplayed());
        extentTest.pass("Verify that admin is in 'Properties' page");


        //7. Click log out
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.sleep(2);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Log out admin account");

        ReusableMethods.wait(1);
        // 8.Verify that admin is in 'log in' page
        Assert.assertTrue(adminDashboard.textBoxAdminPassword.isDisplayed());
        extentTest.pass("Verify that admin is in 'log in' page");



    }

    @Test
    public void test003(){

        AdminDashboard  adminDashboard = new AdminDashboard();

        extentTest = extentReports.createTest("Verify that properties is reachable" , "Admin must able to reach properties on dashboard");
        //1. Navigate to "qa.hauseheaven.com/admin/login".
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to 'qa.hauseheaven.com/admin/login'.");

        ReusableMethods.wait(1);
        //2.Verify that you're logged in as a admin
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that you're logged in as a admin");
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin03"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("");

        ReusableMethods.wait(1);
        //3.Click side bar button on the left of the page
        adminDashboard.sideBarButton.click();
        extentTest.info("Click side bar button on the left of the page");

        ReusableMethods.wait(1);
        //4. Click 'Real Estate' button in the side bar
        adminDashboard.realEstateButton.click();
        extentTest.info("Click 'Real Estate' button in the side bar");

        ReusableMethods.sleep(2);
        //5.Click 'Proerties' button
        adminDashboard.realEstatePropertiesButton.click();
        extentTest.info("Click 'Proerties' button");

        ReusableMethods.wait(1);
        //6.Verify that ads of page are seesable
        int counter =0;
        WebElement dynamicTableWay ;
        try {
            for (int i = 1; i <=10 ; i++) {
                dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[4]/a"));
                Assert.assertTrue(dynamicTableWay.isDisplayed());
                extentTest.pass("verify that items on cities page");
                counter++;
            }
        } catch (Exception e) {
            System.out.println(counter + ". table is not displayed");
            Assert.fail();
            extentTest.fail("verify that items on cities page is failed");
        }

        ReusableMethods.wait(1);
        //7. verify that records of page are visible
        Assert.assertTrue(adminDashboard.labelResultsText.isDisplayed());
        extentTest.pass("verify that record of items on cities page");

        ReusableMethods.wait(1);
        //8.Click first ad and Verify that admin is in page
        adminDashboard.firstAdInPropertiesPage.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(adminDashboard.dropDownModerationStatus.isDisplayed());
        extentTest.pass("Click first ad and Verify that admin is in page");


        //9.Click Log out
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.sleep(2);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Log out admin account");



    }

    @Test
    public void test004(){
        Faker faker = new Faker();

        AdminDashboard  adminDashboard = new AdminDashboard();

        UserDashboard userDashboard = new UserDashboard();

        String propertyName = faker.name().title();

        Actions actions = new Actions(Driver.getDriver());

        Select select ;

        extentTest = extentReports.createTest("Verify that properties is reachable" , "Admin must able to reach properties on dashboard");
        //1. Navigate to "qa.hauseheaven.com/admin/login".
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to 'qa.hauseheaven.com/admin/login'.");

        ReusableMethods.wait(1);
        //2.Verify that you're logged in as a admin
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that you're logged in as a admin");
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin03"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("");

        ReusableMethods.wait(1);
        //3.Click side bar button on the left of the page
        adminDashboard.sideBarButton.click();
        extentTest.info("Click side bar button on the left of the page");

        ReusableMethods.wait(1);
        //4. Click 'Real Estate' button in the side bar
        adminDashboard.realEstateButton.click();
        extentTest.info("Click 'Real Estate' button in the side bar");

        ReusableMethods.sleep(2);
        //5.Click 'Proerties' button
        adminDashboard.realEstatePropertiesButton.click();
        extentTest.info("Click 'Proerties' button");

        ReusableMethods.wait(1);
        //6.Click 'Create' button
        adminDashboard.propertiesCreateButton.click();

        ReusableMethods.wait(1);
        //7.Verify that admin is in create of property
        Assert.assertTrue(adminDashboard.dropDownModerationStatus.isDisplayed());
        extentTest.pass("Verify that admin is in create of property");

        ReusableMethods.wait(1);
        //8.Fill information in for create of property
        adminDashboard.textBoxPropertiesTitle.sendKeys(propertyName);
        ReusableMethods.sleep(1);
        adminDashboard.propertiesFeaturedSwitchButton.click();
        ReusableMethods.sleep(1);
        adminDashboard.textBoxPropertiesDescription.sendKeys(faker.lorem().sentence());

        adminDashboard.textBoxpropertiesContentParagraph.sendKeys(faker.lorem().paragraph());
        select = new Select(adminDashboard.propertiesSelectCity);
        select.selectByIndex(2);
        String cityValue= select.getFirstSelectedOption().getText();
       adminDashboard.propertiesLocationInput.sendKeys(faker.address().state());

        ReusableMethods.sleep(100);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        userDashboard.latitudeFromAdressLink.click();
        String hauseHeavenWH = Driver.getDriver().getWindowHandle();
        ReusableMethods.switchToWindowMetin(Driver.getDriver().getWindowHandle());
        ReusableMethods.wait(3);
        userDashboard.cookiesAcceptButtonInLatlong.click();
        userDashboard.textBoxGetLanLong.sendKeys(cityValue);
        userDashboard.getLanLongFindButton.click();
        //if the related website doesnt give me query right then i must able to verify that

        try {
            if (userDashboard.labelDailyQueryLimit.isDisplayed()){

                userDashboard.longLatQueryPageSigninButton.click();
                userDashboard.textBoxLongLatQueryPageEmail.sendKeys(ConfigReader.getProperty("latLongQdataEmail"));
                ReusableMethods.sleep(1000);
                userDashboard.textBoxLongLatQueryPagePassword.sendKeys(ConfigReader.getProperty("latLongQdatePassword"));
                ReusableMethods.sleep(100);
                userDashboard.longLatQueryPageLogginButton.click();
                Driver.getDriver().get(ConfigReader.getProperty("latLongConvertUrl"));
            }
        }catch (RuntimeException e) {
            System.out.println("You have credit for querying lon and lat");
        }
        ReusableMethods.sleep(2000);
        userDashboard.textBoxGetLanLong.sendKeys(cityValue);
        userDashboard.getLanLongFindButton.click();
        String labelLanLongValuestr=userDashboard.labelLanLongValue.getText();
        String[] labelLanLongValueArr = labelLanLongValuestr.split(",");
        Driver.getDriver().switchTo().window(hauseHeavenWH);
        ReusableMethods.sleep(2000);
        userDashboard.latitudeInput.sendKeys(labelLanLongValueArr[0]);
        userDashboard.longitudeInput.sendKeys(labelLanLongValueArr[1]);
        ReusableMethods.sleep(2000);



        userDashboard.numberBedroomInput.sendKeys(ConfigReader.getProperty("bedroom"));
        userDashboard.numberBathroomInput.sendKeys(ConfigReader.getProperty("bathroom"));
        userDashboard.numberFloorInput.sendKeys(ConfigReader.getProperty("numberFloors"));
        userDashboard.squareInput.sendKeys(ConfigReader.getProperty("square"));


        userDashboard.priceInput.sendKeys(ConfigReader.getProperty("priceOfNewHouse"));
        userDashboard.propertyLabelInput.sendKeys(faker.lorem().paragraph());


        select = new Select(userDashboard.selectFacility);
        select.selectByValue("4");
        userDashboard.distanceInput.sendKeys(faker.number().digit());
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);

        userDashboard.addNewButton.click();
        ReusableMethods.sleep(2000);
        userDashboard.xButton.click();
        ReusableMethods.sleep(1000);


        select = new Select(userDashboard.typeSelect);
        select.selectByValue("1");




        userDashboard.wifiSelect.click();
        ReusableMethods.sleep(2000);

        adminDashboard.scrollToTopInPropertyCreate.click();
        ReusableMethods.wait(3);



        //9.Click 'Save&Exit'
        adminDashboard.saveExitButton.click();
        ReusableMethods.wait(3);
        //10. Verify that the ad was created
        for (int i = 1; i <=10 ; i++) {
            WebElement dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[4]"));
            if (propertyName.equals(dynamicTableWay.getText())){
                Assert.assertTrue(dynamicTableWay.isDisplayed());
                break;
            }
        }
        //11. Click 'Deleted' button and verify that the ad is deleted
        for (int i = 1; i <=10 ; i++) {
            WebElement dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[4]"));
            if (propertyName.equals(dynamicTableWay.getText())) {
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[8]/div/a[2]")).click();
                ReusableMethods.wait(1);
                adminDashboard.confirmDeleteButton.click();
                ReusableMethods.wait(1);
                Assert.assertTrue(adminDashboard.labelSuccessfullDelete.isDisplayed());
                break;
            }
        }
    }
}

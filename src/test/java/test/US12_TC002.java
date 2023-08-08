package test;

import com.github.javafaker.BackToTheFuture;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US12_TC002 extends TestBaseReport {

    Faker faker = new Faker();
    String titleName = faker.name().title();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void testCrateEditSearchAndSendMessageOnProperty(){

        UserHomepage userHomepage = new UserHomepage();
        UserDashboard userDashboard = new UserDashboard();
        AdminDashboard adminDashboard  = new AdminDashboard();
        extentTest=extentReports.createTest("testCrateEditSearchAndSendMessageOnProperty","testCrateEditSearchAndSendMessageOnProperty");


        //Write a Property in related agent account
        writeProperty();
        extentTest.info("Write a Property in related agent account");
        //Navigate to url 'https://qa.hauseheaven.com/admin/login'
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Navigate to url 'https://qa.hauseheaven.com/admin/login'");

        //Verify that the admin login page is visible
        Assert.assertTrue(adminDashboard.textBoxAdminUserNameOnLogInPage.isDisplayed());
        extentTest.pass("Verify that the admin login page is visible");
        //Fill in admin information and Click 'Sign in' button
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.radioButtonRememberMe.click();
        adminDashboard.adminLogInButton.click();
        extentTest.info("Fill in admin information and Click 'Sign in' button");
        //Click 'Pending Properties'
        ReusableMethods.wait(1);
        adminDashboard.pendingPropertiesButton.click();
        extentTest.info("Click 'Pending Properties'");
        //Find your aded property and Click on it
        ReusableMethods.wait(2);
        for (int i = 1; i <=10 ; i++) {
            String dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[4]/a")).getText();
            if (titleName.equals(dynamicTableWay)){
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[4]/a")).click();
                break;
            }
        }
        extentTest.info("Find your aded property and Click on it");
        //Change the 'Moderation status' as Approved
        ReusableMethods.wait(3);
        Select select = new Select(adminDashboard.dropDownModerationStatus);
        select.selectByIndex(1);
        adminDashboard.saveExitButton.click();
        ReusableMethods.wait(2);
        extentTest.info("Change the 'Moderation status' as Approved");
        //Verify that 'changed successfully' message is visiable
        Assert.assertTrue(adminDashboard.labelSuccessMessage.isDisplayed());
        extentTest.pass("Verify that 'changed successfully' message is visiable");
        //Verify that 'Moderation status' in properties page was changed as approved
        ReusableMethods.wait(2);
        for (int i = 1; i <=10 ; i++) {
            String dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[4]/a")).getText();
            if (titleName.equals(dynamicTableWay)){
                String expectedValue = ConfigReader.getProperty("approvedText");
                String actualValue = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[6]/span")).getText();
                Assert.assertEquals(actualValue,expectedValue);
                extentTest.pass("Verify that 'Moderation status' in properties page was changed as approved");
                break;
            }
        }
        //Click 'Log out'
        adminDashboard.adminUserButtonOnHeader.click();
        ReusableMethods.sleep(10);
        adminDashboard.adminLogOutButton.click();
        extentTest.info("Click 'Log out'");
        //Navigate to 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Navigate to 'https://qa.hauseheaven.com/'");
        //Click 'Sign in' button and Fill your account information
        userDashboard.headerSignIn.click();
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        extentTest.info("Click 'Sign in' button and Fill your account information");
        ReusableMethods.sleep(10);
        //Verify that your logged in as a agent
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        extentTest.pass("Verify that your logged in as a agent");
        //Click your account name
        userDashboard.headerUserName.click();
        extentTest.info("Click your account name");
        //Click Properties
        userDashboard.properties.click();
        extentTest.info("Click Properties");
        //Click edit on your related property
        ReusableMethods.wait(2);
        for (int i = 1; i <=10 ; i++) {
            String dynamicTableWay = Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]/a")).getText();
            if (titleName.equals(dynamicTableWay)){
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+ i +"]/td[3]/a")).click();
                break;
            }
        }
        extentTest.info("Click edit on your related property");
        //Click Save&Exit
        ReusableMethods.wait(2);
        userDashboard.saveAndExitButton.click();
        extentTest.info("Click Save&Exit");
        //Verify that you got 'updated successfully' message
        ReusableMethods.wait(2);
        Assert.assertTrue(userDashboard.labelUpdatedSuccessfully.isDisplayed());
        extentTest.pass("Verify that you got 'updated successfully' message");
        //Log out agent account and make sure verifying that you are in hauseheaven as a visitor
        userDashboard.headerLogOutButton.click();
        ReusableMethods.sleep(10);
        Assert.assertTrue(userDashboard.headerSignIn.isDisplayed());
        extentTest.pass("Log out agent account and make sure verifying that you are in hauseheaven as a visitor");

        //Click Listing
        ReusableMethods.wait(1);
        userHomepage.linkMenuListing.click();
        extentTest.info("Click Listing");
        //Click 'Investor Research Agent' Text Box
        //Write related property name down in text box and Click Enter
        ReusableMethods.wait(1);
        userHomepage.searchForALocation.click();
        userHomepage.searchForALocation.sendKeys(titleName + Keys.ENTER);
        ReusableMethods.sleep(2);
        extentTest.info("Write related property name down in text box and Click Enter");
        //Verify that it is visible
        //Click 'view' on related post
         actions = new Actions(Driver.getDriver());
         actions.sendKeys(Keys.PAGE_DOWN).perform();
        userHomepage.viewButtonAfterSearchedForListing.click();//check it out
        extentTest.info("Click 'view' on related post");
        ReusableMethods.sleep(2);
        //Fill in neccasery information into contact form on the rigth side of page

        userHomepage.labelListingName.sendKeys(faker.name().firstName());
        userHomepage.labelListingPhone.sendKeys(faker.phoneNumber().cellPhone());
        userHomepage.labelListingEmail.sendKeys(faker.internet().emailAddress());
        userHomepage.labelListingMessage.sendKeys(faker.lorem().paragraph());
         actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        userHomepage.listingSendMessageButton.click();
        extentTest.info("Fill in neccasery information into contact form on the rigth side of page");

        //Click 'Send Message' and verify that 'Send consult successfully!' is visible
        ReusableMethods.sleep(10);
        Assert.assertTrue(userHomepage.sendMessageSuccessfully.isDisplayed());
        extentTest.pass("Click 'Send Message' and verify that 'Send consult successfully!' is visible");
    }

    private void writeProperty() {
        UserHomepage userHomepage = new UserHomepage();
        UserDashboard userDashboard = new UserDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Verify that the home page is visible
        Assert.assertTrue(userHomepage.searchForALocation.isDisplayed());
        //Click Sign in button
        userHomepage.linkSignIn.click();
        //Verify that you are in sign in page
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        //Fill in your acoount information and Click 'Login'
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        //Verify that logged in as a agent
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        //Click 'Add Property' button
        userDashboard.addProperty.click();
        //Verify that if agent needs credit then Click 'Agent name' button and buy credits
        try {
            if (userDashboard.labelAlertMessageForCredit.isDisplayed()){
                userDashboard.userNameVisibleTest.click();
                userDashboard.buyCredits.click();
                ReusableMethods.sleep(4);
                Assert.assertTrue(userDashboard.buyCreditsPageVisible.isDisplayed());
                userDashboard.purchaseButton2.click();
                ReusableMethods.sleep(4);
                userDashboard.cardNumber.sendKeys(ConfigReader.getProperty("creditCarNumver"));
                userDashboard.fullName.sendKeys(ConfigReader.getProperty("creditCartFullName"));
                userDashboard.mMYY.sendKeys(ConfigReader.getProperty("creditCardValidMonthYear"));
                userDashboard.cVC.sendKeys(ConfigReader.getProperty("creditCardCVC"));
                userDashboard.checkOut.click();

                //Verify that your credit greater than '0'
                String yourCreditsText = userDashboard.yourCreditsText.getText();
                String[] yourCreditTextArr=yourCreditsText.split(" ");

                int creditNumber = Integer.parseInt(yourCreditTextArr[2]);

                Assert.assertTrue(creditNumber>0);
                //Click 'Add Property' button and verify that you are in related page
                userDashboard.addProperty.click();
                ReusableMethods.sleep(7);
                Assert.assertTrue(userDashboard.writePropertySaveButton.isEnabled());

            }
        }catch (RuntimeException e){
            System.out.println("You have enough credit for add property");
        }


        //Fill in your property information in boxes


        userDashboard.titleInput.sendKeys(titleName);
        userDashboard.descriptionInput.sendKeys(faker.lorem().sentence());
        userDashboard.contentTextInput.sendKeys(faker.lorem().paragraph());
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //String imgFilePath = "src/test/java/img/house1.jpg";
        //userDashboard.dropImagesInWriteProperty.sendKeys(imgFilePath);

        Select select = new Select(userDashboard.citySelect);
        select.selectByValue(ConfigReader.getProperty("wantedCityIndexForWriteProperty"));
        String cityValue= select.getFirstSelectedOption().getText();
        userDashboard.propertyLocation.sendKeys(faker.address().city());
        userDashboard.allowCookiesButton.click();
        ReusableMethods.sleep(100);
        userDashboard.latitudeFromAdressLink.click();
        String hauseHeavenWH = Driver.getDriver().getWindowHandle();
        ReusableMethods.switchToWindowMetin(Driver.getDriver().getWindowHandle());
        ReusableMethods.sleep(2000);
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



        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        userDashboard.numberBedroomInput.sendKeys(ConfigReader.getProperty("bedroom"));
        userDashboard.numberBathroomInput.sendKeys(ConfigReader.getProperty("bathroom"));
        userDashboard.numberFloorInput.sendKeys(ConfigReader.getProperty("numberFloors"));
        userDashboard.squareInput.sendKeys(ConfigReader.getProperty("square"));


        userDashboard.priceInput.sendKeys(ConfigReader.getProperty("priceOfNewHouse"));
        userDashboard.propertyLabelInput.sendKeys(faker.lorem().paragraph());
        ReusableMethods.sleep(1);
        userDashboard.renewAutomaticallyButton.click();

        select = new Select(userDashboard.selectFacility);
        select.selectByValue("4");
        userDashboard.distanceInput.sendKeys(faker.number().digit());


        userDashboard.addNewButton.click();
        ReusableMethods.sleep(2000);
        userDashboard.xButton.click();
        ReusableMethods.sleep(1000);






        select = new Select(userDashboard.typeSelect);
        select.selectByValue("1");

        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.sleep(100);


        userDashboard.wifiSelect.click();
        ReusableMethods.sleep(2000);


        userDashboard.backToTop.click();

        ReusableMethods.sleep(5000);
        select = new Select(userDashboard.dropDownCategoryinWriteProperty);
        select.selectByValue("2");

        //Click 'Save & Exit'
        userDashboard.saveButton.click();
    }
}

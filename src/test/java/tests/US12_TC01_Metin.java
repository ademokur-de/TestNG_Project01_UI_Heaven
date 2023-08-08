package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US12_TC01_Metin extends TestBaseReport {

    @Test
    public void testCheckYourPropertyAndAddProperty(){
        Faker faker = new Faker();
        String titleName = faker.name().title();
        extentTest=extentReports.createTest("testCheckYourPropertyAndAddProperty","testCheckYourPropertyAndAddProperty");


        UserHomepage userHomepage = new UserHomepage();
        UserDashboard userDashboard = new UserDashboard();
        //Navigate to url 'https://qa.hauseheaven.com/'
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        //Verify that the home page is visible
        Assert.assertTrue(userHomepage.searchForALocation.isDisplayed());
        extentTest.pass("Verify that the home page is visible");
        //Click Sign in button
        userHomepage.linkSignIn.click();
        //Verify that you are in sign in page
        Assert.assertTrue(userDashboard.loginVisibleTest.isDisplayed());
        extentTest.pass("Verify that you are in sign in page");
        //Fill in your acoount information and Click 'Login'
        userDashboard.textBoxEmailUserName.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.textBoxPassword.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.loginButton.click();
        extentTest.info("Fill in your acoount information and Click 'Login'");
        //Verify that logged in as a agent
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        extentTest.pass("Verify that logged in as a agent");
        //Click 'Add Property' button
        userDashboard.addProperty.click();
        extentTest.info("Click 'Add Property' button");
        //Verify that if agent needs credit then Click 'Agent name' button and buy credits
        try {
            if (userDashboard.labelAlertMessageForCredit.isDisplayed()){
                userDashboard.userNameVisibleTest.click();
                userDashboard.buyCredits.click();
                ReusableMethods.sleep(4);
                Assert.assertTrue(userDashboard.buyCreditsPageVisible.isDisplayed());
                extentTest.pass("buyCreditsPageVisible");
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
                extentTest.pass("Verify that your credit greater than '0'");
                //Click 'Add Property' button and verify that you are in related page
                userDashboard.addProperty.click();
                ReusableMethods.sleep(7);
                Assert.assertTrue(userDashboard.writePropertySaveButton.isEnabled());
                extentTest.pass("Click 'Add Property' button and verify that you are in related page");

            }
        }catch (RuntimeException e){
            System.out.println("You have enough credit for add property");
        }
        extentTest.info("//Verify that if agent needs credit then Click 'Agent name' button and buy credits");


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

        extentTest.info("Fill in your property information in boxes");

        //Click 'Save & Exit'
        userDashboard.saveButton.click();
        ReusableMethods.sleep(100);
        userDashboard.properties.click();
        ReusableMethods.sleep(3000);
        extentTest.info("Click 'Save & Exit'");

        //Verify that related property is in 'Properties page'
        String expectedName = userDashboard.nameRecord1.getText();

        String actualName = titleName;

        Assert.assertEquals(actualName,expectedName);
        extentTest.pass("Verify that related property is in 'Properties page'");









    }
}

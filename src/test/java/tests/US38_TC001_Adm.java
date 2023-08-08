package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import java.awt.*;
import java.util.List;

public class US38_TC001_Adm extends TestBaseReport {

    @Test
    public void adminRealEstateTypesMenuTest() {
        //Common Objects
        AdminDashboard adminPage = new AdminDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Actions actions=new Actions(Driver.getDriver());
        String expectedValue="Sale";
        int records;
        String recordsNummer="";

        extentTest=extentReports.createTest("Admin Real Estate Types menu test","It should be possible to go to the Types menu under Real Estate on the admin page.");

        //User goes to admin login page
        //Go to qa.hauseheaven.com/admin/login
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        ReusableMethods.wait(2);

        //Enters valid username and password, presses the login button
        adminPage.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminPage.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPage.adminLogInButton.click();

        ReusableMethods.wait(2);
        //Verifies that you are on the admin page
        Assert.assertTrue(adminPage.labelAccountsText.getText().contains("Dashboard"));

        //Click on Real Estate menu
        adminPage.realEstateButton.click();

        //Click on the Types link that opens under it and go to the Types page.
        adminPage.realEstateTypeButton.click();
        ReusableMethods.wait(1);

        //Verifies that you're on the Types page
        WebElement headerMenuText=Driver.getDriver().findElement(By.xpath("//ol[@class='breadcrumb']"));
        ReusableMethods.wait(1);

        //System.out.println("Sayfa baslik : "+headerMenuText.getText());
        Assert.assertTrue(headerMenuText.getText().contains("Types"));
        extentTest.pass("It was possible to go to the Types menu under Real Estate on the admin page.");

        //Verifies that the number of Types appears
        recordsNummer=adminPage.labelPropertiesRecords.getText();
        records= Integer.parseInt(recordsNummer);
        System.out.println("total records : "+records);
        Assert.assertTrue(records>=0,"number of records verified");
        extentTest.pass("Types records can be displayed : "+records);
        ReusableMethods.webElementFotoCek(Driver.getDriver(),adminPage.tableTypes);


        //Alle records sout:
        List<WebElement> typesRecordsList=Driver.getDriver().findElements(By.xpath("//td[@class=' text-start column-key-name']"));
        System.out.println("Registered Records :\n=====================================");
        for (WebElement each: typesRecordsList
             ) {
            System.out.println(each.getText());
        }
        System.out.println("=====================================");
        //Types verifies that other elements on the page are visible and active
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.editButton);
        ReusableMethods.wait(1);
        Assert.assertTrue(adminPage.editButton.isDisplayed());
        Assert.assertTrue(adminPage.deleteButton.isDisplayed());
        Assert.assertTrue(adminPage.checkboxAdminRealEstateTypesFirstSelect.isDisplayed());
        extentTest.pass("Types and icon links can be displayed");
        ReusableMethods.wait(1);

        //Click on add new types button  // facilitiesCreateFacilitiesButton
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.createButton);
        ReusableMethods.wait(1);
        adminPage.createButton.click();
        ReusableMethods.wait(1);

        //Name - code - slug textbox add value: "aa"
        adminPage.textBoxCategoryName.click();

        actions.sendKeys(expectedValue+Keys.TAB)
                .sendKeys(expectedValue+Keys.TAB)
                .sendKeys(expectedValue+Keys.TAB)
                .sendKeys("1").perform();
        ReusableMethods.wait(1);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.saveExitButton);
        ReusableMethods.wait(1);

        //Save&Exit Button click();
        jsExecutor.executeScript("arguments[0].click();",adminPage.saveExitButton);
        ReusableMethods.wait(1);

        //Verifies that Types have been created  // textAdminRealEstateTypesFirstSelect
        Assert.assertTrue(adminPage.labelSuccessfullDelete.isDisplayed());
        String actualValue=adminPage.textAdminRealEstateTypesFirstSelect.getText();
        recordsNummer=adminPage.labelPropertiesRecords.getText();
        records= Integer.parseInt(recordsNummer);
        System.out.println("Added Value : \""+actualValue+"\" --- total records : "+records);
        ReusableMethods.wait(2);
        Assert.assertEquals(actualValue,expectedValue);
        extentTest.pass("New Type can be added : \""+expectedValue+"\" ## records : "+records);

        expectedValue="Rent";  //edit value

        //Clicks the Types edit button
        adminPage.editButton.click();
        ReusableMethods.wait(1);
        adminPage.textBoxCategoryName.click();
        actions.doubleClick(adminPage.textBoxCategoryName).perform();
        actions.sendKeys(expectedValue+Keys.TAB).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(expectedValue+Keys.TAB).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(expectedValue+Keys.TAB).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys("2").perform();

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.saveExitButton);


        //Save&Exit Button click();
        jsExecutor.executeScript("arguments[0].click();",adminPage.saveExitButton);
        ReusableMethods.wait(2);
        //Edits Types and verifies changes
        String previousValue=actualValue;
        actualValue=adminPage.textAdminRealEstateTypesFirstSelect.getText();
        recordsNummer=adminPage.labelPropertiesRecords.getText();
        records= Integer.parseInt(recordsNummer);
        System.out.println("After Edit Latest Value : \""+actualValue+"\" --- total records : "+records);
        Assert.assertNotEquals(actualValue,previousValue);
        extentTest.pass("Types can be edited : \""+actualValue+"\" ## records : "+records);
        ReusableMethods.wait(2);
        ReusableMethods.webElementFotoCek(Driver.getDriver(),adminPage.tableTypes);

        //Clicks the delete type button, clicks the confirm button and deletes the types
        String beforeDeleteValue = adminPage.textAdminRealEstateTypesFirstSelect.getText();

        try {
            Robot robot = new Robot();
            ReusableMethods.wait(1);
            adminPage.deleteButton.click();
            robot.mouseMove(450,600);
            ReusableMethods.wait(2);
            robot.mouseMove(250,200);
            ReusableMethods.wait(2);
            robot.mouseMove(350,400);
            ReusableMethods.wait(2);
            adminPage.blogPostDeleteConfirmButton.click();
            ReusableMethods.wait(1);

        } catch (Exception e) {
            System.out.println("Something went wrong: Delete Pop Up Not Close");
            WebElement close=Driver.getDriver().findElement(By.xpath("(//button[@class='btn-close'])[1]"));
            close.click();
        }

        //Types verifies deleted
        Assert.assertTrue(adminPage.deleteSuccessfullyText.isDisplayed());
        String afterDeleteValue = adminPage.textAdminRealEstateTypesFirstSelect.getText();
        recordsNummer=adminPage.labelPropertiesRecords.getText();
        records= Integer.parseInt(recordsNummer);
        System.out.println("After Delete Latest Value : \""+afterDeleteValue+"\" --- total records : "+records);
        Assert.assertNotEquals(afterDeleteValue, beforeDeleteValue);
        extentTest.pass("Types can be deleted - ## records : "+records);
        ReusableMethods.wait(2);

        ReusableMethods.webElementFotoCek(Driver.getDriver(),adminPage.tableTypes);


        // Checkbox ile isim degistirme ve silme
        // new Types add
        expectedValue="Deneme";
        adminPage.createButton.click();
        adminPage.textBoxCategoryName.click();
        actions.sendKeys(expectedValue+Keys.TAB)
                .sendKeys(expectedValue+Keys.TAB)
                .sendKeys(expectedValue+Keys.TAB)
                .sendKeys("1").perform();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.saveExitButton);
        ReusableMethods.wait(1);
        jsExecutor.executeScript("arguments[0].click();",adminPage.saveExitButton);

        Assert.assertTrue(adminPage.deleteSuccessfullyText.isDisplayed());
        extentTest.pass("The Type was successfully added : \""+expectedValue+"\" with \"Bulk Actions Menu\"");

        //Name edit with Bulk action menu
        //Clicks the first Types checkbox
        Driver.getDriver().navigate().refresh();
        ReusableMethods.wait(1);
        adminPage.checkboxAdminRealEstateTypesFirstSelect.click();
        ReusableMethods.wait(1);

        actions.moveToElement(adminPage.buttonTypesBulkActionSelection).click().perform();

        //jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.buttonTypesNameEditJs);
        ReusableMethods.wait(1);

        actions.moveToElement(adminPage.buttonTypesBulkActionRight).perform();
        ReusableMethods.wait(1);

        actions.click(adminPage.buttonTypesBulkActionNameMenu).perform();
        previousValue=expectedValue;
        expectedValue="Deneme Edited";
        ReusableMethods.wait(1);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",adminPage.textBoxAlertCategoryValue);
        ReusableMethods.wait(1);
        actions.click(adminPage.textBoxAlertCategoryValue).perform();
        adminPage.textBoxAlertCategoryValue.sendKeys(expectedValue);
        ReusableMethods.wait(1);
        adminPage.buttonTypesNameEditSubmit.click();
        ReusableMethods.wait(1);
        //Edits Types and verifies changes
        Assert.assertTrue(adminPage.deleteSuccessfullyText.isDisplayed());
        actualValue=adminPage.textAdminRealEstateTypesFirstSelect.getText();
        Assert.assertNotEquals(actualValue,previousValue);
        extentTest.pass("The Type was successfully edited : \""+expectedValue+"\" with \"Bulk Actions Menu\"");

        //delete Tpyes with menu

        adminPage.checkboxAdminRealEstateTypesFirstSelect.click();
        ReusableMethods.wait(1);
        adminPage.buttonTypesBulkActionSelection.click();
        ReusableMethods.wait(1);

        WebElement deleteMenu=Driver.getDriver().findElement(By.xpath("//a[@class='delete-many-entry-trigger']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",deleteMenu);
        ReusableMethods.wait(1);
        actions.click(deleteMenu).perform();
        ReusableMethods.wait(1);
        adminPage.buttonDeleteConfirmWithCheckBox.click();

        Assert.assertTrue(adminPage.deleteSuccessfullyText.isDisplayed());
        extentTest.pass("Types can be deleted  with \"Bulk Actions Menu\"");

        ReusableMethods.wait(1);

        //closes the page
        Driver.quitDriver();
    }

}

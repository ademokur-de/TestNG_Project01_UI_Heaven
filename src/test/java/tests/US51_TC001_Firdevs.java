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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class US51_TC001_Firdevs extends TestBaseReport{


    @Test
    public void test01() {
        extentTest=extentReports.createTest("Admin Dashboard Media Page Test","Admin should be able to access the media Page and verify that the files and the images from the internet have been uploaded,a new folder has been opened,the files have been filtered and the display section has been changed.");

        AdminDashboard adminDashboard = new AdminDashboard();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());

        //Admin logs to the system with its user name and password.
        //The user logins to "https://qa.hauseheaven.com/admin/login" page.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        ReusableMethods.wait(2);
        //Admin logs to the system with its user name and password.
        adminDashboard.textBoxAdminUserNameOnLogInPage.sendKeys(ConfigReader.getProperty("admin01"));
        adminDashboard.textBoxAdminPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminDashboard.adminLogInButton.click();

        extentTest.info("Admin accesses the Admin page");

        //It is successfully directed to Dashboard.
        Assert.assertTrue(adminDashboard.adminDasboardButton.isDisplayed());
        extentTest.pass("It is verified that Media Page is displayed.");

        //It accesses the "Media" page via menu or l
        // Links on the page.
        adminDashboard.mediaLinkButton.click();

        //It successfully accesses the "Media" page.
        Assert.assertTrue(adminDashboard.mediaLinkButton.isEnabled());
        extentTest.pass("It is verified that the Media page has been accessed.");

        ReusableMethods.wait(3);
        // team1 directory select
        actions.doubleClick(adminDashboard.team1DirectoryMedia_Firdevs).perform();

        //Make the "File" path dynamic.
        String filesPath = System.getProperty("user.dir") + "\\src\\test\\java\\img\\hause.jpg";

        //Verify the file exists
        Assert.assertTrue(Files.exists(Paths.get(filesPath)));
        extentTest.pass("It is verifies that the file exists.");
        WebElement uploadProcess = Driver.getDriver().findElement(By.xpath("//*[@type='file']"));

        ReusableMethods.wait(3);

        // File Uploading
        uploadProcess.sendKeys(filesPath);

        ReusableMethods.wait(3);

        // the locate of "File uploaded" message
        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.xpath("//span[text()='hause.jpg']"));

        // Verify the File is uploaded
        Assert.assertTrue(fileUploadedMessage.isDisplayed());
        extentTest.pass("It is verified that the file has been successfully uploaded.");

        // page refresh
        Driver.getDriver().navigate().refresh();

        // Click Download for internet upload
        WebElement buttonDownload = Driver.getDriver().findElement(By.xpath("//*[@class='btn btn-success js-download-action']"));
        buttonDownload.click();

        //file path on internet and Enter
        WebElement textareaDownload = Driver.getDriver().findElement(By.xpath("//*[@name='urls']"));
        textareaDownload.click();
        actions.sendKeys(textareaDownload, "https://qa.hauseheaven.com/storage/team1.png").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethods.wait(3);
        // Verify the File is uploaded
        Assert.assertTrue(adminDashboard.labelBlogPostDeleteConfirm.isDisplayed());
        extentTest.pass("It is verified that the file has been successfully uploaded");

        // ReusableMethods.wait(2);
        //Click the "Create New Folder" button.
        adminDashboard.creatfolderButton.click();

        ReusableMethods.wait(3);

        //The folder entered the name and completes the creation process.
        WebElement folderNameInputTextbox = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Folder name']"));
        actions.sendKeys(folderNameInputTextbox, "Erasable").sendKeys(Keys.ENTER).perform();

        ReusableMethods.wait(3);
        //Verify new Folder succesfully
        Assert.assertTrue(adminDashboard.labelBlogPostDeleteConfirm.isDisplayed());
        extentTest.pass("It is verified that new folder is displayed.");

        // page refresh
        Driver.getDriver().navigate().refresh();

        // Select Filter menu
        adminDashboard.buttonMediaFilter_Firdevs.click();

        //Selects one of the filtration options.(images)
        adminDashboard.buttonMediaImages_Firdevs.click();

        ReusableMethods.wait(3);
        // images List
        List<WebElement> imagesList = Driver.getDriver().findElements(By.xpath("(//li[@data-context='file']/div/div/img)"));
        List<WebElement> videosList = Driver.getDriver().findElements(By.xpath("//*[@class='far fa-file-video']"));
        List<WebElement> dokumentsList = Driver.getDriver().findElements(By.xpath("//*[@class='far fa-file-alt']"));

        System.out.println("==============================");
        System.out.println("== Image === Video === Document ==");

        System.out.print("    " + imagesList.size());
        System.out.print("         " + videosList.size());
        System.out.print("           " + dokumentsList.size() + "\n");

        Assert.assertTrue(imagesList.size() > 0);
        Assert.assertFalse(videosList.size() > 0);
        Assert.assertFalse(dokumentsList.size() > 0);
        extentTest.pass("It is verified which option has been selected among the filtration options.");

        // Select Filter menu
        adminDashboard.buttonMediaFilter_Firdevs.click();

        //Selects one of the filtration options.(videos)
        adminDashboard.buttonMediaVideos_Firdevs.click();

        ReusableMethods.wait(2);

        List<WebElement> imagesList2 = Driver.getDriver().findElements(By.xpath("(//li[@data-context='file']/div/div/img)"));
        List<WebElement> videosList2 = Driver.getDriver().findElements(By.xpath("//*[@class='far fa-file-video']"));
        List<WebElement> dokumentsList2 = Driver.getDriver().findElements(By.xpath("//*[@class='far fa-file-alt']"));
        System.out.print("    " + imagesList2.size());
        System.out.print("         " + videosList2.size());
        System.out.print("           " + dokumentsList2.size() + "\n");

        Assert.assertFalse(imagesList2.size() > 0);
        Assert.assertTrue(videosList2.size() > 0);
        Assert.assertFalse(dokumentsList2.size() > 0);
        extentTest.pass("It is verified which option has been selected among the filtration options.");

        // Select Filter menu
        adminDashboard.buttonMediaFilter_Firdevs.click();

        //Selects one of the filtration options.(docs)
        adminDashboard.buttonMediaDocs_Firdevs.click();

        List<WebElement> imagesList3 = Driver.getDriver().findElements(By.xpath("(//li[@data-context='file']/div/div/img)"));
        List<WebElement> videosList3 = Driver.getDriver().findElements(By.xpath("//*[@class='far fa-file-video']"));
        List<WebElement> dokumentsList3 = Driver.getDriver().findElements(By.xpath("//*[@class='far fa-file-alt']"));
        System.out.print("    " + imagesList3.size());
        System.out.print("         " + videosList3.size());
        System.out.print("           " + dokumentsList3.size() + "\n==============================");


        Assert.assertFalse(imagesList3.size() > 0);
        Assert.assertFalse(videosList3.size() > 0);
        Assert.assertTrue(dokumentsList3.size() > 0);
        extentTest.pass("It is verified which option has been selected among the filtration options.");

        //Files matching the selected filter are displayed successfully.
        Driver.getDriver().navigate().refresh();

        //He selects one of the options to change the displayed section.
        adminDashboard.buttonMediaView_Firdevs.click();

        ReusableMethods.wait(2);
        adminDashboard.buttonMediaTrash_Firdevs.click();
        ReusableMethods.wait(2);
        //The displayed section is successfully modified and the corresponding files are displayed.
        Assert.assertTrue(adminDashboard.iconMediaTrash_Firdevs.isDisplayed());
        extentTest.pass("It is verified that the displayed section has been successfully modified and the filters are displayed.");

        Driver.closeDriver();
    }
}

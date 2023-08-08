package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.UserHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_019_SI extends TestBaseReport {
    // US019
    // Kayıtlı kullanıcı olarak Home page sayfasının footer bölümündeki öğelerin ve
    // fonksiyonların görünür ve
    // aktif olduğunu görüntüleyebildiğimi doğrulayabilmeliyim





    @Test
    public void test01() throws InterruptedException {

    extentTest = extentReports.createTest("Home Page footer View and activate test", "Check that the test works correctly");



// User olarak giris yapiyoruz ------------------------------------------------------
        UserHomepage userHomepage = new UserHomepage();

        //The user logins to "https://qa.hauseheaven.com/admin/login" page.

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userHomepage.linkSignIn.click();

        //Allow Cookies
        if (userHomepage.cookiesAllowButton.isDisplayed()) {
            userHomepage.cookiesAllowButton.click();
        }

        // Enter username, password and login click
        UserDashboard userDashboard = new UserDashboard();

        userDashboard.nameUsername.sendKeys(ConfigReader.getProperty("userName"));
        userDashboard.password.sendKeys(ConfigReader.getProperty("userPassword"));
        userDashboard.login.click();

        //Verify successful login by checking for username name in the header
        Assert.assertTrue(userDashboard.headerUserName.isDisplayed());
        extentTest.pass("Verify successful login by checking for username name in the header");

        // Go to down 600pixel
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // Sayfayı 600 piksel aşağı kaydırın.
        // Sayfanın aşağı doğru 600 piksel kaydırmasını sağlar.
        js.executeScript("window.scrollBy(0, 600);");
//----------------------------------------------------------------------------------

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.sleep(100);

//-----------------------------------------------------------------------------------

        Assert.assertTrue(userDashboard.footerContactInformation.isDisplayed());

        Assert.assertTrue(userDashboard.footerAboutText.isDisplayed());
        Assert.assertTrue(userDashboard.footerAboutUs.isDisplayed());
        Assert.assertTrue(userDashboard.footerContacUs.isDisplayed());
        Assert.assertTrue(userDashboard.contactEmail.isDisplayed());
        Assert.assertTrue(userDashboard.moreInformationText.isDisplayed());
        Assert.assertTrue(userDashboard.termsAndConditionsVisible.isDisplayed());
        Assert.assertTrue(userDashboard.moreInformationText.isDisplayed());
        Assert.assertTrue(userDashboard.allProperties.isDisplayed());

        Assert.assertTrue(userDashboard.houseForSaleText.isDisplayed());

        Assert.assertTrue(userDashboard.houseForRentListVisible.isDisplayed());

        js.executeScript("window.scrollBy(0, 500);");

        Assert.assertTrue(userDashboard.newsTextVisible.isDisplayed());
        Assert.assertTrue(userDashboard.firstNewsPage.isDisplayed());
        Assert.assertTrue(userDashboard.secondNewsPage.isDisplayed());
        Assert.assertTrue(userDashboard.thirdNewsPage.isDisplayed());
        Assert.assertTrue(userDashboard.fourthNewsPage.isDisplayed());
        Assert.assertTrue(userDashboard.fifthNewsPage.isDisplayed());
        extentTest.pass("Verify The information in the footer section of the Homepage is visible and verified to be active");


        Driver.closeDriver();
    }
}


    /*
    @FindBy(xpath = "//div[@class='col-lg-3 col-md-4']")
    public WebElement footerContactInformation;
    @FindBy(xpath = "//h4[text()='About']")
    public WebElement footerAboutText;
    @FindBy(xpath = "//span[text()='About us']")
    public WebElement footerAboutUs;
    @FindBy(xpath = "//span[text()='Contact us']")
    public WebElement footerContacUs;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement contactName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement contactEmail;
    @FindBy(xpath = "//input[@name='subject']")
    public WebElement contactSubject;
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement contactPhone;
    @FindBy(xpath = "//input[@name='content']")
    public WebElement contactContent;
    @FindBy(xpath = "//button[text()='Send message']")
    public WebElement contactSendMessageButton;
    @FindBy(xpath = "//div[@class='address']")
    public WebElement adressOnMap;
    @FindBy(xpath = "//div[@class='contact-info']")
    public WebElement contactInfoOnContacPage;
    @FindBy(xpath = "//span[text()='Terms & Conditions']")
    public WebElement termsAndConditions;
    @FindBy(xpath = "(//div[@class='container'])[4]")
    public WebElement termsAndConditionsVisible;
    @FindBy(xpath = "//h4[text()='MORE INFORMATION']")
    public WebElement moreInformationText;
    @FindBy(xpath = "//span[text()='All properties']")
    public WebElement allProperties;
    @FindBy(xpath = "//input[@id='cp-sale']")
    public WebElement forSaleRadioButton;
    @FindBy(xpath = "//input[@id='cp-rent']")
    public WebElement forRentRadioButton;
    @FindBy(xpath = "//input[@id='cp-hsd']")
    public WebElement okRadioButton;
    @FindBy(xpath = "//input[@placeholder='Search for a location']")
    public WebElement propertiesSearchForLocation;
    @FindBy(xpath = "//button[text()='Search']")
    public WebElement propertiesSearchButton;
    @FindBy(xpath = "//h4[@class='m-0']")
    public WebElement houseForSaleSearchResults;
    @FindBy(xpath = "//div[@class='col-lg-12 col-md-12 list-layout']")
    public WebElement houseForSaleListVisible;
    @FindBy(xpath = "//div[@class='container']")
    public WebElement houseForRentListVisible;
    @FindBy(xpath = "//h4[@class='m-0']")
    public WebElement houseForRentSearchResults;
    @FindBy(xpath = "//span[@id='select2-sort_by-container']")
    public WebElement sortBy;
    @FindBy(xpath = "//i[@class='ti-layout-grid2']")
    public WebElement grid1;
    @FindBy(xpath = "//i[@class='ti-view-list']")
    public WebElement grid2;
    @FindBy(xpath = "//h4[text()='NEWS']")
    public WebElement newsTextVisible;
    @FindBy(xpath = "//span[text()='The Benefits Of Investing In Emerging Real Estate Markets']")
    public WebElement firstNews;
    @FindBy(xpath = "//div[@id='app']")
    public WebElement firstNewsPage;
    @FindBy(xpath = "//span[text()='//span[text()='A Guide To Negotiating The Best Deal On Your Dream Home']']")
    public WebElement secondNews;
    @FindBy(xpath = "//div[@id='app']")
    public WebElement secondNewsPage;
    @FindBy(xpath = "//span[text()='The Rise Of Sustainable Homes: Building For A Greener Future']")
    public WebElement thirdNews;
    @FindBy(xpath = "//div[@id='app']")
    public WebElement thirdNewsPage;
    @FindBy(xpath = "//span[text()='How to Stage Your Home for a Quick and Profitable Sale']")
    public WebElement fourthNews;
    @FindBy(xpath = "//div[@id='app']")
    public WebElement fourthNewsPage;
    @FindBy(xpath = "//span[text()='Investing in Vacation Rental Properties: A Lucrative Opportunity']")
    public WebElement fifthNews;
    @FindBy(xpath = "//div[@id='app']")
    public WebElement fifthNewsPage;
    @FindBy(xpath = "//*[text()='Download Apps']")
    public WebElement downloadAppsText;
    @FindBy(xpath = "(//*[@class='os-app-caps'])[1]")
    public WebElement googlePlay;
    @FindBy(xpath = "(//*[@class='os-app-caps'])[2]")
    public WebElement appStore;
    @FindBy(xpath = "//span[text()='Subscribe']")
    public WebElement subscribeText;
    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    public WebElement enterYourEmail;
    @FindBy(xpath = "//button[text()='Subscribe']")
    public WebElement subscribeButton;



        */








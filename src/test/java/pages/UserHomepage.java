package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserHomepage {
    //-Sevda -Adem -Veysel
    public UserHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //ON NAVBAR
    // User Homepage Logo icon
    @FindBy(xpath="//img[@class='logo']")
    public WebElement logoHome;


    // User Homepage Home link
    @FindBy(xpath="(//li[@class])[1]")
    public WebElement linkMenuHome;


    // User Homepage Listing link
    @FindBy(xpath="(//li[@class])[2]/a")
    public WebElement linkMenuListing;


    // User Homepage Projects link
    @FindBy(xpath="(//li[@class])[3]")
    public WebElement linkMenuProjects;


    // User Homepage Agents link
    @FindBy(xpath="(//li[@class])[4]")
    public WebElement linkMenuAgents;


    // User Homepage Blog link
    @FindBy(xpath="(//li[@class])[5]")
    public WebElement linkMenuBlog;


    // User Homepage Contact link
    @FindBy(xpath="(//li[@class])[6]")
    public WebElement linkMenuContact;


    // User Homepage Sign Up link
    @FindBy(xpath="(//li[@class])[7]")
    public WebElement linkMenuSingUp;


    // User Homepage Add Property link
    @FindBy(xpath="//a[@class='text-success']")
    public WebElement linkAddProperty;


    // User Homepage Sign In link
    @FindBy(xpath="(//li[@class])[8]")
    public WebElement linkSignIn;


    // User Homepage Wishlist link
    @FindBy(xpath="//*[@class='text-white']")
    public WebElement linkWishlist;


//ON FOOTER


    //User Homepage Footer
    @FindBy(xpath= "//*[@class='py-5']")
    public WebElement completeFooter;


    //User Homepage Footer “About us” button
    @FindBy(xpath= "//*[text()='About us']")
    public WebElement aboutUsButtonInFooter;


    //User Homepage Footer “Contact us” button
    @FindBy(xpath= "//*[text()='Contact us']")
    public WebElement contactUsButtonInFooter;


    //User Homepage Footer “Terms & Conditions” button
    @FindBy(xpath= "//*[text()='Terms & Conditions']")
    public WebElement TermsAndConditionsButtonInFooter;


    //User Homepage Footer “All properties” button
    @FindBy(xpath= "//*[text()='All properties']")
    public WebElement allPropertiesButtonInFooter;


    //User Homepage Footer “Houses for sale” button
    @FindBy(xpath= "//*[text()='Houses for sale']")
    public WebElement housesForSaleButtonInFooter;


    //User Homepage Footer “Houses for rent” button
    @FindBy(xpath= "//*[text()='Houses for rent']")
    public WebElement housesForRentButtonInFooter;


    //User Homepage Footer 1. News button
    @FindBy(xpath= "//*[text()='The Benefits Of Investing In Emerging Real Estate Markets']")
    public WebElement newsOneButtonInFooter;


    //User Homepage Footer 2. News button
    @FindBy(xpath= "//*[text()='A Guide To Negotiating The Best Deal On Your Dream Home']")
    public WebElement newsTwoButtonInFooter;


    //User Homepage Footer 3. News button
    @FindBy(xpath= "//*[text()='The Rise Of Sustainable Homes: Building For A Greener Future']")
    public WebElement newsThreeButtonInFooter;


    //User Homepage Footer 4. News button
    @FindBy(xpath= "//*[text()='How to Stage Your Home for a Quick and Profitable Sale']")
    public WebElement newsFourButtonInFooter;


    //User Homepage Footer 5. News button
    @FindBy(xpath= "//*[text()='Investing in Vacation Rental Properties: A Lucrative Opportunity']")
    public WebElement newsFiveButtonInFooter;


    //User Homepage Footer google play button
    @FindBy(xpath= "(//a[@class='other-store-link'])[1]") // app ile tiklanmiyor!! -- Adem
    public WebElement googlePlayIconInFooter;


    //User Homepage Footer apple store button
    @FindBy(xpath= "(//a[@class='other-store-link'])[9]") // app ile tiklanmiyor!! -- Adem
    public WebElement appleStoreIconInFooter;


//IN HOME PAGE


    //User Home Page Search Location
    @FindBy(xpath="//input[@class='form-control']")
    public WebElement searchForALocation;


    //User Home Page Min Price
    @FindBy(xpath="//span[@id='select2-minprice-container']")
    public WebElement dropDownMinPrice;


    //User Home Page Max Price
    @FindBy(xpath="//span[@id='select2-maxprice-container']")
    public WebElement dropDownMaxPrice;


    //User Home Page Property Type
    @FindBy(xpath="//span[@id='select2-ptypes-container']")
    public WebElement dropDownPropertyType;


    //User Home Page Bed Rooms
    @FindBy(xpath="//span[@id='select2-select-bedroom-container']")
    public WebElement dropDownBedRooms;


    //User Home Page Property Location
    @FindBy(xpath="//span[@id='select2-city_id-container']")
    public WebElement dropDownPropertyLocation;


    //User Home Page Search Result Button
    @FindBy(xpath="//button[@class='btn search-btn']")
    public WebElement searchResultButton;


    //User Home Page Search Result Number
    @FindBy(xpath="//h4[@class='m-0']")
    public WebElement bodySearchResultNumber;


//IN LISTING PAGE -A US-005


    //Result Text that appears when you click on the Listing link and Search on the page
    @FindBy(xpath="//h4[@class='m-0']")
    public WebElement labelListingResultText;


    //Link to the first advertisement (Property) on the listing page and when you search
    @FindBy(xpath="(//h4[@class='listing-name'])[1]")
    public WebElement linkFirstProperty;


    //Detail text when you enter the listing page and click on the first ad that comes up when you search
    @FindBy(xpath="(//h4[@class='property_block_title'])[1]")
    public WebElement labelFirstPropertyDetail;


    //Listingpage search textbox
    @FindBy(xpath="//input[@name='k']")
    public WebElement textboxListingSearchLocation;


    //Listingpage Search button
    @FindBy(xpath="(//button[@type='submit'])[1]")
    public WebElement buttonListingSearchSubmit;


//IN LISTING PAGE -B US-006


    //User Listing Page Found Result Number
    @FindBy(xpath="//div[@class='left-column pull-left']")
    public WebElement foundResultListing;


    //User Listing Page 1.Result's View Button
    @FindBy(xpath="(//div[@class='footer-flex'])[1]")
    public WebElement listingViewButton;


    //User Listing Page 1.Result's Share Icon
    @FindBy(xpath="//a[@data-original-title='Share']")
    public WebElement iconListingShare;


    //User Listing Page 1.Result's Facebook Icon
    @FindBy(xpath="//a[@class='cl-facebook']")
    public WebElement iconlistingShareFacebook;


    //User Listing Page 1.Result's Twitter Icon
    @FindBy(xpath="//a[@class='cl-twitter']")
    public WebElement iconlistingShareTwitter;


    //User Listing Page 1.Result's Linked in Icon
    @FindBy(xpath="//a[@class='cl-linkedin']")
    public WebElement iconlistingShareLinkedin;


    //User Listing Page Wish add
    @FindBy(xpath ="//a[@class='btn btn-likes add-to-wishlist']")
    public WebElement listingSaveButonu;


    //User Listing Page Send Message Name
    @FindBy(xpath="//input[@name='name']")
    public WebElement labelListingName;


    //User Listing Page Send Message Phone
    @FindBy(xpath="//input[@name='phone']")
    public WebElement labelListingPhone;


    //User Listing Page Send Message Email
    @FindBy(xpath="//input[@id='email']")
    public WebElement labelListingEmail;


    //User Listing Page Send Message Great House
    @FindBy(xpath="//input[@value='Great House']")
    public WebElement labelListingGreatHause;


    //User Listing Page Send Message Message
    @FindBy(xpath="//textarea[@placeholder='Message']")
    public WebElement labelListingMessage;


    //User Listing Page Send Message Button
    @FindBy(xpath="//button[@class='btn btn-black btn-md rounded full-width']")
    public WebElement listingSendMessageButton;


//IN PROJECTS PAGE


    //Projectspage listelenen projelerin sayisi
    @FindBy(xpath = "//*[@class='left-column']")
    public WebElement numbersOfProjectsProjectsPage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[1]")
    public WebElement projectOneProjectsPage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[2]")
    public WebElement projectTwoProjectsPage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[3]")
    public WebElement projectThreeProjectsPage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[4]")
    public WebElement projectFourProjectsPage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[5]")
    public WebElement projectFiveProjectspage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[6]")
    public WebElement projectSixProjectspage;


    @FindBy(xpath = "(//*[@class='list-img-slide'])[7]")
    public WebElement projectSevenProjectspage;


    //Eighth Project on the Project Page
    @FindBy(xpath = "(//*[@class='list-img-slide'])[8]")
    public WebElement projectEightProjectspage;


    //Ninth Project on the Project Page
    @FindBy(xpath = "(//*[@class='list-img-slide'])[9]")
    public WebElement projectNineProjectspage;


    //Country search Textbox on Projectpage
    @FindBy(xpath = "(//*[@class='selection'])[1]")
    public WebElement countrySearchTextboxOnProjectspage;

    //State search Textbox on Projectpage
    @FindBy(xpath = "(//*[@class='selection'])[2]")
    public WebElement stateSearchTextboxOnProjectspage;

    //City search Textbox on Projectpage
    @FindBy(xpath = "(//*[@class='selection'])[3]")
    public WebElement citySearchTextboxOnProjectspage;

    //Category search Textbox on Projectpage
    @FindBy(xpath = "(//*[@class='selection'])[4]")
    public WebElement categorySearchTextboxOnProjectspage;

    //Search Button on Projectspage
    @FindBy(xpath = "//*[@class='search-action-wrapper']")
    public WebElement searchButtonOnProjectpage;


    // One of a Project, after search USA option on the Projectpage
    @FindBy(xpath = "(//*[@class='foot-location d-flex'])[1]")
    public WebElement oneOfProjectTextboxOnProjectspage;


    // Details of a Project, after search USA option on the Projectpage
    @FindBy(xpath = "//*[@class='prt-detail-title-desc']")
    public WebElement detailsOfProjectTextboxOnProjectspage;


    //IN AGENTS PAGE

    //The first real estate agent link that comes up when you click on the Agents link
    @FindBy(xpath="(//h5[@class='fr-can-name'])[1]")
    public WebElement linkFirstAgent;


    //The first real estate agent (Agent) property number text when clicking on the Agents link
    @FindBy(xpath="(//span[@class='fr-position'])[1]")
    public WebElement labelFirstAgentNumberOfProperties;


    //The first real estate agent contact information text that appears after clicking on the Agents link
    @FindBy(xpath="(//div[@class='fr-grid-info'])[1]")
    public WebElement labelFirstAgentContactInfo;


    //First real estate agent details access button (view) after clicking on the Agents link
    @FindBy(xpath="(//a[@class='prt-view'])[1]")
    public WebElement buttonFirstAgentDetail;


    //Link to listings for sale in the first real estate agent details on the Agents page
    // @FindBy(xpath="//a[@class='nav-link active ']") - Burda prob var onun icin yeni xpath yaptim - Adem
    @FindBy(xpath="(//a[@role='tab'])[2]")  // -- Yeni menu eklendiginde onceki link bozuluyordu bununla degistirdim -- Adem
    public WebElement linkFirstAgentForSale;


    //Agents link to view the details of the first of the for sale listings in the first real estate agent details on the page
    @FindBy(xpath="(//a[@class='prt-view'])[1]")
    public WebElement linkFirstAgentForSaleFirstProperty;


    //Link to rental listings in the first real estate agent details on the Agents page
    // @FindBy(xpath="(//a[@class='nav-link '])[1]") - Burda prob var onun icin yeni xpath yaptim - Adem
    @FindBy(xpath="(//a[@role='tab'])[2]") // -- Yeni menu eklendiginde onceki link bozuluyordu bununla degistirdim -- Adem
    public WebElement linkFirstAgentForRent;


    //Link to view the details of the first of the rental ads in the first real estate agent details on the Agents page
    @FindBy(xpath="(//a[@class='prt-view'])[2]")
    public WebElement linkFirstAgentForRentFirstProperty;


//IN BLOG PAGE


    //User Blog Page Continue Button
    @FindBy(xpath="(//a[@class='bl-continue'])[2]")
    public WebElement BlogMenuContinueButton;


    //User Blog Page Continue-Categories House Design
    @FindBy(xpath="(//a[@class='text-dark'])[1]")
    public WebElement linkBlogMenuCategories;


    //User Blog Page Continue-Categories Latest news
    @FindBy(xpath="(//a[@class='text-dark'])[2]")
    public WebElement linkBlogMenuLatestNews;


    //User Blog Page Continue-Categories House Architecture
    @FindBy(xpath="(//a[@class='text-dark'])[3]")
    public WebElement linkBlogMenuHouseArchitecture;


    //User Blog Page Continue-Categories Building Materials
    @FindBy(xpath="(//a[@class='text-dark'])[4]")
    public WebElement linkBlogMenuBuildingMaterials;


    //User Blog Page Continue-Featured Properties Pine Street
    @FindBy(xpath="(//a[text()='2468 Pine Street'])[1]")
    public WebElement linkBlogFeaturedPropertiesPineStreet;


    //User Blog Page Continue-Featured Properties Elmwood Avenue
    @FindBy(xpath="(//a[text()='13579 Elmwood Avenue'])[1]")
    public WebElement linkBlogFeaturedPropertiesElmwoodAvenue;


    //User Blog Page Continue-Featured Properties Willow Street
    @FindBy(xpath="(//a[text()='13579 Willow Street'])[1]")
    public WebElement linkBlogFeaturedPropertiesWillowStreet;


    //User Blog Page Continue-Featured Properties Oak Avenue
    @FindBy(xpath="(//a[text()='9876 Oak Avenue'])[1]")
    public WebElement linkBlogFeaturedPropertiesOakAvenue;


    //User Blog Page Continue-Featured Properties Pine Street Austin
    @FindBy(xpath="(//a[text()='2468 Pine Street'])[2]")
    public WebElement linkBlogFeaturedPropertiesPineStreetAustin;


    //User Blog Page Continue Share This Post Facebook Button
    @FindBy(xpath="//i[@class='fab fa-facebook-f']")
    public WebElement shareThisPostFacebook;


    //User Blog Page Continue Share This Post Linked in Button
    @FindBy(xpath="//a[@class='cl-linkedin']")
    public WebElement shareThisPostLinkedin;


    //User Blog Page Continue Share This Post Twitter Button
    @FindBy(xpath="//a[@class='cl-twitter']")
    public WebElement shareThisPostTwitter;


//IN CONTACT PAGE


    //Visitor Homepage contact button
    @FindBy(xpath="//*[@class='current-menu-item']")
    public WebElement contactButton;


    //Visitor Homepage contact button in Reach Us address
    @FindBy(xpath="(//div[@class='cn-info-detail'])[1]")
    public WebElement reachUsLabel;


    //Visitor Homepage page contact button in Email address
    @FindBy(xpath="(//div[@class='cn-info-detail'])[2]")
    public WebElement emailLabel;


    //Visitor Homepage page contact button in call Us(phone)
    @FindBy(xpath="(//div[@class='cn-info-detail'])[3]")
    public WebElement phoneLabel;


    //Name textbox in Visitor Homepage dialog button
    @FindBy(xpath="(//input[@class='form-control simple'])[1]")
    public WebElement nameTextBox;


    //Email textbox inside the visitor Homepage contact button
    @FindBy(xpath="(//input[@class='form-control simple'])[2]")
    public WebElement emailTextBox;


    //Subject textbox in visitor Homepage contact button
    @FindBy(xpath="(//input[@class='form-control simple'])[3]")
    public WebElement subjectTextBox;


    //Visitor Homepage page contact button in phone textbox
    @FindBy(xpath="(//input[@class='form-control simple'])[4]")
    public WebElement phoneTextBox;


    //Message textbox inside the visitor Home page contact button
    @FindBy(xpath="//*[@name='content']")
    public WebElement messageTextBox;


    //Send message button inside the contact button of the Visitor Home page
    @FindBy(xpath="//div[@class='form-actions form-group']")
    public WebElement sendMessageButton;


    //Detail text when you enter the listing page and click on the first ad that comes up when you search
    @FindBy(xpath="//*[@class='alert alert-success alert-dismissible']")
    public WebElement sendMessageSuccessfully;


    //Visitor Homepage contact button in map address
    @FindBy(xpath="//div[@class='place-desc-large']")
    public WebElement mapAdresLabel;

    //Cookies Allow button
    @FindBy(xpath="//button[@class='js-cookie-consent-agree cookie-consent__agree']")
    public WebElement cookiesAllowButton;
  
    //bir ust satirda guncel cookies butonu var, ekstra koyulanlari guncelleyelim
    //userDashboard sayfasi icerisinde user log in ve sign up locateleri mevcut guncelleyelim


    //==============yusuf=====================


    //categories list
    @FindBy(xpath="//h2[@class='text-center']")
    public WebElement signUpLoginYazisiyusuf;


    //categories list
    @FindBy(xpath="//body[@class='blue-skin']")
    public WebElement bodyTextyusuf;


    //categories list
    @FindBy(xpath="//div[@class='single-widgets widget_category']")
    public WebElement categoriesListsyusuf;



    //Visitor Homepage projects two properties
    @FindBy(xpath="//*[text()='Related Projects']")
    public WebElement relatedProjectsyusuf;


    //Visitor Homepage projects button
    @FindBy(linkText="https://qa.hauseheaven.com/login")
    public WebElement signUpButtonyusuf;

    // country secimi
    @FindBy(xpath = "//select[@name='country_id']")
    public WebElement ulkesecimiyusuf;


    // state secimi
    @FindBy(xpath = "//select[@name='state_id']")
    public WebElement statesecimiyusuf;

    // state secimi
    @FindBy(xpath = "//select[@name='city_id']")
    public WebElement citysecimiyusuf;

    // state secimi
    @FindBy(xpath = "//select[@name='category_id']")
    public WebElement categorysecimiyusuf;


    @FindBy(xpath = "//button[@class='js-cookie-consent-agree cookie-consent__agree']")
    public WebElement cookiesButtonyusuf;

    @FindBy(xpath = "//h2[@class='ipt-title']")
    public WebElement allProjectsYazisiyusuf;


    @FindBy(xpath = "(//div[@class='property_block_wrap_header'])[3]")
    public WebElement projecttwoDetailFeaturesYazisiyusuf;


    // facebook anasayfa cookies
    @FindBy(xpath = "//div[@aria-labelledby='manage_cookies_title']")
    public WebElement anasayfafacebookcookiesyusuf;


    // facebook anasayfa cookies
    @FindBy(xpath = "//button[@data-cookiebanner='accept_only_essential_button']")
    public WebElement facebookcookiesyusuf;



    @FindBy(xpath = "(//h4[@class='property_block_title'])[3]")
    public WebElement projectthreeDetailFeaturesYazisiyusuf;

    @FindBy(xpath = "//h4[@class='mb-0']")
    public WebElement numberofProjectyusuf;


    @FindBy(xpath = "//h1[@class='ipt-title']")
    public WebElement blogLogoYazisiyusuf;


    @FindBy(xpath = "(//h4[@class='title'])[1]")
    public WebElement categoriesYazisiyusuf;


    @FindBy(xpath = "(//h4[@class='title'])[1]")
    public WebElement relatedPostsYazisiyusuf;

    @FindBy(xpath = "//h4[text()='Featured properties']")
    public WebElement featuredPropertiesYazisiyusuf;


    @FindBy(xpath = "//button[@data-cookiebanner='accept_only_essential_button']")
    public WebElement cookies2Buttonyusuf;

    @FindBy(xpath = "//*[@class='add-listing']")
    public WebElement signInButtonyusuf;


    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBoxyusuf;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBoxyusuf;


    @FindBy(xpath = "(//div[@class='form-group'])[3]")
    public WebElement loginButtonyusuf;



    @FindBy(xpath = "//div[@class='hero-search']")
    public WebElement findAccessibleYaziyusuf;


    @FindBy(xpath = "//h1[@class='ipt-title']")
    public WebElement propertiesYaziyusuf;


    @FindBy(xpath = "//h1[@class='ipt-title']")
    public WebElement allAgentsYaziyusuf;

    @FindBy(xpath = "//h1[@class='ipt-title']")
    public WebElement contactYaziyusuf;


    @FindBy(xpath = "//div[@class='col-lg-12 col-md-12 col-sm-12']")
    public WebElement yourCurrentCreditsYaziyusuf;

    @FindBy(xpath = "//input[@placeholder='Email/Username']")
    public WebElement adminEmailTextBoxyusuf;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement adminPasswordTextBoxyusuf;

    @FindBy(xpath = "//*[@class='breadcrumb-item active']")
    public WebElement dahsboardYazisiYusuf;

    // User Homepage Footer Contact Info Field - Adem
    @FindBy(xpath="(//*[@class='footer-widget'])[1]")
    public WebElement footerContactInfo;

    // User Homepage Footer Copyright Info Field - Adem
    @FindBy(xpath="//p[@class='mb-0']")
    public WebElement copyrightInFooter;


//================metin's locators start

    // User Homepage Footer Facebook link - Adem
    @FindBy(xpath="//a[@title='Facebook']")
    public WebElement linkFacebookInFooter;

    // User Homepage Footer Twitter link - Adem
    @FindBy(xpath="//i[@class='ti-twitter']")
    public WebElement linkTwitterInFooter;

    // User Homepage Footer Instagram link - Adem
    @FindBy(xpath="//i[@class='ti-instagram']")
    public WebElement linkInstagramInFooter;

    // User Homepage Footer LinkedIn link - Adem
    @FindBy(xpath="//i[@class='ti-linkedin']")
    public WebElement linkLinkedInInFooter;

    // User Homepage Footer Pinterest link - Adem
    @FindBy(xpath="//i[@class='ti-pinterest']")
    public WebElement linkPinterestInFooter;

    // User Homepage Footer Subscribe button - Adem
    @FindBy(xpath="//*[@class='btn bg-dark text-white']")
    public WebElement buttonSubscribeInFooter;

    //Agents sayfada ilk emlakci detaylarindaki header - Adem
    @FindBy(xpath="//div[@class='block-wrap']")
    public WebElement headerFirstAgentDetail;


    @FindBy(xpath = "(//div[@class='listing-detail-btn'])[1]")
    public WebElement viewButtonAfterSearchedForListing;
  
  

//================metin's locators finish



//**** Suleyman Locate start *******


    @FindBy (xpath ="//i[@class='lni-linkedin']")
    public WebElement linkedinShareButton;

    @FindBy (xpath ="//i[@class='lni-twitter']")
    public WebElement twitterShareButton;

    @FindBy (xpath= "//i[@class='lni-facebook']")
    public WebElement fbShareButton;


    @FindBy (xpath="//a[@class='btn btn-likes']")
    public WebElement shareButton;

    @FindBy (xpath="(//a[@class='prt-view'])[3]")
    public WebElement propertyViewButton;

    @FindBy (xpath ="//input[@id='name']")
    public WebElement nameInput;

    @FindBy (xpath ="//input[@name='phone']")
    public WebElement phoneInput;

    @FindBy (xpath ="//input[@id='email']")
    public WebElement emailInput;

    @FindBy (xpath="//textarea[@name='content']")
    public WebElement messageInput;

    @FindBy (xpath="//button[@class='btn btn-black btn-md rounded full-width']")
    public WebElement sendMessageButton_SI;

    @FindBy (xpath = "//div[@id='alert-container']")
    public WebElement wishlistAlert;

    @FindBy (xpath = "(//a[@class='br-selected br-current'])[1]")
    public WebElement puanStarClick;

    @FindBy(xpath = "//div[@id='alert-container']")   //"//div[@id='alert alert-success alert-dismissible']")
    public WebElement sendMessageButtonAlert;

    @FindBy(xpath = "(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[2]")
    public WebElement twitterPageControlText;

    @FindBy(xpath = "//i[@class='fas fa-user']")
    public WebElement LogOnuserName;

    @FindBy(xpath = "//textarea[@class='form-control ht-80']")
    public WebElement yorumTextBoxInput;

    @FindBy(xpath = "//button[@class='btn btn-theme-light-2 rounded']")
    public WebElement yorumSubmitButton;


    //**** Suleyman Locate end ******

    
// User Homepage Footer Newsletter Subscribe textbox - Adem
    @FindBy(xpath="//input[@name='email']")
    public WebElement textboxSubscribeInFooter;

    // User Homepage Footer Newsletter Subscribe Successfully Message - Adem
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    public WebElement labelSubscribeTrueMessageInFooter;

    // User Homepage Footer Newsletter Subscribe False Message - Adem
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    public WebElement labelSubscribeFalseMessageInFooter;

    // User Home Register a now account-enver
    @FindBy(xpath = "//a[@class=\"link d-block d-sm-inline-block text-sm-left text-center\"]")
    public WebElement RegisterANowAccount;

    //user home register a now firstname-enver
    @FindBy(xpath = "//input[@name=\"first_name\"]")
    public WebElement firstName;

    //user home register a now lasttname-enver
    @FindBy(xpath = "//input[@name=\"last_name\"]")
    public WebElement lastName;

    //user home register a now email-enver
    @FindBy(xpath = "(//input[@name=\"email\"])[1]")
    public WebElement registerEmail;

    //user home register a now username-enver
    @FindBy(xpath = "(//input[@name=\"username\"])[1]")
    public WebElement userNameEnver;

    //user home register a now pasword-enver
    @FindBy(xpath = "(//input[@name=\"password\"])[1]")
    public WebElement pasWordEnver;

    //user home register a now confirmPassword-enver
    @FindBy(xpath = "(//input[@name=\"password_confirmation\"])[1]")
    public WebElement confirmPassword;

    //user home register a now register button-enver
    @FindBy(xpath = "//button[@class=\"btn btn-md full-width btn-theme-light-2 rounded\"]")
    public WebElement registerButton;





    

}

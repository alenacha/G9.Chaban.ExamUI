package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderElements;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement buttonSignUpLogin;

    @FindBy(xpath = ".//a[@href='#Women']")
    private WebElement womenCategory;

    @FindBy(xpath = ".//a[@href='/category_products/1']")
    private WebElement dressSubcategory;

    @FindBy(xpath = ".//*[@id='dismiss-button']")
    private WebElement closeAD;

    @FindBy(xpath = ".//a[@data-product-id='7' and @class='btn btn-default add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//a[@href='/view_cart' and not(i)]")
    private WebElement viewCartButton;

//    @FindBy(xpath = ".//h2[contains(text(),'Features Items')]")
//    private WebElement featuredItemsLabel;

//    @FindBy(xpath = ".//a[@href='/product_details/1']")
//    private WebElement viewProduct;


    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElements getHeaderElement() {
        return new HeaderElements(webDriver);
    }

    public HomePage openHomePage() {
        try{
            webDriver.get(baseUrl);
            logger.info("Home page was opened with URL " + baseUrl);

        }catch (Exception e){
            logger.error("Can not open login page " + e);
            Assert.fail("Can not open login page " + e);
        }
        return this;
    }

    public LoginPage clickOnButtonSignUpLogin(){
        clickOnElement(buttonSignUpLogin);
        return new LoginPage(webDriver);
    }

     public HeaderElements checkIsRedirectToHomePage() {
         checkUrl();
         return new HeaderElements(webDriver);
     }
     public HeaderElements openHomePageAndLoginIfNeeded() {
         LoginPage loginPage = new LoginPage(webDriver);
         loginPage.openLoginPage();
         if (this.getHeaderElement().isButtonLogoutVisible()){
             logger.info("User is already logged in");
         } else {
             loginPage.loginToAccount();
             checkIsRedirectToHomePage();
             logger.info("User was logged in");
         }
         return new HeaderElements(webDriver);
    }

    public CategoryProductsPage navigateToWomenCategory()  {
        scrollToElement(womenCategory);
        clickOnElement(womenCategory);
        clickOnElement(dressSubcategory);
        closeAdd(closeAD);
        return new CategoryProductsPage(webDriver);
    }


    public HomePage clickOnAddToCartButton(){
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        return this;
    }
    public CartPage clickVewCartButton() {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
            logger.info("Modal content is displayed");
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        clickOnElement(viewCartButton);
        return new CartPage(webDriver);

    }



}

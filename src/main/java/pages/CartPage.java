package pages;

import data.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ParentPage{
    @FindBy(xpath =".//h2['Subscription']")
    private WebElement subscriptionLabel;

    @FindBy(xpath = ".//input[@id='susbscribe_email']")
    private WebElement emailInput;

    @FindBy(xpath = ".//button[@id='subscribe']")
    private WebElement submitButton;

    @FindBy(xpath = ".//div[@id='success-subscribe']//div[@class='alert-success alert']")
    private WebElement successMessage;

    @FindBy(xpath = ".//li[contains(text(), 'Shopping Cart')]")
    private WebElement breadcrumbs;

    @FindBy(xpath ="//a[contains(text(), 'Madame Top For Women')]")
    private WebElement productLabelInCart;

    @FindBy(xpath = "//td[@class='cart_total']/p[@class='cart_total_price'][text()='Rs. 1000']")
    private WebElement productPriceInCart;



    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "view_cart";
    }
    public boolean isSubscriptionDisplayed(){
        return isElementDisplayed(subscriptionLabel);
    }
    public boolean isBreadcrumbsDisplayed(){
        return isElementDisplayed(breadcrumbs);
    }
    public CartPage populationEmailInSubscription(String email) {
        cleanAndEnterTextIntoElement(emailInput, email);
        return this;
    }
    public CartPage populateEmailAndClickSubscribe(){
        populationEmailInSubscription(TestData.LOGIN_EMAIL);
        webDriver.switchTo().defaultContent();
        clickOnElement(submitButton);
        return this;
    }

    public CartPage checkIsRedirectToCartPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Invalid page Not Cart page",isBreadcrumbsDisplayed());
        logger.info("User is on Cart page");
        return this;
    }
    public CartPage assertionSuccessMessage(){
        checkElementIsDisplayed(successMessage);
        return this;
    }
    public CartPage assertionProductInCart(){
        checkElementIsDisplayed(productLabelInCart);
        checkElementIsDisplayed(productPriceInCart);
        return this;
    }
}

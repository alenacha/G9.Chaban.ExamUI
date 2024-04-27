package pages;

import data.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends ParentPage {

    @FindBy(xpath = ".//a[@href='#reviews']")
    private WebElement writeYourReview;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameInput;

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = ".//textarea[@id='review']")
    private WebElement reviewInput;

    @FindBy(xpath = ".//button[@id='button-review']")
    private WebElement submitButton;

    @FindBy(xpath = ".//div[@class='alert-success alert']/span[text()='Thank you for your review.']")
    private WebElement successMessage;

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "product_details/[a-zA-Z0-9]*";
    }
    public ProductDetailsPage checkIsRedirectToProductDetailsPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Invalid page -  Not Product Details page", isElementDisplayed(writeYourReview));
        return this;
    }
    public ProductDetailsPage populateInputNameSignUp(String name) {
        cleanAndEnterTextIntoElement(nameInput, name);
        return this;
    }
    public ProductDetailsPage populateInputEmailSignUp(String email) {
        cleanAndEnterTextIntoElement(emailInput, email);
        return this;
    }
    public ProductDetailsPage populateReviewInput(String review) {
        cleanAndEnterTextIntoElement(reviewInput, review);
        return this;
    }
    public ProductDetailsPage leaveReview(){
        scrollToElement(nameInput);
        populateInputNameSignUp(TestData.SIGNUP_FIRSTNAME);
        populateInputEmailSignUp(TestData.LOGIN_EMAIL);
        populateReviewInput(TestData.REVIEW_TEXT);
        clickOnElement(submitButton);
        return this;
    }
    public ProductDetailsPage checkIsSuccessMessageDisplayed() {
        isElementDisplayed(successMessage);
        return this;
    }
    
}

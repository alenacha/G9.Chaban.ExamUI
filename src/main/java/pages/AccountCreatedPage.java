package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends ParentPage{

    @FindBy(xpath = ".//b[contains(text(),'Account Created!')]")
    private WebElement successMessage;

    @FindBy(xpath = ".//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = ".//*[@id='dismiss-button']")
    private WebElement closeAD;



    public AccountCreatedPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "account_created";
    }
    public AccountCreatedPage checkIsRedirectToAccountCreatedPage() {
        checkUrlWithPattern();
        return this;
    }
    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(successMessage);
    }

    public HomePage clickOnContinueButton() {
        clickOnElement(continueButton);
        closeAdd(closeAD);
        return new HomePage(webDriver);
    }

}
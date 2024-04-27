package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DeleteAccountPage extends ParentPage {

    public DeleteAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//b[contains(text(),'Account Deleted')]")
    private WebElement deleteMessage;

    @FindBy(xpath = ".//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = ".//div[@id='dismiss-button']")
    private WebElement closeAD;

    @Override
    protected String getRelativeUrl() {
        return "delete_account";
    }
    public boolean checkDeleteMessageDisplays() {
        return isElementDisplayed(deleteMessage);
    }

    public DeleteAccountPage checkIsRedirectToDeleteAccountPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Invalid page Not home page",checkDeleteMessageDisplays());
        return this;
    }
    public HomePage clickOnContinueButton() {
        clickOnElement(continueButton);
        return new HomePage(webDriver);
    }
}

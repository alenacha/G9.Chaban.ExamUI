package pages.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.DeleteAccountPage;
import pages.ProductsPage;

public class HeaderElements extends CommonActionsWithElements {
    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement buttonSignUpLogin;

    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement buttonLogout;

    @FindBy(xpath = ".//li/a/b")
    private WebElement loggedInAs;

    @FindBy(xpath = ".//a[@href='/delete_account']")
    private WebElement deleteAccount;

    @FindBy(xpath = ".//a[@href='/view_cart']/i")
    private WebElement cart;

    @FindBy(xpath = ".//a[@href='/products']")
    private WebElement products;

    @FindBy(xpath = "//*[@id='dismiss-button']")
    private WebElement closeAD;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

        public boolean isButtonLogoutVisible(){
        return isElementDisplayed(buttonLogout);

    }
    public HeaderElements assertionForLoggedUserElementsAreDisplayed() {
        checkElementIsDisplayed(buttonLogout);
        checkElementIsDisplayed(loggedInAs);
        checkElementIsDisplayed(deleteAccount);
        return this;
    }
    public DeleteAccountPage clickOnDeleteAccountButton() {
        clickOnElement(deleteAccount);
        return new DeleteAccountPage(webDriver);
    }
    public HeaderElements clickOnCartButton() {
        clickOnElement(cart);
        return this;
    }
    public ProductsPage clickOnProductsButton() {
        clickOnElement(products);
        closeAdd(closeAD);
        return new ProductsPage(webDriver);
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElements;

public class PageProvider {

    private WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage(){
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage(){
        return new HomePage(webDriver);}

    public SignUp getSignUpPage(){
        return new SignUp(webDriver);}

    public AccountCreatedPage getAccountCreatedPage(){
        return new AccountCreatedPage(webDriver);}

    public HeaderElements getHeaderElements(){
        return new HeaderElements(webDriver);}

    public DeleteAccountPage getDeleteAccountPage(){
        return new DeleteAccountPage(webDriver);
    }


    public CartPage getCartPage() {
        return new CartPage(webDriver);
    }
}

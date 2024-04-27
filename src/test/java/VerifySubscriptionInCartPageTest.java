import baseTest.BaseTest;
import org.junit.Test;

public class VerifySubscriptionInCartPageTest extends BaseTest {
    @Test

    public void VerifySubscriptionInCartPage(){
        pageProvider.getHomePage().openHomePage();
        pageProvider.getHeaderElements().clickOnCartButton();
        pageProvider.getCartPage().checkIsRedirectToCartPage();
        pageProvider.getCartPage().isSubscriptionDisplayed();
        pageProvider.getCartPage().populateEmailAndClickSubscribe();
        pageProvider.getCartPage().assertionSuccessMessage();

    }

}

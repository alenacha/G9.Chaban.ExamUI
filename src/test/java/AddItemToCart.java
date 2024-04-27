import baseTest.BaseTest;
import org.junit.Test;

public class AddItemToCart extends BaseTest {
    @Test
    public void addItemToCart() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnAddToCartButton()
                .clickVewCartButton()
                .checkIsRedirectToCartPage()
                .assertionProductInCart();
    }
}

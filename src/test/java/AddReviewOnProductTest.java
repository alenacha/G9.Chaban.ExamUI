import baseTest.BaseTest;
import org.junit.Test;

public class AddReviewOnProductTest extends BaseTest {

    @Test
    public void addReviewOnProduct()  {
        pageProvider.getHomePage()
                .openHomePage();
        pageProvider.getHeaderElements()
                .clickOnProductsButton()
                .checkIsRedirectToProductsPage()
                .clickOnViewProduct()
                .checkIsRedirectToProductDetailsPage()
                .leaveReview()
                .checkIsSuccessMessageDisplayed();
    }


}

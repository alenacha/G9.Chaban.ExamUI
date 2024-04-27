import baseTest.BaseTest;
import org.junit.Test;

public class CheckCategoryProductsTest extends BaseTest {

    @Test
    public void checkCategoryProducts() throws InterruptedException {
        pageProvider.getHomePage()
                .openHomePage()
                .navigateToWomenCategory()
                .checkIsRedirectToCategoryProductsPage()
                .assertTextInCategoryProductsPage()
                .checkCountOfProducts();
    }

}

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Thread.sleep;

public class ProductsPage extends ParentPage{

    @FindBy(xpath = ".//h2[contains(text(),'Products')]")
    private WebElement productsLabel;

    @FindBy(xpath = ".//h2[contains(text(),'Features Items')]")
    private WebElement featuredItemsLabel;
    @FindBy(xpath = ".//a[@href='/product_details/1']")
    private WebElement viewProduct;

    @FindBy(xpath = ".//*[@id='dismiss-button']")
    private WebElement closeAD;

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "products";
    }

    public boolean isProductsLabelDisplayed(){
        return isElementDisplayed(productsLabel);
    }

    public ProductsPage checkIsRedirectToProductsPage(){
        checkUrlWithPattern();
        Assert.assertTrue("Invalid page -  Not Create Post page", isProductsLabelDisplayed());
        return this;
    }

    public ProductDetailsPage clickOnViewProduct() {
        scrollToElement(productsLabel);
        clickOnElement(viewProduct);
        return new ProductDetailsPage(webDriver);
    }

}

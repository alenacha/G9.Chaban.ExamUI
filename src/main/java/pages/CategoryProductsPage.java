package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryProductsPage extends ParentPage{

    @FindBy(xpath = ".//h2[contains(text(),'Women - Dress Products')]")
    private WebElement DressProductsLabel;

    public CategoryProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "category_products/[a-zA-Z0-9]*";
    }
    public CategoryProductsPage checkIsRedirectToCategoryProductsPage() {
        checkUrlWithPattern();
        return this;
    }
    public CategoryProductsPage assertTextInCategoryProductsPage(){
        checkElementIsDisplayed(DressProductsLabel);
        return this;
    }
    List<WebElement> elements = webDriver.findElements(By.xpath(".//div[@class='productinfo text-center']//descendant::p[contains(., 'Dress')]"));


    public CategoryProductsPage checkCountOfProducts(){
        int actualCount = elements.size();
        int expectedCount = 3;
        Assert.assertEquals("Number of products is not as expected", expectedCount, actualCount);
        logger.info("Number of products is as expected");
        return this;
    }


}

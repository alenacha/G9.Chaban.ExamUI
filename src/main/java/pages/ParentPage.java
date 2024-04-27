package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements{

    String baseUrl = "https://automationexercise.com/";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
    abstract protected String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("Invalid Page",
                baseUrl + getRelativeUrl() //метод перевіряє чи поточний URL відповідає очікуваному
                , webDriver.getCurrentUrl());
    }
    protected void checkUrlWithPattern() {
        Assert.assertTrue("Invalid Page \n"
                        + "Expected URL : " + baseUrl + getRelativeUrl() +
                         "\n" + "Actual URL: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl()));
    }
}


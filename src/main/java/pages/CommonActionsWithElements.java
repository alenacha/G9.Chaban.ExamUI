package pages;

import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait10, webDriverWait15, webDriverWait20;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        webDriverWait20 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));
    }


    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String elementName = getElementName(webElement);
            webElement.click();
            logger.info(elementName + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

    protected void cleanAndEnterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(getElementName(webElement) + " Element is displayed ");
            } else {
                logger.info(getElementName(webElement) + " Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    public void checkElementIsDisplayed(WebElement webElement) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(webElement));
    }

    public void checkElementIsNotDisplayed(WebElement webElement) {
        Assert.assertTrue("Element is displayed", !isElementDisplayed(webElement));
    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
        js.executeScript("window.scrollBy(0, " + pixels + ")");
    }

    public void scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void closeAdd(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        for (int i = 0; i < 10; i++) {
            try {
                String iframeName = "aswift_" + i;
                WebElement element = webDriver.findElement(By.id(iframeName));
                if (element.isDisplayed()) {
                    logger.info("visible " + iframeName);
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(iframeName)));
                    clickOnElement(webElement);

                    webDriver.switchTo().defaultContent();
                    break;
                } else {
                    logger.info("not visible " + iframeName);
                }
            } catch (NoSuchElementException e) {
                logger.info("Frame with id 'aswift_'" + i + " not found");
                webDriver.switchTo().defaultContent();
            }
        }
    }
}
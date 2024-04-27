package pages;

import data.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy (xpath = ".//h2[contains(text(),'New User Signup!')]")
    private WebElement newUserSignup;

    @FindBy (xpath = ".//input[@data-qa='signup-name']")
    private WebElement inputName;

    @FindBy (xpath = ".//input[@data-qa='signup-email']")
    private WebElement inputEmail;

    @FindBy (xpath = ".//button[@data-qa='signup-button']")
    private WebElement buttonSignUp;

    @FindBy(xpath = ".//input[@data-qa='login-email']")
    private WebElement inputEmailLogin;

    @FindBy(xpath = ".//input[@data-qa='login-password']")
    private WebElement inputPasswordLogin;

    @FindBy(xpath = ".//button[@data-qa='login-button']")
    private WebElement buttonLogin;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "login";
    }

    public LoginPage checkIsRedirectToLoginPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Invalid page Not home page",checkElementsOnLoginPageAreDisplayed());
        return this;
    }

    public boolean checkElementsOnLoginPageAreDisplayed() {
        return isElementDisplayed(newUserSignup) && isElementDisplayed(buttonSignUp);
    }
    public LoginPage populateInputNameSignUp(String name) {
        cleanAndEnterTextIntoElement(inputName, name);
        return this;
    }
    public LoginPage populateInputEmailSignUp(String email) {
        cleanAndEnterTextIntoElement(inputEmail, email);
        return this;
    }
    public LoginPage clickOnButtonSignUp() {
        clickOnElement(buttonSignUp);
        return this;
    }
    public LoginPage populateInputEmailLogin(String email) {
        cleanAndEnterTextIntoElement(inputEmailLogin, email);
        return this;
    }
    public LoginPage populateInputPasswordLogin(String password) {
        cleanAndEnterTextIntoElement(inputPasswordLogin, password);
        return this;
    }
    public LoginPage clickOnButtonLogin() {
        clickOnElement(buttonLogin);
        return this;
    }

    public SignUp populateRequiredFieldsOnLoginPageAndClickSignUp(){
        populateInputNameSignUp(TestData.LOGIN_NAME);
        populateInputEmailSignUp(TestData.LOGIN_EMAIL);
        clickOnButtonSignUp();
        return new SignUp(webDriver);
    }
    public HomePage loginToAccount(){
        populateInputEmailLogin(TestData.LOGIN_EMAIL);
        populateInputPasswordLogin(TestData.SIGNUP_PASSWORD);
        clickOnButtonLogin();
        return new HomePage(webDriver);
    }

    public void openLoginPage() {
        try{
            webDriver.get(baseUrl);
            logger.info("Login page was opened with URL " + baseUrl);

        }catch (Exception e){
            logger.error("Can not open login page " + e);
            Assert.fail("Can not open login page " + e);
        }
    }

}

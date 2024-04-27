package pages;

import data.TestData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp extends ParentPage{

    @FindBy(xpath = ".//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@id='first_name']")
    private WebElement inputFirstName;

    @FindBy(xpath = ".//input[@id='last_name']")
    private WebElement inputLastName;

    @FindBy(xpath = ".//input[@id='address1']")
    private WebElement inputAddress1;

    @FindBy(xpath = ".//input[@id='state']")
    private WebElement inputState;

    @FindBy(xpath = ".//input[@id='city']")
    private WebElement inputCity;

    @FindBy(xpath = ".//input[@id='zipcode']")
    private WebElement inputZipcode;

    @FindBy(xpath = ".//input[@id='mobile_number']")
    private WebElement inputMobileNumber;

    @FindBy(xpath = ".//button[@data-qa='create-account']")
    private WebElement buttonCreateAccount;


    public SignUp(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "signup";
    }

    public SignUp checkIsRedirectToSignUpPage() {
        checkUrlWithPattern();
        return this;
    }
    public SignUp populateInputPassword(String password) {
        cleanAndEnterTextIntoElement(inputPassword, password);
        return this;
    }
    public SignUp populateInputFirstName(String firstName) {
        cleanAndEnterTextIntoElement(inputFirstName, firstName);
        return this;
    }
    public SignUp populateInputLastName(String lastName) {
        cleanAndEnterTextIntoElement(inputLastName, lastName);
        return this;
    }
    public SignUp populateInputAddress1(String address1) {
        cleanAndEnterTextIntoElement(inputAddress1, address1);
        return this;
    }
    public SignUp populateInputState(String state) {
        cleanAndEnterTextIntoElement(inputState, state);
        return this;
    }
    public SignUp populateInputCity(String city) {
        cleanAndEnterTextIntoElement(inputCity, city);
        return this;
    }
    public SignUp populateInputZipcode(String zipcode) {
        cleanAndEnterTextIntoElement(inputZipcode, zipcode);
        return this;
    }
    public SignUp populateInputMobileNumber(String mobileNumber) {
        cleanAndEnterTextIntoElement(inputMobileNumber, mobileNumber);
        return this;
    }
    public SignUp clickOnButtonCreateAccount() {
        clickOnElement(buttonCreateAccount);
        return this;
    }
    public AccountCreatedPage populateFieldsOnSignUpPageAndClickOnCreateAcc(){
        scrollDown(100);
        populateInputPassword(TestData.SIGNUP_PASSWORD);
        populateInputFirstName(TestData.SIGNUP_FIRSTNAME);
        populateInputLastName(TestData.SIGNUP_LASTNAME);
        populateInputAddress1(TestData.SIGNUP_ADDRESS);
        populateInputState(TestData.SIGNUP_STATE);
        populateInputCity(TestData.SIGNUP_CITY);
        populateInputZipcode(TestData.SIGNUP_ZIPCODE);
        populateInputMobileNumber(TestData.SIGNUP_MOBILE);
        scrollDown(100);
        clickOnButtonCreateAccount();
        return new AccountCreatedPage(webDriver);
    }


}

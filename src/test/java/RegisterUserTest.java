import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

public class RegisterUserTest extends BaseTest {

    @Test

    public void registerUser(){
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnButtonSignUpLogin()
                .checkIsRedirectToLoginPage().
                populateRequiredFieldsOnLoginPageAndClickSignUp()
                .checkIsRedirectToSignUpPage()
                .populateFieldsOnSignUpPageAndClickOnCreateAcc()
                .checkIsRedirectToAccountCreatedPage()
                .isSuccessMessageDisplayed();
        pageProvider.getAccountCreatedPage()
                .clickOnContinueButton()
                .checkIsRedirectToHomePage()
                .assertionForLoggedUserElementsAreDisplayed();
    }

        @After
        public void deleteAcc(){
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .clickOnDeleteAccountButton()
                .checkIsRedirectToDeleteAccountPage()
                .clickOnContinueButton()
                .checkIsRedirectToHomePage();
        }

}



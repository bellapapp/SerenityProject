package fasttrackit.tests;

import fasttrackit.utils.EnvConstants;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void validLoginWithValidUserEmailAndPassword() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(EnvConstants.VALID_LOGIN_USER_EMAIL, EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsLoggedIn();
        loginSteps.checkMyAccountHelloMessageIsPresent();
        loginSteps.checkMyAccountHelloMessageContent(EnvConstants.VALID_LOGIN_USERNAME);
    }

    @Test
    public void validLoginWithValidUsernameAndPassword() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsLoggedIn();
        loginSteps.checkMyAccountHelloMessageIsPresent();
        loginSteps.checkMyAccountHelloMessageContent(EnvConstants.VALID_LOGIN_USERNAME);
    }

    @Test
    public void failedLoginWithValidUserEmailAndInvalidPassword() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(EnvConstants.VALID_LOGIN_USER_EMAIL, EnvConstants.INVALID_LOGIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsNotLoggedIn();
        loginSteps.checkFailedLoginErrorMsgIsPresent();
        loginSteps.checkFailedLoginWithInvalidPasswordErrorMsgContent(EnvConstants.VALID_LOGIN_USER_EMAIL);
    }

    @Test
    public void failedLoginWithInvalidUserEmail() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(EnvConstants.INVALID_LOGIN_USERNAME_EMAIL, EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsNotLoggedIn();
        loginSteps.checkFailedLoginErrorMsgIsPresent();
        loginSteps.checkFailedLoginWithInvalidEmailErrorMsgContent();
    }

    @Test
    public void failedLoginWithInvalidUsername() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials(EnvConstants.INVALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsNotLoggedIn();
        loginSteps.checkFailedLoginErrorMsgIsPresent();
        loginSteps.checkFailedLoginWithInvalidUsernameErrorMsgContent();
    }

    @Test
    public void failedLoginWithEmptyPasswordField() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterUsername(EnvConstants.VALID_LOGIN_USERNAME);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsNotLoggedIn();
        loginSteps.checkFailedLoginErrorMsgIsPresent();
        loginSteps.checkFailedLoginWithoutPasswordErrorMsgContent();
    }

    @Test
    public void failedLoginWithEmptyUsernameField() {
        loginSteps.navigateToMyAccount();
        loginSteps.enterPassword(EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsNotLoggedIn();
        loginSteps.checkFailedLoginErrorMsgIsPresent();
        loginSteps.checkFailedLoginWithoutUsernameErrorMsgContent();
    }

    @Test
    public void failedLoginWithEmptyFields() {
        loginSteps.navigateToMyAccount();
        loginSteps.clickOnLoginButton();
        loginSteps.checkUserIsNotLoggedIn();
        loginSteps.checkFailedLoginErrorMsgIsPresent();
        loginSteps.checkFailedLoginWithoutUsernameErrorMsgContent();
    }

    @Test
    public void logoutTestWithMyAccountNavigationBarLogoutButton() {
        loginSteps.doLogin(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.checkUserIsLoggedIn();
        loginSteps.clickOnMyAccountNavigationLogoutButton();
        loginSteps.checkUserIsNotLoggedIn();
    }

    @Test
    public void logoutTestWithMyAccountHelloMsgLogoutButton() {
        loginSteps.doLogin(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        loginSteps.checkUserIsLoggedIn();
        loginSteps.clickOnHelloMsgLogoutButton();
        loginSteps.checkUserIsNotLoggedIn();
    }
}

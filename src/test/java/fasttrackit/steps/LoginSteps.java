package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Step
    public void navigateToMyAccount(){
        homePage.clickOnMyAccountLink();
    }

    @Step
    public void clickOnLoginButton() {
        myAccountPage.clickOnLoginButton();
    }

    @Step
    public void enterUsername(String username) {
        myAccountPage.setLoginUsernameField(username);
    }

    @Step
    public void enterPassword(String password) {
        myAccountPage.setLoginPasswordField(password);
    }

    @Step
    public void enterCredentials(String username, String password) {
        myAccountPage.setLoginUsernameField(username);
        myAccountPage.setLoginPasswordField(password);
    }

    @Step
    public void doLogin(String userName, String password) {
        homePage.clickOnMyAccountLink();
        myAccountPage.setLoginUsernameField(userName);
        myAccountPage.setLoginPasswordField(password);
        myAccountPage.clickOnLoginButton();
    }

    @Step
    public void doLogout() {
        homePage.clickOnMyAccountLink();
        myAccountPage.clickOnMyAccountNavigationLogoutButton();
    }

    @Step
    public void clickOnMyAccountNavigationLogoutButton() {
        myAccountPage.clickOnMyAccountNavigationLogoutButton();
    }

    @Step
    public void clickOnHelloMsgLogoutButton() {
        myAccountPage.clickOnHelloMsgLogoutButton();
    }

    @Step
    public void checkUserIsLoggedIn() {
        Assert.assertTrue("The My Account navigation is not present.",
                myAccountPage.checkMyAccountNavigationIsPresent());
    }

    @Step
    public void checkUserIsNotLoggedIn() {
        Assert.assertFalse("The My Account navigation is present.",
                myAccountPage.checkMyAccountNavigationIsPresent());
    }

    @Step
    public void checkMyAccountHelloMessageContent(String username) {
        Assert.assertTrue("The My Account hello message doesn't contain: 'Hello " + username + "'.",
                myAccountPage.checkMyAccountHelloMessageContent(username));
    }

    @Step
    public void checkMyAccountHelloMessageIsPresent() {
        Assert.assertTrue("The My Account Hello message is not present.",
                myAccountPage.checkMyAccountHelloMessageIsPresent());
    }

    @Step
    public void checkFailedLoginErrorMsgIsPresent() {
        Assert.assertTrue("The failed login Error message is not present.",
                myAccountPage.checkFailedLoginRegisterErrorMsgIsPresent());
    }

    @Step
    public void checkFailedLoginWithInvalidPasswordErrorMsgContent(String email) {
        Assert.assertTrue("The Error message doesn't contain: 'The password you entered for the email address " + email + " is incorrect'.",
                myAccountPage.checkFailedLoginWithInvalidPasswordErrorMsg(email));
    }

    @Step
    public void checkFailedLoginWithInvalidEmailErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'Invalid email address'.",
                myAccountPage.checkFailedLoginWithInvalidEmailErrorMsg());
    }

    @Step
    public void checkFailedLoginWithInvalidUsernameErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'Invalid username'.",
                myAccountPage.checkFailedLoginWithInvalidUsernameErrorMsg());
    }

    public void checkFailedLoginWithoutPasswordErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'The password field is empty'.",
                myAccountPage.checkFailedLoginWithoutPasswordErrorMsg());
    }

    public void checkFailedLoginWithoutUsernameErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'Username is required'.",
                myAccountPage.checkFailedLoginWithoutUsernameErrorMsg());
    }
}

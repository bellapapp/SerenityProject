package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class RegisterSteps extends BaseSteps{

    @Step
    public void navigateToMyAccount(){
        homePage.clickOnMyAccountLink();
    }

    @Step
    public void clickOnRegisterButton() {
        myAccountPage.clickOnRegisterButton();
    }

    @Step
    public void setRegisterEmailField(String email) {
        myAccountPage.setRegisterEmailField(email);
    }

    @Step
    public void setRegisterPasswordField(String password) {
        myAccountPage.setRegisterPasswordField(password);
    }

    @Step
    public void enterRegisterCredentials(String username, String password) {
        myAccountPage.setRegisterEmailField(username);
        myAccountPage.setRegisterPasswordField(password);
    }

    @Step
    public void doRegister(String username, String password) {
        homePage.clickOnMyAccountLink();
        myAccountPage.setRegisterEmailField(username);
        myAccountPage.setRegisterPasswordField(password);
        myAccountPage.clickOnRegisterButton();
    }

    @Step
    public void checkUserIsRegistered() {
        Assert.assertTrue("The My Account navigation is not present.",
                myAccountPage.checkMyAccountNavigationIsPresent());
    }

    @Step
    public void checkUserIsNotRegistered() {
        Assert.assertFalse("The My Account navigation is present.",
                myAccountPage.checkMyAccountNavigationIsPresent());
    }

    @Step
    public void checkMyAccountHelloMessageContent(String username) {
        Assert.assertTrue("The My Account hello message is different from: 'Hello " + username + "'.",
                myAccountPage.checkMyAccountHelloMessageContent(username));
    }

    @Step
    public void checkMyAccountHelloMessageIsPresent() {
        Assert.assertTrue("The My Account Hello message is not present.",
                myAccountPage.checkMyAccountHelloMessageIsPresent());
    }

    @Step
    public void checkFailedRegisterErrorMsgIsPresent() {
        Assert.assertTrue("The failed register Error message is not present.",
                myAccountPage.checkFailedLoginRegisterErrorMsgIsPresent());
    }

    @Step
    public void checkFailedRegisterWithAlreadyRegisteredEmailErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'An account is already registered with your email address'.",
                myAccountPage.checkFailedRegisterWithAlreadyRegisteredEmailErrorMsg());
    }

    @Step
    public void checkFailedRegisterValidEmailProvideErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'Please provide a valid email address'",
                myAccountPage.checkFailedRegisterValidEmailProvideErrorMsg());
    }

    @Step
    public void checkFailedRegisterWithoutPasswordErrorMsgContent() {
        Assert.assertTrue("The Error message doesn't contain: 'Please enter an account password'.",
                myAccountPage.checkFailedRegisterWithoutPasswordErrorMsg());
    }

    @Step
    public void checkRegisterButtonIsDisabled() {
        Assert.assertTrue("The register button is enabled.",
                myAccountPage.checkRegisterButtonIsDisabled());
    }
}

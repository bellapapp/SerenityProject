package fasttrackit.tests;

import fasttrackit.utils.EnvConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegister() {
        String register_email = RandomStringUtils.randomAlphanumeric(5);
        registerSteps.navigateToMyAccount();
        registerSteps.enterRegisterCredentials(register_email + EnvConstants.VALID_EMAIL_FORMAT, RandomStringUtils.randomAlphanumeric(12));
        registerSteps.clickOnRegisterButton();
        registerSteps.checkUserIsRegistered();
        registerSteps.checkMyAccountHelloMessageIsPresent();
        registerSteps.checkMyAccountHelloMessageContent(register_email);
    }

    @Test
    public void registerWithAlreadyRegisteredEmail() {
        registerSteps.navigateToMyAccount();
        registerSteps.enterRegisterCredentials(EnvConstants.VALID_LOGIN_USER_EMAIL, RandomStringUtils.randomAlphanumeric(12));
        registerSteps.clickOnRegisterButton();
        registerSteps.checkUserIsNotRegistered();
        registerSteps.checkFailedRegisterErrorMsgIsPresent();
        registerSteps.checkFailedRegisterWithAlreadyRegisteredEmailErrorMsgContent();
    }

    @Test
    public void registerWithInvalidEmailFormat() {
        registerSteps.navigateToMyAccount();
        registerSteps.enterRegisterCredentials(RandomStringUtils.randomAlphanumeric(5) + EnvConstants.INVALID_EMAIL_FORMAT, RandomStringUtils.randomAlphanumeric(12));
        registerSteps.clickOnRegisterButton();
        registerSteps.checkUserIsNotRegistered();
        registerSteps.checkFailedRegisterErrorMsgIsPresent();
        registerSteps.checkFailedRegisterValidEmailProvideErrorMsgContent();
    }

    @Test
    public void registerWithPasswordFromInvalidPartition() {
        registerSteps.navigateToMyAccount();
        registerSteps.enterRegisterCredentials(RandomStringUtils.randomAlphanumeric(5) + EnvConstants.VALID_EMAIL_FORMAT, RandomStringUtils.randomAlphanumeric(8));
        registerSteps.checkRegisterButtonIsDisabled();
        registerSteps.checkUserIsNotRegistered();
    }

    @Test
    public void registerWithEmptyPasswordField() {
        registerSteps.navigateToMyAccount();
        registerSteps.setRegisterEmailField(RandomStringUtils.randomAlphanumeric(5) + EnvConstants.VALID_EMAIL_FORMAT);
        registerSteps.clickOnRegisterButton();
        registerSteps.checkUserIsNotRegistered();
        registerSteps.checkFailedRegisterErrorMsgIsPresent();
        registerSteps.checkFailedRegisterWithoutPasswordErrorMsgContent();
    }

    @Test
    public void registerWithEmptyEmailField() {
        registerSteps.navigateToMyAccount();
        registerSteps.setRegisterPasswordField(RandomStringUtils.randomAlphanumeric(12));
        registerSteps.clickOnRegisterButton();
        registerSteps.checkUserIsNotRegistered();
        registerSteps.checkFailedRegisterErrorMsgIsPresent();
        registerSteps.checkFailedRegisterValidEmailProvideErrorMsgContent();
    }

    @Test
    public void registerWithEmptyEmailAndPasswordField() {
        registerSteps.navigateToMyAccount();
        registerSteps.clickOnRegisterButton();
        registerSteps.checkUserIsNotRegistered();
        registerSteps.checkFailedRegisterErrorMsgIsPresent();
        registerSteps.checkFailedRegisterValidEmailProvideErrorMsgContent();
    }
}

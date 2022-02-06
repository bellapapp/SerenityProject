package fasttrackit.pages;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(id = "username")
    private WebElementFacade loginUsernameField;

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailField;

    @FindBy(id = "password")
    private WebElementFacade loginPasswordField;

    @FindBy(id = "reg_password")
    private WebElementFacade registerPasswordField;

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade myAccountContent;

    @FindBy(css = ".login .button")
    private WebElementFacade loginSubmitButton;

    @FindBy(css = ".register .woocommerce-Button")
    private WebElementFacade registerSubmitButton;

    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade myAccountContentHelloText;

    @FindBy(css = ".woocommerce-MyAccount-navigation")
    private WebElementFacade myAccountNavigationMenu;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade loginRegisterErrorMsg;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout a")
    private WebElementFacade logoutButtonInMyAccountNavigation;

    @FindBy(css = ".woocommerce-MyAccount-content p a[href*='logout']")
    private WebElementFacade logoutButtonInMyAccountHelloMsg;

    public void clickOnLoginButton() {
        clickOn(loginSubmitButton);
    }

    public void clickOnMyAccountNavigationLogoutButton() {
        clickOn(logoutButtonInMyAccountNavigation);
    }

    public void clickOnHelloMsgLogoutButton() {
        clickOn(logoutButtonInMyAccountHelloMsg);
    }

    public void clickOnRegisterButton() {
        waitFor(registerSubmitButton);
        clickOn(registerSubmitButton);
    }

    public void setLoginUsernameField(String username) {
        typeInto(loginUsernameField, username);
    }

    public void setLoginPasswordField(String password) {
        typeInto(loginPasswordField, password);
    }

    public void setRegisterEmailField(String username) {
        typeInto(registerEmailField, username);
    }

    public void setRegisterPasswordField(String password) {
        typeInto(registerPasswordField, password);
    }

    public boolean checkMyAccountNavigationIsPresent() {
        return myAccountNavigationMenu.isPresent();
    }

    public boolean checkMyAccountHelloMessageContent(String username) {
        return myAccountContentHelloText.containsText("Hello " + username);
    }

    public boolean checkMyAccountHelloMessageIsPresent() {
        return myAccountContent.isPresent();
    }

    public boolean checkFailedLoginRegisterErrorMsgIsPresent() {
        return loginRegisterErrorMsg.isPresent();
    }

    public boolean checkFailedLoginWithInvalidPasswordErrorMsg(String email) {
        return loginRegisterErrorMsg.containsText("The password you entered for the email address " + email + " is incorrect");
    }

    public boolean checkFailedLoginWithInvalidEmailErrorMsg() {
        return loginRegisterErrorMsg.containsText("Invalid email address");
    }

    public boolean checkFailedLoginWithInvalidUsernameErrorMsg() {
        return loginRegisterErrorMsg.containsText("Invalid username");
    }

    public boolean checkFailedLoginWithoutPasswordErrorMsg() {
        return loginRegisterErrorMsg.containsText("The password field is empty");
    }

    public boolean checkFailedLoginWithoutUsernameErrorMsg() {
        return loginRegisterErrorMsg.containsText("Username is required");
    }

    public boolean checkFailedRegisterWithAlreadyRegisteredEmailErrorMsg() {
        return loginRegisterErrorMsg.containsText("An account is already registered with your email address");
    }

    public boolean checkFailedRegisterValidEmailProvideErrorMsg() {
        return loginRegisterErrorMsg.containsText("Please provide a valid email address");
    }

    public boolean checkFailedRegisterWithoutPasswordErrorMsg() {
        return loginRegisterErrorMsg.containsText("Please enter an account password");
    }

    public boolean checkRegisterButtonIsDisabled() {
        return registerSubmitButton.isDisabled();
    }
}

package fasttrackit.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckOutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElementFacade billingFirstNameField;

    @FindBy(id = "shipping_first_name")
    private WebElementFacade shippingFirstNameField;

    @FindBy(id = "billing_last_name")
    private WebElementFacade billingLastnameField;

    @FindBy(id = "shipping_last_name")
    private WebElementFacade shippingLastnameField;

    @FindBy(id = "billing_address_1")
    private WebElementFacade billingAddressFirstField;

    @FindBy(id = "shipping_address_1")
    private WebElementFacade shippingAddressFirstField;

    @FindBy(id = "billing_city")
    private WebElementFacade billingCityField;

    @FindBy(id = "shipping_city")
    private WebElementFacade shippingCityField;

    @FindBy(id = "billing_state")
    private WebElementFacade billingCountyDropdown;

    @FindBy(id = "billing_postcode")
    private WebElementFacade billingPostcodeField;

    @FindBy(id = "shipping_postcode")
    private WebElementFacade shippingPostcodeField;

    @FindBy(id = "billing_phone")
    private WebElementFacade billingPhoneField;

    @FindBy(id = "billing_email")
    private WebElementFacade billingEmailField;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(id = "createaccount")
    private WebElementFacade createAccountCheckbox;

    @FindBy(id = "account_password")
    private WebElementFacade createPasswordField;

    @FindBy(css = ".showlogin")
    private WebElementFacade loginLink;

    @FindBy(id = "username")
    private WebElementFacade loginUsernameField;

    @FindBy(id = "password")
    private WebElementFacade loginPasswordField;

    @FindBy(css = ".login .button[name='login']")
    private WebElementFacade loginButton;

    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElementFacade orderReceivedSuccessMsg;

    @FindBy(id = "ship-to-different-address-checkbox")
    private WebElementFacade shipToDifferentAddressCheckbox;

    @FindBy(css = ".checkout .woocommerce-error")
    private WebElementFacade checkOutErrorMsg;

    @FindBy(css = ".woocommerce-thankyou-order-details")
    private WebElementFacade orderDetails;

    @FindBy(css = ".woocommerce-order-details")
    private WebElementFacade orderedProductsAndTotal;

    @FindBy(css = ".menu-item-125")
    private WebElementFacade checkOutLink;

    @FindBy(css = ".woocommerce-checkout-review-order-table tbody .cart_item")
    private List<WebElementFacade> listOfItemsInCheckout;

    public void clickOnPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public void clickOnLoginLink() {
        clickOn(loginLink);
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
    }

    public void clickOnCreateAccountCheckbox() {
        clickOn(createAccountCheckbox);
    }

    public void clickOnShippingDifferentAddressCheckbox() {
        scrollToPageTop();
        clickOn(shipToDifferentAddressCheckbox);
    }

    public void setBillingFirstNameField(String firstName) {
        typeInto(billingFirstNameField, firstName);
    }

    public void setShippingFirstNameField(String firstName) {
        typeInto(shippingFirstNameField, firstName);
    }

    public void setBillingLastnameField(String lastName) {
        typeInto(billingLastnameField, lastName);
    }

    public void setShippingLastnameField(String lastName) {
        typeInto(shippingLastnameField, lastName);
    }

    public void setBillingAddressFirstField(String address) {
        typeInto(billingAddressFirstField, address);
    }

    public void setShippingAddressFirstField(String address) {
        typeInto(shippingAddressFirstField, address);
    }

    public void setBillingCityField(String city) {
        typeInto(billingCityField, city);
    }

    public void setShippingCityField(String city) {
        typeInto(shippingCityField, city);
    }

    public void setBillingPostcodeField(String postcode) {
        typeInto(billingPostcodeField, postcode);
    }

    public void setShippingPostcodeField(String postcode) {
        typeInto(shippingPostcodeField, postcode);
    }

    public void setBillingPhoneField(String phoneNumber) {
        typeInto(billingPhoneField, phoneNumber);
    }

    public void setBillingEmailField(String email) {
        typeInto(billingEmailField, email);
    }

    public void setNewPasswordField(String password) {
        typeInto(createPasswordField, password);
    }

    public void setLoginUsername(String username) {
        typeInto(loginUsernameField, username);
    }

    public void setLoginPasswordField(String password) {
        typeInto(loginPasswordField, password);
    }

    public boolean checkOutErrorMsgIsPresent() {
        return checkOutErrorMsg.isPresent();
    }

    public boolean orderReceivedMsgIsPresent() {
        try {
            withTimeoutOf(Duration.ofSeconds(8)).waitFor(orderReceivedSuccessMsg);
            return true;
        } catch (org.openqa.selenium.TimeoutException error) {
            return false;
        }
    }

    public boolean errorMsgContainTheInvalidPhoneMsg() {
        return checkOutErrorMsg.containsText("Billing Phone is not a valid phone number");
    }

    public boolean errorMsgContainTheInvalidEmailMsg() {
        return checkOutErrorMsg.containsText("Billing Email address is not a valid email address");
    }

    public boolean errorMsgContainTheFieldIsRequired() {
        return checkOutErrorMsg.containsText("is a required field");
    }

    public boolean orderDetailContainsOrderNumber() {
        return orderDetails.findElement(By.cssSelector(".order")).isDisplayed();
    }

    public boolean orderDetailContainsOrderDate() {
        return orderDetails.findElement(By.cssSelector(".date")).isDisplayed();
    }

    public boolean orderDetailContainsOrderTotalPrice() {
        return orderDetails.findElement(By.cssSelector(".total")).isDisplayed();
    }

    public boolean orderDetailContainsOrderPaymentMethod() {
        return orderDetails.findElement(By.cssSelector(".method")).isDisplayed();
    }

    public boolean orderCartDetailsIsPresent() {
        return orderedProductsAndTotal.isPresent();
    }

    public List<String> getCheckOutItemList() {
        clickOn(checkOutLink);
        List<String> listWithProductNames = new ArrayList<>();

        for (WebElementFacade elementFacade : listOfItemsInCheckout) {
            listWithProductNames.add(elementFacade.findBy(".product-name:not(.product-quantity)").getText());
        }

        return listWithProductNames;
    }

    public String getOrderNumber() {
        return find(By.cssSelector(".woocommerce-order-overview__order strong")).getText();
    }
}

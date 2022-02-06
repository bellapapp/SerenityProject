package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckOutSteps extends BaseSteps{

    @Step
    public void navigateToCheckOut() {
        homePage.clickOnCheckOutLink();
    }

    @Step
    public void clickOnCreateAccountCheckbox() {
        checkOutPage.clickOnCreateAccountCheckbox();
    }

    @Step
    public void clickOnPlaceOrderButton() {
        checkOutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void clickOnLoginLink() {
        checkOutPage.clickOnLoginLink();
    }

    @Step
    public void clickOnLoginButton() {
        checkOutPage.clickOnLoginButton();
    }

    @Step
    public void setBillingFirstNameField(String firstName) {
        checkOutPage.setBillingFirstNameField(firstName);
    }

    @Step
    public void setShippingFirstNameField(String firstName) {
        checkOutPage.setShippingFirstNameField(firstName);
    }

    @Step
    public void setBillingLastNameField(String lastName) {
        checkOutPage.setBillingLastnameField(lastName);
    }

    @Step
    public void setShippingLastNameField(String lastName) {
        checkOutPage.setShippingLastnameField(lastName);
    }

    @Step
    public void setBillingAddressFirstField(String address) {
        checkOutPage.setBillingAddressFirstField(address);
    }

    @Step
    public void setShippingAddressFirstField(String address) {
        checkOutPage.setShippingAddressFirstField(address);
    }

    @Step
    public void setBillingCityField(String city) {
        checkOutPage.setBillingCityField(city);
    }

    @Step
    public void setShippingCityField(String city) {
        checkOutPage.setShippingCityField(city);
    }

    @Step
    public void setBillingPostcodeField(String postcode) {
        checkOutPage.setBillingPostcodeField(postcode);
    }

    @Step
    public void setShippingPostcodeField(String postcode) {
        checkOutPage.setShippingPostcodeField(postcode);
    }

    @Step
    public void setBillingPhoneField(String phoneNumber) {
        checkOutPage.setBillingPhoneField(phoneNumber);
    }

    @Step
    public void setBillingEmailField(String email) {
        checkOutPage.setBillingEmailField(email);
    }

    @Step
    public void setCreatePasswordField(String password) {
        checkOutPage.setNewPasswordField(password);
    }

    @Step
    public void setLoginUsernameField(String username) {
        checkOutPage.setLoginUsername(username);
    }

    @Step
    public void setLoginPasswordField(String password) {
        checkOutPage.setLoginPasswordField(password);
    }

    @Step
    public String getOrderNumber() {
        return checkOutPage.getOrderNumber();
    }

    @Step
    public void checkShipToDifferentAddress() {
        checkOutPage.clickOnShippingDifferentAddressCheckbox();
    }

    @Step
    public void checkOrderReceivedMessageIsNotPresent() {
        Assert.assertFalse("The order received confirmation is present.",
                checkOutPage.orderReceivedMsgIsPresent());
    }

    @Step
    public void checkOrderReceivedMessageIsPresent() {
        Assert.assertTrue("The order received confirmation is not present.",
                checkOutPage.orderReceivedMsgIsPresent());
    }

    @Step
    public void checkOutErrorMsgIsPresent() {
        Assert.assertTrue("The checkout Error message is not present.",
                checkOutPage.checkOutErrorMsgIsPresent());
    }

    @Step
    public void checkErrorMsgContainTheInvalidPhoneMsg() {
        Assert.assertTrue("The error message doesn't contain 'Billing Phone is not a valid phone number'.",
                checkOutPage.errorMsgContainTheInvalidPhoneMsg());
    }

    @Step
    public void checkErrorMsgContainTheInvalidEmailMsg() {
        Assert.assertTrue("The error message doesn't contain 'Billing Email address is not a valid email address'.",
                checkOutPage.errorMsgContainTheInvalidEmailMsg());
    }

    @Step
    public void checkErrorMsgContainTheFieldIsRequiredMsg() {
        Assert.assertTrue("The error message doesn't contain 'is a required field'.",
                checkOutPage.errorMsgContainTheFieldIsRequired());
    }

    @Step
    public void checkOrderDetailContainsOrderNumber() {
        Assert.assertTrue("The order details doesn't contain the Order number.",
                checkOutPage.orderDetailContainsOrderNumber());
    }

    @Step
    public void checkOrderDetailContainsOrderDate() {
        Assert.assertTrue("The order details doesn't contain the Order date.",
                checkOutPage.orderDetailContainsOrderDate());
    }

    @Step
    public void checkOrderDetailContainsOrderTotalPrice() {
        Assert.assertTrue("The order details doesn't contain the Order Total Price.",
                checkOutPage.orderDetailContainsOrderTotalPrice());
    }

    @Step
    public void checkOrderDetailContainsOrderPaymentMethod() {
        Assert.assertTrue("The order details doesn't contain the Payment method.",
                checkOutPage.orderDetailContainsOrderPaymentMethod());
    }

    @Step
    public void checkTheFinishedOrderDetailsIsPresent() {
        Assert.assertTrue("The order details are not present.",
                checkOutPage.orderCartDetailsIsPresent());
    }

    @Step
    public void checkTheCartItemAreEqualsWithChekOutItems(String value) {
        waitABit(3000);
        Assert.assertEquals("The two lists are not equals.",
                cartPage.getCartItemListToCompareWithCheckOutItemList(value), checkOutPage.getCheckOutItemList());
    }
}

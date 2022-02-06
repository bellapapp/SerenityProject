package fasttrackit.tests;
import fasttrackit.utils.EnvConstants;
import org.junit.Test;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class CheckOutTest extends BaseTest {

    @Test
    public void validCheckOutWithAnonymousUser() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(6) + EnvConstants.VALID_EMAIL_FORMAT);

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsPresent();
    }

    @Test
    public void validCheckOutWithRegister() {
        String user = randomAlphanumeric(6);
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(user + EnvConstants.VALID_EMAIL_FORMAT);

        checkOutSteps.clickOnCreateAccountCheckbox();
        checkOutSteps.setCreatePasswordField(randomAlphanumeric(12));

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsPresent();
        loginSteps.navigateToMyAccount();
        loginSteps.checkUserIsLoggedIn();
        loginSteps.checkMyAccountHelloMessageContent(user);
    }

    @Test
    public void validCheckOutWithLoginFromTheCheckOutPage() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();
        checkOutSteps.clickOnLoginLink();
        checkOutSteps.setLoginUsernameField(EnvConstants.VALID_LOGIN_USERNAME);
        checkOutSteps.setLoginPasswordField(EnvConstants.VALID_LOGIN_PASSWORD);
        checkOutSteps.clickOnLoginButton();

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsPresent();
        loginSteps.navigateToMyAccount();
        loginSteps.checkUserIsLoggedIn();
        loginSteps.checkMyAccountHelloMessageContent(EnvConstants.VALID_LOGIN_USERNAME);
    }

    @Test
    public void invalidCheckOutWithAnEmptyBillingRequiredField() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(6) + EnvConstants.VALID_EMAIL_FORMAT);

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsNotPresent();
        checkOutSteps.checkOutErrorMsgIsPresent();
        checkOutSteps.checkErrorMsgContainTheFieldIsRequiredMsg();
    }

    @Test
    public void invalidCheckOutWithWithInvalidPhoneNumber() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.INVALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(6) + EnvConstants.VALID_EMAIL_FORMAT);

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsNotPresent();
        checkOutSteps.checkOutErrorMsgIsPresent();
        checkOutSteps.checkErrorMsgContainTheInvalidPhoneMsg();
    }

    @Test
    public void invalidCheckOutWithWithInvalidEmail() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(5) + EnvConstants.INVALID_EMAIL_FORMAT);

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsNotPresent();
        checkOutSteps.checkOutErrorMsgIsPresent();
        checkOutSteps.checkErrorMsgContainTheInvalidEmailMsg();
    }

    @Test
    public void validCheckOutWithDifferentShippingAddress() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(6) + EnvConstants.VALID_EMAIL_FORMAT);
        checkOutSteps.checkShipToDifferentAddress();

        checkOutSteps.setShippingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setShippingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setShippingAddressFirstField(EnvConstants.CHECKOUT_SHIPPING_ADDRESS);
        checkOutSteps.setShippingCityField(EnvConstants.CHECKOUT_SHIPPING_CITY);
        checkOutSteps.setShippingPostcodeField(EnvConstants.CHECKOUT_SHIPPING_POSTCODE);
        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsPresent();
    }

    @Test
    public void inValidCheckOutWithAnEmptyRequiredFieldFromShippingAddress() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(6) + EnvConstants.VALID_EMAIL_FORMAT);

        checkOutSteps.checkShipToDifferentAddress();
        checkOutSteps.setShippingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setShippingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setShippingCityField(EnvConstants.CHECKOUT_SHIPPING_CITY);
        checkOutSteps.setShippingPostcodeField(EnvConstants.CHECKOUT_SHIPPING_POSTCODE);
        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOutErrorMsgIsPresent();
        checkOutSteps.checkErrorMsgContainTheFieldIsRequiredMsg();
        checkOutSteps.checkOrderReceivedMessageIsNotPresent();
    }

    @Test
    public void checkTheCartItemsAndQuantitiesAreEqualsWithTheCheckOutListOfItems() {
        String modifyQtyToString = "1";

        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_BEANIE);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_BEANIE);
        cartSteps.modifyQtyInCartByProductName(EnvConstants.SEARCH_T_SHIRT, modifyQtyToString);
        cartSteps.modifyQtyInCartByProductName(EnvConstants.SEARCH_BEANIE, modifyQtyToString);
        cartSteps.checkTheQtyWasModified(EnvConstants.SEARCH_T_SHIRT, modifyQtyToString);
        cartSteps.checkTheQtyWasModified(EnvConstants.SEARCH_BEANIE, modifyQtyToString);
        checkOutSteps.checkTheCartItemAreEqualsWithChekOutItems(modifyQtyToString);
    }

    @Test
    public void verifyValidCheckoutContainsAllOrderDetails() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        checkOutSteps.navigateToCheckOut();

        checkOutSteps.setBillingFirstNameField(EnvConstants.CHECKOUT_FIRST_NAME);
        checkOutSteps.setBillingLastNameField(EnvConstants.CHECKOUT_LAST_NAME);
        checkOutSteps.setBillingAddressFirstField(EnvConstants.CHECKOUT_BILLING_ADDRESS);
        checkOutSteps.setBillingCityField(EnvConstants.CHECKOUT_BILLING_CITY);
        checkOutSteps.setBillingPostcodeField(EnvConstants.CHECKOUT_BILLING_POSTCODE);
        checkOutSteps.setBillingPhoneField(EnvConstants.VALID_CHECKOUT_PHONE_NUMBER);
        checkOutSteps.setBillingEmailField(randomAlphanumeric(6) + EnvConstants.VALID_EMAIL_FORMAT);

        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsPresent();
        checkOutSteps.checkOrderDetailContainsOrderNumber();
        checkOutSteps.checkOrderDetailContainsOrderDate();
        checkOutSteps.checkOrderDetailContainsOrderTotalPrice();
        checkOutSteps.checkOrderDetailContainsOrderPaymentMethod();
        checkOutSteps.checkTheFinishedOrderDetailsIsPresent();
    }
}

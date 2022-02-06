package fasttrackit.tests;

import fasttrackit.utils.EnvConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class AdminTest extends BaseTest{

    @Test
    public void addNewProduct() {
        String productName = "Annabella_Product_" + RandomStringUtils.randomAlphabetic(8);
        String productPrice = "25";

        navigateToAdminInterface();
        adminSteps.doLogin(EnvConstants.VALID_ADMIN_USERNAME, EnvConstants.VALID_ADMIN_PASSWORD);
        adminSteps.checkAdminIsLoggedIn();
        adminSteps.navigateToProductsMenu();
        adminSteps.clickOnAddNewProductSubmenu();
        adminSteps.setProductName(productName);
        adminSteps.selectFromDropdowns(EnvConstants.SIMPLE_PRODUCT_DROPDOWN_TEXT, EnvConstants.TAXABLE_DROPDOWN_TEXT, EnvConstants.STANDARD_DROPDOWN_TEXT);
        adminSteps.setProductPrice(productPrice);
        adminSteps.setStockStatus(EnvConstants.IN_STOCK_DROPDOWN_TEXT);
        adminSteps.clickOnPublishButton();
        adminSteps.clickOnUserInterfaceSymbol();
        searchSteps.executeSearch(productName);
        searchSteps.checkTheProduct(productName);
    }

    @Test
    public void addNewPost() {
        String postTitle = "Annabella_Post_" + RandomStringUtils.randomAlphabetic(8);

        navigateToAdminInterface();
        adminSteps.doLogin(EnvConstants.VALID_ADMIN_USERNAME, EnvConstants.VALID_ADMIN_PASSWORD);
        adminSteps.checkAdminIsLoggedIn();
        adminSteps.navigateToPostMenu();
        adminSteps.clickOnAddNewPostSubmenu();
        adminSteps.setPostTitle(postTitle);
        adminSteps.setPostText(RandomStringUtils.randomAlphabetic(25));
        adminSteps.clickOnUncategorizedCheckBox();
        adminSteps.clickOnPublishButton();
        adminSteps.clickOnUserInterfaceSymbol();
        adminSteps.navigateToUncategorizedPosts();
        adminSteps.findAndOpenPost(postTitle);
    }

    @Test
    public void addNewCouponCode() {
        String newCouponCode = RandomStringUtils.randomAlphabetic(10);

        navigateToAdminInterface();
        adminSteps.doLogin(EnvConstants.VALID_ADMIN_USERNAME, EnvConstants.VALID_ADMIN_PASSWORD);
        adminSteps.checkAdminIsLoggedIn();
        adminSteps.navigateToWooCommerceMenu();
        adminSteps.clickOnCouponsSubmenu();
        adminSteps.clickOnAddNewCouponButton();
        adminSteps.setCouponName(newCouponCode);
        adminSteps.selectDiscountType(EnvConstants.PERCENTAGE_DISCOUNT_TYPE);
        adminSteps.setCouponAmount("25");
        adminSteps.clickOnPublishButton();
        adminSteps.clickOnUserInterfaceSymbol();
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(newCouponCode);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        cartSteps.emptyAllItemsFromCart();
    }

    @Test
    public void checkOrderIsReceivedOnAdminInterface() {
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
        String orderNumber = checkOutSteps.getOrderNumber();
        navigateToAdminInterface();
        adminSteps.doLogin(EnvConstants.VALID_ADMIN_USERNAME, EnvConstants.VALID_ADMIN_PASSWORD);
        adminSteps.navigateToWooCommerceMenu();
        adminSteps.clickOnOrdersSubmenu();
        adminSteps.executeSearch(orderNumber);
        adminSteps.checkTheOrderExistOnAdminInterface(orderNumber);
    }
}

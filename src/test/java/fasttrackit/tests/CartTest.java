package fasttrackit.tests;

import fasttrackit.utils.EnvConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Test
    public void addToCartFromProductPageLoggedOut() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.checkCommerceMsgIsPresent();
        cartSteps.checkCommerceMsgContainsTheAddedToCartConfirmation();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
    }

    @Test
    public void addToCartFromProductPageLoggedIn() {
        loginSteps.doLogin(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsNotPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.checkCommerceMsgIsPresent();
        cartSteps.checkCommerceMsgContainsTheAddedToCartConfirmation();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.emptyAllItemsFromCart();
    }

    @Test
    public void addToCartFromShopPage() {
        cartSteps.navigateToCart();
        cartSteps.checkTheCartIsEmpty();
        baseSteps.navigateToShop();
        cartSteps.clickOnAddToCartFromShopPageList(0);
        cartSteps.navigateToCart();
        cartSteps.checkTheCartIsNotEmpty();
    }

    @Test
    public void addToCartMoreProducts() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.checkCommerceMsgIsPresent();
        cartSteps.checkCommerceMsgContainsTheAddedToCartConfirmation();
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_BEANIE);
        cartSteps.addToCartFromProductPage();
        cartSteps.checkCommerceMsgIsPresent();
        cartSteps.checkCommerceMsgContainsTheAddedToCartConfirmation();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_BEANIE);

    }

    @Test
    public void addToCartModifiedProductQty() {
        String modifyQtyTo = "5";

        searchSteps.executeSearch(EnvConstants.SEARCH_POLO);
        cartSteps.modifyQty(modifyQtyTo);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_POLO);
        cartSteps.checkTheQtyWasModified(EnvConstants.SEARCH_POLO, modifyQtyTo);
    }

    @Test
    public void tryToAddToCartHigherStockThanExist() {
        searchSteps.executeSearch(EnvConstants.SEARCH_POLO);
        searchSteps.checkTheProduct(EnvConstants.SEARCH_POLO);
        cartSteps.modifyQtyToHigherThanExistInStock();
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.checkTheCartIsEmpty();
    }

    @Test
    public void removeOneProductFromCart() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_BEANIE);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_BEANIE);
        cartSteps.removeProductFromCartByProductName(EnvConstants.SEARCH_BEANIE);
        cartSteps.checkItemRemovedMessageContent();
        cartSteps.verifyTheProductIsNotPresentInTheCart(EnvConstants.SEARCH_BEANIE);
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
    }

    @Test
    public void verifyEmptyCart() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_BEANIE);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_BEANIE);
        cartSteps.emptyAllItemsFromCart();
        cartSteps.checkTheCartIsEmpty();
        cartSteps.checkTheCartIsEmptyConfirmationMsgIsPresent();
    }

    @Test
    public void verifyIfTheProductIsPresentInTheCartAfterRegister() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        registerSteps.doRegister(RandomStringUtils.randomAlphanumeric(5) + EnvConstants.VALID_EMAIL_FORMAT, RandomStringUtils.randomAlphanumeric(12));
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
    }

    @Test
    public void verifyIfTheProductIsPresentInTheCartAfterLogoutAndLoginBack() {
        loginSteps.doLogin(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        cartSteps.verifyTheProductIsNotPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        loginSteps.doLogout();
        loginSteps.doLogin(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.emptyAllItemsFromCart();
        cartSteps.checkTheCartIsEmpty();
    }

    @Test
    public void verifyCartTotalSummaryProducts() {
        baseSteps.navigateToShop();
        cartSteps.clickOnAddToCartFromShopPageList(0);
        cartSteps.clickOnAddToCartFromShopPageList(1);
        cartSteps.clickOnAddToCartFromShopPageList(2);
        cartSteps.navigateToCart();
        cartSteps.checkSubTotalPriceIsCorrect();
        cartSteps.checkOrderTotalPriceIsCorrect();
    }

    @Test
    public void verifyUpdateCartFunction() {
        String modifyQtyTo = "5";

        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.modifyQtyInCartByProductName(EnvConstants.SEARCH_T_SHIRT, modifyQtyTo);
        cartSteps.checkTheQtyWasModified(EnvConstants.SEARCH_T_SHIRT, modifyQtyTo);
        cartSteps.checkCartMessageIsPresent();
        cartSteps.checkCartUpdatedMessageContent();
        cartSteps.checkTotalProductQtyPriceIsCorrect(EnvConstants.SEARCH_T_SHIRT, modifyQtyTo);
    }

    @Test
    public void verifyUndoButtonIsWorking() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.removeProductFromCartByProductName(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.verifyTheProductIsNotPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.clickOnUndoButton();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
    }

    @Test
    public void verifyAfterCheckOutTheCartDoesNotContainTheProduct() {
        loginSteps.doLogin(EnvConstants.VALID_LOGIN_USERNAME, EnvConstants.VALID_LOGIN_PASSWORD);
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
        checkOutSteps.navigateToCheckOut();
        checkOutSteps.clickOnPlaceOrderButton();
        checkOutSteps.checkOrderReceivedMessageIsPresent();
        cartSteps.navigateToCart();
        cartSteps.verifyTheProductIsNotPresentInTheCart(EnvConstants.SEARCH_T_SHIRT);
    }
}

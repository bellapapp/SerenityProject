package fasttrackit.tests;

import fasttrackit.utils.EnvConstants;
import org.junit.Test;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class CouponTest extends BaseTest {

    @Test
    public void checkValidPercentageCouponCodeDiscount() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        couponSteps.checkPercentageDiscountIsCalculatedIsCorrect(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_DISCOUNT);
    }

    @Test
    public void checkValidFixCartAmountCouponCodeDiscount() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_BEANIE);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.VALID_12_FIX_CART_AMOUNT_OFF_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        couponSteps.checkFixCartAmountDiscountIsIsCorrect(EnvConstants.VALID_12_FIX_AMOUNT_OFF_COUPON_CODE_DISCOUNT);
    }

    @Test
    public void checkInValidCouponCodeDiscount() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(randomAlphanumeric(15));
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponDoesNotExistMessageContent();
        couponSteps.checkCouponDiscountIsNotPresent();
    }

    @Test
    public void applyExpiredCouponCodeDiscount() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.EXPIRED_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkExpiredCouponMessageContent();
        couponSteps.checkCouponDiscountIsNotPresent();
        cartSteps.checkOrderTotalPriceIsCorrect();
    }

    @Test
    public void checkGrandTotalIsCalculatedCorrectWithCouponDiscount() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        couponSteps.checkPercentageDiscountIsCalculatedIsCorrect(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_DISCOUNT);
        couponSteps.checkOrderTotalPriceIsCalculatedCorrectWithDiscount();
    }

    @Test
    public void removeCouponCode() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        couponSteps.clickOnRemoveCouponButton();
        couponSteps.checkRemovedCouponMessageContent();
        couponSteps.checkCouponDiscountIsNotPresent();
    }

    @Test
    public void checkIfTheCouponCodeIsPresentAfterEmptyCartAndAddToCart() {
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        cartSteps.removeProductFromCartByProductName(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.checkTheCartIsEmpty();
        couponSteps.checkCouponDiscountIsNotPresent();
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_BEANIE);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.checkCouponDiscountIsPresent();
    }

    @Test
    public void checkIfTheCouponCodeDiscountIsRecalculatedAfterCartUpdate() {
        String modifyQtyTo = "5";
        searchSteps.searchAndSelectProduct(EnvConstants.SEARCH_T_SHIRT);
        cartSteps.addToCartFromProductPage();
        cartSteps.navigateToCart();
        couponSteps.enterCouponCode(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_NAME);
        couponSteps.clickOnApplyCouponButton();
        couponSteps.checkCouponCodeIsAppliedMessageContent();
        couponSteps.checkCouponDiscountIsPresent();
        couponSteps.checkPercentageDiscountIsCalculatedIsCorrect(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_DISCOUNT);
        cartSteps.modifyQtyInCartByProductName(EnvConstants.SEARCH_T_SHIRT, modifyQtyTo);
        cartSteps.checkTheQtyWasModified(EnvConstants.SEARCH_T_SHIRT, modifyQtyTo);
        couponSteps.checkPercentageDiscountIsCalculatedIsCorrect(EnvConstants.VALID_10_PERCENTAGE_COUPON_CODE_DISCOUNT);
    }
}

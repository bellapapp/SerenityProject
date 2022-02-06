package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CouponSteps extends BaseSteps {

    @Step
    public void clickOnApplyCouponButton() {
        cartPage.clickOnApplyCouponButton();
    }

    @Step
    public void clickOnRemoveCouponButton() {
        cartPage.clickOnRemoveCouponButton();
    }

    @Step
    public void enterCouponCode(String couponCode) {
        cartPage.enterCouponCode(couponCode);
    }

    @Step
    public void checkCouponDiscountIsPresent() {
        Assert.assertTrue("The coupon discount is not present.",
                cartPage.couponDiscountIsPresent());
    }

    @Step
    public void checkCouponDiscountIsNotPresent() {
        Assert.assertFalse("The coupon discount is present.",
                cartPage.couponDiscountIsPresent());
    }

    @Step
    public void checkPercentageDiscountIsCalculatedIsCorrect(int percentageDiscount) {
        Assert.assertTrue("The discount is not calculated correct.",
                cartPage.checkPercentageDiscountIsCalculatedIsCorrect(percentageDiscount));
    }

    @Step
    public void checkFixCartAmountDiscountIsIsCorrect(int fixCartDiscount) {
        Assert.assertTrue("The discount is not correct.",
                cartPage.checkFixCartAmountDiscountIsIsCorrect(fixCartDiscount));
    }

    @Step
    public void checkOrderTotalPriceIsCalculatedCorrectWithDiscount() {
        Assert.assertTrue("The order total price is not correct.",
                cartPage.isOrderTotalPriceCorrectAfterValidCouponCode());
    }

    @Step
    public void checkCouponCodeIsAppliedMessageContent() {
        Assert.assertTrue("The cart message doesn't contain 'Coupon code applied successfully'.",
                cartPage.checkCouponCodeIsAppliedMessageContent());
    }

    @Step
    public void checkCouponDoesNotExistMessageContent() {
        Assert.assertTrue("The cart Error message doesn't contain 'does not exist'.",
                cartPage.checkCouponCodeDoesNotExistMessageContent());
    }

    @Step
    public void checkExpiredCouponMessageContent() {
        Assert.assertTrue("The cart Error message doesn't contain 'This coupon has expired.'.",
                cartPage.checkExpiredCouponMessageContent());
    }

    @Step
    public void checkRemovedCouponMessageContent() {
        Assert.assertTrue("The cart message doesn't contain 'Coupon has been removed'.",
                cartPage.checkRemovedCouponMessageContent());
    }
}

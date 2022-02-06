package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps extends BaseSteps {

    @Step
    public void navigateToCart() {
        homePage.clickOnCartIcon();
    }

    @Step
    public void addToCartFromProductPage() {
        productPage.clickOnAddToCart();
    }

    @Step
    public void clickOnAddToCartFromShopPageList(int listIndex) {
        shopPage.clickOnAddToCartFromShopPageFromList(listIndex);
    }

    @Step
    public void clickOnUndoButton() {
        cartPage.clickOnUndoButton();
    }


    @Step
    public void modifyQty(String qty) {
        productPage.modifyQty(qty);
    }

    @Step
    public void modifyQtyToHigherThanExistInStock() {
        productPage.modifyQty(productPage.increaseQty(productPage.getQty()));
    }

    @Step
    public void modifyQtyInCartByProductName(String productName, String quantity) {
        Assert.assertTrue( cartPage.modifyQtyInCartByProductName(productName, quantity));
    }

    @Step
    public void removeProductFromCartByProductName(String productName) {
        Assert.assertTrue(cartPage.removeProductFromCartByProductName(productName));
    }

    @Step
    public void emptyAllItemsFromCart() {
        cartPage.emptyAllItemsFromCart();
    }

    @Step
    public void verifyTheProductIsPresentInTheCart(String product) {
        Assert.assertTrue("The product wasn't found in the cart.",
                cartPage.isTheProductPresentInTheCart(product));
    }

    @Step
    public void verifyTheProductIsNotPresentInTheCart(String product) {
        Assert.assertFalse("The product was found in the cart.",
                cartPage.isTheProductPresentInTheCart(product));
    }

    @Step
    public void checkTheCartIsEmpty() {
        Assert.assertTrue("The cart isn't empty.",
                cartPage.isTheCartEmpty());
    }

    @Step
    public void checkTheCartIsNotEmpty() {
        Assert.assertFalse("The cart is empty.",
                cartPage.isTheCartEmpty());
    }

    @Step
    public void checkTheCartIsEmptyConfirmationMsgIsPresent() {
        Assert.assertTrue("The cart is empty message isn't present.",
                cartPage.cartIsEmptyMessageIsPresent());
    }

    @Step
    public void checkCartMessageIsPresent() {
        Assert.assertTrue("The cart message wasn't present",
                cartPage.cartSuccessMessageIsPresent());
    }

    @Step
    public void checkCommerceMsgIsPresent() {
        Assert.assertTrue("The commerce message wasn't present.",
                productPage.commerceMsgIsPresent());
    }

    @Step
    public void checkItemRemovedMessageContent() {
        Assert.assertTrue("The confirmation message doesn't contain the 'removed' word.",
                cartPage.checkTheCartMsgContainsTheRemovedWord());
    }

    @Step
    public void checkCartUpdatedMessageContent() {
        Assert.assertTrue("The confirmation message doesn't contain the 'updated' word.",
                cartPage.checkTheCartMsgContainsTheUpdatedWord());
    }

    @Step
    public void checkSubTotalPriceIsCorrect() {
        Assert.assertTrue("The subtotal price is not correct.",
                cartPage.isSubtotalPriceCorrect());
    }

    @Step
    public void checkOrderTotalPriceIsCorrect() {
        Assert.assertTrue("Total Order Total price not correct.",
                cartPage.isOrderTotalPriceCorrectWithShippingFee());
    }

    @Step
    public void checkTheQtyWasModified(String productName, String quantity) {
        Assert.assertTrue("The quantity of the product has not been changed to the introduced quantity.",
                cartPage.checkTheInitialQtyWithTheModifiedQty(productName, quantity));
    }

    @Step
    public void checkTotalProductQtyPriceIsCorrect(String productName, String quantity) {
        Assert.assertTrue("The product qty multiplication with product price is not correct.",
                cartPage.checkProductMultiplicationWithQtySubtotalPriceIsCorrect(productName, quantity));
    }

    @Step
    public void checkCommerceMsgContainsTheAddedToCartConfirmation() {
        Assert.assertTrue("The message to confirm the product was added to the cart isn't displayed.",
                productPage.commerceMsgContainsTheAddedToCartConfirmation());
    }
}

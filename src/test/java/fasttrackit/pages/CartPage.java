package fasttrackit.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".cart-empty")
    private WebElementFacade cartIsEmptyMessage;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade cartErrorMessage;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade cartSuccessMessage;

    @FindBy(css = ".cart-subtotal .amount")
    private WebElementFacade cartOrderSubTotalPrice;

    @FindBy(css = ".shipping .amount")
    private WebElementFacade shippingPrice;

    @FindBy(css = ".order-total .amount")
    private WebElementFacade cartOrderTotalPrice;

    @FindBy(css = ".quantity .input-text")
    private WebElementFacade cartItemQty;

    @FindBy(css = ".actions [name='update_cart']")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".restore-item")
    private WebElementFacade undoButton;

    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartIcon;

    @FindBy(id = "coupon_code")
    private WebElementFacade couponCodeField;

    @FindBy(css = ".coupon .button")
    private WebElementFacade applyCouponButton;

    @FindBy(css = ".cart-discount .amount")
    private WebElementFacade couponDiscount;

    @FindBy(css = ".woocommerce-remove-coupon")
    private WebElementFacade removeCouponButton;

    @FindBy(css = ".woocommerce-cart-form__contents tbody .cart_item")
    private List<WebElementFacade> listOfCartItems;

    @FindBy(css = "tr.cart_item .product-subtotal .amount")
    private List<WebElementFacade> listOfSubtotalPrices;

    public void clickOnUndoButton() {
        clickOn(undoButton);
    }

    public void clickOnApplyCouponButton() {
        clickOn(applyCouponButton);
    }

    public void clickOnRemoveCouponButton() {
        clickOn(removeCouponButton);
    }

    public void enterCouponCode(String couponCode) {
        typeInto(couponCodeField, couponCode);
    }

    public void emptyAllItemsFromCart() {

        while (find(("tbody tr.cart_item:first-child .product-remove a")).isPresent()) {
            find(By.cssSelector("tbody tr.cart_item:first-child .product-remove a")).click();
            waitABit(5000);
        }
    }

    public boolean removeProductFromCartByProductName(String productName) {
        for (WebElementFacade element : listOfCartItems) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                element.findElement(By.cssSelector(".product-remove a")).click();
                return true;
            }
        }
        return false;
    }

    public boolean modifyQtyInCartByProductName(String productName, String quantity) {
        for (WebElementFacade element : listOfCartItems) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                element.findElement(By.cssSelector(".quantity input")).clear();
                element.findElement(By.cssSelector(".quantity input")).sendKeys(quantity);
                clickOn(updateCartButton);
                waitABit(3000);
                return true;
            }
        }
        return false;
    }

    public boolean isTheProductPresentInTheCart(String productName) {
        for (WebElementFacade element : listOfCartItems) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTheCartEmpty() {
        waitABit(3000);
        if (listOfCartItems.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean cartIsEmptyMessageIsPresent() {
        return cartIsEmptyMessage.isPresent();
    }

    public boolean cartSuccessMessageIsPresent() {
        return cartSuccessMessage.isPresent();
    }

    public boolean couponDiscountIsPresent() {
        return couponDiscount.isPresent();
    }

    public boolean checkCouponCodeIsAppliedMessageContent() {
        waitFor(cartSuccessMessage);
        return cartSuccessMessage.containsText("Coupon code applied successfully");
    }

    public boolean checkCouponCodeDoesNotExistMessageContent() {
        waitFor(cartErrorMessage);
        return cartErrorMessage.containsText("does not exist");
    }

    public boolean checkExpiredCouponMessageContent() {
        waitFor(cartErrorMessage);
        return cartErrorMessage.containsText("This coupon has expired");
    }

    public boolean checkRemovedCouponMessageContent() {
        waitFor(cartSuccessMessage);
        return cartSuccessMessage.containsText("Coupon has been removed");
    }

    public boolean checkTheCartMsgContainsTheRemovedWord() {
        return cartSuccessMessage.containsText("removed");
    }

    public boolean checkTheCartMsgContainsTheUpdatedWord() {
        return cartSuccessMessage.containsText("updated");
    }

    public boolean checkPercentageDiscountIsCalculatedIsCorrect(int percentageDiscount) {
        return getIntFromPrice(couponDiscount.getText()) == (getIntFromPrice(cartOrderSubTotalPrice.getText()) * percentageDiscount/100);
    }

    public boolean checkFixCartAmountDiscountIsIsCorrect(int fixCartDiscount) {
        return (getIntFromPrice(couponDiscount.getText())) == fixCartDiscount * 100;
    }


    public int getProductPrice(String productName) {
        int price = 0;
        for (WebElementFacade element : listOfCartItems) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                price = getIntFromPrice(element.findElement(By.cssSelector(".product-price .amount")).getText());
                break;
            }
        }
        return price;
    }

    public String getQtyValueFromProduct(String productName) {
        String value = "";
        for (WebElementFacade element : listOfCartItems) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                value = element.findElement(By.cssSelector(".quantity input")).getAttribute("value");
                break;
            }
        }
        return value;
    }

    public int getProductMultiplicationQtyPrice(String productName) {
        int price = 0;
        for (WebElementFacade element : listOfCartItems) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                price = getIntFromPrice(element.findElement(By.cssSelector(".product-subtotal .amount")).getText());
                break;
            }
        }
        return price;
    }

    public int getSubTotalPriceCalculated() {
        int sum = 0;
        for (WebElementFacade element : listOfSubtotalPrices) {
            sum = sum + getIntFromPrice(element.getText());
        }
        return sum;
    }

    public boolean isSubtotalPriceCorrect() {
        return getSubTotalPriceCalculated() == getIntFromPrice(cartOrderSubTotalPrice.getText());
    }

    public int getSubtotalPriceWithShippingFee() {
        String ifShipTax = "0";

        if (shippingPrice.isPresent()) {
            ifShipTax = shippingPrice.getText();
        }
        return getIntFromPrice(cartOrderSubTotalPrice.getText()) + getIntFromPrice(ifShipTax);
    }

    public boolean isOrderTotalPriceCorrectWithShippingFee() {
        return getSubtotalPriceWithShippingFee() == getIntFromPrice(cartOrderTotalPrice.getText());
    }

    public int getSubtotalPriceWithShippingFeeAndDiscount() {
        return getSubtotalPriceWithShippingFee() - getIntFromPrice(couponDiscount.getText());
    }

    public boolean isOrderTotalPriceCorrectAfterValidCouponCode() {
        return getSubtotalPriceWithShippingFeeAndDiscount() == getIntFromPrice(cartOrderTotalPrice.getText());
    }

    public boolean checkProductMultiplicationWithQtySubtotalPriceIsCorrect(String productName, String quantity) {
        return getIntFromPrice(quantity) * getProductPrice(productName) == getProductMultiplicationQtyPrice(productName);
    }

    public boolean checkTheInitialQtyWithTheModifiedQty(String productName, String quantity) {
        return getQtyValueFromProduct(productName).equals(quantity);
    }

    public List<String> getCartItemListToCompareWithCheckOutItemList(String value) {
        clickOn(cartIcon);
        List<String> listWithProductNames = new ArrayList<>();

        for (WebElementFacade elementFacade : listOfCartItems) {
            listWithProductNames.add(elementFacade.findBy(".product-name a").getText() + "  × " + value);
        }
        return listWithProductNames;
    }
}







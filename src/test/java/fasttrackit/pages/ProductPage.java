package fasttrackit.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade commerceMsg;

    @FindBy(css = ".in-stock")
    private WebElementFacade stockElement;

    @FindBy(css = ".quantity .input-text")
    private WebElementFacade qtyField;

    @FindBy(css = ".product_title")
    private WebElementFacade productTitle;

    public void clickOnAddToCart() {
        clickOn(addToCartButton);
    }

    public int getQty() {
        String Qty = stockElement.getText();
        return getIntFromQty(Qty);
    }

    public String increaseQty(int intQty){
        return String.valueOf(intQty + 1);
    }

    public void modifyQty(String qty) {
        typeInto(qtyField, qty);
    }

    public boolean foundTheProduct() {
        return productTitle.isPresent();
    }

    public boolean productTitleMatches(String productName) {
        return productTitle.getText().equalsIgnoreCase(productName);
    }

    public boolean commerceMsgContainsTheAddedToCartConfirmation() {
        return commerceMsg.containsText("has been added to your cart");
    }

    public boolean commerceMsgIsPresent() {
        return commerceMsg.isPresent();
    }
}

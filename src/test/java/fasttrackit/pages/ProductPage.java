package fasttrackit.pages;

import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {

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

    @FindBy(css = "#review_form .stars .star-5")
    private WebElementFacade fiveStarsReview;

    @FindBy(css = "#review_form #comment")
    private WebElementFacade commentForm;

    @FindBy(css = "#review_form #author")
    private WebElementFacade nameForm;

    @FindBy(css = "#review_form #email")
    private WebElementFacade emailForm;

    @FindBy(css = "#review_form .form-submit #submit")
    private WebElementFacade submitButton;

    @FindBy(css = "#comments .commentlist li")
    private List<WebElementFacade> commentsList;

    public void clickOnFiveStars() {
        clickOn(fiveStarsReview);
    }

    public void clickOnAddToCart() {
        clickOn(addToCartButton);
    }

    public void clickOnReviewSubmitButton() {
        clickOn(submitButton);
        waitABit(3000);
    }

    public int getQty() {
        String Qty = stockElement.getText();
        return getIntFromQty(Qty);
    }

    public String increaseQty(int intQty) {
        return String.valueOf(intQty + 1);
    }

    public void modifyQty(String qty) {
        typeInto(qtyField, qty);
    }

    public void setReviewCommentForm(String comment) {
        typeInto(commentForm, comment);
    }

    public void setReviewNameForm(String name) {
        typeInto(nameForm, name);
    }

    public void setReviewEmailForm(String email) {
        typeInto(emailForm, email);
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

    public boolean findTheComment(String comment) {
        for (WebElementFacade elementFacade : commentsList) {
            if (elementFacade.findElement(By.cssSelector(".comment-text .description p")).getText().equalsIgnoreCase(comment))
                return true;
        }
        return false;
    }

    public boolean handleAlert() {
        return getDriver().switchTo().alert().getText().equalsIgnoreCase("Please select a rating");
    }

}
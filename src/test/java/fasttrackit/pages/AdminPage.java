package fasttrackit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AdminPage extends PageObject {

    @FindBy(id = "user_login")
    private WebElementFacade loginAdminUsernameField;

    @FindBy(id = "user_pass")
    private WebElementFacade loginAdminPasswordField;

    @FindBy(id = "wp-submit")
    private WebElementFacade loginButton;

    @FindBy(css = ".welcome-panel")
    private WebElementFacade welcomePanel;

    @FindBy(css = "#menu-posts-product .menu-top")
    private WebElementFacade productsMenu;

    @FindBy(css = "#menu-posts .menu-top")
    private WebElementFacade postsMenu;

    @FindBy(css = "#toplevel_page_woocommerce .menu-top")
    private WebElementFacade wooCommerceMenu;

    @FindBy(css = "#menu-posts-product a[href*='post-new']")
    private WebElementFacade addNewProductSubmenu;

    @FindBy(css = "#menu-posts a[href*='post-new']")
    private WebElementFacade addNewPostSubmenu;

    @FindBy(css = "#toplevel_page_woocommerce a[href*='coupon']")
    private WebElementFacade couponsSubMenu;

    @FindBy(css = "#toplevel_page_woocommerce a[href*='shop_order'].current")
    private WebElementFacade ordersSubmenu;

    @FindBy(css = ".wrap .page-title-action")
    private WebElementFacade addNewCouponButton;

    @FindBy(id = "title")
    private WebElementFacade titleField;

    @FindBy(id = "product-type")
    private WebElementFacade productTypeDropdown;

    @FindBy(id = "_tax_status")
    private WebElementFacade taxStatusDropdown;

    @FindBy(id = "_tax_class")
    private WebElementFacade taxClassDropdown;

    @FindBy(id = "_regular_price")
    private WebElementFacade priceField;

    @FindBy(css = ".inventory_options a")
    private WebElementFacade inventorySubmenu;

    @FindBy(id = "_stock_status")
    private WebElementFacade stockStatusDropdown;

    @FindBy(id = "publish")
    private WebElementFacade publishButton;

    @FindBy(css = ".postarea.wp-editor-expand .wp-editor-area")
    private WebElementFacade postTextField;

    @FindBy(id = "in-category-1")
    private WebElementFacade unCategorizedCheckBox;

    @FindBy(css = "#wp-admin-bar-root-default #wp-admin-bar-site-name > a")
    private WebElementFacade userInterfaceSiteButton;

    @FindBy(id = "discount_type")
    private WebElementFacade discountTypeDropdown;

    @FindBy(id = "coupon_amount")
    private WebElementFacade couponAmountField;

    @FindBy(id = "post-search-input")
    private WebElementFacade searchField;

    @FindBy(css = "#the-list tr .order_number .order-view")
    private List<WebElementFacade> listOfOrders;


    public void clickOnLoginButton() {
        clickOn(loginButton);
    }

    public void clickOnProductsMenu() {
        clickOn(productsMenu);
    }

    public void clickOnAddNewProduct() {
        clickOn(addNewProductSubmenu);
    }

    public void clickOnPostsMenu() {
        clickOn(postsMenu);
    }

    public void clickOnAddNewPost() {
        clickOn(addNewPostSubmenu);
    }

    public void clickOnWooCommerceMenu() {
        clickOn(wooCommerceMenu);
    }

    public void clickOnCouponSubmenu() {
        clickOn(couponsSubMenu);
    }

    public void clickOnOrdersSubmenu() {
        clickOn(ordersSubmenu);
    }

    public void clickOnAddNewCoupon() {
        clickOn(addNewCouponButton);
    }

    public void clickOnInventorySubmenu() {
        clickOn(inventorySubmenu);
    }

    public void clickOnPublishButton() {
        clickOn(publishButton);
        waitABit(3000);
    }

    public void setTitle(String title) {
        typeInto(titleField, title);
    }

    public void clickOnUncategorizedCheckBox() {
        clickOn(unCategorizedCheckBox);
    }

    public void clickOnUserInterfaceButton() {
        clickOn(userInterfaceSiteButton);
    }

    public void setLoginUsernameField(String username) {
        typeInto(loginAdminUsernameField, username);
    }

    public void setLoginPasswordField(String password) {
        typeInto(loginAdminPasswordField, password);
    }

    public void setProductPrice(String price) {
        typeInto(priceField, price);
    }

    public void setPostTextField(String text) {
        typeInto(postTextField, text);
    }

    public void setCouponAmountField(String couponAmount) {
        typeInto(couponAmountField, couponAmount);
    }

    public void setSearchField(String keyword) {
        typeInto(searchField, keyword);
    }

    public void selectFromProductDataDropdown(String select) {
        productTypeDropdown.selectByVisibleText(select);
    }

    public void selectTFromTaxStatus(String select) {
        taxStatusDropdown.selectByVisibleText(select);
    }

    public void selectFromTaxClass(String select) {
        taxClassDropdown.selectByVisibleText(select);
    }

    public void selectStockStatus(String status) {
        stockStatusDropdown.selectByVisibleText(status);
    }

    public void selectDiscountType(String discountType) {
        discountTypeDropdown.selectByVisibleText(discountType);
    }

    public boolean checkAdminIsLoggedIn() {
        return welcomePanel.isPresent();
    }

    public boolean isTheOrderFound(String orderNumber) {
        waitFor(listOfOrders.get(0));
        for(WebElementFacade elementFacade : listOfOrders) {
            if (elementFacade.getText().contains(orderNumber)){
                clickOn(elementFacade);
                return true;
            }
        }
        return false;
    }
}

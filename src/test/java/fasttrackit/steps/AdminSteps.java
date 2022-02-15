package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class AdminSteps extends BaseSteps {

    @Step
    public void navigateToProductsMenu() {
        adminPage.clickOnProductsMenu();
    }

    @Step
    public void clickOnAddNewProductSubmenu() {
        adminPage.clickOnAddNewProduct();
    }

    @Step
    public void navigateToPostMenu() {
        adminPage.clickOnPostsMenu();
    }

    @Step
    public void clickOnAddNewPostSubmenu() {
        adminPage.clickOnAddNewPost();
    }

    @Step
    public void navigateToWooCommerceMenu() {
        adminPage.clickOnWooCommerceMenu();
    }

    @Step
    public void clickOnCouponsSubmenu() {
        adminPage.clickOnCouponSubmenu();
    }

    @Step
    public void clickOnAddNewCouponButton() {
        adminPage.clickOnAddNewCoupon();
    }

    @Step
    public void clickOnOrdersSubmenu() {
        adminPage.clickOnOrdersSubmenu();
    }

    @Step
    public void clickOnUncategorizedCheckBox() {
        adminPage.clickOnUncategorizedCheckBox();
    }

    @Step
    public void navigateToUncategorizedPosts() {
        homePage.clickOnUncategorizedPosts();
    }

    @Step
    public void clickOnPublishButton() {
        adminPage.clickOnPublishButton();
    }

    @Step
    public void clickOnUserInterfaceSymbol() {
        adminPage.clickOnUserInterfaceButton();
    }


    @Step
    public void doLogin(String userName, String password) {
        adminPage.setLoginUsernameField(userName);
        adminPage.setLoginPasswordField(password);
        adminPage.clickOnLoginButton();
    }

    @Step
    public void setProductName(String name) {
        adminPage.setTitle(name);
    }

    @Step
    public void setProductPrice(String price) {
        adminPage.setProductPrice(price);
    }

    @Step
    public void selectFromDropdowns(String productType, String taxStatus, String taxClass) {
        adminPage.selectFromProductDataDropdown(productType);
        adminPage.selectTFromTaxStatus(taxStatus);
        adminPage.selectFromTaxClass(taxClass);
    }

    @Step
    public void setStockStatus(String status) {
        adminPage.clickOnInventorySubmenu();
        adminPage.selectStockStatus(status);
    }

    @Step
    public void setPostTitle(String title) {
        adminPage.setTitle(title);
    }

    @Step
    public void setPostText(String text) {
        adminPage.setPostTextField(text);
    }

    @Step
    public void setCouponName(String couponName) {
        adminPage.setTitle(couponName);
    }

    @Step
    public void executeSearch(String keyword) {
        adminPage.setSearchField(keyword);
    }

    @Step
    public void selectDiscountType(String discountType) {
        adminPage.selectDiscountType(discountType);
    }

    @Step
    public void setCouponAmount(String couponAmount) {
        adminPage.setCouponAmountField(couponAmount);
    }

    @Step
    public void findAndOpenPost(String postTitle) {
        Assert.assertTrue(homePage.findAndOpenPost(postTitle));
    }

    @Step
    public void checkTheOrderExistOnAdminInterface(String keyword) {
        Assert.assertTrue("The order was not found.", adminPage.isTheOrderFound(keyword));
    }

    @Step
    public void checkAdminIsLoggedIn() {
        Assert.assertTrue("The welcome panel is not present.", adminPage.checkAdminIsLoggedIn());
    }
}

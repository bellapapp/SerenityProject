package fasttrackit.steps;

import fasttrackit.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BaseSteps extends ScenarioSteps {

    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    public HomePage homePage;
    public MyAccountPage myAccountPage;
    public ProductPage productPage;
    public SearchResultPage searchResultPage;
    public ShopPage shopPage;
    public AdminPage adminPage;

    @Step
    public void navigateToShop() {
        homePage.clickOnShopLink();
    }
}

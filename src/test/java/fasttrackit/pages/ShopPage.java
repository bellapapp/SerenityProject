package fasttrackit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ShopPage extends PageObject {

    @FindBy(css = ".azera_shop_grid li .add_to_cart_button")
    private List<WebElementFacade> listOfProductsWithAddToCartButton;

    public void clickOnAddToCartFromShopPageFromList(int index) {
        clickOn(listOfProductsWithAddToCartButton.get(index));
    }
}
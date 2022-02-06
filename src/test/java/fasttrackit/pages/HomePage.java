package fasttrackit.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "menu-item-122")
    private WebElementFacade myAccountLink;

    @FindBy(id = "menu-item-123")
    private WebElementFacade shopLink;

    @FindBy(css = ".header-search-button")
    private WebElementFacade searchIcon;

    @FindBy(css = ".search-field")
    private WebElementFacade searchField;

    @FindBy(css = ".header-search-input [type='submit']")
    private WebElementFacade searchSubmitIcon;

    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartIcon;

    @FindBy(css = ".menu-item-125")
    private WebElementFacade checkOutLink;

    @FindBy(css = ".widget_categories .cat-item.cat-item-1 a")
    private WebElementFacade uncategorizedPosts;

    @FindBy(css = ".type-post .entry-title a")
    private List<WebElementFacade> listOfPostTitles;

    public void clickOnMyAccountLink() {
        clickOn(myAccountLink);
    }

    public void clickOnShopLink() {
        clickOn(shopLink);
    }

    public void clickOnSearchIcon(){
        clickOn(searchIcon);
    }

    public void clickOnCartIcon(){
        clickOn(cartIcon);
    }

    public void clickOnCheckOutLink() {
        clickOn(checkOutLink);
    }

    public void clickOnUncategorizedPosts() {
        clickOn(uncategorizedPosts);
    }

    public void setSearchField(String keyword){
        typeInto(searchField,keyword);
    }

    public void submitSearch(){
        clickOn(searchSubmitIcon);
    }

    public boolean findAndOpenPost(String postTitle) {
        waitFor(listOfPostTitles.get(0));
        for (WebElementFacade element : listOfPostTitles) {
            if (element.getText().equalsIgnoreCase(postTitle)) {
                element.click();
                return true;
            }
        }
        return false;
    }
}

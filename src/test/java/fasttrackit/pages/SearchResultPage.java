package fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".woocommerce-result-count")
    private WebElementFacade searchResultCounter;

    @FindBy(css = ".woocommerce-info")
    private WebElementFacade noSearchResultInfo;

    @FindBy(css = ".page-title")
    private WebElementFacade pageTitle;

    @FindBy(css = ".orderby")
    private WebElementFacade sortingDropdown;

    @FindBy(css = ".products li")
    private List<WebElementFacade> listOfProducts;

    @FindBy(css = ".azera_shop_grid li:nth-child(1) .amount:not(del > .amount):first-child")
    private List<WebElementFacade> firstLineProducts;

    @FindBy(css = ".azera_shop_grid li:nth-child(2) .amount:not(del > .amount):first-child")
    private List<WebElementFacade> secondLineProducts;

    @FindBy(css = ".azera_shop_grid li:nth-child(3) .amount:not(del > .amount):first-child")
    private List<WebElementFacade> thirdLineProducts;

    @FindBy(css = ".azera_shop_grid li:nth-child(4) .amount:not(del > .amount):first-child")
    private List<WebElementFacade> fourthLineProducts;

    public void sortByPriceLowToHigh() {
        sortingDropdown.selectByVisibleText("Sort by price: low to high");
    }

    public boolean openProduct(String name) {
        waitFor(listOfProducts.get(0));
        for (WebElementFacade element : listOfProducts) {
            if (element.findElement(By.cssSelector(".woocommerce-loop-product__title")).getText().equalsIgnoreCase(name)) {
                element.findElement(By.cssSelector("a")).click();
                return true;
            }
        }
        return false;
    }

    public boolean checkSearchResultInfo() {
        if (!listOfProducts.isEmpty() && searchResultCounter.isDisplayed()) {
            return true;
        } else if (listOfProducts.isEmpty() && noSearchResultInfo.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSearchResultTitle(String keyword) {
        return pageTitle.getText().toLowerCase().contains(keyword);
    }

    public List <Integer> getIntegerPriceList() {

        List <Integer> priceList =  new ArrayList<>();

        for(WebElementFacade webElementFacade : firstLineProducts) {
            priceList.add(getIntFromPrice(webElementFacade.getText()));
        }

        for(WebElementFacade webElementFacade : secondLineProducts) {
            priceList.add(getIntFromPrice(webElementFacade.getText()));
        }

        for(WebElementFacade webElementFacade : thirdLineProducts) {
            priceList.add(getIntFromPrice(webElementFacade.getText()));
        }

        for(WebElementFacade webElementFacade : fourthLineProducts) {
            priceList.add(getIntFromPrice(webElementFacade.getText()));
        }

        return priceList;
    }

    public boolean comparePricesAfterSortingLowToHigh(List<Integer> priceList) {

        boolean sortIsCorrect = false;

        for (int i = 0; i < priceList.size() - 1; i++) {
            if (priceList.get(i) <=
                    priceList.get(i + 1)) {
                sortIsCorrect = true;
            } else {
                sortIsCorrect = false;
                break;
            }
        }
        return sortIsCorrect;
    }
}

package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{


    @Step
    public void executeSearch(String keyword){
        homePage.clickOnSearchIcon();
        homePage.setSearchField(keyword);
        homePage.submitSearch();
    }

    @Step
    public void findAndOpenProduct(String productName){
        Assert.assertTrue("No product name matches the searched keyword.",
                searchResultPage.openProduct(productName));
    }

    @Step
    public void searchAndSelectProduct(String keyword) {
        executeSearch(keyword);
        findAndOpenProduct(keyword);
    }

    @Step
    public void sortByPriceTheProductList() {
        searchResultPage.sortByPriceLowToHigh();
    }

    @Step
    public void checkTheProduct(String productName) {
        Assert.assertTrue("The product was not found.", productPage.foundTheProduct());
        Assert.assertTrue(productPage.productTitleMatches(productName));
    }

    @Step
    public void checkSearchResultInfo() {
        Assert.assertTrue("The Search results info doesn't match with the results.",
                searchResultPage.checkSearchResultInfo());
    }

    @Step
    public void checkSearchResultsTitle(String keyword) {
        Assert.assertTrue("The Search results title doesn't contain the searched keyword.",
                searchResultPage.checkSearchResultTitle(keyword));
    }

    @Step
    public void comparePricesAfterSortingLowToHigh() {
        Assert.assertTrue("The sorting is incorrect.",
                searchResultPage.comparePricesAfterSortingLowToHigh(searchResultPage.getIntegerPriceList()));
    }
}

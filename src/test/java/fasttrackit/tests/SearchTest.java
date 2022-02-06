package fasttrackit.tests;

import fasttrackit.utils.EnvConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class SearchTest extends BaseTest{

    @Test
    public void searchAndSelectFromSearchResults() {
        searchSteps.executeSearch(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.findAndOpenProduct(EnvConstants.SEARCH_T_SHIRT);
    }

    @Test
    public void checkSearchResultsInfoWithAnExistingProduct() {
        searchSteps.executeSearch(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.checkSearchResultInfo();
    }

    @Test
    public void checkSearchResultsInfoTestWithANonExistingProduct() {
        searchSteps.executeSearch(RandomStringUtils.randomAlphanumeric(10));
        searchSteps.checkSearchResultInfo();
    }

    @Test
    public void searchResultsTitleContainsTheSearchedKeyword() {
        searchSteps.executeSearch(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.checkSearchResultsTitle(EnvConstants.SEARCH_T_SHIRT);
    }

    @Test
    public void checkSortingByPriceLowToHighOnFixPricedProducts() {
        searchSteps.executeSearch(EnvConstants.SEARCH_T_SHIRT);
        searchSteps.sortByPriceTheProductList();
        searchSteps.comparePricesAfterSortingLowToHigh();
    }
}

package fasttrackit.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage extends PageObject {

    public int getIntFromPrice(String priceNonFormatted) {
        return Integer.parseInt(priceNonFormatted
                .replace(",", "")
                .replace(" lei", "")
                .replace(".", ""));
    }

    public int getIntFromQty(String priceNonFormatted) {
        return Integer.parseInt(priceNonFormatted
                .replace(" in stock", ""));
    }

    public void scrollToPageTop() {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
}

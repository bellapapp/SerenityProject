package fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ReviewSteps extends BaseSteps {

    @Step
    public void addReviewStar() {
        productPage.clickOnFiveStars();
    }

    @Step
    public void addReviewComment(String comment) {
        productPage.setReviewCommentForm(comment);
    }

    @Step
    public void setAuthorDates(String name, String email) {
        productPage.setReviewNameForm(name);
        productPage.setReviewEmailForm(email);
        productPage.clickOnReviewSubmitButton();
    }

    @Step
    public void checkTheCommentIsVisible(String comment) {
        Assert.assertTrue(productPage.findTheComment(comment));
    }

    @Step
    public void handleAlert() {
        Assert.assertTrue(productPage.handleAlert());
    }
}

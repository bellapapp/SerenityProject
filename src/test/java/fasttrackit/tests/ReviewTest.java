package fasttrackit.tests;


import fasttrackit.utils.EnvConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class ReviewTest extends BaseTest {

    @Test
    public void validReviewOnProduct() {
        String comment = RandomStringUtils.randomAlphabetic(25);
        searchSteps.executeSearch(EnvConstants.SEARCH_NEW_HAT);
        reviewSteps.addReviewStar();
        reviewSteps.addReviewComment(comment);
        reviewSteps.setAuthorDates(EnvConstants.INVALID_LOGIN_USERNAME, EnvConstants.INVALID_LOGIN_USERNAME_EMAIL);
        reviewSteps.checkTheCommentIsVisible(comment);
    }

    @Test
    public void invalidReviewOnProductWithoutRating() {
        String comment = RandomStringUtils.randomAlphabetic(25);
        searchSteps.executeSearch(EnvConstants.SEARCH_NEW_HAT);
        reviewSteps.addReviewComment(comment);
        reviewSteps.setAuthorDates(EnvConstants.INVALID_LOGIN_USERNAME, EnvConstants.INVALID_LOGIN_USERNAME_EMAIL);
        reviewSteps.handleAlert();
    }

    @Test
    public void validateReviewFromAdminPanel() {
        String comment = RandomStringUtils.randomAlphabetic(25);
        searchSteps.executeSearch(EnvConstants.SEARCH_NEW_HAT);
        reviewSteps.addReviewStar();
        reviewSteps.addReviewComment(comment);
        reviewSteps.setAuthorDates(EnvConstants.INVALID_LOGIN_USERNAME, EnvConstants.INVALID_LOGIN_USERNAME_EMAIL);
        reviewSteps.checkTheCommentIsVisible(comment);
        navigateToAdminInterface();
        adminSteps.doLogin(EnvConstants.VALID_ADMIN_USERNAME, EnvConstants.VALID_ADMIN_PASSWORD);
        adminSteps.navigateToCommentsMenu();
        adminSteps.approveTheReview(comment);
        navigateToUserInterface();
        searchSteps.executeSearch(EnvConstants.SEARCH_NEW_HAT);
        reviewSteps.checkTheCommentIsVisible(comment);
    }

}

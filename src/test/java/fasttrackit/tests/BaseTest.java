package fasttrackit.tests;

import fasttrackit.steps.*;
import fasttrackit.utils.EnvConstants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed(uniqueSession = true)
    WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
        driver.get(EnvConstants.BASE_URL);
    }

    public void navigateToUserInterface() {
        driver.get(EnvConstants.BASE_URL);
    }

    public void navigateToAdminInterface() {
        driver.get(EnvConstants.ADMIN_URL);
    }

    @Steps
    protected BaseSteps baseSteps;

    @Steps
    protected CartSteps cartSteps;

    @Steps
    protected CheckOutSteps checkOutSteps;

    @Steps
    protected CouponSteps couponSteps;

    @Steps
    protected LoginSteps loginSteps;

    @Steps
    protected RegisterSteps registerSteps;

    @Steps
    protected SearchSteps searchSteps;

    @Steps
    protected AdminSteps adminSteps;

    @Steps
    protected ReviewSteps reviewSteps;

}

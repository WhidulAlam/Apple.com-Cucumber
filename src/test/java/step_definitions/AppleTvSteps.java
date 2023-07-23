package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.AppleTv;
import utilities.ReadConfigFiles;

public class AppleTvSteps {

    private static final Logger LOGGER = LogManager.getLogger(AppleTvSteps.class);

    WebDriver driver = Hooks.driver;


    @Given("user navigate to Apple TV+ page upon clicking on Apple TV+ link upon mouse hovering on Tv&Home Menu")
    public void userNavigateToAppleTvPage() {

      new AppleTv(driver)
              .mouseHoverToTvAndHome()
              .fixWait(3000)
              .navigateToAppleTve()
              .fixWait(3000);
      LOGGER.info("user on Apple TV+ - Apple page");
    }

    @When("^user click on Check eligibility button upon scrolling down$")
    public void user_click_on_check_eligibility() throws InterruptedException {
        new AppleTv(driver)
                .clickOnCheckEligibility()
                .fixWait(3000)
                .clickOnTryItButton()
                .fixWait(3000);
        LOGGER.info("user on Apple TV+ - Apple page");
    }

    @Then("^user Successfully subscribed$")
    public void user_successfully_subscribed() {
        new AppleTv(driver)
                .iFrame()
                .fixWait(3000)
                .userSuccessfullySubscribed();
        LOGGER.info("user on Apple TV+ subscription page");
    }


}

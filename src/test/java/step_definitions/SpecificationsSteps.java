package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.Specifications;
import utilities.ReadConfigFiles;

public class SpecificationsSteps {
    private static final Logger LOGGER = LogManager.getLogger(SpecificationsSteps.class);

    WebDriver driver = Hooks.driver;

    @Given("Click on Apple Fitness+ link upon mouse hovering on Entertainment from menu bar")
    public void User_mouse_hover_on_Entertainment() throws InterruptedException {
        new Specifications(driver)
                .mouseHoverOnEntertainment()
                .fixWait(3000)
                .clickOnAppleFitness()
                .fixWait(3000);
        LOGGER.info("User clicked on Apple Fitness+");
    }

    @And("^User click on Try It Free button upon scrolling down & then click on Identify and Tech Specs upon scrolling down$")
    public void user_performs_all_the_required_steps() throws InterruptedException {
        new Specifications(driver)
                .clickOnTryItFree()
                .fixWait(3000)
                .clickOnIdentify()
                .fixWait(3000)
                .clickOnSeeTheTech();
        LOGGER.info("User performed all the required steps");
    }

    @Then("Technical specification of iPhone14 Pro Max appears")
    public void technical_specification_of_i_phone14_pro_max_appears() {
        new Specifications(driver)
                .userSuccessfullySeeSpecification();
        LOGGER.info("Technical specification of iPhone14 Pro Max appears");
    }


}

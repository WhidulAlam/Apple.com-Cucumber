package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.DeviceCoverage;
import utilities.ReadConfigFiles;

public class DeviceCoverageSteps {

    private static final Logger LOGGER = LogManager.getLogger(DeviceCoverageSteps.class);

    WebDriver driver = Hooks.driver;


    @Given("^Click on check coverage link upon mouse hovering on Support from menu$")
    public void click_on_check_coverage() {
       new DeviceCoverage(driver)
               .mouseHoverToSupport()
               .fixWait(3000)
               .navigateToDeviceCoverage()
               .fixWait(3000);
        LOGGER.info("Clicked on check coverage");
    }

    @When("^user Enter a device serial number \"(.+?)\" to check Coverage$")
    public void userEnter_a_device_serial_number(String sNumber) {
           new DeviceCoverage(driver)
                   .typeDeviceSerialNumber(sNumber);

           LOGGER.info("user Entered a device serial number");
    }
    @And("^Type the characters captcha & click submit button$")
    public void Type_the_characters_captcha() {
        new DeviceCoverage(driver)
                .typeTheCharactersAbove("Auto")
                .clickOnSubmitButton()
                .fixWait(3000);
        LOGGER.info("user performed all the required steps to check");
    }

    @Then("user will see coverage details")
    public void user_will_see_coverage_details() {
        new DeviceCoverage(driver)
                .userWillSeeCoverageDetails();
        LOGGER.info("user will see coverage details");
    }

}

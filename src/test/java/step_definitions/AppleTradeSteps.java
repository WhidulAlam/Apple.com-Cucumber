package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.AppleTrade;
import utilities.ReadConfigFiles;

public class AppleTradeSteps {
    private static final Logger LOGGER = LogManager.getLogger(AppleTradeSteps.class);

    WebDriver driver= Hooks.driver;


    @Given("^user navigate to Apple trade in page upon clicking on Apple Trade In link from Store Menu$")
    public void userNavigateToTradeIn() throws InterruptedException {
        new AppleTrade(driver)
                .hoverMouseOnStore()
                .fixWait(3000)
                .clickOnAppleTrade()
                .fixWait(3000)
                .clickOnFindTradeInValue()
                .fixWait(3000);
        LOGGER.info("Pop-up will be appears");
    }
    @When("^user click on Find your trade-in-Value for good condition \"(.+?)\" & then click on SmartPhone$")
    public void user_performs_all_the_required_step(String model) throws InterruptedException {
        new AppleTrade(driver)
                .clickOnSmartPhone()
                .fixWait(3000)
                .clickOnApple()
                .fixWait(3000)
                .clickOniPhone11()
                .fixWait(3000)
                .clickOnYes()
                .fixWait(3000);

        LOGGER.info("user performs all the required step");

    }
    @Then("^user will see trade in price is \"(.+?)\"$")
    public void user_will_see_trade_in_value (String value){
        new AppleTrade(driver)
                .successfullyAppearsTradeValue(value);
        LOGGER.info("Trade value of device will appears");
    }
}

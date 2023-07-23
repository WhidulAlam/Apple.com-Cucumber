package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.HomePodPrice;



public class HomePodPriceSteps {
    private final static Logger LOGGER = LogManager.getLogger(HomePodPriceSteps.class);

    WebDriver driver = Hooks.driver;


    @Given("user Click on Shop All Accessories link upon mouse hovering on Accessories from menu")
    public void user_mouse_hover_on_accessorise() {
       new HomePodPrice(driver)
               .mouseHoverOnAccessories()
               .clickOnShopAllAccessorise()
               .fixWait(3000);
       LOGGER.info("user on the Searching page");
    }

    @And("user click on Browser by Category")
    public void user_performs_some_required_steps() throws InterruptedException {
        new HomePodPrice(driver)
                .clickOnBrowserByCategory()
                .fixWait(3000)
                .clickOnHeadPhone()
                .fixWait(3000);
        LOGGER.info("user performs some required steps");
    }

    @Then("user will see the price successfully")
    public void user_will_see_the_price_successfully() {
        new HomePodPrice(driver)
                .userSuccessfullySeeThePrice();
        LOGGER.info("Home pod price is appears");

    }

}

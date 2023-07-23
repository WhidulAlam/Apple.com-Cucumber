package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.Buy;

public class BuySteps {

    private static final Logger LOGGER = LogManager.getLogger(BuySteps.class);

    WebDriver driver = Hooks.driver;


    @Given("user Click on Shop All Accessories link upon mouse hovering on Accessories from menu bar")
    public void the_user_mouse_hover_on_Accessories() {
    new Buy(driver)
            .mouseHoverToAccessories()
            .fixWait(3000)
            .clickOnShopAllAccessories()
            .fixWait(3000);
       LOGGER.info("user on the Searching page");
    }

    @When("^user searching product \"(.+?)\" & click the product upon scrolling down$")
    public void user_performs_all_the_required_steps_upon_adding_the_item_to_the_cart_to_purchase( String product) throws InterruptedException {

     new Buy(driver)
             .typeProductName(product)
             .fixWait(3000)
             .clickOnSearchIcon()
             .fixWait(3000)
             .clickOnSearchProduct()
             .fixWait(3000);

        LOGGER.info("user on the order page");
    }

    @And("^click on Connectivity \"(.+?)\" & Storage \"(.+?)\" then clicks on GrayColour, AddToBag, CheckOut, ContinueAsGuest upon scrolling down$")
    public void performs_all_required_step_to_purchase(String connectivity, String storage) {
        new Buy(driver)
                .selectConnectivity(connectivity)
                .selectStorage(storage)
                .clickOnGrayColour()
                .fixWait(3000)
                .clickOnAddToBagButton()
                .fixWait(3000)
                .clickOnCheckOutButton()
                .clickOnContinueAsGuestButton()
                .fixWait(3000)
                .clickOnDelivery()
                .fixWait(3000);
       LOGGER.info("user performed all required steps");
    }

    @Then("user purchased successfully")
    public void i_phone_is_purchased_successfully() {
        new Buy(driver)
                .userPurchasedSuccessfully();
        LOGGER.info("user is purchased successfully");
    }


}

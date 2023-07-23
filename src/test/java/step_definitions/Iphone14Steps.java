package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import page_object.AppleTrade;
import page_object.Explore;
import utilities.ReadConfigFiles;

public class Iphone14Steps {

    private static final Logger LOGGER = LogManager.getLogger(Iphone14Steps.class);

    WebDriver driver = Hooks.driver;


    @When("user Click on Explore All iPhone link upon mouse hovering on iPhone from menu then click on Buy button")
    public void the_user_mouse_hover_on_i_phone() {
        new Explore(driver)
                .mouseHoverToIphone()
                .fixWait(3000)
                .navigateToExplore()
                .fixWait(3000)
                .clickOnBuyButton()
                .fixWait(3000);
        LOGGER.info("user navigated to Explore page");

    }

    @When("^clicks on iPhone14, BlueColour, 256GB, NoTradeIn, Buy, connectToAny, NoAppleCare, AddToBag, ReviewBag, checkOut, ContinueAsGuest, DeliversFree, ShippingAddressButton upon scrolling down$")
    public void the_user_performs_all_the_required_steps_upon_adding_the_item_to_the_cart_to_purchase() throws InterruptedException {

        new Explore(driver)
                .clickOnIphone14()
                .fixWait(3000)
                .clickOnColourYellow()
                .fixWait(3000)
                .clickOnStorage()
                .fixWait(3000)
                .clickOnNoTradeIn()
                .clickOnPaymentOption()
                .fixWait(3000)
                .clickOnConnectivity()
                .waitForPageToLoad()
                .clickOnNoAppleCare()
                .fixWait(3000)
                .clickOnAddToBagButton()
                .fixWait(3000)
                .clickOnReviewBagButton()
                .fixWait(3000)
                .clickOnCheckOutButton()
                .fixWait(3000)
                .clickOnContinueAsGuestButton()
                .fixWait(3000)
                .clickOnIwouldLikeItDelivered()
                .clickOnExpressDelivery()
                .clickOnContinueToShippingAddressButton()
                .fixWait(3000);
        LOGGER.info("user_performs_all_the_required_steps");

    }
    @And("^user enters shipping address credentials FN\"(.+?)\", LN\"(.+?)\", SA\"(.+?)\", ZC\"(.+?)\", CN\"(.+?)\", EA\"(.+?)\", PN\"(.+?)\"$")
        public void userEntersShippingAddressCredentials(String Fn,String Ln,String Sa,String Zc,String Cn,String Ea, String Pn) {
        new Explore(driver)
               .typeFirstName(Fn)
               .typeLastName(Ln)
               .typeStreetAddress(Sa)
               .typeZipCode(Zc)
               .fixWait(3000)
               .typeCityAndStateName(Cn)
               .clickOnCountry()
               .typeEmailAddress(Ea)
               .typePhoneNumber(Pn);
        LOGGER.info("user entered credentials");
    }

    @Then("user is purchased successfully")
    public void i_phone_is_purchased_successfully() {
       new Explore(driver)
               .userSuccessfullyPurchased();
        LOGGER.info("user purchased is successful");
    }


}

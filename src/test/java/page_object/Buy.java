package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class Buy extends NavigationBar{
        private final By ShopAllAccessories = By.xpath("//a[text()='Shop All Accessories']");
        private final By SearchBox = By.name("search");
        private final By SearchIcon = By.xpath("//span[@class='form-icons form-icons-search15']");
        private final By ChoseIpad = By.xpath("//a[@data-evar11=\"FHQY3|search\"]");//a[@data-evar11="FHQY3|search"]
        private final By WiFi = By.name("dimensionconnectivity");
        private final By Colour = By.xpath("//*[normalize-space()='Space Gray']/../../..//*[@data-autom='colornav-space_gray']");
        private final By TB1 = By.name("dimensionCapacity");

        private final By AddToBag = By.id("add-to-cart");
        private final By CheckOut = By.id("shoppingCart.actions.navCheckout");
        private final By ContinueAsGuest = By.xpath("//span[normalize-space()='Continue as Guest']");
        private final By ShippingAddress = By.xpath("//span[text()='Continue to Shipping Address']");
        private final By DeliversTomorrow = By.xpath("//span[normalize-space()='$8.00']");



        private static final Logger LOGGER = LogManager.getLogger(Buy.class);

        public Buy(WebDriver driver){
            super(driver);
        }


        public Buy fixWait(long ms){
            try{
                Thread.sleep(ms);
            }catch (InterruptedException e){
                LOGGER.error("Wait Exception is: " + e.getMessage());
            }
            return this;
        }

        public Buy clickOnShopAllAccessories() {
            LOGGER.debug("Clicking on Shop Al lAccessories");
            ActOn.element(driver, ShopAllAccessories).click();
            return new Buy(driver);
        }
        public Buy typeProductName(String value) {
            LOGGER.debug("Typing Product Name value: " + value);
            ActOn.element(driver, SearchBox).setValue(value);
            return this;
        }
        public Buy clickOnSearchIcon() {
            LOGGER.debug("Clicking on the SearchIcon");
            ActOn.element(driver, SearchIcon).click();
            return new Buy(driver);
        }
    public Buy clickOnSearchProduct() {
        LOGGER.debug("Clicking on the Search Product");
        ActOn.element(driver, ChoseIpad).click();
        return new Buy(driver);
    }
/*        public Buy connectivity(String value){
            try{
                ActOn.element(driver, WiFi).selectValue(value);
            }catch (Exception e){
                LOGGER.error("connectivity Exception is: " + e.getMessage());
            }
            return this;
//        }*/
    public Buy selectConnectivity(String value) {
        LOGGER.debug("Selecting connectivity value: " + value);
        ActOn.element(driver, WiFi).selectValue(value);
        return new Buy(driver);
    }
    public Buy selectStorage(String value) {
        LOGGER.debug("Selecting storage value: " + value);
        ActOn.element(driver, TB1).selectValue(value);
        return this;
    }
    public Buy clickOnGrayColour() {
        LOGGER.debug("Clicking on the gray colour");
        ActOn.element(driver, Colour).click();
        return this;
    }
    public Buy clickOnAddToBagButton() {
        LOGGER.debug("Clicking on the Add to Bag button");
        ActOn.element(driver, AddToBag).click();
        return new Buy(driver);
    }
    public Buy clickOnCheckOutButton() {
        LOGGER.debug("Clicking on the Check Out button");
        ActOn.element(driver, CheckOut).click();
        return new Buy(driver);
    }
    public Buy clickOnContinueAsGuestButton() {
        LOGGER.debug("Clicking on the Continue As Guest button");
        ActOn.element(driver, ContinueAsGuest).click();
        return new Buy(driver);
    }
    public Buy clickOnDelivery() {
        LOGGER.debug("Clicking on the Check Out button");
        ActOn.element(driver, DeliversTomorrow).click();
        return new Buy(driver);
    }
    public Buy userPurchasedSuccessfully(){
        LOGGER.debug("user purchased successfully");
        AssertThat.elementAssertions(driver, ShippingAddress).elementIsDisplayed();
        return this;
    }
}

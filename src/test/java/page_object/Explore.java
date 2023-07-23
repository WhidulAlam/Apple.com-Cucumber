package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Explore extends NavigationBar {
    private final By Buy = By.xpath("//*[@class=\"typography-hero-cta control cta-link cta-view-pricing\"]//a[text()='Buy'][@aria-label='Buy iPhone 14']");
    private final By iphone14 = By.xpath("//*[@id='dimensionScreensize']//*[text()='Model. ']/../../..//*[@value='6_1inch']");
    private final By Colour = By.xpath("//*[@class='colornav-swatch']");
    private final By GB256 = By.xpath("//*[@id='dimensionCapacity']//*[text()='Storage. ']/../../..//*[@value='256gb']");
    private final By NoTradeIn = By.xpath("//span[text()='No trade-in']");
    private final By PaymentOption = By.xpath("//span[text()='Pay with Apple Pay or other payment methods.']");
    private final By ConnectToAnyCarrier = By.xpath("//*[@id='carrierModel']/span[1]/../../..//*[@value='UNLOCKED/US']");
    private final By NoAppleCare = By.xpath("//*[@id='applecareplus_58_noapplecare_label']/span[text()='No AppleCare+ coverage']");//*[@id="root"]/div[3]/div[3]/div[4]/div/h2/span[1]/../../..//*[@aria-labelledby='applecareplus_58_noapplecare_label']
    private final By AddToBag = By.xpath("//span[text()='Add to Bag']");
    private final By ReviewBag = By.name("proceed");
    private final By CheckOut = By.xpath("//*[@id='shoppingCart.actions.navCheckout']/span[text()='Check Out']");
    private final By ContinueAsGuest = By.xpath("//span[text()='Continue as Guest']");
    private final By ShippingAddress = By.xpath("//span[text()='Continue to Shipping Address']");
    private final By LikeItDelivered = By.xpath("//span[text()='I’d like it delivered']");
    private final By ExpressDelivery = By.xpath("//span[text()='Delivers Tue, Jul 11']");
    private final By FirstName = By.xpath("//input[@id='checkout.shipping.addressSelector.newAddress.address.firstName']");
    private final By LastName = By.name("lastName");
    private final By StreetAddress = By.name("street");
    private final By ZipCode = By.name("postalCode");
    private final By CityStateName = By.name("zipLookupCityState");
    private final By CountryName = By.name("countryCode");
    private final By EmailAddress = By.name("emailAddress");
    private final By PhoneNumber = By.name("fullDaytimePhone");
    private final By Payment = By.xpath("//span[text()='Continue to Payment']");
    private static final By Logo = By.xpath("//*[@id='globalnav-list']/li[1]/a");


    private static final Logger LOGGER = LogManager.getLogger(Explore.class);

    public Explore(WebDriver driver) {

        super(driver);
    }


    public Explore fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }
    public Explore waitForPageToLoad(){
        LOGGER.debug("Waiting for the page to load");
        ActOn.wait(driver, Logo).waitForElementToBeDisplayed();
        return this;
    }
   public Explore clickOnBuyButton(){
        LOGGER.debug("Clicking on the Buy button");
        ActOn.element(driver, Buy).click();
        return new Explore(driver);
   }
   public Explore clickOnIphone14(){
        LOGGER.debug("Clicking on the iPhone14");
       ActOn.element(driver, iphone14).click();
        return this;
   }
    public Explore clickOnColourYellow(){
        LOGGER.debug("Clicking on the colour yellow");
        ActOn.element(driver, Colour).click();
        return this;
    }
    public Explore clickOnStorage() {
        LOGGER.debug("Clicking on the storage");
        ActOn.element(driver, GB256).click();
        return this;
    }
    public Explore clickOnNoTradeIn() {
        LOGGER.debug("Clicking on the No Trade In");
        ActOn.element(driver, NoTradeIn).click();
        return this;
    }
    public Explore clickOnPaymentOption() {
        LOGGER.debug("Clicking on the payment option");
        ActOn.element(driver, PaymentOption).click();
        return this;
    }
    public Explore clickOnConnectivity() {
        LOGGER.debug("Clicking on the connectivity");
        ActOn.element(driver, ConnectToAnyCarrier).click();
        return this;
    }
    public Explore clickOnNoAppleCare() {
        LOGGER.debug("Clicking on the No Apple care");
        ActOn.element(driver, NoAppleCare).click();
        return this;
    }
    public Explore clickOnAddToBagButton() {
        LOGGER.debug("Clicking on the Add to Bag button");
        ActOn.element(driver, AddToBag).click();
        return new Explore(driver);
    }
    public Explore clickOnReviewBagButton() {
        LOGGER.debug("Clicking on the Review Bag button");
        ActOn.element(driver, ReviewBag).click();
        return new Explore(driver);
    }
    public Explore clickOnCheckOutButton() {
        LOGGER.debug("Clicking on the Check Out button");
        ActOn.element(driver, CheckOut).click();
        return new Explore(driver);
    }
    public Explore clickOnContinueAsGuestButton() {
        LOGGER.debug("Clicking on the Continue as Guest button");
        ActOn.element(driver, ContinueAsGuest).click();
        return new Explore(driver);
    }
    public Explore clickOnIwouldLikeItDelivered() {
        LOGGER.debug("Clicking on the I'd like it delivered");
        ActOn.element(driver, LikeItDelivered).click();
        return this;
    }
    public Explore clickOnExpressDelivery() {
        LOGGER.debug("Clicking on the express delivery");
        ActOn.element(driver, LikeItDelivered).click();
        return this;
    }
    public Explore clickOnContinueToShippingAddressButton() {
        LOGGER.debug("Clicking on the Continue to shipping address button");
        ActOn.element(driver, ShippingAddress).click();
        return new Explore(driver);
    }
    public Explore typeFirstName(String value) {
        LOGGER.debug("Typing First Name value: " + value);
        ActOn.element(driver, FirstName).setValue(value);
        return this;
    }
    public Explore typeLastName(String value) {
        LOGGER.debug("Typing Last Name value: " + value);
        ActOn.element(driver, LastName).setValue(value);
        return this;
    }
    public Explore typeStreetAddress(String value) {
        LOGGER.debug("Typing street address value: " + value);
        ActOn.element(driver, StreetAddress).setValue(value);
        return this;
    }
    public Explore typeZipCode(String value) {
        LOGGER.debug("Typing zip code value: " + value);
        ActOn.element(driver, ZipCode).setValue(value);
        return this;
    }
    public Explore typeCityAndStateName(String value) {
        LOGGER.debug("Typing city & state name value: " + value);
        ActOn.element(driver, CityStateName).selectValue(value);
        return this;
    }
    public Explore clickOnCountry() {
        LOGGER.debug("Clicking on the Country");
        ActOn.element(driver, CountryName).click();
        return this;
    }
    public Explore typeEmailAddress(String value) {
        LOGGER.debug("Typing Email address value: " + value);
        ActOn.element(driver, EmailAddress).setValue(value);
        return this;
    }
    public Explore typePhoneNumber(String value) {
        LOGGER.debug("Typing phone number value: " + value);
        ActOn.element(driver, PhoneNumber).setValue(value);
        return this;
    }
    public Explore userSuccessfullyPurchased(){
        LOGGER.debug("User successfully purchased");
        AssertThat.elementAssertions(driver, Payment).elementIsDisplayed();
        return this;
    }

}

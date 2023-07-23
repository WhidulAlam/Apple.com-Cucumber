package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppleTrade extends NavigationBar{

    private final By AppleTrade = By.xpath("//*[@id=\"globalnav-submenu-link-store\"]//a[text()='Apple Trade In']");
    private final By SmartPhone = By.xpath("//div[text()='Smartphone']");
    private final By FindTradeInValue = By.xpath("//span[text()='Find your trade-in value']");
    private final By Apple = By.xpath("//div[text()='Apple']");
    private final By iPhone11 = By.xpath("//*[@class='form-selector-label']//div[text()='iPhone 11']");
    private final By Yes = By.xpath("//span/div[contains(text(),'Yes')]");
    private final By Value = By.xpath("//*[text()='Get $200 trade-in credit toward a new iPhone.']");




    private static Logger LOGGER = LogManager.getLogger(AppleTrade.class);

    public AppleTrade (WebDriver driver){
        super(driver);
    }

    public AppleTrade fixWait(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            LOGGER.info("Wait Exception is: " + e.getMessage());
        }
        return this;
    }

    public AppleTrade clickOnAppleTrade(){
        LOGGER.debug("Clicking on apple trade");
        ActOn.element(driver,AppleTrade).click();
        return new AppleTrade(driver);
    }
    public AppleTrade clickOnFindTradeInValue(){
        LOGGER.debug("Clicking on Find your trade in value");
        ActOn.element(driver,FindTradeInValue).click();
        return new AppleTrade(driver);
    }
    public AppleTrade clickOnSmartPhone(){
        LOGGER.debug("Clicking on Smart Phone");
        ActOn.element(driver,SmartPhone).click();
        return new AppleTrade(driver);
    }
    public AppleTrade clickOnApple(){
        LOGGER.debug("Clicking on apple");
        ActOn.element(driver,Apple).click();
        return new AppleTrade(driver);
    }
    public AppleTrade clickOniPhone11(){
        LOGGER.debug("Clicking on iPhone11");
        ActOn.element(driver,iPhone11).click();
        return new AppleTrade(driver);
    }
    public AppleTrade clickOnYes(){
        LOGGER.debug("Clicking on Yes");
        ActOn.element(driver,Yes).click();
        return new AppleTrade(driver);
    }
    public AppleTrade successfullyAppearsTradeValue(String expectedValue){
        LOGGER.debug("Trade value is: "+ expectedValue);
        //AssertThat.elementAssertions(driver,Value).elementIsDisplayed();
        String actualTradeValue = ActOn.element(driver, Value).getTextValue();
        Assert.assertEquals(expectedValue, actualTradeValue);
        return this;
    }
}

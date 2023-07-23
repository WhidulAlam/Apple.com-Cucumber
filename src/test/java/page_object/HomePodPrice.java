package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePodPrice extends NavigationBar{


    private final By ShopAllAccessories = By.xpath("//a[text()='Shop All Accessories']");
    private final By BrowserByCategory = By.xpath("//*[@id='alp-category-browser']//*[@data-autom='Browse by Category']");
    private final By HeadPhone = By.xpath("//span[normalize-space()='Headphones & Speakers']");
    private final By HomePodPrice = By.xpath("//a[text()='HomePod - Midnight']");

    private static final Logger LOGGER = LogManager.getLogger(HomePodPrice.class);

    public HomePodPrice (WebDriver driver){
        super(driver);
    }

    public HomePodPrice fixWait(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            LOGGER.error("Wait Exception is:" + e.getMessage());
        }
        return this;
    }

    public HomePodPrice clickOnShopAllAccessorise(){
        LOGGER.debug("Clicking on the Shop all Accessorise");
        ActOn.element(driver, ShopAllAccessories).click();
        return this;
    }

    public HomePodPrice clickOnBrowserByCategory(){
        LOGGER.debug("Clicking on the Browser by category");
        ActOn.element(driver, BrowserByCategory).click();
        return this;
    }

    public HomePodPrice clickOnHeadPhone(){
        LOGGER.debug("Clicking on the Head phone");
        ActOn.element(driver, HeadPhone).click();
        return this;
    }

    public HomePodPrice userSuccessfullySeeThePrice(){
        LOGGER.debug("user will see the price successfully");
        AssertThat.elementAssertions(driver, HomePodPrice).elementIsDisplayed();
        return this;
    }
}

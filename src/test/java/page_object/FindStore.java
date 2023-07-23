package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindStore extends NavigationBar{

    private static final By SearchInput = By.xpath("//a[text()='Find a store']/../../..//*[@aria-label='Find a store']");
    private static final By ZipCode = By.xpath("//*[@id='store-search-suggestions']/li[1]/a");
    private static final By ViewMap = By.xpath("//*[@id=\"page-landing\"]/main/section[1]/div[4]/h2");

    private static final Logger LOGGER = LogManager.getLogger(FindStore.class);

    public FindStore(WebDriver driver) {

        super(driver);
    }

    public FindStore fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }

    public FindStore typingZipCode(String value){
        LOGGER.debug("Typing Zip code value: " + value);
        ActOn.element(driver, SearchInput).setValue(value);
        return this;
    }
    public FindStore clickOnZipCode(){
        LOGGER.debug("Clicking on the Continue as Guest button");
        ActOn.element(driver, ZipCode).click();
        return new FindStore(driver);
    }
    public FindStore successfullyFindNearStore(){
        LOGGER.debug("User successfully find a store");
        AssertThat.elementAssertions(driver, ViewMap).elementIsDisplayed();
        return this;
    }
}

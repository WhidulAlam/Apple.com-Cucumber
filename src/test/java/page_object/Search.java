package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search extends NavigationBar{
    private static final By SearchIcon = By.id("globalnav-menubutton-link-search");
    private static final By TypeInSearchBox = By.xpath("//input[@placeholder='Search apple.com']");
    private static final By SearchBar = By.xpath("//button[@aria-label='Submit search']");
    private static final By AirTag4 = By.xpath("//button[@data-analytics-title=\"accessories\"]");

    private static final Logger LOGGER = LogManager.getLogger(Search.class);

    public Search(WebDriver driver) {

        super(driver);
    }

    public Search fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }

    public Search clickOnSearchIcon() {
        LOGGER.debug("Clicking on the search icon");
        ActOn.element(driver, SearchIcon).click();
        return this;
    }
    public Search typeTheSearchingNameOfProduct(String value) {
        LOGGER.debug("Typing the searching name of product value: " + value);
        ActOn.element(driver, TypeInSearchBox).setValue(value);
        return this;
    }
    public Search backSpaceForTest() {
        LOGGER.debug("Clicking on the search bar");
        ActOn.element(driver, TypeInSearchBox).backSpace();
        return this;
    }
    public Search pressEnterOnSearchBox() {
        LOGGER.debug("Clicking on the search bar");
        ActOn.element(driver, TypeInSearchBox).enter();
        return this;
    }
    public Search clickOnSearchBar() {
        LOGGER.debug("Clicking on the search bar");
        ActOn.element(driver, SearchBar).click();
        return this;
    }

    public Search userNavigatedSearchResults(){
        LOGGER.debug("user will see coverage details");
        AssertThat.elementAssertions(driver, AirTag4).elementIsDisplayed();
        return this;
    }
}
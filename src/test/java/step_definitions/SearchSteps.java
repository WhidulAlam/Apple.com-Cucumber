package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_object.Search;
import utilities.ReadConfigFiles;

public class SearchSteps {

    private static final By SearchIcon = By.id("globalnav-menubutton-link-search");
    private static final By SearchBox = By.xpath("//*[@id='globalnav-submenu-search']/div/div/form/div[1]/input[1]");
    private static final By SearchBar = By.xpath("//*[@id=\"globalnav-submenu-search\"]/div/div/form/div[1]/button[2]");
    private static final By Accessories = By.xpath("//*[@id=\"globalnav-list\"]/li[2]/div/div/div[10]/ul/li[1]/a/span[1]");


    private static final Logger LOGGER = LogManager.getLogger(SearchSteps.class);

    WebDriver driver = Hooks.driver;


    @Given("^user click on Search icon from menu bar$")
    public void user_on_apple_search_page() {
        new Search(driver)
                .clickOnSearchIcon();

        LOGGER.info("user in a text search box page");

    }

    @When("^user enters text \"(.+?)\" in search box$")
    public void user_enters_s_text_in_search_box(String product) {
        new Search(driver)
                .typeTheSearchingNameOfProduct(product)
                .fixWait(3000);

        LOGGER.info("user entered a text in search box");

    }

    @And("user press Enter on SearchBox")
    public void user_press_Enter_on_SearchBox() {
        new Search(driver)
                .pressEnterOnSearchBox()
                .fixWait(3000);
        LOGGER.info("user clicked on SearchBar");

    }

    @Then("user navigate to search results")
    public void user_navigate_to_search_results() {
        new Search(driver)
                .userNavigatedSearchResults();
        LOGGER.info("accessories are appears");
    }
}

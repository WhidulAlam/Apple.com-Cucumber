package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.FindStore;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;


public class FindStoreSteps {

    private static final Logger LOGGER = LogManager.getLogger(FindStoreSteps.class);

    WebDriver driver = Hooks.driver;

    @Given("^Click on Find store link upon mouse hovering on Store from menu$")
    public void user_mouse_hover_on_store() throws InterruptedException {
        new FindStore(driver)
                .mouseHoverToStore()
                .fixWait(3000)
                .navigateToFindStore()
                .fixWait(3000);
        LOGGER.info("User is on the find store page");
    }

    @When("^user enters a ZipCode \"(.+?)\" & click on drop down of zip code$")
    public void user_enter_a_ZipCode_to_near(String zipCode) throws InterruptedException {
      new FindStore(driver)
              .typingZipCode(zipCode)
              .fixWait(3000)
              .clickOnZipCode()
              .fixWait(3000);
        LOGGER.info("user performed all the required steps");
    }

    @When("^user enters a ZipCode & click on drop down of zip code$")
    public void  userEnter_ZipCode_to_near(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            new FindStore(driver)
                    .typingZipCode(cells.get("zipCode"))
                    .fixWait(3000)
                    .clickOnZipCode()
                    .fixWait(3000);
            LOGGER.info("user performed all the required steps");
        }
    }

    @Then("user Find a store successfully")
    public void user_find_a_store_successfully() {
        new FindStore(driver)
                .successfullyFindNearStore();
        LOGGER.info("user find a store near to zip code");
        ActOn.browser(driver).closeBrowser();
    }
}

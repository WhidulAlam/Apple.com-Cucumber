package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;
import utilities.ReadConfigFiles;

import java.time.Duration;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    public static WebDriver driver;

    @Before
    public void initialize(Scenario scenario){
        LOGGER.info(String.format("--------Scenario: %s-------", scenario.getName()));
        driver= DriverFactory.getDf().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppleAppUrl"));
        LOGGER.info("User on the Apple home page");
    }

    @After
    public void cleanup(Scenario scenario){
        DriverFactory.getDf().removeDriver();
        LOGGER.info(String.format("-------Scenario: %s------", scenario.getName()));
    }
}

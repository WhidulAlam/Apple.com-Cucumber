package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private final By BagIcon = By.id("globalnav-menubutton-link-bag");
    private final By SignInOption = By.xpath("//span[text()='Sign in']");
    private final By EmailInputField = By.xpath("//*[@id='sign_in_form']//*[@id='account_name_text_field']");
    private final By AroButton1 = By.xpath("//*[@id='sign_in_form']//*[@id='account_name_text_field']/../../../../../../..//*[@id='sign-in']/i");
    private final By PasswordInputField = By.xpath("//*[@id='sign_in_form']//*[@id='password_text_field']");
    private final By VerificationCode = By.xpath("//input[@aria-label='Enter Verification Code Digit 1']");
    private final By Incorrect = By.id("errMsg");


    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);

    WebDriver driver = Hooks.driver;


    @Given("user click Bag icon & then click sign in again")
    public void user_click_bag_icon_then_click_sign_in_again() {
        ActOn.element(driver, BagIcon).click();
        ActOn.element(driver, SignInOption).click();
        LOGGER.info("User on the sign in page");

    }

    @And("^user performs appleId \"(.+?)\" and password \"(.+?)\" to login$")
    public void enterUserCredentials(String appleId, String password) throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame("aid-auth-widget-iFrame");
        ActOn.element(driver, EmailInputField).setValue(appleId);
        Thread.sleep(3000);
        ActOn.element(driver, AroButton1).click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("aid-auth-widget-iFrame");
        ActOn.element(driver, PasswordInputField).setValue(password);
        Thread.sleep(3000);
        ActOn.element(driver, AroButton1).click();
        driver.switchTo().defaultContent();
        LOGGER.info("User has entered credentials");
    }

    @And("^user performs all the required steps upon to login$")
    public void enterUserCredentialsToLogin(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {

            Thread.sleep(3000);
            driver.switchTo().frame("aid-auth-widget-iFrame");
            ActOn.element(driver, EmailInputField).setValue(cells.get("appleId"));
            Thread.sleep(3000);
            ActOn.element(driver, AroButton1).click();
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
            driver.switchTo().frame("aid-auth-widget-iFrame");
            ActOn.element(driver, PasswordInputField).setValue(cells.get("password"));
            Thread.sleep(3000);
            ActOn.element(driver, AroButton1).click();
            driver.switchTo().defaultContent();
            LOGGER.info("User has entered credentials");
        }
    }


    @Then("user should be enter Verification Code to login")
    public void user_should_be_redirected_to_the_apple_account_dashboard() throws InterruptedException {

        driver.switchTo().frame("aid-auth-widget-iFrame");
        Thread.sleep(3000);
        AssertThat.elementAssertions(driver, VerificationCode).elementIsDisplayed();
        LOGGER.info("user on the Verification page");
    }
    @Then("user is failed to login")
    public void validateUserIsFailedToLogin() {
        driver.switchTo().frame("aid-auth-widget-iFrame");
        AssertThat.elementAssertions(driver, Incorrect).elementIsDisplayed();
        driver.switchTo().defaultContent();
        LOGGER.info("User is still on the Sign in page");
    }
}
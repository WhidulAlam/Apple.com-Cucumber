package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn extends NavigationBar{

    private final By BagIcon = By.id("globalnav-menubutton-link-bag");
    private final By SignInOption = By.xpath("//span[text()='Sign in']");
    private final By EmailInputField = By.xpath("//*[@id='sign_in_form']//*[@id='account_name_text_field']");
    private final By ArrowButton = By.xpath("//*[@id='sign_in_form']//*[@id='account_name_text_field']/../../../../../../..//*[@id='sign-in']/i");
    private final By PasswordInputField = By.xpath("//*[@id='sign_in_form']//*[@id='password_text_field']");
    private final By ShopNow = By.cssSelector("a[aria-label='Shop now, back to school 2023']");
    private final By VerificationCode = By.xpath("//*[@id='no-trstd-device-pop']");
    private final By Incorrect = By.id("errMsg");

    private static final Logger LOGGER = LogManager.getLogger(LogIn.class);

    public LogIn(WebDriver driver){
        super(driver);
    }

    public LogIn fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }

    public LogIn clickOnBagIcon(){
        LOGGER.debug("Clicking on the Bag icon");
        ActOn.element(driver, BagIcon).click();
        return new LogIn(driver);
    }
    public LogIn clickOnSignInOption(){
        LOGGER.debug("Clicking on the sign in option");
        ActOn.element(driver, SignInOption).click();
        return new LogIn(driver);
    }
    public LogIn typeAppleId(String value) {
        LOGGER.debug("Typing Apple Id value: " + value);
        ActOn.element(driver, EmailInputField).setValue(value);
        return this;
    }
    public LogIn clickOnArrowSign(){
        LOGGER.debug("Clicking on the Arrow sign");
        ActOn.element(driver, ArrowButton).click();
        return this;
    }
    public LogIn typePassword(String value) {
        LOGGER.debug("Typing password value: " + value);
        ActOn.element(driver, PasswordInputField).setValue(value);
        return this;
    }
    public LogIn successfullyGetVerificationCode() {
        LOGGER.debug("User successfully get verification code");
        AssertThat.elementAssertions(driver, VerificationCode).elementIsDisplayed();
        return this;
    }
    public LogIn validateUserIsFailedToLogin() {
        LOGGER.debug("User is still on the login page");
        AssertThat.elementAssertions(driver, Incorrect).elementIsDisplayed();
        return this;
    }
}

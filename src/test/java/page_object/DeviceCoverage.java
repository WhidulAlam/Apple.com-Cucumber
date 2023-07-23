package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeviceCoverage extends NavigationBar{
    private final By SerialNumber = By.xpath("//input[@id='SerialNumberForm_serial-number-input__2eBx6']");
    private final By TypeCharacters = By.xpath("//input[@id='captchaAnswer Captcha_captchaAnswer__14feM']");
    private final By Submit = By.xpath(" //span[contains(text(),'Submit')]");
    private final By SignIn = By.xpath("//*[@id=\"main-layout\"]/div[1]/nav/div/div[2]/div[2]/div/div/span/a");

    private static final Logger LOGGER = LogManager.getLogger(DeviceCoverage.class);

    public DeviceCoverage(WebDriver driver) {

        super(driver);
    }

    public DeviceCoverage fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }
    public DeviceCoverage typeDeviceSerialNumber(String value) {
        LOGGER.debug("Typing device serial number value: " + value);
        ActOn.element(driver, SerialNumber).setValue(value);
        return this;
    }
    public DeviceCoverage typeTheCharactersAbove(String value) {
        LOGGER.debug("Typing the characters above value: " + value);
        ActOn.element(driver, TypeCharacters).setValue(value);
        return this;
    }
    public DeviceCoverage clickOnSubmitButton() {
        LOGGER.debug("Clicking on the submit button");
        ActOn.element(driver, Submit).click();
        return this;
    }
    public DeviceCoverage userWillSeeCoverageDetails(){
        LOGGER.debug("user will see coverage details");
        AssertThat.elementAssertions(driver, SignIn).elementIsDisplayed();
        return this;
    }
}

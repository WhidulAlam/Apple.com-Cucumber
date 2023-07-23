package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

public class AppleTv extends NavigationBar{
    private final By CheckEligibility = By.xpath("//a[normalize-space()='Check eligibility']");
    private final By Continue = By.xpath("//span[@class='web-button__text']");
    private static By iFrame = By.xpath("//*[@id='commerce-iframe']/iframe");
    private final By TryIt = By.xpath("//*[@id='tabpanel-0']//span[normalize-space()='Try It Free']");


    private static final Logger LOGGER = LogManager.getLogger(AppleTv.class);

    public AppleTv(WebDriver driver) {

        super(driver);
    }

    public AppleTv fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }

    public AppleTv clickOnCheckEligibility(){
        LOGGER.debug("Clicking on the CheckEligibility");
        ActOn.element(driver, CheckEligibility).click();
        return this;
    }
    public AppleTv clickOnTryItButton(){
        LOGGER.debug("Clicking on Try It button");
        ActOn.element(driver, TryIt).click();
//        WebElement element = (WebElement) ActOn.element(driver, TryIt);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollInToView(true):",element);
//        element.click();
        return this;
    }

    public AppleTv iFrame(){
        //Using WebElement as a argument
        driver.switchTo().frame(driver.findElement(iFrame));
        return this;
    }
    public AppleTv iFrameClose(){
        //using getting out of iFrame
        driver.switchTo().defaultContent();
        return this;
    }

    public AppleTv userSuccessfullySubscribed(){
        LOGGER.debug("user on Apple TV+ subscription page");
        AssertThat.elementAssertions(driver, Continue).elementIsDisplayed();
        return this;
    }

}

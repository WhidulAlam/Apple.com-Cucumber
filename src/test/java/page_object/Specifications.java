package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Specifications extends NavigationBar{
    private final By AppleFitness = By.xpath("//li[@class='globalnav-submenu-list-item-elevated']//a[normalize-space()='Apple Fitness+']");
    private final By TryItFree = By.xpath("//span[contains(text(),'Try it free')]");
    private final By Identify = By.xpath("//*[text()='Identify your iPhone'][@class='icon-copy']");
    private final By SeeTheTech = By.xpath("//a[text()='tech specs for iPhone 14 Pro Max']");
    private final By TechnicalSpecifications = By.id("main-title");

    private static final Logger LOGGER = LogManager.getLogger(Specifications.class);

    public Specifications(WebDriver driver) {

        super(driver);
    }

    public Specifications fixWait(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            LOGGER.error("Wait Exception is: " + e.getMessage());
        }
        return this;
    }

    public Specifications clickOnAppleFitness(){
        LOGGER.debug("Clicking on the Apple Fitness +");
        ActOn.element(driver, AppleFitness).click();
        return new Specifications(driver);
    }
    public Specifications clickOnTryItFree(){
        LOGGER.debug("Clicking on the Try it free");
        ActOn.element(driver, TryItFree).click();
        return this;
    }
    public Specifications clickOnIdentify(){
        LOGGER.debug("Clicking on the Identify");
        ActOn.element(driver, Identify).click();
        return this;
    }
    public Specifications clickOnSeeTheTech(){
        LOGGER.debug("Clicking on see the tech space for iPhone");
        ActOn.element(driver, SeeTheTech).click();
        return new Specifications(driver);
    }
    public Specifications userSuccessfullySeeSpecification(){
        LOGGER.debug("user will see Technical specification of iPhone14 Pro Max appears");
        AssertThat.elementAssertions(driver, TechnicalSpecifications).elementIsDisplayed();
        return this;
    }
}

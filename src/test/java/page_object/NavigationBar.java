package page_object;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationBar {

    private final By Entertainment = By.xpath("//a[@aria-label='Entertainment']//span[@class='globalnav-link-text-container']");

    private final By Support = By.xpath("//a[@aria-label='Support']//span[@class='globalnav-link-text-container']");
    private final By CheckCoverage = By.xpath("//a[text()='Check Coverage']");


    private final By Accessories = By.xpath("//a[@aria-label='Accessories']//span[@class='globalnav-link-text-container']");


    private final By TvAndHome = By.xpath("//a[@aria-label='TV and Home']//span[@class='globalnav-link-text-container']");
    private final By AppleTv = By.xpath("//a[normalize-space()='Apple TV+']");


    private static final By Store = By.xpath("//*[@id='globalnav-list']//span/span[contains(text(),'Store')]");
    private static final By FindStore = By.xpath("//*[@id='globalnav-submenu-link-store']//a[text()='Find a Store']");

    private final By iPhone = By.xpath("//*[@aria-label='iPhone']//span[@class='globalnav-link-text-container']");
    private final By ExploreAllIphone = By.xpath("//a[text()='Explore All iPhone']");
    private static final By Logo = By.xpath("//*[@id='globalnav-list']/li[1]/a");
    private static final By ApplePage = By.xpath("//*[@id=\"page\"]/div[2]");
    private static final By Store2 = By.cssSelector("span.globalnav-link-text-container");
    private static final By Latest = By.xpath("//a[text()='Shop the Latest']");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;
    public NavigationBar(WebDriver driver){

        this.driver= driver;
    }

    public Specifications mouseHoverOnEntertainment(){
        LOGGER.debug("mouse hover to the Entertainment Link");
        ActOn.element(driver, Entertainment).mouseHover();
        return (Specifications) this;
    }

    public AppleTrade hoverMouseOnStore(){
        LOGGER.debug("mouse hover to the Store Link");
        ActOn.element(driver, Store).mouseHover();
        return (AppleTrade) this;
    }


    public DeviceCoverage mouseHoverToSupport(){
        LOGGER.debug("mouse hover to the Store Link");
        ActOn.element(driver, Support).mouseHover();
        return (DeviceCoverage) this;
    }
    public DeviceCoverage navigateToDeviceCoverage() {
        LOGGER.debug("Clicking on the Explore All iPhone");
        ActOn.element(driver, CheckCoverage).click();
        return new DeviceCoverage(driver);
    }



    public HomePodPrice mouseHoverOnAccessories(){
        LOGGER.debug("mouse hover to the Store Link");
        ActOn.element(driver, Accessories).mouseHover();
        return (HomePodPrice) this;
    }

    public Buy mouseHoverToAccessories(){
        LOGGER.debug("mouse hover to the Store Link");
        ActOn.element(driver, Accessories).mouseHover();
        return (Buy) this;
    }



    public AppleTv mouseHoverToTvAndHome(){
        LOGGER.debug("mouse hover to the Store Link");
        ActOn.element(driver, TvAndHome).mouseHover();
        return (AppleTv) this;
    }
    public AppleTv navigateToAppleTve() {
        LOGGER.debug("Clicking on the Explore All iPhone");
        ActOn.element(driver, AppleTv).click();
        return new AppleTv(driver);
    }

    public FindStore mouseHoverToStore(){
        LOGGER.debug("mouse hover to the Store Link");
        ActOn.element(driver, Store).mouseHover();
        return (FindStore) this;
    }
    public FindStore navigateToFindStore() {
        LOGGER.debug("Clicking on the Explore All iPhone");
        ActOn.element(driver, FindStore).click();
        return new FindStore(driver);
    }

    public Explore mouseHoverToIphone(){
        LOGGER.debug("mouse hover to the iPhone Link");
        ActOn.element(driver, iPhone).mouseHover();
        return (Explore) this;
    }
    public Explore navigateToExplore() {
        LOGGER.debug("Clicking on the Explore All iPhone");
        ActOn.element(driver, ExploreAllIphone).click();
        return new Explore(driver);
    }
}

package command_providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameAction {

    public static final Logger LOGGER= LogManager.getLogger(FrameAction.class);

    private By locator;
    private WebDriver driver;

    public FrameAction(WebDriver driver,By locator){
        this.driver= driver;
        this.locator= locator;
    }
    /*public iFrame getFrame(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebSocketFrame frame= null;
        try{
            frame= driver.findElement(locator).getSize();
        }catch (Exception e){
            ScreenCapture.getScreenShot(driver);
            LOGGER.error("Frame Exception for the locator:" + locator + "and exception is:" + e.getMessage());
        }
        return frame;
    }*/
    public FrameAction switchTo(){
        getClass().getClass();
        return this;
    }
}

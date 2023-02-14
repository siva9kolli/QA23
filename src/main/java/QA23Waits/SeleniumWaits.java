package QA23Waits;

import Constants.WAITTIME;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    WAITTIME waitTime;
    WebDriverWait webDriverWait;

    public SeleniumWaits(WebDriver driver){
        waitTime = new WAITTIME();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime.EXPLICITWAIT));
    }

    public WebElement waitForElementToBeClickable(WebElement element){
       return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

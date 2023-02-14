package QA23Actions;

import QA23Waits.SeleniumWaits;
import org.openqa.selenium.*;

public class SeleniumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;

    public SeleniumActions(WebDriver driver){
        this.driver = driver;
        seleniumWaits = new SeleniumWaits(driver);
    }

    public boolean waitAndClickOnElement(WebElement element){
        try{
            seleniumWaits.waitForElementToBeClickable(element).click();
            return true;
        }catch (Exception e){

            return false;
        }
    }

    public boolean clickOnElement(WebElement element) {
        boolean flag = false;
        try {
            element.click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see){
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie){
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

    public boolean enterValue(WebElement element, String data) {
        boolean flag = false;
        try {
            element.sendKeys(data);
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see){
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie){
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

    public boolean clickOnElement(By by){
        try{
            driver.findElement(by).click();
            return true;
        }catch (Exception e){

            return false;
        }
    }
}

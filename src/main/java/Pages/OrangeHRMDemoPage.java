package Pages;

import QA23Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OrangeHRMDemoPage {
    WebDriver driver;
    SeleniumActions seleniumActions;

    public OrangeHRMDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(name = "username")
    WebElement userNameInputField;
    @FindBy(name = "password")
    WebElement passwordInputField;
    @FindBy(css = "button[type='submit']")
    WebElement signInButton;


    /**
     * Click on the list and click on the option
     * @param listName
     * @param optionName
     */
    public void selectValueFromDropDown(String listName, String optionName ){
        driver.findElement(By.xpath("//*[text()='"+listName+"']/../following-sibling::div/div/div")).click();
        seleniumActions.clickOnWebElementUsingText("span", optionName);
    }

    public void clickLeftSideMenuItem(String menuItemName){
        seleniumActions.clickOnWebElementUsingText("span", menuItemName);

    }

    public boolean verifyInputBoxPresent() {
        return userNameInputField.isDisplayed();
    }

    public void login(String userName, String pwd) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        userNameInputField.sendKeys(userName);
        passwordInputField.sendKeys(pwd);
        signInButton.click();
    }

}

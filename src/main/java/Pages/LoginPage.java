package Pages;

import QA23Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private SeleniumActions seleniumActions;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }

    By userNameInputBox = By.name("username");
    By passwordInputBox = By.name("password");
    By loginButton = By.cssSelector("input.button");

    @FindBy(name = "username")
    WebElement userNameInputField;

    @FindBy(name = "password")
    WebElement passwordInputField;

    @FindBy(css = "input.button")
    WebElement signInButton;

    public void login(String userName, String pwd){
        driver.findElement(userNameInputBox).sendKeys(userName);
        driver.findElement(passwordInputBox).sendKeys(pwd);
        driver.findElement(loginButton).click();
    }

    public void login(String userName, String pwd, String description){
        seleniumActions.enterValue(userNameInputField, userName);
        seleniumActions.enterValue(passwordInputField, pwd);
        seleniumActions.waitAndClickOnElement(signInButton);
        System.out.println("Test result :: " + description);
    }


}

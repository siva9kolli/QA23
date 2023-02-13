package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
        userNameInputField.sendKeys(userName);
        System.out.println("Successfully entered value in userNameInputField");
        passwordInputField.sendKeys(pwd);
        System.out.println("Successfully entered value in  passwordInputField");
        signInButton.click();
        System.out.println("Click Successfully on signInButton");
        System.out.println("Test result :: " + description);
    }


}

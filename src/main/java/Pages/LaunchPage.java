package Pages;

import Automation.QA23Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
    WebDriver driver;

    public LaunchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Driver assigning");
    }

    @FindBy(name = "username")
            WebElement userNameInputBox;

//    By userNameInputBox = By.name("username");
    By passwordInputBox = By.name("password");

   // WebElement userNameInputBox = driver.findElement(By.name("username"));
//    WebElement passwordInputBox = driver.findElement(By.name("password"));
//    WebElement loginButton = driver.findElement(By.cssSelector("input.button"));

    public void login(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
        //userNameInputBox.sendKeys(username);
        driver.findElement(passwordInputBox).sendKeys(password);
//        loginButton.click();
    }


}

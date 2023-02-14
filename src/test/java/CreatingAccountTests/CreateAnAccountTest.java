package CreatingAccountTests;

import Automation.QA23Base;
import DataManager.ReadDataFromJson;
import Pages.LaunchPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAnAccountTest extends QA23Base {
    public LaunchPage launchPage;
    public LoginPage loginPage;
    public WelcomePage welcomePage;
    public ReadDataFromJson readDataFromJson;

    @BeforeClass
    public void intializingPages(){
        launchPage = new LaunchPage(driver);
        loginPage = new LoginPage(driver);
        welcomePage = new WelcomePage(driver);
        readDataFromJson = new ReadDataFromJson();
    }

    @Test
    public void loginAsAdmin(){
        loginPage.login(readDataFromJson.readValueFromJson("email"),
                readDataFromJson.readValueFromJson("password"), "Passed");
        String actualErrorMessage = welcomePage.getErrorMessage();
        String expectedErrorMessage = "An internal error has occurred and has been logged.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}

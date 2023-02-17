package CreatingAccountTests;

import DataManager.ReadDataFromJson;
import Pages.LaunchPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LamdaTestExample {

    WebDriver driver;

    public LaunchPage launchPage;
    public LoginPage loginPage;
    public WelcomePage welcomePage;
    public ReadDataFromJson readDataFromJson;

    @BeforeTest
    public void setUpLamdaTest(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browserName", "chrome");
        desiredCapabilities.setCapability("platform", "win10");
        desiredCapabilities.setCapability("browserVersion", "108");
        desiredCapabilities.setCapability("build", "QA");
        desiredCapabilities.setCapability("project", "ParaBank");
        desiredCapabilities.setCapability("test", "ParaBank");

        try {
            driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

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

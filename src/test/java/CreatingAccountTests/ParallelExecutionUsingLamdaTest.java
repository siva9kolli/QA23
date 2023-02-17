package CreatingAccountTests;

import DataManager.ReadDataFromJson;
import Pages.LaunchPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelExecutionUsingLamdaTest {
    public WebDriver driver;
    public DesiredCapabilities desiredCapabilities;
    public LaunchPage launchPage;
    public LoginPage loginPage;
    public WelcomePage welcomePage;
    public ReadDataFromJson readDataFromJson;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser){
        switch (browser){
            case "chrome":
                desiredCapabilities = new DesiredCapabilities();
                ChromeOptions chromeOptions = new ChromeOptions();
                desiredCapabilities.setCapability("browserName", "chrome");
                chromeOptions.merge(desiredCapabilities);
                try {
                    driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"), chromeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "firefox":
                desiredCapabilities = new DesiredCapabilities();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                desiredCapabilities.setCapability("browserName", "firefox");
                firefoxOptions.merge(desiredCapabilities);
                try {
                    driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"), firefoxOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "safari":
                desiredCapabilities = new DesiredCapabilities();
                SafariOptions safariOptions = new SafariOptions();
                desiredCapabilities.setCapability("browserName", "safari");
                safariOptions.merge(desiredCapabilities);
                try {
                    driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"), safariOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "edge":
                desiredCapabilities = new DesiredCapabilities();
                EdgeOptions edgeOptions = new EdgeOptions();
                desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                edgeOptions.merge(desiredCapabilities);
                try {
                    driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"), edgeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
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

    @AfterTest
    public void stopSession(){
        driver.quit();
    }

}

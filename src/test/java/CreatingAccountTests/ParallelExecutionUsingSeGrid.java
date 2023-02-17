package CreatingAccountTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelExecutionUsingSeGrid {
    public WebDriver driver;
    public DesiredCapabilities desiredCapabilities;

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
                    driver = new RemoteWebDriver(new URL(" http://192.168.88.2:4444/wd/hub"), chromeOptions);
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
                    driver = new RemoteWebDriver(new URL(" http://192.168.88.2:4444/wd/hub"), firefoxOptions);
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
                    driver = new RemoteWebDriver(new URL(" http://192.168.88.2:4444/wd/hub"), safariOptions);
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
                    driver = new RemoteWebDriver(new URL(" http://192.168.88.2:4444/wd/hub"), edgeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Test
    public void automationTest(){
        driver.get("https://www.linkedin.com/feed/");
    }

    @AfterTest
    public void stopSession(){
        driver.quit();
    }

}

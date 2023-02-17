package CreatingAccountTests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SingleTest {

    public WebDriver driver;
    public DesiredCapabilities desiredCapabilities;

    @Parameters({"browser"})
    @Test
    public void launchApp(String browser) throws MalformedURLException {
        if (browser.equals("chrome")) {
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            desiredCapabilities.setBrowserName("chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
            chromeOptions.merge(desiredCapabilities);
        } else if (browser.equals("safari")) {
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            desiredCapabilities.setBrowserName("safari");
            SafariOptions safariOptions = new SafariOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), safariOptions);
            safariOptions.merge(desiredCapabilities);
        } else if (browser.equals("firefox")) {
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            desiredCapabilities.setBrowserName("firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.merge(desiredCapabilities);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
        } else if (browser.equals("edge")) {
            desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            desiredCapabilities.setBrowserName("MicrosoftEdge");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.merge(desiredCapabilities);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);
        }

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.get("https://www.selenium.dev/");
            System.out.println("Title of " + browser + " ==== " + driver.getTitle());
            driver.quit();
        }


}

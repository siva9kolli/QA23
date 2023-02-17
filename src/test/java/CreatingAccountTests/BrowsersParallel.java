package CreatingAccountTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowsersParallel {
    public WebDriver driver;

    @Test
    @Parameters({"browser"})
    public void test1(String browser) throws MalformedURLException {
        System.out.println("Test1 on === " + browser);
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities dc = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(dc);
        driver = new ChromeDriver();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), chromeOptions);
        driver.get("https://www.linkedin.com/feed/");
    }

    @Test
    @Parameters({"browser"})
    public void test2(String browser) {
        System.out.println("Test2" + " on === " + browser);
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://github.com/");
    }

    @Test
    @Parameters({"browser"})
    public void test3(String browser) {
        System.out.println("Test3" + " on === " + browser);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://gmail.com/");
    }

    @AfterTest
    public void killSession() {
        driver.quit();
    }
}

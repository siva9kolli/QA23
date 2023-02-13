package Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class QA23Base {
    public WebDriver driver;

    @BeforeSuite
    public void initializeReportAndWebDriver(){
        System.out.println("Report is Intailzed");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void launchApplication(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }
}

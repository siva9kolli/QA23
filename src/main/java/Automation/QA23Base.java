package Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class QA23Base {
    public WebDriver driver;

    @Parameters({"browserName"})
    @BeforeSuite
    public void initializeReportAndWebDriver(@Optional("CHROME") String browser){
        System.out.println("Report is Intailzed");
        switch (browser){
            case "CHROME" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "SAFARI" :
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Provide valid browser name");
                break;
        }
    }
    public void fullScreenshot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+ "/screenshots/fullpage.png");
        FileUtils.copyFile(source, dest);
    }

    @AfterMethod
    public void takeScreenshotWhenTestFails(ITestResult iTestResult) throws IOException {
        if(iTestResult.getStatus() == ITestResult.FAILURE){
            fullScreenshot();
        }
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

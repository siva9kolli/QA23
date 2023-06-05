package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.MessageFormat;

public class ABTestPage {
    WebDriver driver;

    public ABTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    String heading = "A/B Test {0} {1}";
    String heading1 = "A/B Test {0}";

    public void openLink(String linkName) {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText(linkName)).click();
    }

    public void verifyABTestPage() {
        ;
        String td;
        String ts;
        try {
            td = MessageFormat.format(heading, "Variation", 1);
            driver.findElement(By.xpath("//*[text()='"+td+"']")).isDisplayed();
            System.out.println("Test with variation 1");
        } catch (Exception e) {
            ts = MessageFormat.format(heading1, "Control");
            driver.findElement(By.xpath("//*[text()='"+ts+"']")).isDisplayed();
            System.out.println("Test with control");
        }
    }
}


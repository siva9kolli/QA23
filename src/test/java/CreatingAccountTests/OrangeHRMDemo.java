package CreatingAccountTests;

import Automation.QA23Base;
import Pages.OrangeHRMDemoPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMDemo extends QA23Base {
    public OrangeHRMDemoPage orangeHRMDemoPage;

    @BeforeClass
    public void initlaizePage(){
        orangeHRMDemoPage = new OrangeHRMDemoPage(driver);
    }

    @Test
    public void verifyDropDown(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        orangeHRMDemoPage.login("Admin","admin123");
        orangeHRMDemoPage.clickLeftSideMenuItem("Recruitment");
        orangeHRMDemoPage.selectValueFromDropDown("Job Title", "Account Assistant");
    }
}

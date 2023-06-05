package CreatingAccountTests;

import Automation.QA23Base;
import Pages.ABTestPage;
import org.testng.annotations.Test;

public class VerifyABTest extends QA23Base {

    @Test
    public void verifyABTestHeading(){
        ABTestPage abTestPage = new ABTestPage(driver);
        abTestPage.openLink("A/B Testing");
        abTestPage.verifyABTestPage();
    }
}

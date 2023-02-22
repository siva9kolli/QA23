package CreatingAccountTests;

import Automation.QA23Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SpanDealTest extends QA23Base {

    /**
     * Test
     */
    @Test
    public void testSpanDeal(){
        driver.get("https://www.snapdeal.com/product/urbanmark-blue-mens-sneakers/635684595927#bcrumbSearch:shoes");
        String price = driver.findElement(By.xpath("//h1[@itemprop=\"name\"]/parent::div/following::div[@itemprop=\"offers\"]/div/div/div/descendant::span[@class='pdp-final-price']/span")).getText();
        System.out.println(price);
    }
}

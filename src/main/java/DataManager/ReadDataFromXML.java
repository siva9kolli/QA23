package DataManager;

import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class ReadDataFromXML {

    public static void main(String[] args) throws XPathExpressionException {
        readDataFromXML("//userid");
    }

    public static void readDataFromXML(String xpath){
        String xpathResult = null;
        InputSource inputSource = new InputSource(System.getProperty("user.dir") + "/testData/XMLTestData.xml");
        XPath Xpath = XPathFactory.newInstance().newXPath();
        try {
            xpathResult = Xpath.evaluate(xpath, inputSource);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        System.out.println(xpathResult);
    }
}

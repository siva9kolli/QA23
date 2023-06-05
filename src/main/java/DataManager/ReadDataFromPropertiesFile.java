package DataManager;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        try {
             reader=new FileReader(System.getProperty("user.dir") + "/testData/globalProperties.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.load(reader);

        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("id"));
    }

    public String testS(String property) throws IOException {
        FileReader reader = null;
        try {
            reader=new FileReader(System.getProperty("user.dir") + "/testData/globalProperties.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.load(reader);

        System.out.println(properties.getProperty(property));
        return properties.getProperty(property);
    }

    @Test
    public void testB() throws IOException {
        testS("name");
    }


}

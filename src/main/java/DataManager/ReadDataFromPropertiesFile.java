package DataManager;

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
}

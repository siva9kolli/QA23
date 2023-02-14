package DataManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJson {

    public String readValueFromJson(String key){
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir")+ "/testData/jsonData.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject)obj;
        String value = jsonObject.get(key).toString();
        System.out.println(value);
        return value;
    }

    public void createJsonFormat(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Jeo");
        jsonObject.put("id","1");
        jsonObject.put("location", "hyderabad");
        jsonObject.put("email", "joe@ml.com");
        System.out.println(jsonObject);
    }
}

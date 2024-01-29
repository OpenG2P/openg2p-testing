package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

import java.io.FileReader;

public class JSONDataReader {

    private static final String JSON_FILE_PATH = "path_to_your_json_file.json";

    @DataProvider(name = "jsonData")
    public Object[][] readJSONData() {
        Object[][] data = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(JSON_FILE_PATH));

            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");

            if (username != null && password != null) {
                data = new Object[][]{{username, password}};
            } else {
                throw new IllegalArgumentException("Username or password is missing in the JSON data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

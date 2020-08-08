package basic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileData {
    public Properties prop = null;

    public void readPropertiesFile() {
        prop = new Properties();
        try {
            InputStream input = new
                    FileInputStream("config.properties");
            prop.load(input);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}

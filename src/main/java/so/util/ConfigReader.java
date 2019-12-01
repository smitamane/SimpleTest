package so.util;

import java.util.ResourceBundle;

public class ConfigReader {
    private static final ResourceBundle rb = ResourceBundle.getBundle("config");
    public static String getProperty(String key){
        return rb.getString(key);
    }
}

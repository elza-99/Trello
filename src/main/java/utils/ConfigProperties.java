package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigProperties {

    private static final Logger LOGGER = Logger.getLogger(ConfigProperties.class.getName());
    private static final String PATH = "src/test/resources/config.properties";
    public static final String API_KEY = "api-key";
    public static final String TOKEN = "token";
    public static final String BASE_URI = "base-uri";

    public static String getProperty(String property) {

        try (InputStream inputStream = new FileInputStream(PATH)) {
            Properties properties = new Properties();

            properties.load(inputStream);
            return (properties.getProperty(property));
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        return null;
    }

    public static String getApiKey() {
        return ConfigProperties.getProperty(API_KEY);
    }

    public static String getToken() {
        return ConfigProperties.getProperty(TOKEN);
    }

    public static String getBaseUri() {
        return ConfigProperties.getProperty(BASE_URI);
    }
}

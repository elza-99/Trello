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
}

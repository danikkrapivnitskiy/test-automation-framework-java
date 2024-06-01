package project.support.configuration;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    public static Properties property;
    private static final String configPath = "src/main/java/project/support/configuration/config.properties";
    @SneakyThrows
    public static void initializePropertyFile() {
        property = new Properties();
        InputStream inputStream = new FileInputStream(configPath);
        property.load(inputStream);
    }
    public static String getProperty(String key) {
        return property.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(property.getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(property.getProperty(key));
    }

    public static String getIdosUrl() {
        return getProperty("idosUrl");
    }

    public static String getRegioJetUrl() {
        return getProperty("regioJetUrl");
    }

    public static String getDbConnectionPath() {
        return getProperty("dbConnectionPath");
    }
}

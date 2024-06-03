package configuration;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    public static Properties property;
    private static final String configPath =  new File(System.getProperty("user.dir")).getParent()
            + "/CommonUtilities/src/main/resources/config.properties";
    @SneakyThrows
    public static void initializePropertyFile() {
        property = new Properties();
        InputStream inputStream = new FileInputStream(configPath);
        property.load(inputStream);
    }
    public static String getProperty(String key) {
        return property.getProperty(key);
    }

    public static String getIdosUrl() {
        return getProperty("idosUrl");
    }

    public static String getRegioJetUrl() {
        return getProperty("regioJetUrl");
    }

    public static String getRegioJetApiUrl() {
        return getProperty("regioJetApi");
    }

    public static String getOpenLibraryUrl() {
        return getProperty("openLibrary");
    }

    public static String getDbConnectionPath() {
        return getProperty("dbConnectionPath");
    }
}

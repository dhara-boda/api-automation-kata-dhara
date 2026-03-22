package utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties configProperties = new Properties();
    private static Properties testDataProperties = new Properties();

    static {
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            configProperties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Load testdata.properties
        try (InputStream input = PropertyReader.class
                .getClassLoader()
                .getResourceAsStream("testdata.properties")) {

            if (input == null) {
                throw new RuntimeException("Unable to find testdata.properties");
            }
            testDataProperties.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //method (for config)
    public static String getProperty(String key) {
        return configProperties.getProperty(key);
    }

    //method (for test data)
    public static String getTestData(String key) {
        return testDataProperties.getProperty(key);
    }
}
package com.automation.utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    public static void loadProperties() {

        try {
            properties = new Properties();
            FileReader reader = new FileReader("src/test/resources/config/config.properties");
            properties.load(reader);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

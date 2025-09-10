package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    /*
     * This method is used to load the properties from config.properties file.
     * Works in two modes:
     * 1. Jenkins: Reads from system property -Dconfig.file (injected file).
     * 2. Local: Reads from src/test/resources/com/config/config.properties.
     */
    public static Properties init_prop() {
        if (prop == null) {
            prop = new Properties();
            try {
                String configFilePath = System.getProperty("config.file"); // set by Jenkins

                InputStream input;
                if (configFilePath != null) {
                    // Running in Jenkins
                    input = new FileInputStream(configFilePath);
                    System.out.println("Loading config from Jenkins managed file: " + configFilePath);
                } else {
                    // Running locally
                    input = ConfigReader.class.getClassLoader().getResourceAsStream("com/config/config.properties");
                    System.out.println("Loading config from local resources: com/config/config.properties");
                }

                if (input != null) {
                    prop.load(input);
                } else {
                    throw new RuntimeException("Config file not found!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        if (prop == null) {
            init_prop(); // load properties if not already loaded
        }
        return prop.getProperty(key);
    }
}

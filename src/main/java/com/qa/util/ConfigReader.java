package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static Properties init_prop() {
        prop = new Properties();
        InputStream input = null;

        try {
            String configFilePath = System.getProperty("config.file");

            if (configFilePath != null) {
                System.out.println("Loading config from Jenkins path: " + configFilePath);
                input = new FileInputStream(configFilePath);
            } else {
                System.out.println("Loading config from local resources: com/config/config.properties");
                input = ConfigReader.class.getClassLoader()
                        .getResourceAsStream("com/config/config.properties");
            }

            if (input == null) {
                throw new RuntimeException("Config file not found!");
            }

            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file", e);
        }

        return prop;
    }

    public static String getProperty(String key) {
        if (prop == null) {
            init_prop();
        }
        return prop.getProperty(key);
    }
}

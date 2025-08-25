package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	/*
	 * This method is used to load the properties from config.properties file.
	 * 
	 * @return it returns Properties prop object
	 */
	public static Properties init_prop() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/com/config/config.properties");
			prop = new Properties();
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
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

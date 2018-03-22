package utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	private static final String CONFIG_FILE = "/config.properties";
	private static Properties prop = null;

	public static String getValue(String key) {
		String result = null;

		if (prop == null) prop = new Properties();

		InputStream inStream = Properties.class
				.getResourceAsStream(CONFIG_FILE);

		try {
			prop.load(inStream);
			String appurl = System.getProperty("cxm.qa.appurl");
			if (appurl != null) {
				prop.setProperty("appUrl", appurl);
			}

		} catch (Exception e) {
			System.out.println("LOG: error opening file: " + CONFIG_FILE);
			throw new RuntimeException(e);
		}

		result = prop.getProperty(key);

		if (result == null) {
			System.out.println("LOG: property not found: " + key);
		}
		return result;
	}
}

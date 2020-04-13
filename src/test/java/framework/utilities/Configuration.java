package utilities;

import java.util.Properties;

import interfaces.IConfiguration;

public class Configuration implements IConfiguration {

	private Properties globalProperties = null;
	private Properties environmentProperties = null;
	
	public Configuration() {
		globalProperties = new Properties();
		environmentProperties = new Properties();
		
		// Load global configuration
		loadConfig(globalProperties, "global.properties");
		// Get current environment
		String environment = getEnvironment();
		// Load environment based configuration
		loadConfig(environmentProperties, environment + ".properties");
	}
	
	@Override
	public String get(String propertyName) {
		// Check environment based configuration first
		String value = environmentProperties.getProperty(propertyName);
		
		// If nothing exists in environment configurations
		if(value == null) {
			// Then check global configurations
			value = globalProperties.getProperty(propertyName);
		}
		
		return value;
	}

	@Override
	public String getEnvironment() {
		return get("environment");
	}
	
	private void loadConfig(Properties properties, String propertyFileName) {
		try {
			// Load properties from properties file
			properties.load(ResourceHelper.getResourcePathInputStream("properties/" + propertyFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

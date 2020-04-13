package utilities;

import java.util.Properties;

import interfaces.IConfiguration;

public class Configuration implements IConfiguration {

	private Properties globalProperties = null;
	private Properties environmentProperties = null;
	
	public Configuration() {
		globalProperties = new Properties();
		environmentProperties = new Properties();
		
		try {
			globalProperties.load(ResourceHelper.getResourcePathInputStream("properties/global.properties"));
			String environment = getEnvironment();
			environmentProperties.load(ResourceHelper.getResourcePathInputStream("properties/" + environment + ".properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String get(String propertyName) {
		String value = environmentProperties.getProperty(propertyName);
		
		if(value == null) {
			value = globalProperties.getProperty(propertyName);
		}
		
		return value;
	}

	@Override
	public String getEnvironment() {
		return get("environment");
	}
}

package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends Browser {

	public FirefoxBrowser() {
		super("webdriver.gecko.driver", "geckodriver.exe");
	}

	@Override
	public WebDriver getDriver() {
		return new FirefoxDriver();
	}
}

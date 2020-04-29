package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser extends Browser {

	public IEBrowser() {
		super("webdriver.ie.driver", "IEDriverServer.exe");
	}

	@Override
	public WebDriver getDriver() {
		return new InternetExplorerDriver();
	}
}

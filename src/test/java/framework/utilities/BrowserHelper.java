package utilities;

import browsers.Browser;
import browsers.ChromeBrowser;
import browsers.FirefoxBrowser;
import browsers.IEBrowser;

public class BrowserHelper {
	// Create browser instance
	public static Browser getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
			case "firefox":
				return new FirefoxBrowser();
			case "internetexplorer":
			case "ie":
				return new IEBrowser();
			case "chrome":
			default:
				return new ChromeBrowser();
		}
	}
}

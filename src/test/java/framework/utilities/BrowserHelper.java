package utilities;

import browsers.Browser;
import browsers.ChromeBrowser;
import browsers.FirefoxBrowser;

public class BrowserHelper {
	public static Browser getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
			case "chrome":
				return new ChromeBrowser();
			case "firefox":
				return new FirefoxBrowser();
			default:
				return new ChromeBrowser();
		}
	}
}

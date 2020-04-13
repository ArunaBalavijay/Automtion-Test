package utilities;

import browsers.Browser;
import browsers.ChromeBrowser;
import browsers.FirefoxBrowser;
import browsers.IEBrowser;

public class BrowserHelper {
	public static Browser getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
			case "chrome":
				return new ChromeBrowser();
			case "firefox":
				return new FirefoxBrowser();
			case "internetexplorer":
			case "ie":
				return new IEBrowser();
			default:
				return new ChromeBrowser();
		}
	}
}

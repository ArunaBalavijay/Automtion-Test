package utilities;

import browsers.Browser;
import browsers.ChromeBrowser;

public class BrowserHelper {
	public static Browser getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
			case "chrome":
				return new ChromeBrowser();
			default:
				return new ChromeBrowser();
		}
	}
}

package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends Browser {

	public ChromeBrowser() {
		super("webdriver.chrome.driver", "chromedriver.exe");
	}

	@Override
	public WebDriver getDriver() {
		return new ChromeDriver();
	}
}

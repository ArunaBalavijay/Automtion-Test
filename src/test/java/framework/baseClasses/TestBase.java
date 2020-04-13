package baseClasses;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsers.Browser;
import cucumber.api.Scenario;
import interfaces.IConfiguration;
import utilities.BrowserHelper;
import utilities.Configuration;

public class TestBase {
	protected WebDriver driver;
	protected IConfiguration configuration;
	
	public TestBase() {
		configuration = new Configuration();
	}
	
	public void setup(Scenario scenario)
	{
		Browser browser = getBrowser();
		driver = browser.getDriver();
		driver.get(configuration.get("testHost"));
	}
	
	public void teardown(Scenario scenario)
	{
		if(driver != null) {
			if(scenario.isFailed()){
	           saveScreenshotsForScenario(scenario);
	        }
			
			driver.quit();
		}
	}
	
	public void waitUntilElementLocated(WebElement element) {
		int pageTimeOutInSeconds = Integer.parseInt(configuration.get("pageTimeOutInSeconds"));
		WebDriverWait wait = new WebDriverWait(driver, pageTimeOutInSeconds);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.until(elementLocated(element));
	}
	
	private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return element.isDisplayed();
			}
		};
	}
	
	private Browser getBrowser() {
		return BrowserHelper.getBrowser(configuration.get("browser"));
	}
	
	private void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}

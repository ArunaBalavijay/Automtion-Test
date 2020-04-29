package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimpleLogin {
	private WebDriver driver;
	
	@Given("^User is on landing page \"([^\"]*)\"$")
	public void user_is_on_landing_page(String website) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(website);
	    waitTest(By.id("Email"));
	}

	@When("^User is logging in with valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_is_logging_in_with_valid_username_and_password(String username, String password) throws Exception {
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.className("login-button")).click();
	}

	@Then("^User can able to login and view dashboard page$")
	public void user_can_able_to_login_and_view_dashboard_page() throws Exception {
		waitTest(By.linkText("Logout"));
	    driver.quit();
	}
	
	private void waitTest(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/*@Given("^User is on landing page \"([^\"]*)\"$")
	public void user_is_on_landing_page(String website) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(website);
	    Thread.sleep(5000);
	}

	@When("^User enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_valid_username_and_password(String username, String password) throws Exception {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@When("^Click login button$")
	public void click_login_button() throws Exception {
		driver.findElement(By.id("loginbutton")).click();
	}

	@Then("^User logged in successfully$")
	public void user_logged_in_successfully() throws Exception {
		Thread.sleep(15000);
	    driver.quit();
	}*/
}

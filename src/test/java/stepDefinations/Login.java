package stepDefinations;

import org.junit.Assert;

import baseClasses.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class Login extends TestBase {
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	
	public Login() {
		super();
	}
	
	@Before("@RegressionTest")
	public void beforeTest(Scenario scenario)
	{
		// Setup Web driver
		setup(scenario);
	}
	
	@After("@RegressionTest")
	public void afterTest(Scenario scenario)
	{
		// Dispose Web Driver
		teardown(scenario);
	}
	
	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Exception {
		// Create Login POM (Page Object Model)
		loginPage = new LoginPage(driver);
		// Wait until the page loaded and username textbox is visible
		waitUntilElementLocated(loginPage.usernameBox);
	}

	@When("^User is logging in with valid username and password$")
	public void user_is_logging_in_with_valid_username_and_password() throws Exception {
		// Retrieve username and password from configurations (properties file)
		String username = configuration.get("username");
		String password = configuration.get("password");
		
		// Invoke login which can navigate to dashboard page
		// upon successful login
		dashboardPage = loginPage.login(username, password);
		// Wait until the dashboard page loaded and logout button is visible
		waitUntilElementLocated(dashboardPage.logoutButton);
	}

	@Then("^User can able to login$")
	public void user_can_able_to_login() throws Exception {
		// Assert true if dashboard page is loaded and logout button is visible
	    Assert.assertTrue(dashboardPage.logoutButton.isDisplayed());
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

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	public WebElement usernameBox;
	
	@FindBy(id = "Password")
	public WebElement passwordBox;
	
	@FindBy(className = "login-button")
	public WebElement loginButton;
	
	// Invoke login
	public DashboardPage login(String username, String password) {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
		
		return new DashboardPage(driver);
	}

}

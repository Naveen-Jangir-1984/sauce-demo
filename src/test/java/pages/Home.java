package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Reusable;

public class Home {
	private WebDriver driver;
	private Reusable reusable;
	
	private int customWait = 30;
	private String url = "https://www.saucedemo.com/";
	private By usernameInp = By.cssSelector("#user-name");
	private By passwordInp = By.cssSelector("#password");
	private By loginBtn = By.cssSelector("#login-button");
	private By errorTxt = By.cssSelector("h3");
	
	public Home(WebDriver driver) {
		this.driver = driver;
		reusable = new Reusable();
	}
	
	public void launchUrl() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(customWait));
	}
	
	public void enterUsername(String username) {
		reusable.waitClearAndSendKeys(driver, usernameInp, username);
	}
	
	public void enterPassword(String password) {
		reusable.waitClearAndSendKeys(driver, passwordInp, password);
	}
	
	public void clickLogin() {
		reusable.waitAndClick(driver, loginBtn);
	}
	
	public String getErrorText() {
		return reusable.waitAndGetText(driver, errorTxt);
	}
}

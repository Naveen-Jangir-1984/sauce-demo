package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initializeDriver(String browser) {
		switch(browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver());
				break;
			default:
				Assert.assertFalse(driver.get() == null, browser + "driver not initilized!");
		}
	}
	
	public static WebDriver getDriverInstance() {
		return driver.get();
	}
}

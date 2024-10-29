package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Reusable {
	private static WebDriverWait wait;
	private static long customWait = 30;
	
	public static void waitClearAndSendKeys(WebDriver driver, By locator, String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	
	public static void waitAndClick(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
	}
}

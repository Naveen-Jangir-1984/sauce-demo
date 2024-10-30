package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable {
	private WebDriverWait wait;
	private long customWait = 30;
	
	public void waitClearAndSendKeys(WebDriver driver, By locator, String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	
	public void waitAndClick(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
	}
	
	public String waitAndGetText(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	public List<WebElement> waitAndGetWebElementsList(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elements;
	}
}

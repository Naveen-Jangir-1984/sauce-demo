package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable {
	private WebDriverWait wait;
	private long customWait = 30;
	
	public boolean isVisible(WebDriver driver, By locator) {
		boolean flag = false;
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		flag = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
		return flag;
	}
	
	public void waitClearAndSendKeys(WebDriver driver, By locator, String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	public void waitAndClick(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}
	
	public void waitAndClick(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		wait.until(ExpectedConditions.visibilityOf(element)).click();;
	}
	
	public String waitAndGetText(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText().trim();
	}
	
	public List<WebElement> waitAndGetWebElementsList(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elements;
	}
	
	public void waitAndSelectByText(WebDriver driver, By locator, String option) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(customWait));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	
	public boolean isPriceListSorted(List<Double> list, String order) {
		boolean flag = true;
		for(int i=0; i<list.size() - 1; i++) {
			if((order.equals("low to high") && list.get(i) > list.get(i+1)) || (order.equals("high to low") && list.get(i) < list.get(i+1))) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public boolean isNameListSorted(List<String> list, String order) {
		boolean flag = true;
		for(int i=1; i<list.size(); i++) {
      if ((order.equals("A to Z") && list.get(i - 1).compareTo(list.get(i)) > 0) || (order.equals("Z to A") && list.get(i - 1).compareTo(list.get(i)) < 0)) {
        return false;
      }
    }
		return flag;
	}
}

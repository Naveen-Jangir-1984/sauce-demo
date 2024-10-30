package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
	private WebDriver driver;
	
	private By appLogoTxt = By.cssSelector(".app_logo");
	private By itemsList = By.cssSelector(".inventory_item");
	
	public Inventory(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAppLogoText() {
		return driver.findElement(appLogoTxt).getText();
	}
	
	public int getItemsListCount() {
		return driver.findElements(itemsList).size();
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Reusable;

public class Inventory {
	private WebDriver driver;
	private Reusable reusable;
	
	private By appLogoTxt = By.cssSelector(".app_logo");
	private By itemsList = By.cssSelector(".inventory_item");
	
	public Inventory(WebDriver driver) {
		this.driver = driver;
		reusable = new Reusable();
	}
	
	public String getAppLogoText() {
		return reusable.waitAndGetText(driver, appLogoTxt);
	}
	
	public int getItemsListCount() {
		return reusable.waitAndGetWebElementsList(driver, itemsList).size();
	}
}

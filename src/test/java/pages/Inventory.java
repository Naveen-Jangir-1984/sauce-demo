package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Reusable;

public class Inventory {
	private WebDriver driver;
	private Reusable reusable;
	
	private By appLogoTxt = By.cssSelector(".app_logo");
	private By itemsList = By.cssSelector(".inventory_item");
	private By itemNamesList = By.cssSelector(".inventory_item_name");
	private By itemPricesList = By.cssSelector(".inventory_item_price");
	private By filterDrp = By.cssSelector(".product_sort_container");
	
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
	
	public void applyFilter(String option) {
		reusable.waitAndSelectByText(driver, filterDrp, option);
	}
	
	public List<Double> getPriceList() {
		List<WebElement> elementList = reusable.waitAndGetWebElementsList(driver, itemPricesList);
		List<Double> priceList = new ArrayList<Double>();
		for(WebElement element : elementList) {
			priceList.add(Double.parseDouble(element.getText().trim().replace("$", "")));
		}
		return priceList;
	}
	
	public List<String> getNameList() {
		List<WebElement> elementList = reusable.waitAndGetWebElementsList(driver, itemNamesList);
		List<String> nameList = new ArrayList<String>();
		for(WebElement element : elementList) {
			nameList.add(element.getText().trim());
		}
		return nameList;
	}
}

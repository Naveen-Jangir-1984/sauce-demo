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
	
	private By titleText = By.cssSelector(".title");
	private By productList = By.cssSelector(".inventory_item");
	private By productNameList = By.cssSelector(".inventory_item_name");
	private By addToCardBttn(String product) {
		return By.xpath("//*[@class='inventory_item_name ' and contains(text(),'" + product + "')]//ancestor::div[@class='inventory_item_label']//following-sibling::div//button");
	}
	private By productPriceList = By.cssSelector(".inventory_item_price");
	private By filterDrop = By.cssSelector(".product_sort_container");
	private By sideBarBttn = By.cssSelector("#react-burger-menu-btn");
	private By logoutBttn = By.cssSelector("#logout_sidebar_link");
	private By cartLink = By.cssSelector(".shopping_cart_link");
	
	public Inventory(WebDriver driver) {
		this.driver = driver;
		reusable = new Reusable();
	}
	
	public String getTitleText() {
		return reusable.waitAndGetText(driver, titleText);
	}
	
	public int getItemsListCount() {
		return reusable.waitAndGetWebElementsList(driver, productList).size();
	}
	
	public void applyFilter(String option) {
		reusable.waitAndSelectByText(driver, filterDrop, option);
	}
	
	public List<Double> getPriceList() {
		List<WebElement> elementList = reusable.waitAndGetWebElementsList(driver, productPriceList);
		List<Double> priceList = new ArrayList<Double>();
		for(WebElement element : elementList) {
			priceList.add(Double.parseDouble(element.getText().trim().replace("$", "")));
		}
		return priceList;
	}
	
	public List<String> getNameList() {
		List<WebElement> elementList = reusable.waitAndGetWebElementsList(driver, productNameList);
		List<String> nameList = new ArrayList<String>();
		for(WebElement element : elementList) {
			nameList.add(element.getText().trim());
		}
		return nameList;
	}
	
	public void clickSideBarButton() {
		reusable.waitAndClick(driver, sideBarBttn);
	}
	
	public void clickLogoutButton() {
		reusable.waitAndClick(driver, logoutBttn);
	}
	
	public void clickAddToCartButton(String product) {
		reusable.waitAndClick(driver, addToCardBttn(product));
	}
	
	public void clickCartLink() {
		reusable.waitAndClick(driver, cartLink);
	}
}

package stepDefinitions;

import org.testng.Assert;

import config.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Inventory;
import utility.Reusable;

public class InventoryStepDef {
	
	private Inventory inventory;
	private Reusable reusable;
	
	public InventoryStepDef() {
		inventory = new Inventory(Browser.getDriverInstance());
		reusable = new Reusable();
	}
	
	@Then("^number of items displayed are ([^\"]*)$")
	public void numberOfItemsDisplayedAre(String expected) {
		Assert.assertTrue(Integer.parseInt(expected) == inventory.getItemsListCount());
	}
	
	@When("^user selects filter as ([^\"]*)$")
	public void userSelectsFilterOptionAs(String option) {
		switch(option) {
			case "a to z":
			case "z to a":
				inventory.applyFilter("Name (" + option + ")");
				break;
			case "low to high":
			case "high to low":
				inventory.applyFilter("Price (" + option + ")");
				break;
		}	
	}
	
	@When("^user clicks on add to cart button for ([^\"]*)$")
	public void userSelectsProductAs(String product) {
		inventory.clickAddToCartButton(product);
	}
	
	@Then("^products are displayed in ([^\"]*) order$")
	public void productssAreDisplayedInOrder(String order) {
		switch(order) {
			case "a to z":
			case "z to a":
				Assert.assertTrue(reusable.isNameListSorted(inventory.getNameList(), order));
				break;
			case "low to high":
			case "high to low":
				Assert.assertTrue(reusable.isPriceListSorted(inventory.getPriceList(), order));
				break;
		}
	}
	
	@Then("^([^\"]*) is displayed on the cart$")
	public void isDisplayedOnTheCart(String product) {
		inventory.clickCartLink();
		Assert.assertTrue(inventory.getNameList().contains("Sauce Labs " + product));
	}
}

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
	
	@When("^user selects filter option as ([^\"]*)$")
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
	
	@Then("^items are displayed in ([^\"]*) order$")
	public void itemsAreDisplayedInOrder(String order) {
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
}

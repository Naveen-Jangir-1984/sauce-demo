package stepDefinitions;

import org.testng.Assert;

import config.Browser;
import io.cucumber.java.en.Then;
import pages.Inventory;

public class InventoryStepDef {
	
	private Inventory inventory = new Inventory(Browser.getDriverInstance());
	
	@Then("^number of items displayed are ([^\"]*)$")
	public void numberOfItemsDisplayedAre(String expected) {
		Assert.assertTrue(Integer.parseInt(expected) == inventory.getItemsListCount());
	}
}

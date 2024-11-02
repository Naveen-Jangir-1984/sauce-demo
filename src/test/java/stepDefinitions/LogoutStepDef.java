package stepDefinitions;

import org.testng.Assert;

import config.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home;
import pages.Inventory;

public class LogoutStepDef {
	
	private Home home;
	private Inventory inventory;
	
	public LogoutStepDef() {
		home = new Home(Browser.getDriverInstance());
		inventory = new Inventory(Browser.getDriverInstance());
	}
	
	@When("^user clicks logout button$")
	public void userClicksLogoutButton() {
		inventory.clickSideBarButton();
		inventory.clickLogoutButton();
	}
	
	@Then("^user logs out$")
	public void userLogsOut() {
		Assert.assertTrue(home.isUsernameVisible());
	}
}

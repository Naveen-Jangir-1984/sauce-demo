package stepDefinitions;

import org.testng.Assert;

import config.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home;
import pages.Inventory;

public class AccessStepDef {
	
	private Home home;
	private Inventory inventory;
	
	public AccessStepDef() {
		home = new Home(Browser.getDriverInstance());
		inventory = new Inventory(Browser.getDriverInstance());
	}
	
	@Given("^user is on the login page$")
	public void userIsOnTheLoginPage() {
		home.launchUrl();
	}
	
	@When("^user enters ([^\"]*) as username$")
	public void userEntersAsUsername(String username) {
		home.enterUsername(username);
	}
	
	@When("^user enters ([^\"]*) as password$")
	public void userEntersAsPassword(String password) {
		home.enterPassword(password);
	}
	
	@When("user clicks login button$")
	public void userClicksLoginButton() {
		home.clickLogin();
	}
	
	@When("^user clicks logout button$")
	public void userClicksLogoutButton() {
		inventory.clickSideBarButton();
		inventory.clickLogoutButton();
	}
	
	@Then("^user is able to see ([^\"]*)$")
	public void userIsLoggedIn(String expected) {
		Assert.assertTrue(expected.equalsIgnoreCase(inventory.getTitleText()));		
	}
	
	@Then("^user gets an error which contains ([^\"]*)$")
	public void userGetsAnError(String expected) {
		Assert.assertTrue(home.getErrorText().contains(expected));
	}
	
	@Then("^user logs out$")
	public void userLogsOut() {
		Assert.assertTrue(home.isUsernameVisible());
	}	
}

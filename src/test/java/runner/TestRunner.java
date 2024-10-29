package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import config.Browser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(
	tags = "@valid", 
	features = {"src/test/resources/features/Login.feature"}, 
	glue = {"stepDefinitions"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		Browser.initializeDriver(browser);
	}
	
	@AfterTest
	public void tearDown() {
		Browser.getDriverInstance().quit();
	}
}

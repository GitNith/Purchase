package stepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import reusableOperations.BrowserOps;

public class Hooks {
	
	WebDriver driver;
	
	BrowserOps browser = new BrowserOps();
	
	
	@BeforeMethod
	public void LaunchBrowser() throws IOException {
		browser.BrowserLaunch();
	}

	@AfterMethod
	public void Afterscenario() {
		driver.quit();
	}
}

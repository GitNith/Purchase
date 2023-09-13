package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectsBestBuy.ShoppingCartObjects;
import reusableOperations.BrowserOps;
import reusableOperations.ReusableUtils;

public class ShoppingCart extends ReusableUtils{
	
	public ShoppingCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;

	
	BrowserOps browser = new BrowserOps();

	ShoppingCartObjects cart = new ShoppingCartObjects(driver);

	
	
	@When("When User clicks on the Shopping Cart")
	
	public void ShoppingCartPage() {
	cart.gotocart();
	}
	
	@Then("Validate Order Summary and Check Out option is enabled")
	public void CheckoutEnabled() {
	Assert.assertEquals(cart.OrderSummary(), true);
	
	}

}

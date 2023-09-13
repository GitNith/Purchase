package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectsBestBuy.LandingPage;
import pageObjectsBestBuy.ProductsCatalogue;
import reusableOperations.BrowserOps;

public class addToCart extends BrowserOps {
	public WebDriver driver;
	ProductsCatalogue prodcat = new ProductsCatalogue(driver);
	BrowserOps browser = new BrowserOps();
	
	
	@Given("User is on the BestBuy Website")
	public void user_is_on_the_best_buy_website() throws IOException {
		
		System.out.println(driver.getTitle());
//	    
	    }
	
	@When("^User enters (.+) in the search bar$")
	public void user_enters_the_productname_in_the_search_bar(String productname) {
	    LandingPage landingPage = new LandingPage(driver);
	    landingPage.searchitem(productname); 
	}
	@Then("List of products are displayed")
	public void list_of_products_are_displayed() {
	   prodcat.getProductsList();
	}
	
	
	@And("^User locates the item by the modelnumber (.+) from Search results and add product to cart$")
	
	public void locate_item_by_modelnumber(String model) {
		ProductsCatalogue prodcat = new ProductsCatalogue(driver);
		List<WebElement> helper = prodcat.findtargethelper(model);
		
		for(int i=0;i<(helper.size());i++){
			
			String Childhelper = helper.get(i).getText();
			if (Childhelper == model) {
				
				String targetitemname = helper.get(i).findElement(By.xpath("//ancestor::h4")).getText();
				Assert.assertEquals(targetitemname, "Apple - Pre-Owned iPhone 13 Pro 5G 128GB (Unlocked) - Graphite");
				WebElement parent = helper.get(i).findElement(By.xpath("//ancestor::li"));
				 
				String targetitemprice = parent.findElement(By.xpath("//div[@data-testid='customer-price']")).getText();
				Assert.assertEquals(targetitemprice, "$879.99");
				
				parent.findElement(By.xpath("//div[@class='sli-add-to-cart']")).click();			
				
			}
			
		}
		
		
	}
	
	@Then("Validate the item are added to the cart")
	
	public void itemaddedmessage() {
		WebElement cartconfirm = driver.findElement(By.xpath("//span[@class='added-to-cart']"));
		Assert.assertTrue(cartconfirm.isDisplayed());
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
	}
	
 
}


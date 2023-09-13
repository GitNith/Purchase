package pageObjectsBestBuy;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableOperations.ReusableUtils;

public class LandingPage extends ReusableUtils {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@class='search-input']")
	WebElement searchBar;
	
	
	public void searchitem(String productname) {
		searchBar.sendKeys(productname + Keys.ENTER);
	}
}	

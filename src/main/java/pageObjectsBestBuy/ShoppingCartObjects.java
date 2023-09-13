package pageObjectsBestBuy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableOperations.ReusableUtils;

public class ShoppingCartObjects extends ReusableUtils {
	
	WebDriver driver;
	
	public ShoppingCartObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		@FindBy(xpath="//span[contains(@class,'cart-label')]")
		WebElement Cartlink;
		
		By cartproducts = By.xpath("//div[@class='order-summary ']");
	
		@FindBy(css=(".checkout-buttons"))
				WebElement CheckOutButton;
		
		
		public void gotocart() {
			Cartlink.click();
			waitForElements(cartproducts);
		}
		
		public boolean OrderSummary() {
			waitForElements(cartproducts);
			CheckOutButton.isDisplayed();
			return true;
		}

		
		
}

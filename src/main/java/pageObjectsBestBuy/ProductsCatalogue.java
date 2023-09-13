package pageObjectsBestBuy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableOperations.ReusableUtils;

public class ProductsCatalogue extends ReusableUtils{

	WebDriver driver;
		public ProductsCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ol[@class='sku-item-list']")
	List <WebElement> products;
	
	By productsBy = By.xpath("//ol[@class='sku-item-list']");
	
	
	
	
	public List<WebElement> findtargethelper(Object model) {
		
		Stream<WebElement> prodStream=products.stream();
		List<WebElement> targethelper = (List<WebElement>) prodStream
				.filter(m->((List<WebElement>) m).contains(model))
				.collect(Collectors.toList());
		
		return targethelper;
		
	}
	
	
	
	public List<WebElement> getProductsList() {
		waitForElements(productsBy);
		return products;
	}
	
	
	
	

	
	
		
		
			
		
	
}

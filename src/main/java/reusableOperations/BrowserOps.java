package reusableOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOps {

	public WebDriver driver;
	
	public WebDriver BrowserLaunch() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String urlundertest = prop.getProperty("url");
		
		if(driver==null)
		{
			if(prop.getProperty("browser")=="firefox")
				{
						driver = new FirefoxDriver();
				}
			
			if(prop.getProperty("browser")=="Chrome")
				{
						driver = new ChromeDriver();
				}
			driver.get(urlundertest);
	}
		return driver;
}
}

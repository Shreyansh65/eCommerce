package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;

	public WebDriver intializeDriver() {
	
		String browserName = "chrome";
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}
}

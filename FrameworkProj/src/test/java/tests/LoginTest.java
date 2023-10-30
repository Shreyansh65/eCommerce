package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	WebDriver driver;

	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String status) throws IOException, InterruptedException {
		
	 driver = intializeDriver();
	driver.get("https://tutorialsninja.com/demo/");
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		
		Thread.sleep(8000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys();
		loginPage.passwordField().sendKeys();
		loginPage.loginButton().click();
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult;
		
		try {
			
			accountPage.editAccountInformationOption();
			actualResult = "Successfull";
			
		}catch(Exception e) {
			actualResult = "Failure";
		}
		
		Assert.assertEquals(actualResult, status);
		
        		
	}
	
	@AfterMethod
	public void closure() {
		
		driver.close();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"shreyanshsrivastava555@gmail.com","Qwerty@123","Successfull"},{"wrongtest@gmail.com","12345","Failed"}};
	    
		return data;
		
	}
	
}

package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageFactory.HomePage;
import Parent.Parent;
import Utilities.RetryAnalyzer;

public class DropDownOption extends Parent {
	
	public WebDriver driver;
	HomePage home;
	
	@BeforeMethod
	public void setup() throws IOException {
	driver = initializeBrowser() ;
	driver.get(prop.getProperty("url"));
	cookiePopUpBlock();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(retryAnalyzer =RetryAnalyzer.class)
	public void hoverOver() {
		home= new HomePage(driver);
		home.HoverOverPaintsAndTextures();
		Assert.assertTrue(home.DropDownBox().isDisplayed());
	}
	
}

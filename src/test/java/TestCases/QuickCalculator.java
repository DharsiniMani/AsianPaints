package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.HomePage;
import PageFactory.PaintBudgetCalculatorPage;
import Parent.Parent;
import Utilities.RetryAnalyzer;
import Utilities.TestDataUtil;

public class QuickCalculator extends Parent{
	public WebDriver driver;
	
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
	public void QuickCalculatorWithValidCarpetArea() throws InterruptedException {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		pbc.enterArea(prop.getProperty("validArea"));
		pbc.clickCalculateNow();
		Assert.assertTrue(pbc.estimatedCostforQuickCalculator().size()!=0 && pbc.recommendedProductsforQuickCalculator().size()!=0);
	}
	@Test(retryAnalyzer =RetryAnalyzer.class)
	public void QuickCalculatorWithNullCarpetArea() {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		pbc.enterArea("");
		pbc.clickCalculateNow();
		Assert.assertTrue(pbc.fieldRequiredMessage().isDisplayed());
	}
	
	@Test(dataProvider="carpetArea")
	public void QuickCalculatorWithInvalidCarpetArea(String area) {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		pbc.enterArea(area);
		pbc.clickCalculateNow();
		Assert.assertTrue(pbc.errorMessage().isDisplayed());
	}
	
	@DataProvider
	public Object[][] carpetArea(){
		Object[][] data = null;
		try {
			data = TestDataUtil.getTestData("CarpetArea");
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}

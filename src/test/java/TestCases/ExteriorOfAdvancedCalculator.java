package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import PageFactory.AdvancedCalculatorPage;
import PageFactory.HomePage;
import PageFactory.PaintBudgetCalculatorPage;
import Parent.Parent;
import Utilities.TestDataUtil;

public class ExteriorOfAdvancedCalculator extends Parent{
	
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
	@Test
	public void AdvancedCalculatorWithValidCarpetArea() {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		AdvancedCalculatorPage ac=pbc.openAdvancedCalculator();
		ac.clickExterior();
		ac.enterArea(prop.getProperty("validArea"));
		ac.clickCalculateNow();
		Assert.assertTrue(pbc.recommendedProductsforQuickCalculator().size()!=0&&pbc.estimatedCostforQuickCalculator().size()!=0);
	}
	@Test
	public void QuickCalculatorWithNullCarpetArea() {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		AdvancedCalculatorPage ac=pbc.openAdvancedCalculator();
		ac.clickExterior();
		ac.doubleClickCalculateNow();
		Assert.assertTrue(pbc.fieldRequiredMessage().isDisplayed());
	}
	
	@Test(dataProvider="carpetArea")
	public void AdvancedCalculatorWithInvalidCarpetArea(String area) {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		AdvancedCalculatorPage ac=pbc.openAdvancedCalculator();
		ac.clickExterior();
		ac.enterArea(area);
		ac.clickCalculateNow();
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

package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.AdvancedCalculatorPage;
import PageFactory.HomePage;
import PageFactory.PaintBudgetCalculatorPage;
import Parent.Parent;
import Utilities.RetryAnalyzer;
import Utilities.TestDataUtil;

public class InteriorOfAdvancedCalculator extends Parent  {
public WebDriver driver;
AdvancedCalculatorPage ac;
int counter;
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
	
	public void AdvancedCalculatorWithValidvalues() {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		ac=pbc.openAdvancedCalculator();
		ac.enterValues(prop.getProperty("width"), prop.getProperty("length"),prop.getProperty("height"),prop.getProperty("noOfWindows"), prop.getProperty("noOfDoors"));
		ac.walls( prop.getProperty("wallA"), prop.getProperty("wallB"),prop.getProperty("wallC"), prop.getProperty("wallD"),prop.getProperty("ceiling"),prop.getProperty("paintProduct"),prop.getProperty("textureProduct"),prop.getProperty("wallpaperPaperProduct"));
		ac.clickInteriorCalculateNow();
		Assert.assertTrue(ac.estimatedCostforAdvancedCalculator().size()!=0&&ac.recommendedProductsforAdvancedCalculator().isDisplayed());	
	}	
	
	@Test(retryAnalyzer =RetryAnalyzer.class)
	public void AdvancedCalculatorWithNullvalues() {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		ac=pbc.openAdvancedCalculator();
		ac.clickInteriorCalculateNow();
		Assert.assertTrue(ac.RequiredFieldError3().size()==3&& ac.RequiredFieldError4().size()==4&&ac.RequiredGlobalError().isDisplayed());
	}
	
	@Test(retryAnalyzer =RetryAnalyzer.class ,dataProvider="ExteriorPage" )
	public void AdvancedCalculatorWithInalidvalues(String width, String length, String height, String noOfWindows, String noOfDoors, String wallA, String wallB,String wallC, String wallD, String ceiling, String paintProduct, String textureProduct, String wallpaperPaperProduct) {
		HomePage home= new HomePage(driver);
		PaintBudgetCalculatorPage pbc= home.OpenPaintBudgetCalculator();
		ac=pbc.openAdvancedCalculator();
		ac.enterValues(width, length, height, noOfWindows, noOfDoors);
		ac.walls( wallA, wallB,wallC, wallD, ceiling, paintProduct,textureProduct,wallpaperPaperProduct);
		ac.clickInteriorCalculateNow();
		Assert.assertTrue(ac.widthLenghtHeightError().size()==3&&ac.windowDoorError().size()==2);
		
	}
	@DataProvider
	public Object[][] ExteriorPage(){
		Object[][] data = null;
		try {
			data = TestDataUtil.getTestData("ExteriorPage");
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}

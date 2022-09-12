package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaintBudgetCalculatorPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public PaintBudgetCalculatorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css="input[name='SQ_FT_VALUE']")
	private WebElement carpetAreaBox;
	
	@FindBy(xpath="//div[@class='ctaComp calculate-now track_calculate']")
	private WebElement calculateNow;
	
	@FindBys({@FindBy (id="quickCalculator")})
	private List<WebElement> recommendedProductsforQuickCalculator;
	
	@FindBys({@FindBy (xpath="//div [@class='budget-estimation d-flex justify-content-between']")})
	private List<WebElement> estimatedCostforQuickCalculator;
	
	@FindBy(xpath="//div[normalize-space()='Field should contain non-decimal value greater than 0']")
	WebElement errorMessage;
	
	@FindBy(xpath="//a[normalize-space()='Advanced calculator']")
	private WebElement advancedCalculator;	
	
	public void enterArea(String area) {
		carpetAreaBox.sendKeys(area);
	}
	
	public void clickCalculateNow() {
		calculateNow.click();
	}
	
	public List<WebElement> recommendedProductsforQuickCalculator() {
		return recommendedProductsforQuickCalculator;
	}
	
	public List<WebElement> estimatedCostforQuickCalculator() {
		return estimatedCostforQuickCalculator;
	}
	
	public AdvancedCalculator openAdvancedCalculator() {
		advancedCalculator.click();
		return new AdvancedCalculator(driver);
	}
	
	public WebElement errorMessage() {
		return errorMessage;

	}
	
}

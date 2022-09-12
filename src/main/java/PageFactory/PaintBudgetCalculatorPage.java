package PageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaintBudgetCalculatorPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js; 
	
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
	private WebElement errorMessage;
	
	@FindBy(xpath="//a[normalize-space()='Advanced calculator']")
	private WebElement advancedCalculator;	
	
	@FindBy(xpath="//div[text()='Field is required']")
	private WebElement fieldRequiredMessage;
	
	public void enterArea(String area) {
		carpetAreaBox.sendKeys(area);
	}
	
	public void clickCalculateNow() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(calculateNow));
		calculateNow.click();
	}
	
	public List<WebElement> recommendedProductsforQuickCalculator() {
		return recommendedProductsforQuickCalculator;
	}
	
	public List<WebElement> estimatedCostforQuickCalculator() {
		return estimatedCostforQuickCalculator;
	}
	
	public AdvancedCalculatorPage openAdvancedCalculator() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(advancedCalculator));
		Actions action=new Actions(driver);
		action.scrollToElement(advancedCalculator);
		js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", advancedCalculator);
		return new AdvancedCalculatorPage(driver);
	}
	
	public WebElement errorMessage() {
		return errorMessage;

	}
	
	public WebElement fieldRequiredMessage() {
		wait.until(ExpectedConditions.visibilityOf(fieldRequiredMessage));
		return fieldRequiredMessage;
	}
	
}

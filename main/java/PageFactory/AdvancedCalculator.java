package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedCalculator {
	

	WebDriver driver;
	WebDriverWait wait;
	
	public AdvancedCalculator(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Exterior']/preceding-sibling::span[@class='spriteIcon-Aprevamp  customRadio-checked']")
	private WebElement exterior;
	
	@FindBy(css=" form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
	private WebElement carpetAreaBox;
	
	@FindBy(xpath="(//div[@class='ctaComp calculate-now track_calculate'])[2]")
	private WebElement calculateNow;
	
	@FindBys({@FindBy (id="advanceCalculator")})
	private List<WebElement> recommendedProductsforAdvancedCalculator;
	
	@FindBys({@FindBy (xpath="//div[@id='budgetEstimationSummary']")})
	private List<WebElement> estimatedCostforAdvancedCalculator;

	@FindBy(id="Width")
	private WebElement width;
	
	
	public void clickExterior() {
		exterior.click();
	}
	
	public void enterArea(String area) {
		carpetAreaBox.sendKeys(area);
	}
	
	public void clickCalculateNow() {
		calculateNow.click();
	}
	
	public List<WebElement> recommendedProductsforAdvancedCalculator() {
		return recommendedProductsforAdvancedCalculator;
	}
	
	public List<WebElement> estimatedCostforAdvancedCalculator() {
		return estimatedCostforAdvancedCalculator;
	}
	
}

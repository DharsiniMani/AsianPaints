package PageFactory;

import java.lang.reflect.Method;
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



public class AdvancedCalculatorPage {
	

	WebDriver driver;
	WebDriverWait wait; 
	String[] pwall;
	Actions action;
	JavascriptExecutor js; 
	
	public AdvancedCalculatorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group-global > .productItemWrap:nth-child(2) .form-global:nth-child(2) .spriteIcon-Aprevamp")
	private WebElement exterior;
	
	@FindBy(xpath="(//div[contains(@class,'')]//input[contains(@placeholder,'Ex: 1200')])[2]")
	private WebElement carpetAreaBox;
	
	@FindBy(xpath="//button[normalize-space()='CALCULATE NOW']")
	private WebElement calculateNow;
	
	@FindBy(xpath="//button[normalize-space()='CALCULATE NOW']")
	private WebElement interiorCalculateNow;
	
	@FindBy (xpath="//a[@class='d-inline-block mb-3']")
	private WebElement recommendedProductsforAdvancedCalculator;
	
	@FindBys({@FindBy (xpath="//div[@id='budgetEstimationSummary']")})
	private List<WebElement> estimatedCostforAdvancedCalculator;

	@FindBy(id="Width")
	private WebElement width;
	
	@FindBy(id="Length")
	private WebElement lenght;
	
	@FindBy(id="Height")
	private WebElement height;
	
	@FindBy(id="window")
	private WebElement noOfWindows;
	
	@FindBy(id="door")
	private WebElement noOfDoors;
	
	@FindBy(css="input[name='WALLA']")
	private WebElement wallA;
	
	@FindBy(css="input[name='WALLB']")
	private WebElement wallB;
	
	@FindBy(css="input[name='WALLC']")
	private WebElement wallC;
	
	@FindBy(css="input[name='WALLD']")
	private WebElement wallD;
	
	@FindBy(xpath="//div[@class='form-dropdown__custom-variant--target']//a[contains(text(),'Paint')]")
	private List <WebElement> paint;
	
	@FindBy(xpath="//div[@class='form-dropdown__custom-variant--target']//a[contains(text(),'Texture')]")
	private List <WebElement> texture;
	
	@FindBy(xpath="//div[@class='form-dropdown__custom-variant--target']//a[contains(text(),'Wallpaper')]")
	private List <WebElement> wallpaper;
	
	@FindBy(xpath="//span[@class='spriteIcon-Aprevamp customCheckBox-unchecked']")
	private WebElement ceiling;
	
	@FindBys({@FindBy(xpath="//div[@class='roomCalculatorComp__ChooseProductSection-step3']//span[@class='spriteIcon-Aprevamp  customRadio-checked']")})
	private List <WebElement> radiobtnForchooseProduct;
	
	@FindBy(xpath="//div[@class='roomCalculatorComp__ChooseProductSection-step3']//span[@class='spriteIcon-Aprevamp customRadio-checked']")
	private WebElement radiobtnForRoyale;
	
	@FindBys({@FindBy(xpath="//div[text()='Field should contain only positive numbers with upto 2 decimals greater than 0']")})
	private List <WebElement> errorMessage1;
	
	@FindBys({@FindBy(xpath="//div[text()='Field should contain only numbers']")})
	private List <WebElement> errorMessage2;
	
	@FindBys({@FindBy(xpath="//div[normalize-space()='Choose an option']")})
	private List <WebElement> errorMessageforWalls;
	
	@FindBys({@FindBy(xpath="//div[contains(text(),'Field is required')]")})
	private List <WebElement> errorMessageforWLH;
	
	@FindBy(xpath="//div[@class='form-group-global--error']")
	private WebElement globalError;
	
	public void clickExterior() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(exterior));
		js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", exterior);
	}
	
	public void enterArea(String area) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(carpetAreaBox));
		carpetAreaBox.sendKeys(area);
	}
	
	public void clickCalculateNow() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(calculateNow));
		calculateNow.click();
	}
	public void doubleClickCalculateNow() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(calculateNow));
		calculateNow.click();
		calculateNow.click();
	}
	
	public WebElement recommendedProductsforAdvancedCalculator() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(recommendedProductsforAdvancedCalculator));
		return recommendedProductsforAdvancedCalculator;
	}
	
	public List<WebElement> estimatedCostforAdvancedCalculator() {
		return estimatedCostforAdvancedCalculator;
	}

	
	public void enterValues(String width,String length,String height,String windows,String doors) {
		this.width.sendKeys(width);
		this.lenght.sendKeys(length);
		this.height.sendKeys(height);
		this.noOfWindows.sendKeys(windows);
		this.noOfDoors.sendKeys(doors);
		
	}
	public void walls(String wallA, String wallB,String wallC, String wallD, String ceiling, String paintType,String textureType, String wallpaperType) {
		pwall = new String[] {wallA,wallB,wallC,wallD};
		WebElement[] twall = {this.wallA,this.wallB,this.wallC,this.wallD};
		js = (JavascriptExecutor)driver;
		for(int i=0; i<4;i++) {
			if(pwall[i].equals("paint")){
				
				twall[i].click();
				paint.get(i).click();
			}
			else if(pwall[i].equals("texture")){
				twall[i].click();
				texture.get(i).click();
			}
			else if(pwall[i].equals("wallpaper")){
				twall[i].click();
				wallpaper.get(i).click();
			}
		}
		if(ceiling.equals("yes")) {
			this.ceiling.click();
		}
		
			if(pwall.equals("paint")){
				switch(paintType) {
				case "Royale" : js.executeScript("arguments[0].click();", radiobtnForRoyale);radiobtnForRoyale.click();
				break;
				case "Apocolite" :js.executeScript("arguments[0].click();",radiobtnForchooseProduct.get(0)); 
				break;			
				case "Tractor": js.executeScript("arguments[0].click();", radiobtnForchooseProduct.get(1));
	
			}
		
		}
		else if(pwall.equals("texture")){
			switch(textureType) {
			case "Economy":js.executeScript("arguments[0].click();", radiobtnForchooseProduct.get(2));
			break;
			case "Premium" : js.executeScript("arguments[0].click();", radiobtnForchooseProduct.get(3));
			break; 
			case "Luxury": js.executeScript("arguments[0].click();", radiobtnForchooseProduct.get(4));

			}
		}
		else if(pwall.equals("wallpaper")){
			switch(wallpaperType) {
			case "Economy" : radiobtnForchooseProduct.get(5).click();
			break;
			case "Premium" : radiobtnForchooseProduct.get(6).click();
			break;			
			case "Luxury": radiobtnForchooseProduct.get(7).click();

			}
		}
		
	}
	public void clickInteriorCalculateNow() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(interiorCalculateNow));
		js = (JavascriptExecutor)driver;
		interiorCalculateNow.click();
	}
	
	public List<WebElement> widthLenghtHeightError() {
		return errorMessage1;
	}
	
	public List<WebElement> windowDoorError() {
		return errorMessage2;
	}
	
	public List<WebElement> RequiredFieldError4() {
		return errorMessageforWalls;
	}
	
	public List<WebElement> RequiredFieldError3() {
		return errorMessageforWLH;
	}
	
	public WebElement RequiredGlobalError() {
		return globalError;
	}
}

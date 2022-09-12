package PageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//a[@class='track_section nav-link dropdown-toggle iconTextLinks iconsWithText__wrap'])[1]")
	private WebElement PaintsAndTextures;
	
	@FindBy(className="dropdown-menu__container--list-holder")
	private WebElement DropDownOption;
	
	@FindBy(partialLinkText="Paint Budget Calculator")
	private WebElement paintBudgetCalculator;
	
	public void HoverOverPaintsAndTextures() {
		action= new Actions(driver);
		action.moveToElement(PaintsAndTextures).perform();
	}
	
	public WebElement DropDownBox() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DropDownOption));
		return DropDownOption;
	}
	
	public PaintBudgetCalculatorPage OpenPaintBudgetCalculator() {
		paintBudgetCalculator.click();
		return new PaintBudgetCalculatorPage(driver);
	}
}

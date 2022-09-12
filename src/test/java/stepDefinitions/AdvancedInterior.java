package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageFactory.AdvancedCalculatorPage;
import PageFactory.HomePage;
import PageFactory.PaintBudgetCalculatorPage;
import Parent.Parent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

public class AdvancedInterior extends Parent {
	
	public WebDriver driver;
	public HomePage home;
	public PaintBudgetCalculatorPage pbc;
	public AdvancedCalculatorPage ac;
	
	@Before("@IAC")
	public void setup() throws IOException, InterruptedException {
		driver = initializeBrowser() ;
	}
	
	@Given("^open an Asian Paints Application in any Browser$")
	public void open_an_asian_paints_application_in_any_browser() {
		driver.get(prop.getProperty("url"));
		cookiePopUpBlock();
	 }

	 @When("^enter with valid values in all fields$")
	 public void enter_with_valid_values_in_all_fields() {
	    ac.enterValues(prop.getProperty("width"), prop.getProperty("length"),prop.getProperty("height"),prop.getProperty("noOfWindows"), prop.getProperty("noOfDoors"));
		ac.walls( prop.getProperty("wallA"), prop.getProperty("wallB"),prop.getProperty("wallC"), prop.getProperty("wallD"),prop.getProperty("ceiling"),prop.getProperty("paintProduct"),prop.getProperty("textureProduct"),prop.getProperty("wallpaperPaperProduct"));
	    
	 }

	 @When("^enter with \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\" invalid values in all fields$")
	 public void enter_with_something_something_something_something_something_something_somethingsomething_something_something_somethingsomethingsomething_invalid_values_in_all_fields(String width, String length, String height, String noOfWindows, String noOfDoors, String wallA, String wallB,String wallC, String wallD, String ceiling, String paintProduct, String textureProduct, String wallpaperPaperProduct) {
	    ac.enterValues(width, length, height, noOfWindows, noOfDoors);
		ac.walls( wallA, wallB,wallC, wallD, ceiling, paintProduct,textureProduct,wallpaperPaperProduct);
	 }

	 @Then("^verify Recommended Product with description quantity required and estimated product cost are displayed$")
	 public void verify_recommended_product_with_description_quantity_required_and_estimated_product_cost_are_displayed() {
	    Assert.assertTrue(ac.estimatedCostforAdvancedCalculator().size()!=0&&ac.recommendedProductsforAdvancedCalculator().isDisplayed());
	    
	 }

	 @Then("^verify the error message is displayed in the top of the box and respective fields$")
	 public void verify_the_error_message_is_displayed_in_the_top_of_the_box_and_respective_fields() {
	    Assert.assertTrue(ac.widthLenghtHeightError().size()==3&&ac.windowDoorError().size()==2);
	    
	 }

	 @And("^Navigate to Paint Budget Calculator page$")
	 public void navigate_to_paint_budget_calculator_page() {
		 home= new HomePage(driver);
		 pbc= home.OpenPaintBudgetCalculator();
	 }

	 @And("^click the Advanced Calculator$")
	 public void click_the_advanced_calculator() {
	     ac=pbc.openAdvancedCalculator();
	    }

	 @And("^click the calculate now button$")
	 public void click_the_calculate_now_button() {
	     ac.clickInteriorCalculateNow();
	     
	    }
	    
	 @After("@IAC")
	 public void tearDown() throws IOException {
		  if(driver!= null) {
			  driver.quit();
		  }
	 }
	
}

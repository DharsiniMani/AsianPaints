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
import io.cucumber.java.en.*;

public class AdvancedExterior extends Parent {
	
	public WebDriver driver;
	public HomePage home;
	public PaintBudgetCalculatorPage pbc;
	public AdvancedCalculatorPage ac;
	
	@Before("@EAC")
	public void setup() throws IOException, InterruptedException {
		driver = initializeBrowser() ;
	}
	
	@Given("open Asian Paints Application in the Browser")
	public void open_asian_paints_application_in_the_browser() {
		driver.get(prop.getProperty("url"));
		cookiePopUpBlock();
	}

	@Given("navigate to the Paint Budget Calculator page")
	public void navigate_to_the_paint_budget_calculator_page() {
		 home= new HomePage(driver);
		 pbc= home.OpenPaintBudgetCalculator();
	}

	@Given("click Advanced Calculator")
	public void click_advanced_calculator() {
		ac=pbc.openAdvancedCalculator();
	}

	@Given("select Exterior in Select Space")
	public void select_exterior_in_select_space() {
		ac.clickExterior();
	}

	@When("valid value in Carpet Area of AC Text box is entered")
	public void valid_value_in_carpet_area_of_ac_text_box_is_entered() {
		ac.enterArea(prop.getProperty("validArea"));
	}

	@When("click calculate now button of AC")
	public void click_calculate_now_button_of_ac() {
		ac.clickCalculateNow();
	}

	@Then("verify that Recommended Product with description and estimated product cost are displayed")
	public void verify_that_recommended_product_with_description_and_estimated_product_cost_are_displayed() {
		Assert.assertTrue(pbc.recommendedProductsforQuickCalculator().size()!=0&&pbc.estimatedCostforQuickCalculator().size()!=0);
	}

	@When("enter invalid value in {string} {string} Text box of AC")
	public void enter_invalid_value_in_text_box_of_ac(String string, String area) {
		ac.enterArea(area);
	}

	@Then("verify that error message is displayed")
	public void verify_that_error_message_is_displayed() {
		Assert.assertTrue(pbc.errorMessage().isDisplayed());
	}

	 @After("@EAC")
	 public void tearDown() throws IOException {
		  if(driver!= null) {
			  driver.quit();
		  }
	 }
}

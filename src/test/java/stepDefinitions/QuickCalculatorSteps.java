package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageFactory.HomePage;
import PageFactory.PaintBudgetCalculatorPage;
import Parent.Parent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;


public class QuickCalculatorSteps extends Parent {
	
	public WebDriver driver;
	public HomePage home;
	public PaintBudgetCalculatorPage pbc;
	
	@Before("@QC")
	public void setup() throws IOException, InterruptedException {
		driver = initializeBrowser() ;
	}
	
	@Given("^open the Asian Paints Application in the Browser$")
    public void open_the_asian_paints_application_in_the_browser() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		cookiePopUpBlock();
		
    }

    @When("^valid value in carpet area textbox is entered$")
    public void valid_value_in_carpet_area_textbox_is_entered() {
    	pbc.enterArea(prop.getProperty("validArea"));
    }

    @When("^enter invalid value in \"([^\"]*)\" \"([^\"]*)\" Text box$")
    public void enter_invalid_value_in_something_something_text_box(String carpet, String area) throws Throwable {
    	pbc.enterArea(area);
    }

    @Then("^verify Recommended Product with description and estimated product cost are displayed$")
    public void verify_recommended_product_with_description_and_estimated_product_cost_are_displayed() {
    	Assert.assertTrue(pbc.estimatedCostforQuickCalculator().size()!=0 && pbc.recommendedProductsforQuickCalculator().size()!=0);
    }

    @Then("^verify error message is displayed$")
    public void verify_error_message_is_displayed() {
    	Assert.assertTrue(pbc.errorMessage().isDisplayed());
    }

    @And("^navigate to Paint Budget Calculator page$")
    public void navigate_to_paint_budget_calculator_page() {
    	home= new HomePage(driver);
    	pbc= home.OpenPaintBudgetCalculator();
    }

    @And("^click calculate now button$")
    public void click_calculate_now_button() {
    	pbc.clickCalculateNow();
    }
    
    @After("@QC")
	public void tearDown() throws IOException {
		if(driver!= null) {
			driver.quit();
		}
    }

}

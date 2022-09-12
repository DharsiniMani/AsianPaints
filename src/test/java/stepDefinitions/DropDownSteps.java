package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageFactory.HomePage;
import Parent.Parent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DropDownSteps extends Parent {

	public WebDriver driver;
	public HomePage home;
	
	@Before("@DD")
	public void setup() throws IOException {
		driver = initializeBrowser() ;
	}
	
	@Given("^open the Asian Paints Application in any Browser$")
	public void open_the_asian_paints_application_in_any_browser() throws IOException {
		driver.get(prop.getProperty("url"));
		
	}

	@When("^hover over options in top menu$")
	public void hover_over_options_in_top_menu() {
		home= new HomePage(driver);
		home.HoverOverPaintsAndTextures();
	}

	@Then("^verify Dropdown menu will appear$")
	public void verify_dropdown_menu_will_appear() {
		Assert.assertTrue(home.DropDownBox().isDisplayed());
	}

    @After("@DD")
	public void tearDown() throws IOException {
		if(driver!= null) {
			driver.quit();
		}
    }
}

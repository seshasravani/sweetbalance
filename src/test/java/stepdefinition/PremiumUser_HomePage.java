package stepdefinition;



import org.openqa.selenium.WebDriver;

import Pom.PremiumUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverFactory;

public class PremiumUser_HomePage {
	WebDriver driver = DriverFactory.getDriver();
	
	
	PremiumUser premiumUser = new PremiumUser(driver);
	@Given("the user is in password auth page")
	public void the_user_is_in_password_auth_page() throws Exception {
		String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
	    String sheetName = "Sheet1";  // Update this to your actual Excel sheet name

	    premiumUser.clickLoginBtn();
	    premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
	    premiumUser.clickContinueWithEmailBtn();
	    premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
	
	}

	@When("the user clicks sign in after entering password")
	public void the_user_clicks_sign_in_after_entering_password() {
		
		premiumUser.clickSignInButton();
		}
	

	@Then("the user should see the navigation bar displaying items in the order: Home, Logbook, Dashboard, Education")
	public void the_user_should_see_the_navigation_bar_displaying_items_in_the_order_home_logbook_dashboard_education() {
		premiumUser.isNavButtonsInOrder();
	}

	@Then("the user should see flashing challenge yourself button")
	public void the_user_should_see_flashing_challenge_yourself_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the button should flash in {double} seconds")
	public void the_button_should_flash_in_seconds(Double double1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see a {string} button")
	public void the_user_should_see_a_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see a gender-specific image based on the gender selected during onboarding")
	public void the_user_should_see_a_gender_specific_image_based_on_the_gender_selected_during_onboarding() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see an emoji displayed on the top-right corner of the gender image")
	public void the_user_should_see_an_emoji_displayed_on_the_top_right_corner_of_the_gender_image() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see label {string} below the gender image")
	public void the_user_should_see_label_below_the_gender_image(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see log button under gender image")
	public void the_user_should_see_log_button_under_gender_image() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see mood text based on the emoji")
	public void the_user_should_see_mood_text_based_on_the_emoji() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see Week plan button")
	public void the_user_should_see_week_plan_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see {string} text")
	public void the_user_should_see_text(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see {int} button options")
	public void the_user_should_see_button_options(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see text Blood Glucose")
	public void the_user_should_see_text_blood_glucose() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see text Physical Activity")
	public void the_user_should_see_text_physical_activity() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see text Food Intake")
	public void the_user_should_see_text_food_intake() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see text Medication")
	public void the_user_should_see_text_medication() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see Activity icon in Blood Glucose")
	public void the_user_should_see_activity_icon_in_blood_glucose() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see Running icon in Physical Activity")
	public void the_user_should_see_running_icon_in_physical_activity() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see Pizza icon in Food Intake")
	public void the_user_should_see_pizza_icon_in_food_intake() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see Pill icon in Medication")
	public void the_user_should_see_pill_icon_in_medication() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}


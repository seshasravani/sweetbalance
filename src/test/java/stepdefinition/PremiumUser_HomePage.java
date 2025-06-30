package stepdefinition;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pom.PremiumUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class PremiumUser_HomePage {
	WebDriver driver = DriverFactory.getDriver();

	PremiumUser premiumUser = new PremiumUser(driver);

	@Given("the user is in password auth page")
	public void the_user_is_in_password_auth_page() throws Exception {
		String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
		String sheetName = "Sheet1"; // Update this to your actual Excel sheet name

		premiumUser.clickLoginBtn();
		premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
		premiumUser.clickContinueWithEmailBtn();
		premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);

	}

	@When("the user clicks sign in after entering password")
	public void the_user_clicks_sign_in_after_entering_password() {
		premiumUser.clickSignInButton();
		premiumUser.waitForChallengeButton();
	}

	@Then("the user should see the navigation bar displaying items in the order: Home, Logbook, Dashboard, Education")
	public void the_user_should_see_the_navigation_bar_displaying_items_in_the_order_home_logbook_dashboard_education() {
		premiumUser.isNavButtonsInOrder();
	}

	@Then("the user should see flashing challenge yourself button")
	public void the_user_should_see_flashing_challenge_yourself_button() {
		Assert.assertTrue(premiumUser.isChallengeButtonAnimated(),
				"Challenge Yourself button animation is not detected");

	}

	@Then("the button should flash in {double} seconds")
	public void the_button_should_flash_in_seconds(Double expectedSeconds) {
		boolean isFlashing = premiumUser.isChallengeButtonFlashingWithDuration(expectedSeconds);

		if (isFlashing) {
			LoggerLoad.info("Button is flashing for expected duration: " + expectedSeconds + "s");
		} else {
			LoggerLoad.error("Button is NOT flashing for expected duration: " + expectedSeconds + "s");
		}

		Assert.assertTrue(isFlashing, "Expected the button to flash for " + expectedSeconds + " seconds.");
	}

	@Then("the user should see a {string} button")
	public void the_user_should_see_a_button(String string) {
		premiumUser.getChallengeButtonText();
	}

	@Then("the user should see a gender-specific image based on the gender selected during onboarding")
	public void   		  		the_user_should_see_a_gender_specific_image_based_on_the_gender_selected_during_onboarding() {
		premiumUser.isFemaleImageDisplayed();
	}

	@Then("the user should see an emoji displayed on the top-right corner of the gender image")
	public void the_user_should_see_an_emoji_displayed_on_the_top_right_corner_of_the_gender_image() {
		premiumUser.isEmojiDisplayed();
	}

	@Then("the user should see label {string} below the gender image")
	public void the_user_should_see_label_below_the_gender_image(String string) {
		
		Assert.assertTrue(premiumUser.isMoodStatusDisplayed(), "Mood status is not visible or incorrect.");
	}

	@Then("the user should see log button under gender image")
	public void the_user_should_see_log_button_under_gender_image() {
		premiumUser.isLogButtonVisible();
	}

	@Then("the user should see mood text based on the emoji")
	public void the_user_should_see_mood_text_based_on_the_emoji() {
		String mood = premiumUser.getMoodText();
	    Assert.assertTrue(mood.startsWith("Mood:"), "Mood text not displayed correctly.");
	
	}

	@Then("the user should see Week plan button")
	public void the_user_should_see_week_plan_button() {
		 Assert.assertTrue(premiumUser.isWeeklyPlanButtonVisible(), "Weekly Plan button is not visible!");
	}

	@Then("the user should see {string} text")
	public void the_user_should_see_text(String string) {
		 Assert.assertTrue(premiumUser.isRecordNewDataTextVisible(), "\"Record New Data\" text is not visible!");
	}

	@Then("the user should see {int} button options")
	public void the_user_should_see_button_options(Integer int1) {
		premiumUser.PageScrollDown();
		 Assert.assertTrue(premiumUser.areRecordNewDataButtonsVisible(), "4 Record Data buttons are not visible.");
	}

	@Then("the user should see text Blood Glucose")
	public void the_user_should_see_text_blood_glucose() {
		Assert.assertEquals(premiumUser.getBloodGlucoseText(), "Blood Glucose");
	}

	@Then("the user should see text Physical Activity")
	public void the_user_should_see_text_physical_activity() {
		Assert.assertEquals(premiumUser.getPhysicalActivityText(), "Physical Activity");
	}

	@Then("the user should see text Food Intake")
	public void the_user_should_see_text_food_intake() {
		  Assert.assertEquals(premiumUser.getFoodIntakeText(), "Food Intake");
	}

	@Then("the user should see text Medication")
	public void the_user_should_see_text_medication() {
		  Assert.assertEquals(premiumUser.getMedicationText(), "Medication");
	}

	@Then("the user should see Activity icon in Blood Glucose")
	public void the_user_should_see_activity_icon_in_blood_glucose() {
		premiumUser.isActivitySvgVisible();
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
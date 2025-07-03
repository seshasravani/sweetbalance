package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Pom.PremiumUser;
import Pom.PF_PremiumUser_Exercise;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class PremiumUser_Exercise {
	private WebDriver driver;
    private PremiumUser premiumUser;
    private PF_PremiumUser_Exercise exerciseSpan;
    

    @Before
    public void init() {
    	
        driver = DriverFactory.getDriver();
        // Defensive null-check
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Check your Hooks or DriverFactory.");
        }
        premiumUser = new PremiumUser(driver);
        exerciseSpan = new PF_PremiumUser_Exercise(driver);
    }
    
   
    
	@Given("User is Logged into the app")
	public void user_is_logged_into_the_app() throws Exception {
		String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
		String sheetName = "Sheet1"; // Update this to your actual Excel sheet name

		premiumUser.clickLoginBtn();
		premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
		premiumUser.clickContinueWithEmailBtn();
		premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
		premiumUser.clickSignInButton();
		
	}

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {

	}

	@When("User clicks the {string} option from the side panel")
	public void user_clicks_the_option_from_the_side_panel(String string) {
		premiumUser.clickExerciseButton();
	 
	}

	@Then("{string} button is displayed on the right")
	public void button_is_displayed_on_the_right(String string) {
		Assert.assertTrue(exerciseSpan.isViewFullScheduleBtnVisible(), "View Full Schedule Button is not visible");
	}
	
	@When("User clicks the View Full Schedule button")
	public void user_clicks_the_view_full_schedule_button() {
	    exerciseSpan.clickViewFullScheduleBtn();
	}
	

	@When("User clicks the Mark As Completed button")
	public void user_clicks_the_mark_as_completed_button() {
	    exerciseSpan.clickMarkAsCompletedBtn();
	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to_page(String string) {
	   
	}

	@Then("{string} tab is visible")
	public void tab_is_visible(String exercisePlans) {
		switch(exercisePlans) {
		case "Warm Up":
			Assert.assertTrue(exerciseSpan.isWarmUpBtnVisible(), "Warm Up Tab is not visible");
			break;
		case "Main Workout":
			Assert.assertTrue(exerciseSpan.isMainWorkoutBtnVisible(), "Main Workout Tab is not visible");
			break;
		case "Cool Down":
			Assert.assertTrue(exerciseSpan.isCoolDownBtnVisible(), "Cool Down Tab is not visible");
			break;
		default:
			break;
			}
		}
	
	@Then("Exercise name is displayed under {string} tab")
	public void exercise_name_is_displayed_under_tab(String string) {
	    
	}

	@Then("Description is shown below the Exercise name under {string}")
	public void description_is_shown_below_the_exercise_name_under(String string) {
	    
	}

	@Then("Duration is displayed under {string} tab")
	public void duration_is_displayed_under_tab(String string) {
		Assert.assertTrue(exerciseSpan.isDurationTextVisible(), "Duration text is not visible under tab " +string);
	}

	@Then("Calories are displayed under {string} tab")
	public void calories_are_displayed_under_tab(String string) {
		Assert.assertTrue(exerciseSpan.isCaloriesTextVisible(), "Calories text is not visible under tab " +string);
	}

	@Then("Intensity level is displayed under {string} tab")
	public void intensity_level_is_displayed_under_tab(String string) {
		Assert.assertTrue(exerciseSpan.isIntensityTextVisible(), "Intensity text is not visible under tab " +string);
	   
	}

	@Then("{string} button is displayed for all three sections")
	public void button_is_displayed_for_all_three_sections(String string) {
		Assert.assertTrue(exerciseSpan.isMarkAsCompletedBtnVisible(), "Mark as Completed button is not visible " +string);
	}

	@Then("Success dialog is shown")
	public void success_dialog_is_shown() {
		Assert.assertTrue(exerciseSpan.validateSuccessDialog(), "Success dialog validation failed");
	  
	}

	@Then("Button changes to {string}")
	public void button_changes_to(String string) {
		Assert.assertTrue(exerciseSpan.isCompletedBtnVisible(), "Button is not changed to Completed");
	  
	}

	@Then("Undo option is visible")
	public void undo_option_is_visible() {
		Assert.assertTrue(exerciseSpan.isUndoBtnVisible(), "Undo option is not visible");
	    
	}
	
	@Given("User is in the Exercise section")
	public void user_is_in_the_exercise_section() {
		premiumUser.clickExerciseButton();
	   
	}

	@When("User clicks Undo after marking Exercise as completed")
	public void user_clicks_undo_after_marking_exercise_as_completed() {
		exerciseSpan.clickUndoOption();
	    
	}

	@Then("Button changes back to {string}")
	public void button_changes_back_to(String string) {
		Assert.assertTrue(exerciseSpan.isMarkAsCompletedBtnVisible(), "Button is not changed back to Mark as Completed");
	}

	@When("User clicks {string}")
	public void user_clicks(String string) {
		exerciseSpan.clickViewFullScheduleBtn();
	   
	}

	@Then("User should redirect to Exercise schedule")
	public void user_should_redirect_to_exercise_schedule() {
		Assert.assertTrue(exerciseSpan.isPageLoaded(), "Exercise schedule page is not loaded");
	}

	@Then("User should see title {string}")
	public void user_should_see_title(String string) {
	   
	}

	@Then("User should see {string} button in Today's Exercise schedule page")
	public void user_should_see_button_in_today_s_exercise_schedule_page(String string) {
		Assert.assertTrue(exerciseSpan.isBackToHomeBtnVisible(), "Back to Home button is not visible");
	}

	@Then("{string} section should be visible")
	public void section_should_be_visible(String exercisePlans) {
		switch(exercisePlans) {
		case "Warm Up":
			Assert.assertTrue(exerciseSpan.isWarmUpSectionVisible(), "Warm Up Section is not visible");
			break;
		case "Main Workout":
			Assert.assertTrue(exerciseSpan.isMainWorkoutSectionVisible(), "Main Workout Section is not visible");
			break;
		case "Cool Down":
			Assert.assertTrue(exerciseSpan.isCoolDownSectionVisible(), "Cool Down Section is not visible");
			break;
		default:
			break;
			}
		
	}

	@Then("{string} Exercise description should be visible")
	public void exercise_description_should_be_visible(String string) {
	    
	}

	@Then("{string} Exercise durations should be visible")
	public void exercise_durations_should_be_visible(String string) {
	    
	}

	@Then("{string} Exercise calories should be visible")
	public void exercise_calories_should_be_visible(String string) {
	    
	}

	@Then("{string} Exercise intensity should be visible")
	public void exercise_intensity_should_be_visible(String string) {
	    
	}

	@Then("{string} Exercise name should be visible")
	public void exercise_name_should_be_visible(String string) {
	   
	}

	@Then("Exercise intensity should low\\/medium\\/hard")
	public void exercise_intensity_should_low_medium_hard() {
	    
	}

	@Then("total duration should be displayed")
	public void total_duration_should_be_displayed() {
	   
	}

	@Then("total duration should equal the sum of all individual durations")
	public void total_duration_should_equal_the_sum_of_all_individual_durations() {
	    
	}

	@Then("total calories should equal the sum of all individual calories")
	public void total_calories_should_equal_the_sum_of_all_individual_calories() {
	    
	}


}

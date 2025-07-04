package stepdefinition;


import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pagefactory.PremiumUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class PremiumUser_HomePageSD {
	private WebDriver driver;
    private PremiumUser premiumUser;

    @Before
    public void init() {
    	
        driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Check your Hooks or DriverFactory.");
        }
        premiumUser = new PremiumUser(driver);
    }
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
		 WebElement runningIcon = premiumUser.getIconByIndex(0); // assuming Running icon is 1st
	        assert runningIcon.isDisplayed();
	}

	@Then("the user should see Pizza icon in Food Intake")
	public void the_user_should_see_pizza_icon_in_food_intake() {
		 WebElement pizzaIcon = premiumUser.getIconByIndex(1); // assuming Pizza icon is 2nd
	        assert pizzaIcon.isDisplayed();
	}

	@Then("the user should see Pill icon in Medication")
	public void the_user_should_see_pill_icon_in_medication() {
		WebElement pillIcon = premiumUser.getIconByIndex(2); // assuming Pill icon is 3rd
        assert pillIcon.isDisplayed();
	}
	@Given("the user is logged into the app")
	public void the_user_is_logged_into_the_app() {
		premiumUser.isLoggedInAs();
	}

	@When("the user clicks meal section")
	public void the_user_clicks_meal_section() {
		premiumUser.clickMealPlan();
	}

	@Then("the user should see {string} title under the four tabs")
	public void the_user_should_see_title_under_the_four_tabs(String expectedTitle) {
	    Assert.assertTrue(premiumUser.isPreMealTitleDisplayed(), "Pre-Meal title is not visible");
	    Assert.assertEquals(premiumUser.getPreMealTitleText(), expectedTitle, "Title text mismatch");
	}
	

	@Then("the user should see alarm clock icon")
	public void the_user_should_see_alarm_clock_icon() {
		   Assert.assertTrue(premiumUser.isAlarmClockIconDisplayed(), "Alarm clock icon (⏰) is not visible");
	}

	@Then("the user should see pre-meal in first place of each meal section")
	public void the_user_should_see_pre_meal_in_first_place_of_each_meal_section() {
		
		Assert.assertTrue(premiumUser.isPreMealVisibleInAllTabs(),
		        "'Pre-Meal' text not found in one or more meal tabs");
	}

	@Then("the user should see Pre-Meal entry displays as {string} by default")
	public void the_user_should_see_pre_meal_entry_displays_as_by_default(String string) {
   
	}
	@When("the user clicks snack section")
	public void the_user_clicks_snack_section() {
		premiumUser.clickSnacksBtn();
	}
	@Then("the user should see {int} calorie in pre-meal snack")
	public void the_user_should_see_calorie_in_pre_meal_snack(Integer int1) {
		premiumUser.getTotalText();
	premiumUser.isTotalCountZero();
	}

	@Then("the user should see meal title for main-meal in snack")
	public void the_user_should_see_meal_title_for_main_meal_in_snack() {
		premiumUser.isMainMealTitlesVisible();
	}

	@Then("the user should see description for the dish in snack")
	public void the_user_should_see_description_for_the_dish_in_snack() {
	  
	}

	@Then("the user should see {string} as sub title")
	public void the_user_should_see_as_sub_title(String expectedSubtitle) {
		Assert.assertTrue(premiumUser.isMainMealSubtitleVisible(), expectedSubtitle + " subtitle is not visible");
	    Assert.assertEquals(premiumUser.getMainMealSubtitleText(), expectedSubtitle, "Subtitle text mismatch");
	}

	@Then("the user should see utensil icon for each main-meal")
	public void the_user_should_see_utensil_icon_for_each_main_meal() {
		Assert.assertTrue(premiumUser.isUtensilIconVisible(), "Utensil icon is not visible for main meal");
	}

	@Then("the user should see {string} based time in main-meal")
	public void the_user_should_see_based_time_in_main_meal(String timeFormatKeyword) {
	    Assert.assertTrue(premiumUser.isMainMealTimeVisible(), "Main meal time is not visible");
	    String actualTime = premiumUser.getMainMealTimeText();
	    System.out.println("Displayed time: " + actualTime);
	    boolean isValid = actualTime.matches("\\d{1,2}:\\d{2} (AM|PM)");

	    Assert.assertTrue(isValid, "Time format is not valid. Found: " + actualTime);
	}


	@Then("the user should see indicator {string} for breakfast main-meal")
	public void the_user_should_see_indicator_for_breakfast_main_meal(String expectedIndicator) {
		String actualIndicator = premiumUser.getBreakfastIndicator(); // returns "AM"
	    Assert.assertEquals(actualIndicator, expectedIndicator, "Incorrect indicator for breakfast");
	}
	

	@Then("the user should see indicator {string} for lunch main-meal")
	public void the_user_should_see_indicator_for_lunch_main_meal(String expectedIndicator) {
		premiumUser.clickLunchTab();
		String actualIndicator = premiumUser.getTimeIndicatore(); // returns "PM"
	   Assert.assertEquals(actualIndicator, expectedIndicator, "Incorrect indicator for lunch");
	}

	@Then("the user should see indicator {string} for dinner main-meal")
	public void the_user_should_see_indicator_for_dinner_main_meal(String expectedIndicator) {
		premiumUser.clickDinnerTab();
		String actualIndicator = premiumUser.getTimeIndicatore(); // returns "PM"
		   Assert.assertEquals(actualIndicator, expectedIndicator, "Incorrect indicator for Dinner");
	}

	@Then("the user should see indicator {string} for snack main-meal")
	public void the_user_should_see_indicator_for_snack_main_meal(String expectedIndicator) {
		premiumUser.clickSnacksBtn();
		String actualIndicator = premiumUser.getTimeIndicatore(); // returns "PM"
		   Assert.assertEquals(actualIndicator, expectedIndicator, "Incorrect indicator for Dinner");
	}
	

	@Then("the user should see {int}:{int} o'clock")
	public void the_user_should_see_o_clock(Integer int1, Integer int2) {
		String expectedTime = int1 + ":" + String.format("%02d", int2);  // e.g., 7:30 → "7:30"
	    
	    String actualTime = premiumUser.getBreakfastTimeOnly();  // returns "7:30"
	    
	    Assert.assertEquals(actualTime, expectedTime, "Displayed time does not match expected.");
	}
	

	@Then("the user should see the main-meal calorie value")
	public void the_user_should_see_the_main_meal_calorie_value() {
		    int calories = premiumUser.getMainMealCalorieValue();
		    
		    // Assert it's a positive value (or whatever logic you need)
		    Assert.assertTrue(calories > 0, "Main meal calorie value should be greater than 0 but was: " + calories);

		    System.out.println("Main meal calorie value is: " + calories);
		}

	

	@Then("the user should see text {string} after the calorie value in main meal")
	public void the_user_should_see_text_after_the_calorie_value_in_main_meal(String expectedText) {
	    String actualText = premiumUser.getLabelAfterMainMealCalories();
	    Assert.assertEquals(actualText, expectedText, "calories");
	}

	@Then("the user should see {string} button")
	public void the_user_should_see_button(String expectedButtonText) {

		    String actualText = premiumUser.getStatusButtonText(expectedButtonText);
		    Assert.assertEquals(actualText.trim(), expectedButtonText.trim(), "Button text mismatch.");
		}

	

	@When("the user marks meal as completed")
	public void the_user_marks_meal_as_completed() {
		premiumUser.clickCompletedButton();
	}
	@Then("the user should see {string} button on view full Meal Plan")
	public void the_user_should_see_button_on_view_full_meal_plan(String expectedText) {
		 String actualText = premiumUser.getBackToPlanButtonText();
		    Assert.assertTrue(
		        actualText.equalsIgnoreCase(expectedText),
		        "Expected button text: " + expectedText + " but found: " + actualText
		    );}

	@Then("the button color should change to green")
	public void the_button_color_should_change_to_green() {
		WebElement greenButton = premiumUser.waitForCompletedButtonToBeGreen();
	    String color = greenButton.getCssValue("background-color");
	    System.out.println("Completed button color: " + color);
	    Assert.assertTrue(color.contains("34, 197, 94"), "Expected green color but got: " + color);
	}
	

	@When("the user marks meal as partially completed")
	public void the_user_marks_meal_as_partially_completed() {
		premiumUser.clickPartiallyCompletedButton();
	}

	@Then("the button color should change to yellow")
	public void the_button_color_should_change_to_yellow() {
		
		    WebElement yellowButton = premiumUser.waitForPartiallyCompletedButtonYellow();
		    String color = yellowButton.getCssValue("background-color");
		    System.out.println("Yellow button color: " + color);
		    Assert.assertTrue(color.contains("234, 179, 8"), "Expected yellow color but got: " + color);
		}

	


	@When("the user marks meal as not completed")
	public void the_user_marks_meal_as_not_completed() {
		premiumUser.clickNotCompletedButton();
	}

	@Then("the button color should change to red")
	public void the_button_color_should_change_to_red() {
		
		    WebElement redButton = premiumUser.waitForNotCompletedButtonRed();
		    String color = redButton.getCssValue("background-color");
		    System.out.println("Red button color: " + color);
		    Assert.assertTrue(color.contains("239, 68, 68"), "Expected red color but got: " + color);
		}


	@When("the user views a meal section")
	public void the_user_views_a_meal_section() {
	
		 Assert.assertTrue(premiumUser.isBreakfastBtnVisible(), "Breakfast button is not visible");
	}
	

	@Then("the user should see Nutrition Insight summary card")
	public void the_user_should_see_nutrition_insight_summary_card() {
		Assert.assertTrue(premiumUser.isNutritionCardVisible(), "Nutrition Insight summary card is not visible");
	}
	

	@Then("the user should see title {string}")
	public void the_user_should_see_title(String expectedTitle) {
		 String actual = premiumUser.getPageTitleText();
	        Assert.assertEquals(
	            actual, expectedTitle,
	            "Page title did not match"
	        );

	}

	@Then("the user should see subtitle {string}")
	public void the_user_should_see_subtitle(String expectedText) {
		 String actualText = premiumUser.getLabelAfterMainMealCalories();
		    Assert.assertEquals(actualText, expectedText, "calories");
	}

	@Then("total calorie count should equal the sum of Pre-Meal and Meal calories")
	public void total_calorie_count_should_equal_the_sum_of_pre_meal_and_meal_calories() {
		 int total = premiumUser.getTotalCalories();
		    int preMeal = premiumUser.getPreMealCalories();
		    int mainMeal = premiumUser.getMainMealCalories();

		    System.out.println("Pre-meal: " + preMeal + ", Main meal: " + mainMeal + ", Total: " + total);

		    Assert.assertEquals(total, preMeal + mainMeal, "Total calories do not match sum of Pre-meal and Main meal");
		
	}

	@Then("the user should see calorie detail on the right side of its section")
	public void the_user_should_see_calorie_detail_on_the_right_side_of_its_section() {
		Assert.assertTrue ( premiumUser.isPreMealDetailVisible(),
		        "Pre-meal calorie detail is not visible on the right side." );

		    // assert Main meal detail
		    Assert.assertTrue(premiumUser.isMainMealDetailVisible(),
		        "Main meal calorie detail is not visible on the right side." );
	}
//
//	@Then("calorie in flex card should match with the meal")
//	public void calorie_in_flex_card_should_match_with_the_meal() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should see donut chart")
//	public void the_user_should_see_donut_chart() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should see total calories in donut chart")
//	public void the_user_should_see_total_calories_in_donut_chart() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should see distinct color segment in each macro")
//	public void the_user_should_see_distinct_color_segment_in_each_macro() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("macro percentages should match expected values")
//	public void macro_percentages_should_match_expected_values() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("each segment color should match its corresponding label")
//	public void each_segment_color_should_match_its_corresponding_label() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should see macronutrient bar chart")
//	public void the_user_should_see_macronutrient_bar_chart() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should see progress bars for carbs, protein, fat, and fiber")
//	public void the_user_should_see_progress_bars_for_carbs_protein_fat_and_fiber() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("each nutrient bar should show value consistent with label")
//	public void each_nutrient_bar_should_show_value_consistent_with_label() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("all macro percentages should add up to {int}%")
//	public void all_macro_percentages_should_add_up_to(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user views macro section")
//	public void the_user_views_macro_section() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("each macronutrient should display name and percentage")
//	public void each_macronutrient_should_display_name_and_percentage() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user views macro legend")
//	public void the_user_views_macro_legend() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("legend color should match its chart segment")
//	public void legend_color_should_match_its_chart_segment() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
	@When("the user clicks View Meal Plan button")
	public void the_user_clicks_view_meal_plan_button() {
		premiumUser.clickViewFullMealPlanBtn();
	}

	@Then("the user should be redirected to Full Meal Plan page")
	public void the_user_should_be_redirected_to_full_meal_plan_page() {
		premiumUser.validatePageTitle();
	}
	@Given("the user is on Full Meal Plan page")
	public void the_user_is_on_full_meal_plan_page() {
		premiumUser.clickViewFullMealPlanBtn();
		  Assert.assertTrue(
				  premiumUser.isOnFullMealPlanPage(),
		            "User is not on the Full Meal Plan page"
		        );
	}

	@When("the user views the page")
	public void the_user_views_the_page() { Assert.assertTrue(
			premiumUser.isOnFullMealPlanPage(),
            "Full Meal Plan page did not load correctly"
        );
	}

	@When("the user views navigation controls")
	public void the_user_views_navigation_controls() {
		 Assert.assertTrue(
				 premiumUser.isBackToPlanButtonVisible(),
			        "'Back to Plan' button not found in navigation"
			    );
			}
	

	@When("the user views the meal sections")
	public void the_user_views_the_meal_sections() {
		premiumUser.getVisibleMealSectionButtonLabels();
	}

	@Then("the user should see each meal section button")
	public void the_user_should_see_each_meal_section_button() {
		 List<String> expectedButtons = Arrays.asList("breakfast", "lunch", "dinner", "snacks");
		    List<String> actualButtons = premiumUser.getVisibleMealSectionButtonLabels();

		    for (String expected : expectedButtons) {
		        Assert.assertTrue(
		            actualButtons.contains(expected),
		            "Missing meal section button: " + expected
		        );
		    }
	}
	@Given("User logged onto the application")
	public void user_logged_onto_the_application() throws Exception {
		String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
		String sheetName = "Sheet1"; // Update this to your actual Excel sheet name

		premiumUser.clickLoginBtn();
		premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
		premiumUser.clickContinueWithEmailBtn();
		premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
		premiumUser.clickSignInButton();
		premiumUser.validatePageTitle();
	}

//	@Given("User is in home page")
//	public void user_is_in_home_page() {
//		premiumUser.isChallengeButtonAnimated();
//	}

	@When("User clicks Weekly plan")
	public void user_clicks_weekly_plan() {
		premiumUser.clickweeklyPlanBtn();
	}

	@Then("User should get pdf download of weekly plan")
	public void user_should_get_pdf_download_of_weekly_plan() {
		 String downloadPath = System.getProperty("user.home") + "/Downloads";
		    File downloadDir = new File(downloadPath);

		    // Updated prefix based on actual filename
		    String expectedPrefix = "weekly-meal-plan";

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    boolean fileDownloaded = wait.until(d -> {
		        File[] files = downloadDir.listFiles((dir, name) ->
		            name.startsWith(expectedPrefix) && name.endsWith(".pdf")
		        );
		        return files != null && files.length > 0;
		    });
		    Assert.assertTrue(fileDownloaded, "Expected weekly meal plan PDF not found in Downloads folder.");
		}

	@When("User clicks on Blood glucose button")
	public void user_clicks_on_blood_glucose_button() {
		premiumUser.clickBloodGlucoseBtn();
	}

	@Then("User should redirect to Blood Glucose popup window")
	public void user_should_redirect_to_blood_glucose_popup_window() {
		Assert.assertTrue(premiumUser.isTrackGlucoseTitleVisible(), "Popup window is NOT visible.");
	}

	@When("User clicks on physical activity button")
	public void user_clicks_on_physical_activity_button() {
		premiumUser.clickPhysicalActivityBtn();
	}

	@Then("User should redirect to physical activity popup window")
	public void user_should_redirect_to_physical_activity_popup_window() {

		Assert.assertTrue(premiumUser.isphysicalActivityTitleVisible(), "Popup window is NOT visible.");
	}

	@When("User clicks on food intake button")
	public void user_clicks_on_food_intake_button() {
		premiumUser.clickFoodIntakeBtn();
	}

	@Then("User should redirect to food intake popup window")
	public void user_should_redirect_to_food_intake_popup_window() {
		Assert.assertTrue(premiumUser.isFoodIntakeTrackerTitleVisible(), "Popup window is NOT visible.");
	}

	@When("User clicks on medication button")
	public void user_clicks_on_medication_button() {
		premiumUser.clickMedicationBtn();
	}

	@Then("User should redirect to medication popup window")
	public void user_should_redirect_to_medication_popup_window() {
	
		Assert.assertTrue(premiumUser.isMedicationTrackerTitleVisible(), "Popup window is NOT visible.");
	}

	@When("User clicks log button")
	public void user_clicks_log_button() {
		premiumUser.clickLogBtn();
	}

	@Then("User should redirected to dashboard page")
	public void user_should_redirected_to_dashboard_page() {
		Assert.assertTrue(premiumUser.isOnDashboard(), "User was not redirected to dashboard page.");
	}
	@Given("User is in dashboard page")
	public void user_is_in_dashboard_page() throws Exception {
		String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
		String sheetName = "Sheet1"; // Update this to your actual Excel sheet name

		premiumUser.clickLoginBtn();
		premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
		premiumUser.clickContinueWithEmailBtn();
		premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
		premiumUser.clickSignInButton();
		premiumUser.clickLogBtn();
	}

	@When("User clicks home tab after logging emotional state in dashboard")
	public void user_clicks_home_tab_after_logging_emotional_state_in_dashboard() {
		premiumUser.clickemojiLogBtn();
		premiumUser.clicklogEmotionalStateBtn();
		premiumUser.clickHome();
	}

	@Then("User should see emoji and mood text is changed")
	public void user_should_see_emoji_and_mood_text_is_changed() {
		

	}


@Given("User clicks view meal plan after reaching home page")
public void user_clicks_view_meal_plan_after_reaching_home_page() throws Exception {
	String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
	String sheetName = "Sheet1"; // Update this to your actual Excel sheet name

	premiumUser.clickLoginBtn();
	premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
	premiumUser.clickContinueWithEmailBtn();
	premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
	premiumUser.clickSignInButton();
  premiumUser.clickViewFullMealPlanBtn();
  
}

@Given("User is in View Meal plan")
public void user_is_in_view_meal_plan() {
	premiumUser.getPageTitleText();
}

@When("User clicks Meal sections")
public void user_clicks_meal_sections() {
	premiumUser.clicklunchTabFMP();
}

@Then("Each meal section should display a pre-meal item with the format {string}")
public void each_meal_section_should_display_a_pre_meal_item_with_the_format(String expectedPrefix) {
	String actualText = premiumUser.getPreMealItemText();
    System.out.println("Pre-meal text: " + actualText);
    Assert.assertTrue(actualText.startsWith(expectedPrefix + ": "), 
        "Expected text to start with 'Pre-meal: ', but got: " + actualText);
}


@Then("Item description should be displayed below the item name")
public void item_description_should_be_displayed_below_the_item_name() {
	 Assert.assertTrue(premiumUser.isPreMealDescriptionDisplayed(), 
		        "Pre-meal description is not visible under the item name");

		    String description = premiumUser.getPreMealDescriptionText();
		    System.out.println("Description: " + description);
		    Assert.assertFalse(description.isEmpty(), "Description text is empty");
	
}

@Then("Calories value should be displayed")
public void calories_value_should_be_displayed() {
	premiumUser.isCaloriesValueDisplayed();
	Assert.assertTrue(premiumUser.isCaloriesValueDisplayed(), "calories:value");
}

@Then("Preparation instructions displayed if available, if not then {string}")
public void preparation_instructions_displayed_if_available_if_not_then(String expected) {
	String actualText = premiumUser.getPreparationInstructions();
    System.out.println("Preparation text: " + actualText);
    
    // Assertion: should be "N/A" or real instructions
    Assert.assertTrue(!actualText.isEmpty(), "Preparation instruction text is empty.");
    Assert.assertEquals(actualText, expected, "Preparation text does not match expected.");
}


@Then("User should see {string} heading in full plan")
public void user_should_see_heading_in_full_plan(String expectedHeading) {
	 boolean isVisible = premiumUser.isPreMealNutrientsHeadingVisible();
	    Assert.assertTrue(isVisible, "Expected heading not found: " + expectedHeading);
	
}

@Then("User should see list {string}")
public void user_should_see_list(String expectedNutrients) {
	List<String> expected = Arrays.asList(expectedNutrients.toLowerCase().split(", "));
    List<String> actual = premiumUser.getNutrientLabels(); // Like: ["Carbs: N/A", "Protein: N/A"]

    System.out.println("Expected: " + expected);
    System.out.println("Actual: " + actual);

    for (String nutrient : expected) {
        boolean match = actual.stream()
            .anyMatch(a -> a.toLowerCase().startsWith(nutrient)); // e.g., "carbs" matches "carbs: n/a"
      
        Assert.assertTrue(match, "Expected nutrient not found: " + nutrient);
    }
}



@Given("User is in view full plan page")
public void user_is_in_view_full_plan_page() {
	premiumUser.getPageTitleText();
}

@When("User clicks back to plan button")
public void user_clicks_back_to_plan_button() {
	premiumUser.clickBackToPlan();
}

@Then("User should redirected to Home page")
public void user_should_redirected_to_home_page() {
	premiumUser.getPageTitleText();
}


//ChallengeButton
@Given("User is logged into app")
public void user_is_logged_into_app() throws Exception {

	String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
	String sheetName = "Sheet1"; // Update this to your actual Excel sheet name


	premiumUser.clickLoginBtn();
	premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
	premiumUser.clickContinueWithEmailBtn();
	premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
	premiumUser.clickSignInButton();
}

@When("User clicks Challenge button")
public void user_clicks_challenge_button() {
	premiumUser.clickChallengeButton();
}

@Then("User should get pop window")
public void user_should_get_pop_window() {
    Assert.assertTrue(premiumUser.isPopupVisible(), "Challenge popup is not visible");
}

@Then("User should see title {string} on Popup")
public void user_should_see_title_on_popup(String expectedTitle) {
    Assert.assertEquals(premiumUser.getPopupTitle(), expectedTitle);
}

@Then("User should see sub text on challenge popup {string}")
public void user_should_see_subtext_on_challenge_popup(String expectedText) {
    Assert.assertEquals(premiumUser.getPopupSubtext(), expectedText);
}

@Then("User should see two options for challenge option")
public void user_should_see_two_options_for_challenge_option() {
    Assert.assertTrue(premiumUser.firstChallengeBtn.isDisplayed());
    Assert.assertTrue(premiumUser.secondChallengeBtn.isDisplayed());
}

@Then("User should see {string} as first option")
public void user_should_see_as_first_option(String expectedOption) {
    Assert.assertEquals(premiumUser.getFirstChallengeText(), expectedOption);
}

@Then("User should see {string} as second option")
public void user_should_see_as_second_option(String expectedOption) {
    Assert.assertEquals(premiumUser.getSecondChallengeText(), expectedOption);
}
//@BloodGlucose
@Given("User is in home page after logged into app")
public void user_is_in_home_page_after_logged_into_app() throws Exception {
	String filepath = "src/test/resources/testdata/SweetBalanceApplication.xlsx";
	String sheetName = "Sheet1"; // Update this to your actual Excel sheet name


	premiumUser.clickLoginBtn();
	premiumUser.enterEmailFromExcel(filepath, sheetName, 0);
	premiumUser.clickContinueWithEmailBtn();
	premiumUser.enterPasswordFromExcel(filepath, sheetName, 0);
	premiumUser.clickSignInButton();
}

@When("User clicks Blood Glucose")
public void user_clicks_blood_glucose() {
	premiumUser.clickBloodGlucoseBtn();
}

@Then("User should see title {string} on Track Glucose popup")
public void user_should_see_title_on_track_glucose_popup(String expectedTitle) {
	 String actualTitle = premiumUser.getTrackGlucosePopupTitle();
	    Assert.assertEquals(actualTitle.trim(), expectedTitle, "Track Glucose title mismatch.");
	
}

@Then("User should see subtext {string}")
public void user_should_see_subtext(String expectedTitle) {
	premiumUser.clickBloodGlucoseBtn();

	 String actualTitle = premiumUser.getSubtitleTrackGlucosePopupTitle();
	    Assert.assertEquals(actualTitle.trim(), expectedTitle, "Track Glucose title mismatch.");
}

@Then("User should see field for Blood Glucose Level, Reading Type, Date")
public void user_should_see_field_for_blood_glucose_level_reading_type_date() {
	premiumUser.clickBloodGlucoseBtn();
	 Assert.assertTrue(premiumUser.isGlucoseFieldDisplayed(), "Blood Glucose Level field is not displayed");
     Assert.assertTrue(premiumUser.isReadingTypeLabelDisplayed(), "Reading Type label is not displayed");
     Assert.assertTrue(premiumUser.areAllReadingTypesDisplayed(), "Not all Reading Type options are displayed");
     Assert.assertTrue(premiumUser.isDateLabelDisplayed(), "Date label is not displayed");
//     Assert.assertTrue(premiumUser.isDateInputDisplayed(), "Date input field is not displayed");
}

@Then("User should see text field for blood glucose")
public void user_should_see_text_field_for_blood_glucose() {
	premiumUser.clickBloodGlucoseBtn();
	Assert.assertTrue(premiumUser.isDateInputDisplayed(), "Date input field is not displayed");
}

@Then("User should see text {string} in blood glucose field")
public void user_should_see_text_in_blood_glucose_field(String expectedText) {
	premiumUser.clickBloodGlucoseBtn();
    String actualText = premiumUser.getGlucoseFieldPlaceholder();
    Assert.assertEquals(actualText, expectedText, "Placeholder text does not match.");
}
@Then("User should see \"mg\\/dL\"in blood glucose input field")
public void user_should_see_mg_d_l_in_blood_glucose_input_field() {
	premiumUser.clickBloodGlucoseBtn();
 
     Assert.assertTrue(premiumUser.isDateLabelDisplayed(), "mg/dl field is not displayed");
}
@Then("User should see three transition details with text {string}")
public void user_should_see_three_transition_details_with_text(String expectedText) {
	// Open blood glucose section
    premiumUser.clickBloodGlucoseBtn();

    // Check visibility
    Assert.assertTrue(premiumUser.areAllTransitionLabelsPresent(), "Transition labels are not fully visible");

    // Fetch actual text from UI
    List<String> actualTexts = Arrays.asList(
        premiumUser.lowTransition.getText().trim().toLowerCase(),
        premiumUser.normalTransition.getText().trim().toLowerCase(),
        premiumUser.highTransition.getText().trim().toLowerCase()
    );

    // Convert expected input to list
    List<String> expected = Arrays.stream(expectedText.split(","))
                                  .map(String::trim)
                                  .map(String::toLowerCase)
                                  .collect(Collectors.toList());
    // Assertion
    Assert.assertEquals(actualTexts, expected, 
        "Transition labels mismatch.\nExpected: " + expected + "\nActual: " + actualTexts);
}
@Then("User should see Red color in low")
public void user_should_see_red_color_in_low() {
	premiumUser.clickBloodGlucoseBtn();
    String actualColor = premiumUser.getLowTransitionColor();
    Assert.assertTrue(actualColor.contains("rgba(254, 226, 226"), 
    	    "Expected red color, but found: " + actualColor);

}

@Then("User should see green color in normal")
public void user_should_see_green_color_in_normal() {
	premiumUser.clickBloodGlucoseBtn();
    String actualColor = premiumUser.getNormalTransitionColor();
    Assert.assertTrue(actualColor.contains("rgba(187, 247, 208") || actualColor.contains("green"),
        "Expected green color, but found: " + actualColor);
}

@Then("User should see yellow color in high")
public void user_should_see_yellow_color_in_high() {
	premiumUser.clickBloodGlucoseBtn();
    String actualColor = premiumUser.getHighTransitionColor();
    Assert.assertTrue(actualColor.contains("rgba(254, 243, 199"), 
    	    "Expected yellow color, but found: " + actualColor);

}


@Then("User should see date picker")
public void user_should_see_date_picker() {
	premiumUser.clickBloodGlucoseBtn();
	Assert.assertTrue(premiumUser.isDatePickerVisible(), "Date Picker is not  is not visible");
}

@Then("User should see last reading details")
public void user_should_see_last_reading_details() {
	premiumUser.clickBloodGlucoseBtn();
	Assert.assertTrue(premiumUser.islastreadigofglucoseVisible(), "last reading is not visible");
}

@Then("User should see record reading button")
public void user_should_see_record_reading_button() {
	premiumUser.clickBloodGlucoseBtn();
    Assert.assertTrue(premiumUser.isRecordReadingButtonVisible(), "Record Reading button is not visible");
}
//PhysicalActivity


@When("User clicks physical activiy")
public void user_clicks_physical_activiy() {
	premiumUser.clickPhysicalActivityBtn();
}
@Then("User should see title {string} on the popup")
public void user_should_see_title_on_the_popup(String expectedTitle) {
	premiumUser.isphysicalActivityTitleVisible();
	Assert.assertEquals(premiumUser.getPhysicalActivityTitleText(), expectedTitle);
}

@Then("User should see subtext {string} activity popup")
public void user_should_see_subtext_activity_popup(String expectedSubtext) {
	 premiumUser.clickPhysicalActivityBtn();
	 Assert.assertEquals(premiumUser.getSubtitlePhysicalActivityTitle(), expectedSubtext);
}

@Then("User should see field for Activity Type, Duration, Date, Intensity")
public void user_should_see_field_for_activity_type_duration_date_intensity() {
	premiumUser.clickPhysicalActivityBtn();
	  Assert.assertTrue(premiumUser.isActivityTypeDropdownVisible());
	    Assert.assertTrue(premiumUser.isDurationInputVisible());
	    Assert.assertTrue(premiumUser.isDatePickerVisible1());
	    Assert.assertTrue(premiumUser.isIntensityLabelVisible());
}

@Then("User should see dropdown for activity type")
public void user_should_see_dropdown_for_activity_type() {
	premiumUser.clickPhysicalActivityBtn();
	Assert.assertTrue(premiumUser.isActivityTypeDropdownVisible());

}

@Then("User should see {string} activity type")
public void user_should_see_activity_type(String expectedOptions) {
	premiumUser.clickPhysicalActivityBtn();
	   List<String> actualOptions = premiumUser.getActivityTypeDropdownOptions();
	    for (String expected : expectedOptions.split(", ")) {
	        Assert.assertTrue(actualOptions.contains(expected), "Missing: " + expected);
	    }
}

@Then("User should see input field for duration")
public void user_should_see_input_field_for_duration() {
	premiumUser.clickPhysicalActivityBtn();
	 Assert.assertTrue(premiumUser.isDurationInputVisible());
}
@Then("User should see {string} in placeholder field")
public void user_should_see_in_placeholder_field(String expectedPlaceholder) {
	premiumUser.clickPhysicalActivityBtn();
	 Assert.assertEquals(premiumUser.getDurationPlaceholder(), expectedPlaceholder);;
}

@Then("User should see drop down duration")
public void user_should_see_drop_down_duration() {
	premiumUser.clickPhysicalActivityBtn();
	 Assert.assertTrue(premiumUser.isDurationUnitDropdownVisible());
}

@Then("User should see {string} activity popup")
public void user_should_see_activity_popup(String expectedUnits) {
	premiumUser.clickPhysicalActivityBtn();
	  List<String> actualUnits = premiumUser.getDurationUnitOptionsText();
	    for (String expected : expectedUnits.split(", ")) {
	        Assert.assertTrue(actualUnits.contains(expected), "Missing unit: " + expected);
	    }
}
@Then("User should see date picker on physical Activity popup")
public void user_should_see_date_picker_on_physical_Activity_popup() {
	premiumUser.clickPhysicalActivityBtn();
    Assert.assertTrue(premiumUser.isDatePickerVisible1());
}
@Then("User should see intensity field")
public void user_should_see_intensity_field() {
	premiumUser.clickPhysicalActivityBtn();
	  Assert.assertTrue(premiumUser.isIntensityLabelVisible());
}
@Then("User should see {string} on activity popup")
public void user_should_see_on_activity_popup(String expectedLevels) {
	premiumUser.clickPhysicalActivityBtn();
	  List<String> actualLevels = premiumUser.getIntensityOptionsText();
	    for (String expected : expectedLevels.split(", ")) {
	        Assert.assertTrue(actualLevels.contains(expected), "Missing intensity: " + expected);
	    }
}

@Then("User should see save activity button")
public void user_should_see_save_activity_button() {
	premiumUser.clickPhysicalActivityBtn();
	  Assert.assertTrue(premiumUser.isSaveButtonVisible());

}
//FooIntake 

    @When("User clicks Food Intake")
    public void user_clicks_food_intake() {
    	premiumUser.clickFoodIntakeBtn();
    }

    @Then("User should see title {string} on food popup")
    public void user_should_see_title_on_food_popup(String expectedTitle) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getTitleText(),expectedTitle);
    }

    @Then("User should see subtext {string} in the food popup")
    public void user_should_see_subtext_in_the_food_popup(String expectedSubtext) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getSubtext(), expectedSubtext);
    }
    @Then("User should see {string} in foodIntake popup")
    public void user_should_see_in_food_intake_popup(String expectedTabs) {
    	premiumUser.clickFoodIntakeBtn();
        List<String> expected = List.of(expectedTabs.split(",\\s*"));
        Assert.assertEquals(premiumUser.getMealTabNames(), expected);
    }

    @Then("User should see field for Food Name, Serving Size, Calories, Date, Notes")
    public void user_should_see_field_for_food_name_serving_size_calories_date_notes() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isFoodNameFieldVisible());
        Assert.assertTrue(premiumUser.isServingSizeDropdownVisible());
        Assert.assertTrue(premiumUser.isCaloriesInputVisible());
        Assert.assertTrue(premiumUser.isDatePickerVisible());
        Assert.assertTrue(premiumUser.isNotesInputVisible());
    }

    @Then("User should see {string} tab selected by default")
    public void user_should_see_tab_selected_by_default(String expectedTab) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getSelectedMealTab(), expectedTab);
    }

    @Then("User should see input field for food name")
    public void user_should_see_input_field_for_food_name() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isFoodNameFieldVisible());
    }

    @Then("User should see text {string} as placeholder")
    public void user_should_see_text_as_placeholder(String expectedPlaceholder) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getFoodNamePlaceholder(), expectedPlaceholder);
    }
    @Then("User should see {string} after popoup")
    public void user_should_see_after_popoup(String string) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isServingSizeDropdownVisible());
    }

    @Then("User should see {string} as default")
    public void user_should_see_as_default(String expectedDefault) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getSelectedServingSize(), expectedDefault);
    }

    @Then("User should see {string} options in Serving Size")
    public void user_should_see_options_in_serving_size(String expectedOptions) {
    	premiumUser.clickFoodIntakeBtn();
        List<String> expected = List.of(expectedOptions.split(",\\s*"));
        Assert.assertEquals(premiumUser.getServingSizeOptions(), expected);
    }

    @Then("User should see calculator icon in calorie")
    public void user_should_see_calculator_icon_in_calorie() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isCalculatorIconVisible());
    }

    @Then("User should see input field for calorie")
    public void user_should_see_input_field_for_calorie() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isCaloriesInputVisible());
    }

    @Then("User should see text {string} in calorie field as placeholder")
    public void user_should_see_text_in_calorie_field_as_placeholder(String expected) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getCaloriesPlaceholder(), expected);
    }

    @Then("User should see {string} under calorie field")
    public void user_should_see_under_calorie_field(String expectedHelperText) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getCaloriesHelperText(), expectedHelperText);
    }

    @Then("User should see date picker after popup")
    public void user_should_see_date_picker_after_popup() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isDatePickerVisible());
    }

    @Then("User should see input block for notes")
    public void user_should_see_input_block_for_notes() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isNotesInputVisible());
    }

    @Then("User should see {string} in notes as placeholder")
    public void user_should_see_in_notes_as_placeholder(String expected) {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertEquals(premiumUser.getNotesPlaceholder(), expected);
    }

    @Then("User should see \"Add any additional information...\"after the foodintake popup")
    public void user_should_see_add_any_additional_information_after_the_foodintake_popup() {
    	premiumUser.clickFoodIntakeBtn();
    	String expectedPlaceholder = "Add any additional information...";
        String actualPlaceholder = premiumUser.getNotesPlaceholder();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Placeholder text mismatch after Food Intake popup");
    }
    @Then("User should see save food entry button")
    public void user_should_see_save_food_entry_button() {
    	premiumUser.clickFoodIntakeBtn();
        Assert.assertTrue(premiumUser.isSaveButtonVisible());
    }
    @Then("User should see {string} tabs")
    public void user_should_see_tabs(String expectedTabs) {
    	 List<String> expectedList = Arrays.asList(expectedTabs.split(",\\s*")); // ["Breakfast", "Lunch", "Dinner", "Snack"]
    	    List<String> actualList = premiumUser.getMealTabsText(); // From page object method

    	    System.out.println("Expected Tabs: " + expectedList);
    	    System.out.println("Actual Tabs: " + actualList);

    	    Assert.assertEquals(actualList, expectedList, "Tab names mismatch or order incorrect");
    
    }

    @Then("User should see dropdown for serving size")
    public void user_should_see_dropdown_for_serving_size() {
    	List<String> expectedOptions = Arrays.asList(
    	        "Small (1/2 cup)", "Medium (1 cup)", "Large (2 cups)", "Custom..."
    	    );
    	    List<String> actualOptions = premiumUser.getServingSizeOptions();

    	    System.out.println("Expected: " + expectedOptions);
    	    System.out.println("Actual: " + actualOptions);

    	    Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options do not match expected values");
    	
    }

    @Then("User should see toadys date")
    public void user_should_see_toadys_date() {
        String actualDate = premiumUser.getDisplayedCalendarDate();
        String expectedDate = premiumUser.getFormattedTodaysDate();

        System.out.println("Expected: " + expectedDate);
        System.out.println("Actual: " + actualDate);

        Assert.assertEquals(actualDate.trim(), expectedDate.trim(), "Displayed date does not match today's date");
    
    }




}
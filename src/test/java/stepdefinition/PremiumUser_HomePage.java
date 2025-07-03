package stepdefinition;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Pom.PremiumUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class PremiumUser_HomePage {
	private WebDriver driver;
    private PremiumUser premiumUser;

    @Before
    public void init() {
    	
        driver = DriverFactory.getDriver();
        // Defensive null-check
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

	    // Log actual time for debugging
	    System.out.println("Displayed time: " + actualTime);

	    // Validate format: hh:mm AM/PM (allowing 1 or 2 digit hour)
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
//	    Assert.assertTrue(premiumUser.isNutritionCardVisible(), "Nutrition Insight summary card is not visible");
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
//homepage.clickStackGetStartedButton();
//	Assert.assertEquals(homepage.getHomePageTitle(), "Stack");
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
	}}
//
//
//}
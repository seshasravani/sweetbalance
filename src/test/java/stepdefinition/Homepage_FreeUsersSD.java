package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pagefactory.Homepage_FreeUsers;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;


public class Homepage_FreeUsersSD{

    private WebDriver driver = DriverFactory.getDriver();
    private Homepage_FreeUsers home = new Homepage_FreeUsers(driver);

 
	
	
    @Given("User logs into the app")
    public void user_logs_into_the_app() {
    	 home.clickLoginBtn();
 		home.enterEmail(ConfigReader.getProperty("Email"));
 		home.clickContinueWithEmail();
 		home.enterPassword(ConfigReader.getProperty("password"));
 		home.clickSignIn();
 	     LoggerLoad.info("User successfully signed in.");  
            }
    
    @Then("User should see {string} heading for each of the meal section")
    public void user_should_see_heading_for_each_of_the_meal_section(String expectedHeading) {
        String actualHeading = home.getNutritionInsightsHeading().getText();
        Assert.assertEquals(actualHeading, expectedHeading, "Nutrition Insights heading mismatch");
    }

    @Then("User should see Carbs value for the main")
    public void user_should_see_carbs_value_for_the_main() {
    	Assert.assertTrue(home.getCarbsvalue().isDisplayed(), "Carbs value is not displayed");
        String carbsText = home.getCarbsvalue().getText();
        Assert.assertTrue(carbsText.toLowerCase().contains("carbs"), "Carbs text mismatch: " + carbsText); 
    }

    @Then("User should see Protein value for the main")
    public void user_should_see_protein_value_for_the_main() {
    	Assert.assertTrue(home.getProteinvalue().isDisplayed(), "Protein value is not displayed");
        String proteinText = home.getProteinvalue().getText();
        Assert.assertTrue(proteinText.toLowerCase().contains("protein"), "Protein text mismatch: " + proteinText);
            }

    @Then("User should see Fat value for the main meal")
    public void user_should_see_fat_value_for_the_main_meal() {
    	Assert.assertTrue(home.getFatvalue().isDisplayed(), "Fat value is not displayed");
        String fatText = home.getFatvalue().getText();
        Assert.assertTrue(fatText.toLowerCase().contains("fat"), "Fat text mismatch: " + fatText);
    }
	
    
    @Then("User should see {string} based time in pre-meal snack \\(eg: {int}:{int})")
    public void user_should_see_based_time_in_pre_meal_snack_eg(String string, Integer int1, Integer int2) {
           }

    @Then("User should see {int} o'clock")
    public void user_should_see_o_clock(Integer expectedHour) {
           
            }

    @When("User clicks {string} button")
    public void user_clicks_button(String string) {
    	home.getViewFullPlan().click();
            }

    @Then("User should be redirected to subscription page")
    public void user_should_be_redirected_to_subscription_page() {
    	String currentUrl = driver.getCurrentUrl();
    	Assert.assertTrue(currentUrl.contains("subscription") || currentUrl.contains("pricing") || currentUrl.contains("upgrade"),
    	        "User is not redirected to the subscription page. Current URL: " + currentUrl);

    
    }

    @When("User clicks exercise section")
    public void user_clicks_exercise_section() {
    	LoggerLoad.info("Clicking exercise section...");
    	home.getExerciseSection().click();
 
    }

    @Then("User should see exercises list for the day")
    public void user_should_see_exercises_list_for_the_day() {
        LoggerLoad.info("Validating exercise list visibility...");
    	Assert.assertTrue(home.getExerciseList().isDisplayed(),"Exercise list is not displayed for the day"); 
    }
    

  @Then("User should see scheduled time of each exercise")
  public void user_should_see_scheduled_time_of_each_exercise() {
	  //LoggerLoad.info("Checking if morning and evening exercise times are visible...");
	   // Assert.assertTrue(home.getMorningWalkTime().isDisplayed(), "Morning exercise time is not displayed");
	    //Assert.assertTrue(home.getYogaTime().isDisplayed(), "Evening exercise time is not displayed");
	
  }

  @Then("Morning exercise should be scheduled for {int} o'clock")
  public void morning_exercise_should_be_scheduled_for_o_clock(Integer expectedHour) {
	    String timeText = home.getMorningWalkTime().getText(); // e.g., "7:00 AM"
	    LoggerLoad.info("Validating morning exercise time: " + timeText);
	    String[] parts = timeText.split(":");
	    int actualHour = Integer.parseInt(parts[0].trim());
	    Assert.assertEquals(actualHour, expectedHour.intValue(), 
	        "Expected morning exercise at " + expectedHour + " but found " + actualHour);    }

  @Then("Evening exercise should be scheduled for {int} o'clock")
  public void evening_exercise_should_be_scheduled_for_o_clock(Integer Int) {
   }


 @Then("User should see plan title for each exercise")
 public void user_should_see_plan_title_for_each_exercise() {
	 //LoggerLoad.info("Checking exercise plan titles: Morning Walk and Yoga Session...");
	    //Assert.assertTrue(home.getMorningWalk().isDisplayed(), "Morning Walk title is not displayed");
	   // Assert.assertTrue(home.getYoga().isDisplayed(), "Yoga Session title is not displayed"); 
}

 @Then("User should see a duration in each exercise item")
 public void user_should_see_a_duration_in_each_exercise_item() {
	// LoggerLoad.info("Checking exercise durations...");
	    //Assert.assertTrue(home.getLowExercise().isDisplayed(), "Low intensity duration not displayed");
	    //Assert.assertTrue(home.getMediumExercise().isDisplayed(), "Medium intensity duration not displayed");
	 //String low = home.getLowExercise().getText().trim();
	  //  String medium = home.getMediumExercise().getText().trim();
	    
	   // Assert.assertTrue(low.contains("mins"), "Low intensity duration missing: " + low);
	    //Assert.assertTrue(medium.contains("mins"), "Medium intensity duration missing: " + medium);
	}
	


 @Then("User should see button with text {string}")
  public void user_should_see_button_with_text(String expectedText) {
	    //WebElement btn = home.getViewFullSchedule();
	    //LoggerLoad.info("Verifying button text: " + btn.getText());
	    //Assert.assertEquals(btn.getText().trim(), expectedText);
    	//Assert.assertTrue(home.getViewFullSchedule().isDisplayed(),"ViewFullSchedule is not displayed for the day"); 

}

 @When("User clicks view full schedule button after reaching exercise section")
 public void user_clicks_view_full_schedule_button_after_reaching_exercise_section() {
	 LoggerLoad.info("Clicking 'View Full Schedule' button...");
	    home.getViewFullSchedule().click();
    }

 @Then("User should see the navigation bar displaying items in the order: Home, Dashboard, Education")
 public void user_should_see_the_navigation_bar_displaying_items_in_the_order_home_dashboard_education() {
	 Assert.assertTrue(home.isNavigationBarVisible(), "Navigation bar is not visible");

     Assert.assertTrue(home.isHomeTabVisible(), "Home tab is not visible");
     Assert.assertTrue(home.isDashboardTabVisible(), "Dashboard tab is not visible");
     Assert.assertTrue(home.isEducationTabVisible(), "Education tab is not visible");
 
 }
 

 @Then("User should see a caret toggle icon next to the {string} title")
 public void user_should_see_a_caret_toggle_icon_next_to_the_title(String string) {
	 Assert.assertTrue(home.isTodaysMealPlanDisplayed(), "\"Today's Meal Plan\" section is not visible");
     
 }
}
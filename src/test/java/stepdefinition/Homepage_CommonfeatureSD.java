package stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Homepage_Commonfeature;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class Homepage_CommonfeatureSD {
	private WebDriver driver = DriverFactory.getDriver(); 
	
	 Homepage_Commonfeature homepage = new Homepage_Commonfeature(driver);
	 
	 
	@Given("User is in password auth page")
	public void user_is_in_password_auth_page() {
		String Appname = homepage.getAppnameText();
		assertEquals(Appname,"SweetBalance","App name is not correct");
        }		

   @When("User clicks sign in after entering password")
	public void user_clicks_sign_in_after_entering_password() {
	   homepage.clickLoginBtn();
	   homepage.enterEmail(ConfigReader.getProperty("Email"));
       homepage.clickContinueWithEmail();
       homepage.enterPassword(ConfigReader.getProperty("password"));
       homepage.clickSignIn();
       LoggerLoad.info("User successfully signed in.");
       }


	@Then("User should see SweetBalance text on the left side of the page")
	public void user_should_see_sweet_balance_text_on_the_left_side_of_the_page() {
		//String actualAppName = homepage.getSweetBalanceText();
        //String expectedAppName = prop.getProperty("Appname");
        //Assert.assertEquals(actualAppName, expectedAppName, "App name does not match after login.");
		 //Assert.assertTrue(homepage.SweetBalance.isDisplayed(), "SweetBalance text is not visible on the left side.");
		String Appname = homepage.getSweetBalanceText();
		assertEquals(Appname,"SweetBalance","App name is not correct");
    }
	

	@Then("User should see name displayed at the top-right corner of the home page")
	public void user_should_see_name_displayed_at_the_top_right_corner_of_the_home_page() {
		String actualUsername = homepage.getUsernameText();
        Assert.assertEquals(actualUsername, "munna", "Displayed username is incorrect.");
		//Assert.assertTrue(homepage.vahinig03.isDisplayed(), "User name is not displayed at the top-right corner.");
	}

	@Then("User should see Logout link in the top-right corner")
	public void user_should_see_logout_link_in_the_top_right_corner() {
		Assert.assertTrue(homepage.isLogoutDisplayed(), "Logout link is not visible in the top-right corner.");
	}

	@Then("User should see top navigation bar on the page")
	public void user_should_see_top_navigation_bar_on_the_page() {
	   Assert.assertTrue(homepage.isNavigationBarVisible(),"Navigate bar is not visible in the top"); 
	}

	@Then("User should see {string} tab in the top navigation bar")
	public void user_should_see_tab_in_the_top_navigation_bar(String tabName) {
		switch (tabName) {
        case "Home":
            Assert.assertTrue(homepage.isNavigationBarVisible(), "Navigation bar is not visible");
            Assert.assertTrue(homepage.isHomeTabVisible(), "Home tab is not visible in the navigation bar");
            break;

        case "Dashboard":
            Assert.assertTrue(homepage.isNavigationBarVisible(), "Navigation bar is not visible");
            Assert.assertTrue(homepage.isDashboardTabVisible(), "Dashboard tab is not visible in the navigation bar");
            break;

        case "Education":
            Assert.assertTrue(homepage.isNavigationBarVisible(), "Navigation bar is not visible");
            Assert.assertTrue(homepage.isEducationTabVisible(), "Education tab is not visible in the navigation bar");
            break;

        default:
            throw new IllegalArgumentException("Unknown tab: " + tabName);
         }
	   }


   @Then("User should see {string} section heading on the home page")
   public void user_should_see_section_heading_on_the_home_page(String expectedHeading) {
       String actualHeading = homepage.getCurrentStatus();
       assertEquals(actualHeading, expectedHeading, "Section heading mismatch on the home page.");
     }

    @Then("User should see {string} label below Current Status")
    public void user_should_see_label_below_current_status(String expectedLabelStart) {
        String actualText = homepage.getLastUpdated();
        Assert.assertTrue(actualText.startsWith(expectedLabelStart),
            "Expected label to start with '" + expectedLabelStart + "', but got '" + actualText + "'");
           }
    

    @Then("User should see timestamp displayed next to the {string} label")
    public void user_should_see_timestamp_displayed_next_to_the_label(String lastUpdated) {
    	String lastUpdatedText = homepage.getLastUpdated();
        System.out.println("Last updated text: " + lastUpdatedText);
        Assert.assertTrue(lastUpdatedText.toLowerCase().contains("last updated"), "Label 'Last updated' is not present.");
        Assert.assertTrue(lastUpdatedText.matches("(?i)^Last updated:.*\\d.*$"), "Timestamp is not displayed after 'Last updated:'");
           }

   @Then("User should see last updated timestamp in {int}-hour format as hh:mm:ss or relative format like {string} or {string}")
   public void user_should_see_last_updated_timestamp_in_hour_format_as_hh_mm_ss_or_relative_format_like_or(Integer int1, String string, String string2) {
    
       }

   @Then("User should see {int}-hour clock indicator with AM\\/PM")
   public void user_should_see_hour_clock_indicator_with_am_pm(Integer int1) {
	   String lastUpdatedText = homepage.getLastUpdated();
       System.out.println("Checking AM/PM presence in: " + lastUpdatedText);
       assertTrue(lastUpdatedText.toUpperCase().contains("AM") || lastUpdatedText.toUpperCase().contains("PM"),
               "12-hour format indicator (AM/PM) is missing in the timestamp.");
             }
   
   @Then("User should see {string} label")
   public void user_should_see_label(String labelName) {
	    String actualLabel = "";
	    switch (labelName) {
	        case "Latest HbA1C":
	            actualLabel = homepage.getLatestHbA1C();
	            break;
	        case "BMI":
	            actualLabel = homepage.getBMI();
	            break;
	        case "Average Blood Sugar":
	            actualLabel = homepage.getAverageBloodSugar();
	            break;
	        default:
	            throw new IllegalArgumentException("Unexpected label: " + labelName);
	    }

	    LoggerLoad.info("Verifying label: " + actualLabel);
	    assertEquals(actualLabel.trim(), labelName, "\"" + labelName + "\" label is not visible or incorrect.");          
	      }
   
   @Then("User should see {string} as the condition text")
   public void user_should_see_as_the_condition_text(String expectedCondition) {
	   
	   String actualCondition = null;
	    String expectedCondition1 = null;

	    String hba1cString = homepage.getHbA1CValue();
	    double hba1c = Double.parseDouble(hba1cString);
	    LoggerLoad.info("HbA1C Value: " + hba1c);

	    try {
	        if (hba1c < 5.7) {
	            expectedCondition1 = "Normal";
	            actualCondition = homepage.getNormalStatus();
	        } else if (hba1c >= 5.7 && hba1c <= 6.4) {
	            expectedCondition1 = "Pre-diabetic";
	            actualCondition = homepage.getPrediabeticStatus();
	        } else if (hba1c >= 6.5) {
	            expectedCondition1 = "Diabetic";
	            actualCondition = homepage.getDiabeticStatus();
	        }

	        LoggerLoad.info("Expected: " + expectedCondition1 + " | Actual: " + actualCondition);
	        assertEquals(actualCondition.trim(), expectedCondition1, "Condition text does not match");

	    } catch (Exception e) {
	        LoggerLoad.error("Error validating condition text: " + e.getMessage());
	        throw e;
	    }
   }
   
  @Then("User should see {string} as the BMI category")
  public void user_should_see_as_the_bmi_category(String expectedCategory) {
		    String actualCategory = null;
		    String expectedCategory1 = null;

		    try {
		        // Step 1: Get BMI value from page
		        String bmiString = homepage.getBMIValue(); // e.g., "21.9"
		        double bmi = Double.parseDouble(bmiString);
		        LoggerLoad.info("BMI Value Fetched: " + bmi);

		        // Step 2: Determine category based on value
		        if (bmi < 18.5) {
		        	expectedCategory1 = "Underweight";
		            actualCategory = homepage.getUnderweight();
		        } else if (bmi >= 18.5 && bmi <= 24.9) {
		        	expectedCategory1 = "Normal";
		            actualCategory = homepage.getNormal();
		        } else if (bmi >= 25.0 && bmi <= 29.9) {
		        	expectedCategory1 = "Overweight";
		            actualCategory = homepage.getOverweight();
		        } else if (bmi >= 30.0) {
		        	expectedCategory1 = "Obese";
		            actualCategory = homepage.getObese();
		        }

		        // Step 3: Log and assert
		        LoggerLoad.info("Expected: " + expectedCategory1 + " | Actual: " + actualCategory);
		        assertEquals(actualCategory, expectedCategory1, "BMI category does not match");

		    } catch (Exception e) {
		        LoggerLoad.error("Error while validating BMI category: " + e.getMessage());
		        throw e;
		    }
		}
    


    @Then("User should see mg\\/dL unit below Average Blood Sugar")
    public void user_should_see_mg_d_l_unit_below_average_blood_sugar() {
    	try {
            String unitText = homepage.getUnitText(); // Step 1
            LoggerLoad.info("Unit displayed: " + unitText); // Step 2
            assertEquals(unitText.trim(), "mg/dL", "Unit text does not match expected value."); // Step 3
        } catch (Exception e) {
            LoggerLoad.error("Exception while validating unit text: " + e.getMessage()); // Step 4
            throw e;
        }
     }
    
    @Then("User should see {string} title")
    public void user_should_see_title(String expectedTitle) {
       // String actualTitle = homepage.getTodaysMealPlan();
       // assertEquals(actualTitle, expectedTitle, "Title does not match");
        
    }

    @Then("User should see tabs: Breakfast, Lunch, Dinner, Snacks")
    public void user_should_see_tabs_breakfast_lunch_dinner_snacks() {
    	    //assertTrue(homepage.isBreakfastTabVisible(), "Breakfast tab not visible");
    	    //assertTrue(homepage.isLunchTabVisible(), "Lunch tab not visible");
    	   // assertTrue(homepage.isDinnerTabVisible(), "Dinner tab not visible");
    	   // assertTrue(homepage.isSnacksTabVisible(), "Snacks tab not visible");
    }

    @Then("{string} tab should be selected by default")
    public void tab_should_be_selected_by_default(String expectedTab) {
        String selectedTabText = homepage.getDefaultbreakfastText();  // You need to implement this
        LoggerLoad.info("Selected tab: " + selectedTabText);
        assertEquals(selectedTabText, expectedTab, "Default selected tab is not as expected");
    }

    @Then("User should see sidebar tab container within the flex layout")
    public void user_should_see_sidebar_tab_container_within_the_flex_layout() {
    	
    }

    @Then("User should see {string} label in the sidebar section")
    public void user_should_see_label_in_the_sidebar_section(String label) {
        /*if (label.equals("Meal Plan")) {
            assertTrue(homepage.isMealPlanDisplayed());
        } else if (label.equals("Exercise")) {
            assertTrue(homepage.isExerciseDisplayed());
        } else {
            fail("Unknown label: " + label);
        }*/
    }

    @Then("User should see utensil icon \\(crossed fork and knife) in the Meal Plan tab")
    public void user_should_see_utensil_icon_crossed_fork_and_knife_in_the_meal_plan_tab() {
    	//assertTrue(homepage.MealPlanIcon.isDisplayed(), "Meal Plan icon not visible");
    }

    @Then("User should see dumbbell icon in the Exercise tab")
    public void user_should_see_dumbbell_icon_in_the_exercise_tab() {
    	
            }

    @Then("User should see {string} button in the Meal Plan section")
    public void user_should_see_button_in_the_meal_plan_section(String expectedText) {
        String actualText = homepage.getViewFullPlanText();
        assertEquals(actualText, expectedText, "Button text mismatch");
    }

    //meal section validation
    
   @Given("User is logged into the app")
   public void user_is_logged_into_the_app() {
	 //LoggerLoad.info("User is on homepage");
	   homepage.clickLoginBtn();
	   homepage.enterEmail(ConfigReader.getProperty("Email"));
       homepage.clickContinueWithEmail();
       homepage.enterPassword(ConfigReader.getProperty("password"));
       homepage.clickSignIn();
       LoggerLoad.info("User successfully signed in.");
       }
   
   @Given("User is in home page")
   public void user_is_in_home_page() {
	LoggerLoad.info("User is on homepage");
            }

    @When("User clicks on the {string} section")
    public void user_clicks_on_the_section(String meal) {
        switch (meal.toLowerCase()) {
        case "breakfast":
            homepage.clickBreakfast();
            break;
        case "lunch":
            homepage.clickLunch();
            break;
        case "dinner":
            homepage.clickDinner();
            break;
        case "snacks":
            homepage.clickSnacks();
            break;
        default:
            throw new IllegalArgumentException("Invalid meal section: " + meal);
         }
     }    	
            

    @Then("Breakfast details become visible")
    public void breakfast_details_become_visible() {
        Assert.assertTrue(homepage.isBreakfastDetailsVisible(), "Breakfast details not visible");
         }

    @Then("Lunch details become visible")
    public void lunch_details_become_visible() {
        Assert.assertTrue(homepage.isLunchDetailsVisible(), "Lunch details not visible");
        }

    @Then("Dinner details become visible")
    public void dinner_details_become_visible() {
        Assert.assertTrue(homepage.isDinnerDetailsVisible(), "Dinner details not visible");
         }

    @Then("Snacks details become visible")
    public void snacks_details_become_visible() {
        Assert.assertTrue(homepage.isSnacksDetailsVisible(), "Snacks details not visible");
        }

    //functional and non-functional
    @When("User clicks meal section")
    public void user_clicks_meal_section() {
    	homepage.clickBreakfast();  // default to breakfast for demo
        LoggerLoad.info("User clicked on Breakfast section");
    }

    @Then("User should see dish title")
    public void user_should_see_dish_title() {
        Assert.assertTrue(homepage.isDishTitleVisible(), "Dish title is not visible");
          }
    
    @Then("User should see description for the dish")
    public void user_should_see_description_for_the_dish() {
        Assert.assertTrue(homepage.isDishDescriptionVisible(), "Dish description is not visible");
	  }

    @Then("User should see the pre-meal item name")
    public void user_should_see_the_pre_meal_item_name() {
    	String preMealName = homepage.getPreMealBreakfastName();
        Assert.assertFalse(preMealName.isEmpty(), "Pre-meal item name is empty."); 
        }

    @Then("User should see the pre-meal calorie value")
    public void user_should_see_the_pre_meal_calorie_value() {
    	 String calories = homepage.getBreakfastCalories();
         Assert.assertTrue(calories.toLowerCase().contains("calories"), "Calorie value or text 'calories' not found.");
            }

    @Then("User should see indicator {string} for breakfast pre-meal")
    public void user_should_see_indicator_for_breakfast_pre_meal(String String) {
        //String timeIndicator = homepage.getBreakfastTimeAM();
        //Assert.assertEquals(timeIndicator, indicator, "Breakfast pre-meal indicator does not match.");
        
         }

    @Then("User should see indicator {string} for lunch pre-meal")
    public void user_should_see_indicator_for_lunch_pre_meal(String String) {
        //String timeIndicator = homepage.getLunchTimePM();
        //Assert.assertEquals(timeIndicator, indicator, "Lunch pre-meal indicator does not match.");
        }

    @Then("User should see indicator {string} for dinner pre-meal")
    public void user_should_see_indicator_for_dinner_pre_meal(String String) {
        //String timeIndicator = homepage.getDinnerTimePM();
        //Assert.assertEquals(timeIndicator, indicator, "Dinner pre-meal indicator does not match.");
       }
        
    @Then("User should see {string} based time in pre-meal \\(eg : {int}:{int})")
    public void user_should_see_based_time_in_pre_meal_eg(String string, Integer int1, Integer int2) {
            // Check time format in one or more pre-meal times (you can extend for more)
            String breakfastTime = homepage.getBreakfastTimeAM();
            Assert.assertTrue(breakfastTime.matches("\\d{1,2}:\\d{2} ?[AP]M"), "Time format for breakfast pre-meal is invalid: " + breakfastTime);
        }

    @Then("User should see {int}'o clock")
    public void user_should_see__o_clock(Integer expectedTime) {
        // Example check for breakfast pre-meal time 7'o clock = 7:00 AM
       /* String breakfastTime = homepage.getBreakfastTimeAM();
        String expected = expectedTime.replace("o clock", ":00 AM").trim();
        Assert.assertTrue(breakfastTime.startsWith(expected.substring(0, expected.indexOf(":"))),
                "Expected time '" + expected + "' but found '" + breakfastTime + "'");*/
    	String expectedTimeStr = expectedTime + ":00 AM"; // e.g., 7 -> "7:00 AM"
        String breakfastTime = homepage.getBreakfastTimeAM();
        
        Assert.assertTrue(breakfastTime.startsWith(expectedTimeStr),
                "Expected time '" + expectedTimeStr + "' but found '" + breakfastTime + "'");
               }

    @Then("User should see the {int} o'clock")
    public void user_should_see_the_o_clock(Integer expectedTime) {
    	String expectedTimeStr = expectedTime + ":00 PM"; // e.g., 7 -> "7:00 AM"
        String lunchTime = homepage.getLunchTimePM();
        
        Assert.assertTrue(lunchTime.startsWith(expectedTimeStr),
                "Expected time '" + expectedTimeStr + "' but found '" + lunchTime + "'");
               } 
    

    @Then("User should see green color for Carbs")
    public void user_should_see_green_color_for_carbs() {
        Assert.assertTrue(homepage.isCarbsColorDisplayed(), "Carbs color is not green or element not displayed.");
         }

    @Then("User should see purple color for Fat")
    public void user_should_see_purple_color_for_fat() {
        Assert.assertTrue(homepage.isFatColorDisplayed(), "Fat color is not purple or element not displayed.");
        }

    @Then("User should see pink color for Protein")
    public void user_should_see_pink_color_for_protein() {
        Assert.assertTrue(homepage.isProteinColorDisplayed(), "Protein color is not pink or element not displayed.");
          }

    @Then("It should display the unit as {string}")
    public void it_should_display_the_unit_as(String expectedUnit) {
        String carbsUnit = homepage.getCarbsInGrams();
        String proteinUnit = homepage.getProteinInGrams();
        String fatUnit = homepage.getFatInGrams();
        Assert.assertTrue(carbsUnit.contains(expectedUnit), "Carbs unit does not contain expected unit: " + expectedUnit);
        Assert.assertTrue(proteinUnit.contains(expectedUnit), "Protein unit does not contain expected unit: " + expectedUnit);
        Assert.assertTrue(fatUnit.contains(expectedUnit), "Fat unit does not contain expected unit: " + expectedUnit);
         }
        
    @Then("User should see text {string} after the calorie value in pre meal")
    public void user_should_see_text_after_the_calorie_value_in_pre_meal(String expectedText) {
        String calories = homepage.getBreakfastCalories();
        Assert.assertTrue(calories.toLowerCase().contains(expectedText.toLowerCase()),
                "Expected text '" + expectedText + "' not found after calorie value.");
              }




}
   


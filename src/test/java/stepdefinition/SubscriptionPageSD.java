package stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Homepage_Commonfeature;
import pagefactory.SubscriptionPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class SubscriptionPageSD {
	
	private WebDriver driver = DriverFactory.getDriver();
    private SubscriptionPage subscriptionpage = new SubscriptionPage(driver);
    
    

@Given("User is in the homepage")
public void user_is_in_the_homepage() {
	subscriptionpage.clickLoginBtn();
	subscriptionpage.enterEmail(ConfigReader.getProperty("Email"));
	subscriptionpage.clickContinueWithEmail();
	subscriptionpage.enterPassword(ConfigReader.getProperty("password"));
	subscriptionpage.clickSignIn();
    LoggerLoad.info("User successfully signed in."); 
    LoggerLoad.info("User is in homepage");
    }


@When("User clicks view full plan button in homepage")
public void user_clicks_view_full_plan_button_in_homepage() {
	subscriptionpage.clickViewFullPlan();
}

@Then("Both Free and Premium should show Daily Meal Plan as available")
public void both_free_and_premium_should_show_daily_meal_plan_as_available() {
	boolean isFreeAvailable = subscriptionpage.isDailyMealPlanFreeAvailable();
    assertTrue(isFreeAvailable, "Daily Meal Plan should be available for Free Account");
    boolean isPremiumAvailable = subscriptionpage.isDailyMealPlanPremiumAvailable();
    assertTrue(isPremiumAvailable, "Daily Meal Plan should be available for Premium Account");
}


@Then("Weekly Meal Plan should be available only in Premium")
public void weekly_meal_plan_should_be_available_only_in_premium() {
	 boolean isPremiumAvailable = subscriptionpage.isWeeklyMealPlanPremiumAvailable();
	    assertTrue(isPremiumAvailable, "Weekly Meal Plan should be available in Premium"); 
}

@Then("Personalized Exercise Plan should be available only in Premium")
public void personalized_exercise_plan_should_be_available_only_in_premium() {
	boolean isPremiumAvailable = subscriptionpage.isPersonalExercisePremiumAvailable();
    assertTrue(isPremiumAvailable, "Personalized Exercise Plan should be available in Premium");
}


@Then("{int}-Day Quick Reversal Plan should be available only in Premium")
public void day_quick_reversal_plan_should_be_available_only_in_premium(Integer  days) {
    boolean isPremiumAvailable = subscriptionpage.isQuickPlanPremiumAvailable();
    assertTrue(isPremiumAvailable, days + "-Day Quick Reversal Plan should be available in Premium account");

}

@Then("{int}-Day Blood Sugar Reduction Plan should be available only in Premium")
public void day_blood_sugar_reduction_plan_should_be_available_only_in_premium(Integer days) {
    boolean isPremiumAvailable = subscriptionpage.isBloodSugarPremiumAvailable();
    assertTrue(isPremiumAvailable, days + "-Day Blood Sugar Reduction Plan should be available in Premium account");

}

@Then("Both Free and Premium should show Glucose Level Graph as available")
public void both_free_and_premium_should_show_glucose_level_graph_as_available() {
    boolean isFreeAvailable = subscriptionpage.isGlucoseLevelFreeAvailable();
    boolean isPremiumAvailable = subscriptionpage.isGlucoseLevelPremiumAvailable();
    assertTrue(isFreeAvailable, "Glucose Level Graph should be available for Free account");
    assertTrue(isPremiumAvailable, "Glucose Level Graph should be available for Premium account");
}



@Then("Both Free and Premium should show BMI Calculation as available")
public void both_free_and_premium_should_show_bmi_calculation_as_available() {
	boolean isFreeAvailable = subscriptionpage.isBMICalculateFreeAvailable();
    boolean isPremiumAvailable = subscriptionpage.isBMIPremiumAvailable();
    assertTrue(isFreeAvailable, "BMI Calculation should be available for Free account");
    assertTrue(isPremiumAvailable, "BMI Calculation should be available for Premium account");
 
}

@Then("Downloadable Meal Plan PDF should be available only in Premium")
public void downloadable_meal_plan_pdf_should_be_available_only_in_premium() {
	boolean isPremiumAvailable = subscriptionpage.isMealPlanPdfPremiumAvailable();
    assertTrue(isPremiumAvailable, "Downloadable Meal Plan PDF should be available in Premium account");

}

@Then("Reminders should be available only in Premium")
public void reminders_should_be_available_only_in_premium() {
	boolean isPremiumAvailable = subscriptionpage.isRemindersPremiumAvailable();
    assertTrue(isPremiumAvailable, "Reminders should be available in Premium account");
} 


@Then("The {string} button should be visible")
public void the_button_should_be_visible(String buttonName) {
    switch (buttonName.toLowerCase()) {
    case "continue free":
        assertTrue(subscriptionpage.ContinueFree.isDisplayed(), "\"Continue Free\" button should be visible");
        break;
    case "upgrade to premium":
        assertTrue(subscriptionpage.UpgradetoPremium.isDisplayed(), "\"Upgrade to Premium\" button should be visible");
        break;
    default:
        throw new IllegalArgumentException("Unsupported button: " + buttonName);
}
}

@Then("It should display {string}")
public void it_should_display(String string) {
   }
 

@Then("Features not included should have gray X icons")
public void features_not_included_should_have_gray_x_icons() {
    
}

@Then("All included features should have purple checkmarks")
public void all_included_features_should_have_purple_checkmarks() {
    
}

@Then("It should list exactly {int} features")
public void it_should_list_exactly_features(Integer int1) {
    
}
@Then("{string} button should appear")
public void button_should_appear(String string) {
    
}
@Then("Terms & Conditions and Privacy Policy text should be visible")
public void terms_conditions_and_privacy_policy_text_should_be_visible() {
}

@Then("It should show the text “Upgrade to premium for complete diabetes management”")
public void it_should_show_the_text_upgrade_to_premium_for_complete_diabetes_management() {
}

@Then("The Free and Premium plans should be displayed side-by-side in clearly separated columns")
public void the_free_and_premium_plans_should_be_displayed_side_by_side_in_clearly_separated_columns() {
    }

//Subscriptionpage upgradeflow



@Given("User is in upgrade page")
public void user_is_in_upgrade_page() {
	subscriptionpage.clickLoginBtn();
	subscriptionpage.enterEmail(ConfigReader.getProperty("Email"));
	subscriptionpage.clickContinueWithEmail();
	subscriptionpage.enterPassword(ConfigReader.getProperty("password"));
	subscriptionpage.clickSignIn();
	subscriptionpage.clickViewFullPlan();
	subscriptionpage.clickUpgradeToPremium();
    LoggerLoad.info("User successfully signed in."); 
    LoggerLoad.info("User is in homepage"); 
    LoggerLoad.info("User is in Upgrade To Premium");    

}

@Then("User should be redirected to the subscription payment screen")
public void user_should_be_redirected_to_the_subscription_payment_screen() {
	String expectedTitle = "Upgrade To Premium";
    String actualTitle = subscriptionpage.getUpgradePremiumTitle();
    Assert.assertEquals("User is not on subscription payment screen", expectedTitle, actualTitle);
}

@Then("Page title should be {string}")
public void page_title_should_be(String expectedTitle) {
    String actualTitle = subscriptionpage.getUpgradePremiumTitle();
    assertEquals(actualTitle, expectedTitle, "Page title does not match expected value");
}

@Then("User should see {string}")
public void user_should_see(String string) {
}

@Then("User should see text {string}")
public void user_should_see_text(String string) {
   }


@Then("User should see cancel anytime text below the pricing details")
public void user_should_see_cancel_anytime_text_below_the_pricing_details() {
	String actualText = subscriptionpage.getCancelAnytimeText();
    String expectedText = "Cancel anytime";
    assertTrue(actualText.trim().equalsIgnoreCase(expectedText),
        "Expected 'Cancel anytime' text not found below the pricing details. Found: " + actualText);
}  

@Then("User should see heading {string}")
public void user_should_see_heading(String string) {
    //String actualHeading = subscriptionpage.getCardNumberText(); // You need this getter method in PageFactory
    //assertEquals(actualHeading.trim(), expectedHeading, "Card section heading mismatch");
}

@Then("User should see card number, expiration , cvv field")
public void user_should_see_card_number_expiration_cvv_field() {
	/*boolean isCardNumberVisible = subscriptionpage.isCardNumberFieldVisible();
    boolean isExpireDateVisible = subscriptionpage.isExpireDateFieldVisible();
    boolean isCvcVisible = subscriptionpage.isCvcFieldVisible();

    assertTrue(isCardNumberVisible, "Card number field is not visible");
    assertTrue(isExpireDateVisible, "Expiration date field is not visible");
    assertTrue(isCvcVisible, "CVV field is not visible");*/
    }

@Then("User should see terms of service and auto-renewal notice")
public void user_should_see_terms_of_service_and_auto_renewal_notice() {
    }

@When("user clicks the {string} button")
public void user_clicks_the_button(String string) {
    }

@Then("User should be redirected to the home page")
public void user_should_be_redirected_to_the_home_page() {
	LoggerLoad.info("Validating user redirection to homepage");
	String actualResult = driver.getCurrentUrl();
	  Assert.assertTrue(actualResult.contains("home"), "User is not logged in successfully");
}

   }









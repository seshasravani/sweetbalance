package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.PaymentPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class PaymentPageSD {
	
	private WebDriver driver = DriverFactory.getDriver();
    PaymentPage paymentpage = new PaymentPage(driver);
    
    

@Given("User is on the subscription page")
public void user_is_on_the_subscription_page() {
    paymentpage.clickLoginBtn();
    paymentpage.enterEmail(ConfigReader.getProperty("Email"));
    paymentpage.clickContinueWithEmail();
    paymentpage.enterPassword(ConfigReader.getProperty("password"));
    paymentpage.clickSignIn();
    paymentpage.clickViewFullPlan();
    paymentpage.clickUpgradeToPremium();
    LoggerLoad.info("User successfully signed in."); 
    LoggerLoad.info("User is in homepage"); 
    LoggerLoad.info("User is in Upgrade To Premium");    
}

@When("User clicks the {string} button without entering any card details")
public void user_clicks_the_button_without_entering_any_card_details(String string) {
	paymentpage.clickPayButton();
    }

@Then("User should see validation messages for all required fields")
public void user_should_see_validation_messages_for_all_required_fields() {
    }

@When("User enters an invalid card number")
public void user_enters_an_invalid_card_number() {
	paymentpage.enterCardNumber("1111 2222 3333 4444");
    }

@Then("Error message should be displayed for invalid card number")
public void error_message_should_be_displayed_for_invalid_card_number() {
	//assertTrue("Card number validation not displayed", paymentpage.isCardNumberErrorDisplayed());
}


@When("User enters an expired card")
public void user_enters_an_expired_card() {
	   paymentpage.enterCardNumber("4242 4242 4242 42"); // Valid format
       paymentpage.enterCardExpiry("06/25"); // Expired date
       paymentpage.enterCardCVC("123");
    }

@Then("Error message should be displayed for expired card")
public void error_message_should_be_displayed_for_expired_card() {
    }

@When("User enters valid payment details")
public void user_enters_valid_payment_details() {
	 //paymentpage.enterCardNumber("4242 4242 4242 4242");
     //paymentpage.enterCardExpiry("12/30"); // Future date
     //paymentpage.enterCardCVC("123");
    
}

@Then("User should be redirected to the confirmation or home page with premium access enabled")
public void user_should_be_redirected_to_the_confirmation_or_home_page_with_premium_access_enabled() {
	LoggerLoad.info("Validating user redirection to homepage");
	String actualResult = driver.getCurrentUrl();
	  Assert.assertTrue(actualResult.contains("home"), "User is not logged in successfully");
}
}




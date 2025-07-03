package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPages;
import webdriver.DriverFactory;

public class Sweet_login {

    WebDriver driver = DriverFactory.getDriver();  // get the driver from DriverFactory
    LoginPages loginPages = new LoginPages(driver);  // pass that driver to page object

    @Given("User is on SweetBalance homepage")
    public void user_is_on_sweet_balance_homepage() {
        // Since Hooks already navigate to URL, you might leave this empty or add validations
    }

    @When("User clicks on Login link")
    public void user_clicks_on_login_link() {
        loginPages.loginlink();
    }

    @Then("User should see Welcome back heading")
    public void user_should_see_welcome_back_heading() {
        String actualText = loginPages.getWelcomeText().getText();
        Assert.assertEquals(actualText, "Welcome back");
    }
    
    

    	@Then("User should see Sign in to your account or create a new one")
    	public void user_should_see_sign_in_to_your_account_or_create_a_new_one() {
    	   
    		 String actualText = loginPages.getsubText().getText();
    	        Assert.assertEquals(actualText, "Sign in to your account or create a new one");
    		
    		    	}
    	
    	@Then("User should see close button at the right corner")
    	public void user_should_see_close_button_at_the_right_corner() {
    	Assert.assertTrue(loginPages.getCloseButton().isDisplayed(), "Close button is not visible");
    	}
    	
    	@Then("User should see an input field to enter email")
    	public void user_should_see_an_input_field_to_enter_email() {
    	    Assert.assertTrue(
    	        loginPages.getEnterEmailInput().isDisplayed(), 
    	        "Email input field is not displayed"
    	    );
    	}
    	
    	
    	@Then("User should see text Enter Email in email field placeholder")
    	public void user_should_see_enter_email_placeholder() {
    	    String actualPlaceholder = loginPages.getEmailPlaceholderText();
    	    Assert.assertEquals(actualPlaceholder, "Enter email");
    	}

    	
    	@Then("User should see a Continue with email button")
    	public void user_should_see_a_continue_with_email_button() {
    		Assert.assertTrue(loginPages.getContinueWithEmailButton().isDisplayed(), "Continue with Email button is not displayed");
    	}

    	@Then("User should see Continue with email button to be enabled")
    	public void user_should_see_continue_with_email_button_is_enabled() {
    	    Assert.assertTrue(loginPages.getContinueWithEmailButton().isEnabled(), "Continue with Email button is not enabled");
    	}

    	@Then("User should see a Continue with Google button")
    	public void user_should_see_a_continue_with_google_button() {
    		
    		Assert.assertTrue(
    		        loginPages.getContWithGglBtn().isDisplayed(),
    		        "Continue with Google button is not displayed"
    		    );
    	}
    		
    		@Then("User should see an OR separator")
    		public void user_should_see_an_or_separator() {
    			Assert.assertTrue(loginPages.isOrSeparatorDisplayed(),"OR separator is not displayed");
    	   
    	}

    		
    		@Then("User should see By continuing you agree to our T&C and Privacy")
    		public void user_should_see_by_continuing_you_agree_to_our_t_c_and_privacy() {
    			String actualText = loginPages.getTncText().getText();
    		    Assert.assertEquals(actualText, "By continuing you agree to our T&Cs and Privacy Policy", "Text does not match");
    		    
    		}

    		
    		@Then("Username input field should be displayed")
    		public void username_input_field_should_be_displayed()
    		{
    	    }


    	   
    	}



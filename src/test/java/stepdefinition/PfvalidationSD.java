package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.LoginPages;
import utilities.ExcelReader;
import webdriver.DriverFactory;
import utilities.LoggerLoad;

public class PfvalidationSD {
	
	WebDriver driver = DriverFactory.getDriver();  
    LoginPages loginPages = new LoginPages(driver); 
    
    
    
    @When("User clicks continue with email button after entering a valid new email")
    public void user_clicks_continue_with_email_button_after_entering_a_valid_new_email() {
    	ExcelReader reader = new ExcelReader("src/test/resources/testdata/SweetBalanceApplication.xlsx");
        List<Map<String, String>> data = reader.getDataAll("Sheet1");

        // Using 3rd row (index 2)
         String newvalidemail = data.get(4).get("Email");
        
        loginPages.enterEmail(newvalidemail);
        loginPages.clickContinueWithEmail();
    }
    
    @Then("Full Name input field should be displayed")
    public void full_name_input_field_should_be_displayed() {
    	
    	 Assert.assertTrue(loginPages.isFullNameFieldDisplayed(), "Full Name input is not displayed");
    	}
    
    @Then("Username input field for profile validation should be displayed")
   
    	 public void username_input_field_should_be_displayed() {
 			Assert.assertTrue(loginPages.isUsernameFieldDisplayed(),"Username input field is not displayed" );
    }

    @Then("Password input field should be displayed")
    public void password_input_field_should_be_displayed() {
    	boolean isDisplayed = loginPages.isPasswordinputFieldDisplayed();
        Assert.assertTrue(isDisplayed,"Password input field is not displayed");
    }
    
    @Then("Terms & Conditions checkbox should be displayed")
    public void terms_conditions_checkbox_should_be_displayed() {
    	Assert.assertTrue( loginPages.isTermsCheckboxDisplayed(),"Terms & Conditions checkbox is not displayed");

    }
    
    @Then("Create Account button should be disabled")
    public void create_account_button_should_be_disabled() {
        Assert.assertTrue(loginPages.isCreateAccountButtonEnabled(), "Create Account button is NOT enabled");
    }


       
    }



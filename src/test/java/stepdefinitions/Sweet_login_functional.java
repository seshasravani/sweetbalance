package stepdefinitions;

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
import pageFactory.LoginPages;
import utilities.ExcelReader;
import webdriver.DriverFactory;

public class Sweet_login_functional {
	 WebDriver driver = DriverFactory.getDriver();  // get the driver from DriverFactory
	    LoginPages loginPages = new LoginPages(driver);  // pass that driver to page object
	    private String validemail;
	    private String validpassword;
	
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		loginPages.loginlink();
	}

	@When("Registered user clicks continue with email button after entering a valid existing email")
	public void registered_user_clicks_continue_with_email_button_after_entering_a_valid_existing_email() {
		ExcelReader reader = new ExcelReader("src/test/resources/testdata/SweetBalanceApplication.xlsx");
        List<Map<String, String>> data = reader.getDataAll("Sheet1");

        // Using 3rd row (index 2)
         validemail = data.get(2).get("Email");
        validpassword = data.get(2).get("Password");

        loginPages.enterEmail(validemail);
        loginPages.clickContinueWithEmail();

        // You can store/use password later if needed
        System.out.println("Email used: " + validemail);
        System.out.println("Password from Excel: " + validpassword);
	    
	}

	@Then("User should get password field")
	public void user_should_get_password_field() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(loginPages.getPasswordField()));
		    Assert.assertTrue(loginPages.getPasswordField().isDisplayed());
	    
	}
	
	//invalid email
	@When("User enters an invalid email")
	public void user_enters_an_invalid_email() {
		
		ExcelReader reader = new ExcelReader("src/test/resources/testdata/SweetBalanceApplication.xlsx");
        List<Map<String, String>> data = reader.getDataAll("Sheet1");

        // Using 4rd row (index 3)
        String email = data.get(3).get("Email");
        String password = data.get(3).get("Password");

        loginPages.enterEmail(email);
        loginPages.clickContinueWithEmail();

        // You can store/use password later if needed
        System.out.println("Email used: " + email);
        System.out.println("Password from Excel: " + password);
	   
	}

	@Then("Email field should show validation error")
	public void email_field_should_show_validation_error() {
		
		Assert.assertEquals(loginPages.getEmailErrorText(), "Please enter a valid email address");

	}
		
		@Then("User should see Sign in button")
		public void user_should_see_sign_in_button() {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(loginPages.getSignInButton()));

		    Assert.assertTrue(loginPages.isSignInButtonDisplayed());
		}
		
		@Then("User should see email id  in sub text")
		public void user_should_see_email_id_in_sub_text() {
		    
			
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(loginPages.subTextEmailElement));

			String displayedEmail = loginPages.getSubTextEmail();  

	        // Assert they are equal
	        Assert.assertEquals(displayedEmail, validemail);	
		}
		
		@Then("User should see Forgot password? link")
		public void user_should_see_forgot_password_link() {
			Assert.assertTrue(loginPages.isForgotPasswordDisplayed());
			//loginPages.clickForgotPassword();

		}
		
		@Then("User should see text Enter your password as placeholder in password field")
		public void user_should_see_text_as_placeholder_in_password_field() {
			Assert.assertTrue(loginPages.isPasswordFieldDisplayed());
		}
		
		@When("Registered user clicks sign in after entering password")
		public void registered_user_clicks_sign_in_after_entering_password() {
			loginPages.enterPassword(validpassword);
			
			loginPages.clickSignInButton();
		    
		}

		@Then("User should be navigated to home page")
		public void user_should_be_navigated_to_home_page() {
			
		    
			
		}




	}



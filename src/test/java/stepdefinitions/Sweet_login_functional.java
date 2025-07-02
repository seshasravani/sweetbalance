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
	
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		loginPages.loginlink();
	}

	@When("Registered user clicks continue with email button after entering a valid existing email")
	public void registered_user_clicks_continue_with_email_button_after_entering_a_valid_existing_email() {
		ExcelReader reader = new ExcelReader("src/test/resources/testdata/SweetBalanceApplication.xlsx");
        List<Map<String, String>> data = reader.getDataAll("Sheet1");

        // Using 3rd row (index 2)
        String email = data.get(2).get("Email");
        String password = data.get(2).get("Password");

        loginPages.enterEmail(email);
        loginPages.clickContinueWithEmail();

        // You can store/use password later if needed
        System.out.println("Email used: " + email);
        System.out.println("Password from Excel: " + password);
	    
	}

	@Then("User should get password field")
	public void user_should_get_password_field() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(loginPages.getPasswordField()));
		    Assert.assertTrue(loginPages.getPasswordField().isDisplayed());
	    
	}




}

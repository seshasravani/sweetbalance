package stepdefinitions;

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
}

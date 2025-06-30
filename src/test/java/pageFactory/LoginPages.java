package pageFactory;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	
	 WebDriver driver;
	
	public LoginPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // <- This is required!
    }
	
	//Web Locators
	
	@FindBy(xpath = "//h1[text()='Welcome back']")

		private WebElement welcomeText;
//		@FindBy(id = "id_username")
//		private WebElement Username;
	@FindBy(xpath = "//button[contains(text(), 'Login')]")
       private WebElement login;
//		@FindBy(xpath = "//div[contains(text(),'password_mismatch:The two')]")
//		private WebElement Passwordmismatch;
//		@FindBy(linkText = "Register")
//		private WebElement Registerlinktext;
//		@FindBy(linkText = "Sign in")
//		private WebElement Signinlinktext;
	
	
	 


	
	
	
	public void loginlink() {
		login.click();
	}
	
	public WebElement getWelcomeText() {
	    return welcomeText;
	}

}

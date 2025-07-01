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

	@FindBy(xpath = "//button[contains(text(), 'Login')]")
       private WebElement login;

	@FindBy(xpath = "//p[text()='Sign in to your account or create a new one']")
	private WebElement subText;
	
    @FindBy(xpath = "//*[@id='root']/div[1]/div/button")
	private WebElement closeButton;
    
    @FindBy(xpath = "//*[@id='root']/div[1]/div/div[2]/p")
    private WebElement tncText;


//    @FindBy(xpath = "//input[@placeholder='Enter email']")
//    private WebElement enterEmailInput;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/form/div")
    private WebElement enterEmailInput;
    
    
    
    @FindBy(xpath = "//input[@placeholder='Enter email']")
  private WebElement phText;
  
    @FindBy(xpath = "//button[normalize-space()='Continue with email']")
    private WebElement continueWithEmailButton;
    
    @FindBy(xpath = "//button[text()='Continue with Google']")
    private WebElement contWithGglBtn;
    
    @FindBy(xpath = "//span[text()='OR']")
    private WebElement orSeparator;



    
    
 
	



	
	
	
	public void loginlink() {
		login.click();
	}
	
	public WebElement getWelcomeText() {
	    return welcomeText;
	}

	
	public WebElement getsubText() {
	    return subText;
	}
	
//	public void clickCloseButton() {
//	    closeButton.click();
//	}

	
	public WebElement getCloseButton() {
	    return closeButton;
	}
	
	public WebElement getEnterEmailInput() {
        return enterEmailInput;
    }
	public String getEmailPlaceholderText() {
	    return phText.getDomAttribute("placeholder");
	}
	public WebElement getContinueWithEmailButton() {
	    return continueWithEmailButton;
	}

	public WebElement getContWithGglBtn() {
	    return contWithGglBtn;
	}
	
	public boolean isOrSeparatorDisplayed() {
        return orSeparator.isDisplayed();
    }

	public WebElement getTncText() {
	    return tncText;
	}
}

package pageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPages {
	
	 WebDriver driver;
	
	public LoginPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
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

//    @FindBy(xpath = "//input[@placeholder='Enter your password']")
//    private WebElement passwordField;
    
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/form/div[1]/div/input")
    private WebElement passwordField;

    
    @FindBy(xpath = "//p[contains(text(), 'Please enter a valid email')]")
    private WebElement emailErrorMessage;
    
   // @FindBy(xpath = "//button[text()='Sign in']")
    @FindBy(xpath = "//button[contains(text(), 'Sign in')]")
    private WebElement signInButton;
    
    @FindBy(xpath = "//*[@id='root']/div[1]/div/div[2]/div/p[2]")  // update with actual locator
    private WebElement subTextEmailElement;
    
    @FindBy(xpath = "//button[text()='Forgot password?']")
    private WebElement forgotPasswordButton;

    
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    private WebElement passwordInput;
    
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/form/div[2]/input")
    private WebElement fullNameInput;
    
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/form/div[3]/input")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    
    @FindBy(id = "terms")
    private WebElement termsCheckbox;
    
    @FindBy(xpath = "//*[@id='root']/div[1]/div/div[2]/form/button")
    private WebElement createAccountButton;

    



//input[@placeholder='Enter your password']




    
    
 
	



	
	
	
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
	//****************************  Actions ******************************//
	
	public void enterEmail(String email) {
     
		
		 phText.clear();
	       phText.sendKeys(email);
	    }
    

    public void clickContinueWithEmail() {
    	continueWithEmailButton.click();
    }
    
    public void enterPassword(String password) throws InterruptedException {
    	Thread.sleep(2000);

        passwordField.click();
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
    }
        
        public WebElement getPasswordField() {
            return passwordField;
        }
        
        public String getEmailErrorText() {
            return emailErrorMessage.getText();
        }

        public boolean isSignInButtonDisplayed() {
        	
            return signInButton.isDisplayed();
        }

        
        public void clickSignInButton() {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(signInButton));
            signInButton.click();
        }

        public WebElement getSignInButton() {
            return signInButton;
        }

    
        public String getSubTextEmail() {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(subTextEmailElement));
            return subTextEmailElement.getText();
        }
        
        public void clickForgotPassword() {
            forgotPasswordButton.click();
        }

        public boolean isForgotPasswordDisplayed() {
        	
        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             wait.until(ExpectedConditions.visibilityOf(forgotPasswordButton));
            return forgotPasswordButton.isDisplayed();
        }

        public boolean isPasswordFieldDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            return passwordInput.isDisplayed();
        }
        
        
//        public void enterFullName(String name) {
//            fullNameInput.sendKeys(name);
//        }

        
        public boolean isFullNameFieldDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(fullNameInput));
            return fullNameInput.isDisplayed();
            
        }
        
        public boolean isUsernameFieldDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            return usernameInput.isDisplayed();
        }
        
        public boolean isPasswordinputFieldDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(inputPassword));
            return inputPassword.isDisplayed();
        }

        
        public boolean isTermsCheckboxDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(termsCheckbox));
            return termsCheckbox.isDisplayed();
        }
       
        
       // public boolean isCreateAccountButtonDisabled() {
           // return !createAccountButton.isEnabled(); // true means it's disabled
        	
        //	return createAccountButton.isDisabled();
        
        
        public boolean isCreateAccountButtonEnabled() {
            return createAccountButton.isEnabled();
        }

        }






        



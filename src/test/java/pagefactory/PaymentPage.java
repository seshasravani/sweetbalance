package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class PaymentPage {
	
	private WebDriver driver;
    
	@FindBy(xpath ="//button[normalize-space(text())='Login']")
	private WebElement LoginBtn;
	@FindBy(xpath = "//input[@placeholder='Enter email']")
	private WebElement Enteremail;
	@FindBy(xpath = "//button[text()='Continue with email']")
	private WebElement Continuewithemail;
	@FindBy(xpath = "//input[@type='password' and @placeholder='Enter your password' and @name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement Signin;
	@FindBy(xpath = "//button[text()='View Full Plan']")
	private WebElement ViewFullPlan;
	@FindBy(xpath = "//button[normalize-space(text())='Upgrade to Premium']")
	public WebElement UpgradetoPremium;
	
	@FindBy(xpath = "//div[text()='Your card number is incomplete.']")
	public WebElement Incompletecardnumber;
	@FindBy(xpath = "//p[text()=\"Your card’s expiration date is in the past.\"]")
	public WebElement ExpirationCardDate;
	@FindBy(xpath = "//input[@aria-label='Credit or debit card expiration date']")
    public WebElement CardExpiry;
	@FindBy(xpath = "//input[@aria-label='Credit or debit card number']")
	public WebElement CardNumber;
	@FindBy(xpath = "//*[@id=\\\"root\\\"]/form/span[2]/div/span/input")
    public WebElement CardCVC;
    @FindBy(xpath = "//button[contains(text(),'Pay')]")
    public WebElement PayButton;
	/*@FindBy(xpath = "")
	public WebElement ;
	@FindBy(xpath = "")
	public WebElement ;
	@FindBy(xpath = "")
	public WebElement ;*/
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver; 	// Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); 	
	}
    
	public void clickLoginBtn() {
    	LoginBtn.click();
    }

	public void enterEmail(String email) {
		 CommonMethods.waitForElementVisibilityOf(Enteremail);
        Enteremail.clear();
        Enteremail.sendKeys(email);
    }
    
    public void clickContinueWithEmail() {
        Continuewithemail.click();
    }
    
    public void enterPassword(String pwd) {
		 CommonMethods.waitForElementVisibilityOf(password);
        password.clear();
        password.sendKeys(pwd);
    }
    
    public void clickSignIn() {
		 CommonMethods.waitForElementVisibilityOf(Signin);
        Signin.click();
    }
     
    public void clickViewFullPlan() {
        CommonMethods.waitForElementVisibilityOf(ViewFullPlan);
        ViewFullPlan.click();
    }

    public void clickUpgradeToPremium() {
        CommonMethods.waitForElementVisibilityOf(UpgradetoPremium);
        UpgradetoPremium.click();
    }

    public void enterCardNumber(String cardNum) {
        CommonMethods.waitForElementVisibilityOf(CardNumber);
        CardNumber.clear();
        CardNumber.sendKeys(cardNum);
    }

    public void enterCardExpiry(String expiry) {
        CommonMethods.waitForElementVisibilityOf(CardExpiry);
        CardExpiry.clear();
        CardExpiry.sendKeys(expiry);
    }

    public void enterCardCVC(String cvc) {
        CommonMethods.waitForElementVisibilityOf(CardCVC);
        CardCVC.clear();
        CardCVC.sendKeys(cvc);
    }

    public void clickPayButton() {
        CommonMethods.waitForElementVisibilityOf(PayButton);
        PayButton.click();
    }

    public boolean isCardNumberErrorDisplayed() {
        CommonMethods.waitForElementVisibilityOf(Incompletecardnumber);
        return Incompletecardnumber.isDisplayed();
    }

    public boolean isCardExpiryErrorDisplayed() {
        CommonMethods.waitForElementVisibilityOf(ExpirationCardDate);
        return ExpirationCardDate.isDisplayed();
    }
}






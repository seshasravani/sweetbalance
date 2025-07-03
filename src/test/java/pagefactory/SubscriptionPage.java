package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class SubscriptionPage {
	
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
	
	@FindBy(xpath = "//th[normalize-space(text())='Feature']")
	private WebElement Feature;
	@FindBy(xpath = "//th[normalize-space(text())='Free Account']")
	private WebElement FreeAccount;
	@FindBy(xpath = "//th[contains(., 'Premium Account')]")
	private WebElement PremiumAccount;
	@FindBy(xpath = "//td[normalize-space(text())='Daily Meal Plan']")
	private WebElement DailyMealPlan;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[1]/td[2]")
	private WebElement DailyMealPlanFreeAccount;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[1]/td[3]/span")
	private WebElement PremiunAccountMealPlan;
	@FindBy(xpath = "//td[normalize-space(text())='Weekly Meal Plan']")
	private WebElement WeeklyMealPlan;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/span")
	private WebElement WeeklyMealPlanPremiumAccount;
	@FindBy(xpath = "//td[normalize-space(text())='Personalized Exercise Plan']")
	private WebElement PersonalizedExercisePlan;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/span")
	private WebElement PersonalExercisePremium;
	@FindBy(xpath = "//td[normalize-space(text())='10-Day Quick Reversal Plan']")
	private WebElement Quickplan ;
	@FindBy(xpath = "//span[normalize-space(text())='✓']")
	private WebElement QuickPlanPremiumAccount;
	@FindBy(xpath = "//td[normalize-space(text())='30-Day Blood Sugar Reduction Plan']")
	private WebElement BloodSugarPlan ;
	@FindBy(xpath = "//span[normalize-space(text())='✓']")
	private WebElement BloodSugarPremiumAcc;
	@FindBy(xpath = "//td[normalize-space(text())='Glucose Level Graph']")
	private WebElement GlucoseLevelGraph;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[6]/td[2]")
	private WebElement GlucoseLevelFreeAcc;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[6]/td[3]/span")
	private WebElement GlucoseLevelPremiumAcc;
	@FindBy(xpath = "//td[normalize-space(text())='BMI Calculation']")
	private WebElement BMICalculate;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[7]/td[2]/span")
	private WebElement BMICalculateFreeAcc;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[7]/td[3]/span")
	private WebElement BMIPremiumAcc;
	@FindBy(xpath = "//td[normalize-space(text())='Downloadable Meal Plan PDF']")
	private WebElement MealPlanPdf;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[8]/td[3]/span")
	private WebElement MealPlanPremiumAcc;
	@FindBy(xpath = "//td[normalize-space(text())='Reminders (Medication, Appointments, Health Tasks)']")
	private WebElement Reminders;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/table/tbody/tr[9]/td[3]/span")
	private WebElement RemindersPremiumAcc;
	@FindBy(xpath = "//button[normalize-space(text())='Continue Free']")
	public WebElement ContinueFree;
	@FindBy(xpath = "//button[normalize-space(text())='Upgrade to Premium']")
	public WebElement UpgradetoPremium;
	@FindBy(xpath = "//span[normalize-space(text())='✕']")
	private WebElement crossmarks;
	@FindBy(xpath = "//p[normalize-space(text())='Upgrade to premium for complete diabetes management']")
	private WebElement underAccountMessage;
	//subscription upgradseflow
	@FindBy(xpath = "//h1[normalize-space(text())='Upgrade to Premium']")
	private WebElement upgradepremiumTitle;
	@FindBy(xpath = "//p[normalize-space(text())='Get personalized insights and advanced features to better manage your diabetes.']")
	private WebElement underupgradeText;
	@FindBy(xpath = "//h3[normalize-space(text())='Premium Features']")
	private WebElement PremiunFeature ;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[1]/ul/li[1]")
	private WebElement PersonalMealPlans;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[1]/ul/li[2]")
	private WebElement Advancedanalytics ;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[1]/ul/li[3]")
	private WebElement priortysupport;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/p[1]")
	private WebElement monthprice;
	@FindBy(xpath = "//p[normalize-space(text())='Cancel anytime']")
	private WebElement Cancelanytime;
	@FindBy(xpath = "//input[@aria-label='Credit or debit card number']")
	private WebElement Cardnumber;
	@FindBy(xpath = "//*[@id=\"root\"]/form/span[2]/div/span/input")
	private WebElement ExpireDate;
	@FindBy(xpath = "//*[@id=\"root\"]/form/span[2]/div/span/input")
	private WebElement CVcNumber;
	/*@FindBy(xpath = "")
	private WebElement ;
	@FindBy(xpath = "")
	private WebElement ;
	@FindBy(xpath = "")
	private WebElement ;
	@FindBy(xpath = "")
	private WebElement ;*/

	
	
	public SubscriptionPage(WebDriver driver) {
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


	public String getFeatureText() {
		 CommonMethods.waitForElementVisibilityOf(Feature);
        return Feature.getText();
    }

    public String getFreeAccountText() {
		 CommonMethods.waitForElementVisibilityOf(FreeAccount);
        return FreeAccount.getText();
    }

    public String getPremiumAccountText() {
		 CommonMethods.waitForElementVisibilityOf(PremiumAccount);
        return PremiumAccount.getText();
    }

    // Get text methods for plan/features
    public String getDailyMealPlanText() {
		 CommonMethods.waitForElementVisibilityOf(DailyMealPlan);
        return DailyMealPlan.getText();
    }

    public String getWeeklyMealPlanText() {
		 CommonMethods.waitForElementVisibilityOf(WeeklyMealPlan);
        return WeeklyMealPlan.getText();
    }

    public String getPersonalizedExercisePlanText() {
		 CommonMethods.waitForElementVisibilityOf(PersonalizedExercisePlan);
        return PersonalizedExercisePlan.getText();
    }

    public String getQuickPlanText() {
		 CommonMethods.waitForElementVisibilityOf(Quickplan);
        return Quickplan.getText();
    }

    public String getBloodSugarPlanText() {
		 CommonMethods.waitForElementVisibilityOf(BloodSugarPlan);
        return BloodSugarPlan.getText();
    }

    public String getGlucoseLevelGraphText() {
		 CommonMethods.waitForElementVisibilityOf(GlucoseLevelGraph);
        return GlucoseLevelGraph.getText();
    }

    public String getBMICalculateText() {
		 CommonMethods.waitForElementVisibilityOf(BMICalculate);
        return BMICalculate.getText();
    }

    public String getMealPlanPdfText() {
		 CommonMethods.waitForElementVisibilityOf(MealPlanPdf);
        return MealPlanPdf.getText();
    }

    public String getRemindersText() {
		 CommonMethods.waitForElementVisibilityOf(Reminders);
        return Reminders.getText();
    }

    // Methods to check if Premium account features are available (checkmark visible)
    public boolean isDailyMealPlanPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(PremiunAccountMealPlan);
        return PremiunAccountMealPlan.isDisplayed();
    }

    public boolean isWeeklyMealPlanPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(WeeklyMealPlanPremiumAccount);
        return WeeklyMealPlanPremiumAccount.isDisplayed();
    }

    public boolean isPersonalExercisePremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(PersonalExercisePremium);
        return PersonalExercisePremium.isDisplayed();
    }

    public boolean isQuickPlanPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(QuickPlanPremiumAccount);
        return QuickPlanPremiumAccount.isDisplayed();
    }

    public boolean isBloodSugarPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(BloodSugarPremiumAcc);
        return BloodSugarPremiumAcc.isDisplayed();
    }

    public boolean isGlucoseLevelPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(GlucoseLevelPremiumAcc);
        return GlucoseLevelPremiumAcc.isDisplayed();
    }

    public boolean isBMIPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(BMIPremiumAcc);
        return BMIPremiumAcc.isDisplayed();
    }

    public boolean isMealPlanPdfPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(MealPlanPremiumAcc);
        return MealPlanPremiumAcc.isDisplayed();
    }

    public boolean isRemindersPremiumAvailable() {
		 CommonMethods.waitForElementVisibilityOf(RemindersPremiumAcc);
        return RemindersPremiumAcc.isDisplayed();
    }

    public boolean isDailyMealPlanFreeAvailable() {
		 CommonMethods.waitForElementVisibilityOf(DailyMealPlanFreeAccount);
        return DailyMealPlanFreeAccount.isDisplayed();
    }

    public boolean isGlucoseLevelFreeAvailable() {
		 CommonMethods.waitForElementVisibilityOf(GlucoseLevelFreeAcc);
        return GlucoseLevelFreeAcc.isDisplayed();
    }

    public boolean isBMICalculateFreeAvailable() {
		 CommonMethods.waitForElementVisibilityOf(BMICalculateFreeAcc);
        return BMICalculateFreeAcc.isDisplayed();
    }

    public void clickContinueFree() {
		 CommonMethods.waitForElementVisibilityOf(ContinueFree);
        ContinueFree.click();
    }

    public void clickUpgradeToPremium() {
		 CommonMethods.waitForElementVisibilityOf(UpgradetoPremium);
        UpgradetoPremium.click();
    }

    public void clickCrossMark() {
		 CommonMethods.waitForElementVisibilityOf(crossmarks);
        crossmarks.click();
    }

    public String getUpgradeMessageText() {
		 CommonMethods.waitForElementVisibilityOf(underAccountMessage);
        return underAccountMessage.getText();
    }

    public void clickViewFullPlan() {
		 CommonMethods.waitForElementVisibilityOf(ViewFullPlan);
        ViewFullPlan.click();
    }
    
    //subscriptionpage upgradeflow
    
    public String getUpgradePremiumTitle() {
		 CommonMethods.waitForElementVisibilityOf(upgradepremiumTitle);
        return upgradepremiumTitle.getText();
    }

    public String getUnderUpgradeText() {
		 CommonMethods.waitForElementVisibilityOf(underupgradeText);
		 return underupgradeText.getText();
    }

    public String getPremiumFeatureTitle() {
		 CommonMethods.waitForElementVisibilityOf(PremiunFeature);
        return PremiunFeature.getText();
    }

    public String getPersonalMealPlansText() {
		 CommonMethods.waitForElementVisibilityOf(PersonalMealPlans);
        return PersonalMealPlans.getText();
    }

    public String getAdvancedAnalyticsText() {
		 CommonMethods.waitForElementVisibilityOf(Advancedanalytics);
        return Advancedanalytics.getText();
    }

    public String getPrioritySupportText() {
		 CommonMethods.waitForElementVisibilityOf(priortysupport);
        return priortysupport.getText();
    }

    public String getMonthPriceText() {
		 CommonMethods.waitForElementVisibilityOf(monthprice);
        return monthprice.getText();
    }

    public String getCancelAnytimeText() {
		 CommonMethods.waitForElementVisibilityOf(Cancelanytime);
        return Cancelanytime.getText();
    }

    public void enterCardNumber(String cardNum) {
		 CommonMethods.waitForElementVisibilityOf(Cardnumber);
        Cardnumber.clear();
        Cardnumber.sendKeys(cardNum);
    }
    
    public String getCardNumberText() {
		 CommonMethods.waitForElementVisibilityOf(Cardnumber);
    	return Cardnumber.getText();
    }

    public void enterExpireDate(String expireDate) {
		 CommonMethods.waitForElementVisibilityOf(ExpireDate);
        ExpireDate.clear();
        ExpireDate.sendKeys(expireDate);
    }

    public void enterCvcNumber(String cvc) {
		 CommonMethods.waitForElementVisibilityOf(CVcNumber);
        CVcNumber.clear();
        CVcNumber.sendKeys(cvc);
    }

	public boolean isCardNumberFieldVisible() {
		CommonMethods.waitForElementVisibilityOf(Cardnumber);
        return Cardnumber.isDisplayed();
	}

	public boolean isExpireDateFieldVisible() {
		 CommonMethods.waitForElementVisibilityOf(ExpireDate);
		return ExpireDate.isDisplayed();
	}

	public boolean isCvcFieldVisible() {
		 CommonMethods.waitForElementVisibilityOf(CVcNumber);
			return CVcNumber.isDisplayed();
	}


}



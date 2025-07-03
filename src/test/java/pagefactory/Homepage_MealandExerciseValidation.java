
package pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Homepage_MealandExerciseValidation {

	private WebDriver driver;
	private WebDriverWait wait;

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

	@FindBy(xpath = "//div[text()='Nutrition Insights']")
	private WebElement NutritionInsightsHeading;
	@FindBy(xpath = "//div[contains(text(), 'Carbs:')]")
	private WebElement Carbsvalue;
	@FindBy(xpath = "//div[contains(text(), 'Protein:')]")
	private WebElement Proteinvalue;
	@FindBy(xpath = "//div[contains(text(), 'Fat:')]")
	private WebElement Fatvalue;
	@FindBy(xpath = "//div[text()='Pre-Snack']")
	private WebElement SnackIndicator;
	@FindBy(xpath = "//span[text()='3:00 PM']")
	private WebElement SnackTime;
	@FindBy(xpath = "//button[text()='View Full Plan']")
	private WebElement ViewFullPlan;
	@FindBy(xpath = "//button[.//span[text()='Exercise']]")
	private WebElement ExerciseSection;
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[2]")
	private WebElement ExerciseList;
	@FindBy(xpath = "//h2[text()=\"Today's Exercise Plan\"]")
	private WebElement ExercisePlan;
	@FindBy(xpath = "//span[text()='Morning Walk']")
	private WebElement MorningWalk;
	@FindBy(xpath = "//span[text()='Yoga Session']")
	private WebElement Yoga;
	@FindBy(xpath = "//span[text()='7:00 AM']")
	private WebElement  MorningWalkTime;
	@FindBy(xpath = "//span[text()='5:00 PM']")
	private WebElement YogaTime;
	@FindBy(xpath = "//div[text()='30 mins • Low intensity']")
	private WebElement LowExercise;
	@FindBy(xpath = "//div[text()='20 mins • Medium intensity']")
	private WebElement MediumExercise;
	@FindBy(xpath = "//button[text()='View Full Schedule']")
	private WebElement ViewFullSchedule ;
	@FindBy(xpath ="//div[@class='flex space-x-8']")
	private WebElement Navigatebar;
	@FindBy(xpath = "//button[text()='Home']")
	private WebElement Home;
	@FindBy(xpath = "//button[text()='Dashboard']")
	private WebElement Dashboard ;
	@FindBy(xpath = "//button[text()='Education']")
	private WebElement Education ;
	@FindBy(xpath = "//h2[text()=\"Today's Meal Plan\"]")
	private WebElement TodaysMealPlan;
	
	
	public Homepage_MealandExerciseValidation(WebDriver driver) {
		this.driver = driver; 	// Reuses the driver created in Hooks
		 //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); 	//initialize all the WebElements that are annotated with @FindBy
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

	public WebElement getNutritionInsightsHeading() {
		 CommonMethods.waitForElementVisibilityOf(NutritionInsightsHeading);
        return NutritionInsightsHeading;
    }

    public WebElement getCarbsvalue() {
		 CommonMethods.waitForElementVisibilityOf(Carbsvalue);
        return Carbsvalue;
    }

    public WebElement getProteinvalue() {
		//wait.until(ExpectedConditions.visibilityOf(Proteinvalue));
		 CommonMethods.waitForElementVisibilityOf(Proteinvalue);
        return Proteinvalue;
    }

    public WebElement getFatvalue() {
		//wait.until(ExpectedConditions.visibilityOf(Fatvalue));
		 CommonMethods.waitForElementVisibilityOf(Fatvalue);
         return Fatvalue;
    }

    public WebElement getSnackIndicator() {
		 CommonMethods.waitForElementVisibilityOf(SnackIndicator);
        return SnackIndicator;
    }

    public WebElement getSnackTime() {
		 CommonMethods.waitForElementVisibilityOf(SnackTime);
        return SnackTime;
    }

    public WebElement getViewFullPlan() {
		 CommonMethods.waitForElementVisibilityOf(ViewFullPlan);
        return ViewFullPlan;
    }

    public WebElement getExerciseSection() {
		 CommonMethods.waitForElementVisibilityOf(ExerciseSection);
        return ExerciseSection;
    }

    public WebElement getExerciseList() {
		 CommonMethods.waitForElementVisibilityOf(ExerciseList);
        return ExerciseList;
    }

    public WebElement getExercisePlan() {
		 CommonMethods.waitForElementVisibilityOf(ExercisePlan);
        return ExercisePlan;
    }

    public WebElement getMorningWalk() {
		 CommonMethods.waitForElementVisibilityOf(MorningWalk);
        return MorningWalk;
    }

    public WebElement getYoga() {
		 CommonMethods.waitForElementVisibilityOf(Yoga);
        return Yoga;
    }

    public WebElement getMorningWalkTime() {
		 CommonMethods.waitForElementVisibilityOf(MorningWalkTime);
      return MorningWalkTime;
    }

    public WebElement getYogaTime() {
		 CommonMethods.waitForElementVisibilityOf(YogaTime);
        return YogaTime;
    }

    public WebElement getLowExercise() {
		 CommonMethods.waitForElementVisibilityOf(LowExercise);
        return LowExercise;
    }

    public WebElement getMediumExercise() {
        return MediumExercise;
    }

    public WebElement getViewFullSchedule() {
		 CommonMethods.waitForElementVisibilityOf(ViewFullSchedule);
        return ViewFullSchedule;
    }
    
    public boolean isNavigationBarVisible() {
		 CommonMethods.waitForElementVisibilityOf(Navigatebar);
        return Navigatebar.isDisplayed();
    }

    public void clickHome() {
        Home.click();
    }

    public void clickDashboard() {
        Dashboard.click();
    }

    public void clickEducation() {
        Education.click();
    }
    
    public boolean isHomeTabVisible() {
		 CommonMethods.waitForElementVisibilityOf(Home);
        return Home.isDisplayed();
    }

    public boolean isDashboardTabVisible() {
		 CommonMethods.waitForElementVisibilityOf(Dashboard);
        return Dashboard.isDisplayed();
    }

    public boolean isEducationTabVisible() {
		 CommonMethods.waitForElementVisibilityOf(Education);
        return Education.isDisplayed();

      }
    
    public String getTodaysMealPlan() {
        return TodaysMealPlan.getText();
    }

        public boolean isTodaysMealPlanDisplayed() {
   		 CommonMethods.waitForElementVisibilityOf(TodaysMealPlan);
        return TodaysMealPlan.isDisplayed();
    }

}



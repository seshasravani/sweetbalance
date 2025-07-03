package pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage_Commonfeature {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//div[text()='SweetBalance']")
	private WebElement Appname;
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
	@FindBy(xpath = "//span[text()='SweetBalance']")
	private WebElement SweetBalance;
	@FindBy(xpath = "//span[text()='munna']")
	private WebElement Username;
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement Logout;
	@FindBy(xpath ="//div[@class='flex space-x-8']")
	private WebElement Navigatebar;
	@FindBy(xpath = "//button[text()='Home']")
	private WebElement Home;
	@FindBy(xpath = "//button[text()='Dashboard']")
	private WebElement Dashboard ;
	@FindBy(xpath = "//button[text()='Education']")
	private WebElement Education ;
	@FindBy(xpath = "//h3[text()='Current Status']")
	private WebElement CurrentStatus;
	@FindBy(xpath = "//div[starts-with(text(),'Last updated:')]")
	private WebElement LastUpdated;
	@FindBy(xpath = "//div[text()='Latest HbA1C']")
	private WebElement LatestHbA1C;
	@FindBy(xpath = "//div[text()='BMI']")
	private WebElement BMI;
	@FindBy(xpath = "//div[text()='Average Blood Sugar']")
	private WebElement AverageBloodSugar;
	@FindBy(xpath = "//span[text()='6.4']")
	private WebElement HbA1Cvalue;
	@FindBy(xpath = "//span[text()='21.9']")
	private WebElement BMIvalue;
	@FindBy(xpath = "//span[text()='184']")
	private WebElement AverageBloodSugarvalue;
	@FindBy(xpath = "//div[text()='Pre-diabetic']")
	private WebElement Prediabatic;
	@FindBy(xpath = "//div[text()='Diabetic']")
	private WebElement Diabetic;
    @FindBy(xpath = "//div[text()='Normal']")
	private WebElement Normal;
    @FindBy(xpath = "//div[text()='Underweight']")
	private WebElement Underweight;
	@FindBy(xpath = "//div[text()='Overweight']")
	private WebElement Overweight;
	@FindBy(xpath = "//div[text()='Obese']")
	private WebElement Obese;
	@FindBy(xpath = "//div[text()='Normal']")
	private WebElement normal;
	@FindBy(xpath = "//div[text()='mg/dL']")
	private WebElement mgdL;
	@FindBy(xpath = "//h2[text()=\"Today's Meal Plan\"]")
	private WebElement TodaysMealPlan;
	@FindBy(xpath = "//button[text()='Breakfast']")
	private WebElement Defaultbreakfast;
	@FindBy(xpath = "//span[text()='Meal Plan']")
	private WebElement MealPlanIcon;
	@FindBy(xpath = "//span[text()='Exercise']")
	private WebElement ExerciseIcon;
	@FindBy(xpath = "//button[text()='View Full Plan']")
	private WebElement ViewFullPlan;
	
	//meal validation
	@FindBy(xpath = "//button[text()='Breakfast']")//meal validation
	private WebElement Breakfast;
	@FindBy(xpath = "//button[text()='Lunch']")
	private WebElement Lunch;
	@FindBy(xpath = "//button[text()='Dinner']")
	private WebElement Dinner;
	@FindBy(xpath = "//button[text()='Snacks']")
	private WebElement Snacks;
	@FindBy(xpath = "//h3[text()='Vegetable Poha (flattened rice) made with brown rice']")
	private WebElement BreakfastDetails;
	@FindBy(xpath = "//h3[text()='Mixed Vegetable Curry with Brown Rice and Dal']")
	private WebElement LunchDetails;
	@FindBy(xpath = "//h3[text()='Tandoori Chicken (Skinless) with Vegetable Stir-fry']")
	private WebElement DinnerDetails;
	@FindBy(xpath = "//h3[text()='Roasted Chickpeas']")
	private WebElement SnacksDetails;
	
	//functional and non-functional validation
	@FindBy(xpath = "//h3[contains(@class,'text-lg font-semibold')]")  //functional and non-functional
    private WebElement dishTitle;
    @FindBy(xpath = "//div[contains(@class,'text-gray-600 text-sm mt-1')]")
    private WebElement dishDescription;
    @FindBy(xpath = "//div[text()='Pre-Breakfast' and contains(@class, 'text-gray-700') and contains(@class, 'font-medium')]")
    private WebElement PreBreakfast;
    @FindBy(xpath = "//div[contains(@class,'bg-gray-50')]//h4[text()='Spiced Buttermilk']")
    private WebElement PremealBreakfastname;
    @FindBy(xpath = "//span[contains(text(),'calories')]")
    private WebElement BreakfastCalories ;
    @FindBy(xpath = "//span[text()='7:00 AM']")
    private WebElement BreakfastTimeAM;
    @FindBy(xpath = "//span[text()='12:00 PM']")
    private WebElement LunchTimePM;
    @FindBy(xpath = "//span[text()='7:00 PM']")
    private WebElement DinnerTimePM;
    @FindBy(xpath = "//span[text()='3:00 PM']")
    private WebElement SnacksTimePM;
    @FindBy(xpath = "//div[@class='h-2 rounded-full bg-gray-200']/div[@class='h-2 rounded-full bg-green-500']")
    private WebElement Carbscolor;
    @FindBy(xpath = "//div[@class='h-2 rounded-full bg-gray-200']/div[@class='h-2 rounded-full bg-purple-500']")
    private WebElement Fatcolor;
    @FindBy(xpath = "//div[@class='h-2 rounded-full bg-gray-200']/div[@class='h-2 rounded-full bg-pink-500']")
    private WebElement Proteincolor;
    @FindBy(xpath = "//div[contains(@class, 'text-xs') and contains(@class, 'text-gray-600') and contains(text(), 'Carbs')]")
    private WebElement Carbsingrams;
    @FindBy(xpath = "//div[contains(@class, 'text-xs') and contains(@class, 'text-gray-600') and contains(text(), 'Protein')]")
    private WebElement Proteiningrams;
    @FindBy(xpath = "//div[contains(@class, 'text-xs') and contains(@class, 'text-gray-600') and contains(text(), 'Fat')]")
    private WebElement Fatingrams;
    
	
	

	
	public Homepage_Commonfeature (WebDriver driver) {
		this.driver = driver; 	// Reuses the driver created in Hooks
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); 	//initialize all the WebElements that are annotated with @FindBy
	}
	
    public String getAppnameText() {
		wait.until(ExpectedConditions.visibilityOf(Appname));
		return Appname.getText();
    }
    
    public void clickLoginBtn() {
		wait.until(ExpectedConditions.visibilityOf(LoginBtn));
         LoginBtn.click();
    }

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(Enteremail));
        Enteremail.clear();
        Enteremail.sendKeys(email);
    }
    
    public void clickContinueWithEmail() {
		wait.until(ExpectedConditions.visibilityOf(Continuewithemail));
        Continuewithemail.click();
    }
    
    public void enterPassword(String pwd) {
		wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pwd);
    }
    
    public void clickSignIn() {
        Signin.click();
    }
    
    public String getSweetBalanceText() {
    	wait.until(ExpectedConditions.visibilityOf(SweetBalance));
        return SweetBalance.getText();
    }
    
    public String getUsernameText() {
    	wait.until(ExpectedConditions.visibilityOf(Username));
        return Username.getText();
    }
    
    public void clickLogout() {
        Logout.click();
        }
    
    public boolean isLogoutDisplayed() {
    	wait.until(ExpectedConditions.visibilityOf(Logout));
        return Logout.isDisplayed();
        }
    
    public boolean isNavigationBarVisible() {
    	wait.until(ExpectedConditions.visibilityOf(Navigatebar));
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
        wait.until(ExpectedConditions.visibilityOf(Home));
        return Home.isDisplayed();
    }

    public boolean isDashboardTabVisible() {
        wait.until(ExpectedConditions.visibilityOf(Dashboard));
        return Dashboard.isDisplayed();
    }

    public boolean isEducationTabVisible() {
        wait.until(ExpectedConditions.visibilityOf(Education));
        return Education.isDisplayed();
    }

    public String getCurrentStatus() {
        wait.until(ExpectedConditions.visibilityOf(CurrentStatus));
       return CurrentStatus.getText();
    }

    public String getLastUpdated() {
        wait.until(ExpectedConditions.visibilityOf(LastUpdated));
         return LastUpdated.getText();
    }

    public String getLatestHbA1C() {
        wait.until(ExpectedConditions.visibilityOf(LatestHbA1C));
       return LatestHbA1C.getText();
    }

    public String getBMI() {
        wait.until(ExpectedConditions.visibilityOf(BMI));
        return BMI.getText();
    }

    public String getAverageBloodSugar() {
        wait.until(ExpectedConditions.visibilityOf(AverageBloodSugar));
        return AverageBloodSugar.getText();
    }

    public String getHbA1CValue() {
        wait.until(ExpectedConditions.visibilityOf(HbA1Cvalue));
        return HbA1Cvalue.getText().trim();
    }

     public String getPrediabeticStatus() {
        wait.until(ExpectedConditions.visibilityOf(Prediabatic));
        return Prediabatic.getText();
    }
    
    public String getDiabeticStatus() {
        wait.until(ExpectedConditions.visibilityOf(Diabetic));
        return Diabetic.getText();
    }

    public String getNormalStatus() {
        wait.until(ExpectedConditions.visibilityOf(Normal));
        return Normal.getText();
    }
    
    public String getBMIValue() {
        wait.until(ExpectedConditions.visibilityOf(BMIvalue));
        return BMIvalue.getText();
       }

    public String getUnderweight() {
        wait.until(ExpectedConditions.visibilityOf(Underweight));
		return Underweight.getText();
	}
    
    public String getNormal() {
        wait.until(ExpectedConditions.visibilityOf(Normal));
		return Normal.getText();
	}
    
    public String getOverweight() {
        wait.until(ExpectedConditions.visibilityOf(Overweight));
		return Overweight.getText();
	}
    
    public String getObese() {
        wait.until(ExpectedConditions.visibilityOf(Obese));
		return Obese.getText();
	}

    public String getAverageBloodSugarValue() {
        return AverageBloodSugarvalue.getText();
    }


    public String getUnitText() {
       wait.until(ExpectedConditions.visibilityOf(mgdL));
       return mgdL.getText();
     }

    public String getTodaysMealPlan() {
        return TodaysMealPlan.getText();
    }

        public boolean isTodaysMealPlanDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(TodaysMealPlan));
        return TodaysMealPlan.isDisplayed();
    }

     public boolean isBreakfastTabVisible() {
        wait.until(ExpectedConditions.visibilityOf(Breakfast));
        return Breakfast.isDisplayed();
    }

    public boolean isLunchTabVisible() {
        wait.until(ExpectedConditions.visibilityOf(Lunch));
        return Lunch.isDisplayed();
    }

    public boolean isDinnerTabVisible() {
        wait.until(ExpectedConditions.visibilityOf(Dinner));
        return Dinner.isDisplayed();
    }

    public boolean isSnacksTabVisible() {
        wait.until(ExpectedConditions.visibilityOf(Snacks));
        return Snacks.isDisplayed();
    }
    
    public String getDefaultbreakfastText() {
        wait.until(ExpectedConditions.visibilityOf(Defaultbreakfast));
        return Defaultbreakfast.getText();
	}

    public void clickMealPlan() {
        MealPlanIcon.click();
    }

    public void clickExercise() {
        ExerciseIcon.click();
    }

	public boolean isMealPlanDisplayed() {
       wait.until(ExpectedConditions.visibilityOf(MealPlanIcon));
       return MealPlanIcon.isDisplayed();
	}
   
	public boolean isExerciseDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(ExerciseIcon));
       return ExerciseIcon.isDisplayed();
	}
    
	 public void clickViewFullPlan() {
	        ViewFullPlan.click();
	    }
	 
	public String getViewFullPlanText() {
        wait.until(ExpectedConditions.visibilityOf(ViewFullPlan));
        return ViewFullPlan.getText();
	}
	
	//mealplan validation
	public void clickBreakfast() {
		wait.until(ExpectedConditions.elementToBeClickable(Breakfast));
	    Breakfast.click();
	    }

	 public void clickLunch() {
	    wait.until(ExpectedConditions.elementToBeClickable(Lunch));
		Lunch.click();
	    }

	 public void clickDinner() {
	    wait.until(ExpectedConditions.elementToBeClickable(Dinner));
         Dinner.click();
	    }

	 public void clickSnacks() {
	    wait.until(ExpectedConditions.elementToBeClickable(Snacks));
        Snacks.click();
	    }
	    
	 public boolean isBreakfastDetailsVisible() {
	   return wait.until(ExpectedConditions.visibilityOf(BreakfastDetails)).isDisplayed();
	      }

	 public boolean isLunchDetailsVisible() {
	      return wait.until(ExpectedConditions.visibilityOf(LunchDetails)).isDisplayed();
	    }

	  public boolean isDinnerDetailsVisible() {
	      return wait.until(ExpectedConditions.visibilityOf(DinnerDetails)).isDisplayed();
	    }

	  public boolean isSnacksDetailsVisible() {
	     return wait.until(ExpectedConditions.visibilityOf(SnacksDetails)).isDisplayed();
	    }
    //functional and non-functional
	  public boolean isDishTitleVisible() {
	        return wait.until(ExpectedConditions.visibilityOf(dishTitle)).isDisplayed();
	    }

	    public boolean isDishDescriptionVisible() {
	        return wait.until(ExpectedConditions.visibilityOf(dishDescription)).isDisplayed();
	    }
    
	    public String getPreBreakfastText() {
	        wait.until(ExpectedConditions.visibilityOf(PreBreakfast));
	        return PreBreakfast.getText();
	    }

	    public String getPreMealBreakfastName() {
	        wait.until(ExpectedConditions.visibilityOf(PremealBreakfastname));
	        return PremealBreakfastname.getText();
	    }

	    public String getBreakfastCalories() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(BreakfastCalories));
	        return BreakfastCalories.getText();
	    }

	    public String getBreakfastTimeAM() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(BreakfastTimeAM));
	        return BreakfastTimeAM.getText();
	    }

	    public String getLunchTimePM() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(LunchTimePM));
	        return LunchTimePM.getText();
	    }

	    public String getDinnerTimePM() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(DinnerTimePM));
	        return DinnerTimePM.getText();
	    }

	    public String getSnacksTimePM() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(SnacksTimePM));
	        return SnacksTimePM.getText();
	    }

	    public boolean isCarbsColorDisplayed() {
	        wait.until(ExpectedConditions.visibilityOf(Carbscolor));
	        return Carbscolor.isDisplayed();
	    }

	    public boolean isFatColorDisplayed() {
	        wait.until(ExpectedConditions.visibilityOf(Fatcolor));
	        return Fatcolor.isDisplayed();
	    }

	    public boolean isProteinColorDisplayed() {
	        wait.until(ExpectedConditions.visibilityOf(Proteincolor));
	        return Proteincolor.isDisplayed();
	    }

	    public String getCarbsInGrams() {
	        wait.until(ExpectedConditions.visibilityOf(Carbsingrams));
	        return Carbsingrams.getText();
	    }

	    public String getProteinInGrams() {
	        wait.until(ExpectedConditions.visibilityOf(Proteiningrams));
	        return Proteiningrams.getText();
	    }

	    public String getFatInGrams() {
	        wait.until(ExpectedConditions.visibilityOf(Fatingrams));
	        return Fatingrams.getText();
	    }

	
	
}
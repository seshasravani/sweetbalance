package pagefactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class Dashboard_Commonfeature {
	
	
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
	@FindBy(xpath = "//button[text()='Dashboard']")
	private WebElement Dashboard ;
	@FindBy(xpath = "//h3[contains(text(), 'Welcome Back,')]")
	private WebElement WelcomeBack;
	@FindBy(xpath = "//p[text()='Track your metrics, manage your diet, and stay healthy with our comprehensive tools.']")
	private WebElement belowWelcomemessage;
	@FindBy(xpath = "//button[text()='Upgrade to Premium']")
	private WebElement UpgradePremiumBtn;
	@FindBy(xpath = "//span[text()='Account Information']")
	private WebElement AccountInformation;
	@FindBy(xpath = "//button[text()='Save Changes']")
	private WebElement SaveChangesBtn;
	
	//Account information
	@FindBy(xpath = "//input[@id='age']")
	private WebElement age;
	@FindBy(xpath = "//input[@id='height']")
	private WebElement height;
	@FindBy(xpath = "//input[@id='weight']")
	private WebElement weight;
	@FindBy(xpath = "//button[@id='exerciseLevel']")
	private WebElement ExerciseLevel;
	@FindBy(xpath = "//button[@id='cuisinePreference']")
	private WebElement CuisinePreference;
	@FindBy(xpath = "//button[@id='allergies']")
	private WebElement allergies;
	@FindBy(xpath = "//div[text()='Error']")
	private WebElement ErrorMessage;
	@FindBy(xpath = "//div[text()='Changes Saved']")
	private WebElement SuccessMessage;
	
	//Stress management validation
	@FindBy(xpath = "//span[text()='Stress Management Techniques']")
	private WebElement StressManagement;
	@FindBy(xpath = "//div[@role='tablist']")
	private WebElement Navigatebar;
	@FindBy(xpath = "//button[@role='tab' and text()='Meditation']")
	public WebElement Meditation;
	@FindBy(xpath = "//button[@id='radix-:r3:-trigger-breathing']")
	public WebElement Breating;
	@FindBy(xpath = "//button[@id='radix-:r3:-trigger-movement']")
	public WebElement Movement;
	@FindBy(xpath = "//button[@id='radix-:r3:-trigger-mindfulness']")
	public WebElement Mindfulness;
	@FindBy(xpath = "//h3[text()='Guided Meditation']")
	private WebElement GuidedMeditation;
	@FindBy(xpath = "//button[text()='5 min']")
	private WebElement min;
	@FindBy(xpath = "//div[contains(@class, 'flex') and contains(@class, 'space-x-2')]//button")
	private WebElement allminbuttons;
	@FindBy(xpath = "//div[contains(@class, 'flex') and contains(@class, 'justify-between') and contains(@class, 'w-full') and contains(@class, 'text-sm')]")
	private WebElement Audiobar;
	@FindBy(xpath = "//button[normalize-space(text())='Reset']")
	private WebElement Reset;
	@FindBy(xpath = "//h3[text()='Gentle Movement']")
	private WebElement GentleMovement;
	@FindBy(xpath = "//h3[text()='Present Moment Awareness']")
	private WebElement PresentmomentAwareness;
    @FindBy(xpath = "//h3[text()='4-7-8 Breathing Technique']")
	private WebElement BreatingTechnique;
	@FindBy(xpath = "//p[text()='Simple stretches to release tension:']")
	private WebElement stretchesreleasetension;
	@FindBy(xpath = "//ul[contains(@class, 'space-y-2') and contains(@class, 'text-sm')]")
	private WebElement Allexercise;
	@FindBy(xpath = "//ul[contains(@class, 'space-y-2')]//li[contains(text(), 'Neck rolls')]")
	private WebElement Neckrolls;
	@FindBy(xpath = "//ul[contains(@class, 'space-y-2')]//li[contains(text(), 'Shoulder circles')]")
	private WebElement ShoulderCircle;
	@FindBy(xpath = "//ul[contains(@class, 'space-y-2')]//li[contains(text(), 'Wrist and ankle rotations')]")
	private WebElement Wristankle;
	@FindBy(xpath = "//ul[contains(@class, 'space-y-2')]//li[contains(text(), 'Gentle torso twists')]")
	private WebElement Gentletwists;
	@FindBy(xpath = "//h4[text()='Benefits for Diabetes Management']")
	private WebElement BenefitsforDiabetes;
	@FindBy(xpath = "//p[text()='Reduces Stress Hormones']")
	private WebElement ReducessStressHormones;
	@FindBy(xpath = "//p[text()='Lowers cortisol that can increase blood glucose']")
	private WebElement LowersCortisol;
	@FindBy(xpath = "//p[text()='Improves Sleep']")
	private WebElement ImproveSleep;
	@FindBy(xpath = "//p[text()='Better sleep leads to better glucose control']")
	private WebElement BetterSleep;
	@FindBy(xpath = "//p[text()='Reduces Diabetes Distress']")
	private WebElement ReduceDiabetes;
	@FindBy(xpath = "//p[text()='Helps manage overwhelm from diabetes care']")
	private WebElement HelpsManage;
	@FindBy(xpath = "//h3[text()='4-7-8 Breathing Technique']")
	private WebElement BreathingTechnique;
	@FindBy(xpath = "//p[text()='A natural tranquilizer for the nervous system']")
	private WebElement nervoussystem;
	@FindBy(xpath = "//button[text()='Start Breathing Exercise']")
	private WebElement StartBreathingExercise;
	@FindBy(xpath = "//p[text()='Cycles completed']")
	private WebElement Cyclecompleted;
	@FindBy(xpath = "//p[text()='Current phase']")
	private WebElement CurrentPhase;
	@FindBy(xpath = "//div[contains(@class, 'p-3') and contains(@class, 'rounded-lg') and contains(@class, 'bg-blue-600/10')]")
	private WebElement inhale4sce;
	@FindBy(xpath = "//p[text()='Inhale']")
	private WebElement Inhale;
	@FindBy(xpath = "//p[text()='Hold']")
	private WebElement Hold;
	@FindBy(xpath = "//p[text()='Exhale']")
	private WebElement Exhale;
	@FindBy(xpath = "//button[text()='Start Breathing Exercise']")
	private WebElement StartBreatingExercise;
	@FindBy(xpath = "//button[contains(text(), 'Stop')]")
	private WebElement stop;
	
	
	public Dashboard_Commonfeature (WebDriver driver) {
		this.driver = driver; 	// Reuses the driver created in Hooks
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); 	//initialize all the WebElements that are annotated with @FindBy
	}

	
	// ================= Dashboard Section =================
	
	public void clickLoginBtn() {
    	LoginBtn.click();
    }

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(Enteremail));
        Enteremail.clear();
        Enteremail.sendKeys(email);
    }
    
    public void clickContinueWithEmail() {
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
    
    public void clickDashboard() {
		 CommonMethods.waitForElementVisibilityOf(Dashboard);
		Dashboard.click();
		
	}
	public boolean isDashboardVisible() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 CommonMethods.waitForElementVisibilityOf(Dashboard);
		 return Dashboard.isDisplayed();
	}

	public String getWelcomeMessageText() {
		 CommonMethods.waitForElementVisibilityOf(WelcomeBack);
		return WelcomeBack.getText();
	}

	public String getBelowWelcomeMessageText() {
        //wait.until(ExpectedConditions.visibilityOf(belowWelcomemessage));
		 CommonMethods.waitForElementVisibilityOf(belowWelcomemessage);
		return belowWelcomemessage.getText();
	}
	
	public boolean isBelowWelcomeTextDisplayed() {
        return belowWelcomemessage.isDisplayed();
    }

	public boolean isUpgradeToPremiumVisible() {
		 CommonMethods.waitForElementVisibilityOf(UpgradePremiumBtn);
	     //wait.until(ExpectedConditions.visibilityOf(UpgradePremiumBtn));
		return UpgradePremiumBtn.isDisplayed();
	}
	
	public boolean isAccountInformationHeaderVisible() {
		 CommonMethods.waitForElementVisibilityOf(AccountInformation);
	    return AccountInformation.isDisplayed();
	}
	public boolean isSaveChangesButtonVisible() {
		 CommonMethods.waitForElementVisibilityOf(SaveChangesBtn);
        //wait.until(ExpectedConditions.visibilityOf(SaveChangesBtn));
	    return SaveChangesBtn.isDisplayed();
	}
    
	public boolean isAccountInfoHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(AccountInformation)).isDisplayed();
    }

    public String getAccountInfoHeaderText() {
        return AccountInformation.getText();
    }
	

	// ================= Account Information Section =================
	public void enterAge(String ageValue) {
		wait.until(ExpectedConditions.visibilityOf(age)).clear();
		age.sendKeys(ageValue);
	}
      
	public String getAgeValue() {
        return age.getAttribute("value").trim();
    }
	public void enterHeight(String heightValue) {
		wait.until(ExpectedConditions.visibilityOf(height)).clear();
		height.sendKeys(heightValue);
	}
	public String getHeightValue() {
        return height.getAttribute("value").trim();
    }

	public void enterWeight(String weightValue) {
		wait.until(ExpectedConditions.visibilityOf(weight)).clear();
		weight.sendKeys(weightValue);
	}
	public String getWeightValue() {
        return weight.getAttribute("value").trim();
    }
	/*public void selectDropdownOption(WebElement dropdown, String visibleText) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    public List<WebElement> getDropdownOptions(WebElement dropdown) {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        return new Select(dropdown).getOptions();
        
    }*/


	public void clickExerciseLevelDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(ExerciseLevel)).click();
	}

	public void clickCuisinePreferenceDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(CuisinePreference)).click();
	}

	public void clickAllergiesDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(allergies)).click();
	}

	public void clickSaveChanges() {
		wait.until(ExpectedConditions.elementToBeClickable(SaveChangesBtn)).click();
	}

	public boolean isSuccessMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(SuccessMessage)).isDisplayed();
	}

	public boolean isErrorMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(ErrorMessage)).isDisplayed();
		
	}
	
	public String getErrorMessage() {
		return ErrorMessage.getText();
	}
	public WebElement getExerciseDropdown() {
        return ExerciseLevel;
    }

    public WebElement getCuisineDropdown() {
        return CuisinePreference;
    }

    public WebElement getAllergiesDropdown() {
        return allergies;
    }
    public String getSuccessMessage() {
		return SuccessMessage.getText();
	}

	// ================= Stress Management Section =================
	public void clickStressManagementTab() {
		wait.until(ExpectedConditions.elementToBeClickable(StressManagement)).click();
	}
	
	public String getStressManagementText() {
		wait.until(ExpectedConditions.elementToBeClickable(StressManagement));
		return StressManagement.getText();
	}

	public boolean isNavigationBarVisible() {
		return wait.until(ExpectedConditions.visibilityOf(Navigatebar)).isDisplayed();
	}

	public void clickMeditationTab() {
		wait.until(ExpectedConditions.elementToBeClickable(Meditation)).click();
	}
	
	public boolean isMeditationTabVisible() {
		wait.until(ExpectedConditions.visibilityOf(Meditation));
        return Meditation.isDisplayed();
	}


	public void clickBreathingTab() {
		wait.until(ExpectedConditions.elementToBeClickable(Breating)).click();
	}
	
	public boolean isBreatingTabVisible() {
		wait.until(ExpectedConditions.visibilityOf(Breating));
        return Breating.isDisplayed();
	}
    
	public boolean isMovementTabVisible() {
		wait.until(ExpectedConditions.visibilityOf(Movement));
        return Movement.isDisplayed();
	}


	public void clickMovementTab() {
		wait.until(ExpectedConditions.elementToBeClickable(Movement)).click();
	}
	
	public boolean isMindfulnessTabVisible() {
		wait.until(ExpectedConditions.visibilityOf(Mindfulness));
        return Mindfulness.isDisplayed();
	}


	public void clickMindfulnessTab() {
		wait.until(ExpectedConditions.elementToBeClickable(Mindfulness)).click();
	}

	public boolean isGuidedMeditationVisible() {
		return wait.until(ExpectedConditions.visibilityOf(GuidedMeditation)).isDisplayed();
	}
	public boolean isPresentMomentAwarenessVisible() {
		return wait.until(ExpectedConditions.visibilityOf(PresentmomentAwareness)).isDisplayed();
	}

	public void clickFiveMinButton() {
		wait.until(ExpectedConditions.elementToBeClickable(min)).click();
	}

	public boolean isAudioBarVisible() {
		return wait.until(ExpectedConditions.visibilityOf(Audiobar)).isDisplayed();
	}
	public boolean isBreatingTechniqueVisible() {
		return wait.until(ExpectedConditions.visibilityOf(BreatingTechnique)).isDisplayed();
		}
	public String getBreathingTechniqueText() {
		return BreathingTechnique.getText();
		}

	
	public void clickAudioBarTab() {
		wait.until(ExpectedConditions.elementToBeClickable(Audiobar)).click();
	}

	public void clickResetButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Reset)).click();
	}

	public boolean isGentleMovementVisible() {
		return wait.until(ExpectedConditions.visibilityOf(GentleMovement)).isDisplayed();
	}

	public boolean isStretchReleaseTextVisible() {
		return wait.until(ExpectedConditions.visibilityOf(stretchesreleasetension)).isDisplayed();
	}

	public boolean isAllExerciseVisible() {
		return wait.until(ExpectedConditions.visibilityOf(Allexercise)).isDisplayed();
	}
	
	public WebElement getStartBreathingExerciseButton() {
	    return StartBreathingExercise;
	}
	public boolean isStartBreatingExecriseVisible() {
		return wait.until(ExpectedConditions.visibilityOf(StartBreatingExercise)).isDisplayed();
	}

     public void clickStartBreathingExerciseButton() {
    	 StartBreathingExercise.click();
     }
     public boolean isCycleCompletedLabelVisible() {
    	    return wait.until(ExpectedConditions.visibilityOf(Cyclecompleted)).isDisplayed();
    	}

    	public String getCycleCompletedValue() {
    	    return Cyclecompleted.getText();
    	}

    	
	public boolean isAccountInformationDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(AccountInformation)).isDisplayed();
	}

	public void clickDropdownOption(String dropdownName) {
	    switch (dropdownName.trim().toLowerCase()) {
	        case "exercise routine level":
	            CommonMethods.waitForElementVisibilityOf(ExerciseLevel);
	            ExerciseLevel.click();
	            break;
	        case "cuisine preferences":
	            CommonMethods.waitForElementVisibilityOf(CuisinePreference);
	            CuisinePreference.click();
	            break;
	        case "food allergies":
	            CommonMethods.waitForElementVisibilityOf(allergies);
	            allergies.click();
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid dropdown name: " + dropdownName);
	    }
	}

	
	public List<String> getDropdownOptions(String dropdownName) {
	    Select option;
	    switch (dropdownName.trim().toLowerCase()) {
	        case "exercise routine level":
	            option = new Select(ExerciseLevel);
	            break;
	        case "cuisine preferences":
	            option = new Select(CuisinePreference);
	            break;
	        case "food allergies":
               option = new Select(allergies);
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid dropdown name: " + dropdownName);
	    }

	    return option.getOptions().stream()
	                 .map(WebElement::getText)
	                 .map(String::trim)
	                 .collect(Collectors.toList());


	
}
	public boolean isStopcycleDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(stop)).isDisplayed();
	}


	public void clickStopBreathingExercise() {
		stop.click();
		
	}

}
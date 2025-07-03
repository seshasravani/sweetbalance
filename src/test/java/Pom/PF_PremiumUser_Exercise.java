package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

import java.time.Duration;



public class PF_PremiumUser_Exercise {
	private WebDriver driver;
    private WebDriverWait wait;
  
    ConfigReader config = new ConfigReader();
    public PF_PremiumUser_Exercise(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(xpath = "//button[text()='View Full Schedule']")
    private WebElement fullScehduleBtn;
    
    @FindBy(xpath = "//button[text()='Warm Up']")
    private WebElement warmUpBtn;
    
    @FindBy(xpath = "//button[text()='Main Workout']")
    private WebElement mainWorkoutBtn;
    
    @FindBy(xpath = "//button[text()='Cool Down']")
    private WebElement coolDownBtn;
    
    @FindBy(xpath = "//span[text()='Mark as Completed']")
    private WebElement markAsCompletedBtn;
    
    @FindBy(xpath = "//span[text()='Duration: ']")
    private WebElement durationText;
    
    @FindBy(xpath = "//span[text()='Calories: ']")
    private WebElement caloriesText;
    
    @FindBy(xpath = "//span[text()='Intensity: ']")
    private WebElement intensityText;
    
    @FindBy(xpath = "//div[contains(@class,'font-semibold') and contains(text(),'Success!')]")
    private WebElement successText;
    
    @FindBy(xpath = "//div[contains(@class,'opacity-90') and contains(text(),'Warm Up completed')]")
    private WebElement completionText;
    
    @FindBy(xpath = "//span[text()='Completed']")
    private WebElement CompletedBtn;
    
    @FindBy(xpath = "//button[text()='Undo']")
    private WebElement UndoBtn;
    
    @FindBy(xpath = "//h1[contains(text(),\\\"Today's Exercise Schedule\\\")]")
    private WebElement pageHeader;
    
    @FindBy(xpath = "//h2[text()='Warm Up']")
    private WebElement warmUpSection;
    
    @FindBy(xpath = "//h2[text()='Main Workout']")
    private WebElement mainWorkoutSection;
    
    @FindBy(xpath = "//h2[text()='Cool Down']")
    private WebElement coolDownSection;
    
    @FindBy(xpath = "//button[text()='Back to Home']")
    private WebElement backToHomeBtn;
    
    public boolean isViewFullScheduleBtnVisible() {
        LoggerLoad.info("Checking visibility of View Full Schedule button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fullScehduleBtn));
        boolean visible = fullScehduleBtn.isDisplayed();
        LoggerLoad.info("View Full Schedule button displayed: " + visible);
        return visible;
    }
    
    public boolean isWarmUpBtnVisible() {
        LoggerLoad.info("Checking visibility of Warm Up button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(warmUpBtn));
        boolean visible = warmUpBtn.isDisplayed();
        LoggerLoad.info("Warm Up button displayed: " + visible);
        return visible;
    }
    
    public boolean isMainWorkoutBtnVisible() {
        LoggerLoad.info("Checking visibility of Main Workout button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mainWorkoutBtn));
        boolean visible = mainWorkoutBtn.isDisplayed();
        LoggerLoad.info("Main Workout button displayed: " + visible);
        return visible;
    }
    
    public boolean isCoolDownBtnVisible() {
        LoggerLoad.info("Checking visibility of Cool Down button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(coolDownBtn));
        boolean visible = coolDownBtn.isDisplayed();
        LoggerLoad.info("Cool Down button displayed: " + visible);
        return visible;
    }
    
    public boolean isMarkAsCompletedBtnVisible() {
        LoggerLoad.info("Checking visibility of Mark as Completed button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(markAsCompletedBtn));
        boolean visible = markAsCompletedBtn.isDisplayed();
        LoggerLoad.info("Mark as Completed button displayed: " + visible);
        return visible;
    }
    
    public boolean isCompletedBtnVisible() {
        LoggerLoad.info("Checking visibility of Completed button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(CompletedBtn));
        boolean visible = CompletedBtn.isDisplayed();
        LoggerLoad.info("Completed button displayed: " + visible);
        return visible;
    }
    
    public boolean isUndoBtnVisible() {
        LoggerLoad.info("Checking visibility of Undo option...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(UndoBtn));
        boolean visible = UndoBtn.isDisplayed();
        LoggerLoad.info("Undo option displayed: " + visible);
        return visible;
    }
    
    public boolean isDurationTextVisible() {
    	LoggerLoad.info("Checking visibility of Duration text...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(durationText));
        boolean visible = durationText.isDisplayed();
        LoggerLoad.info("Duration text is displayed: " + visible);
        return visible;
    }
    
    public boolean isCaloriesTextVisible() {
    	LoggerLoad.info("Checking visibility of Calories text...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(caloriesText));
        boolean visible = caloriesText.isDisplayed();
        LoggerLoad.info("Calories text is displayed: " + visible);
        return visible;
    }
    
    public boolean isIntensityTextVisible() {
    	LoggerLoad.info("Checking visibility of Intensity text...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(intensityText));
        boolean visible = intensityText.isDisplayed();
        LoggerLoad.info("Intensity text is displayed: " + visible);
        return visible;
    }

    public boolean validateSuccessDialog() {
    	LoggerLoad.info("Checking Success dialog...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successText));
        wait.until(ExpectedConditions.visibilityOf(completionText));
        boolean success = successText.isDisplayed();
        boolean completion = completionText.isDisplayed();
        if(success && completion) {
        	LoggerLoad.info("Success dialog box is displayed");
        	return true;
        }
        else {
        	return false;
        }
     }
    
    public boolean isPageLoaded() {
    	LoggerLoad.info("Checking Exercise page is loaded...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean loaded = wait.until(ExpectedConditions.visibilityOf(pageHeader)).isDisplayed();
        LoggerLoad.info("Exercise schedule page is loaded");
        return loaded;
    }
    
    public boolean isBackToHomeBtnVisible() {
    	LoggerLoad.info("Checking Back to Home button is visible...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean visible = wait.until(ExpectedConditions.visibilityOf(backToHomeBtn)).isDisplayed();
        LoggerLoad.info("Back to Home button is visible");
        return visible;
    }
    
    public boolean isWarmUpSectionVisible() {
    	LoggerLoad.info("Checking Warm Up section is visible...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean visible = wait.until(ExpectedConditions.visibilityOf(warmUpSection)).isDisplayed();
        LoggerLoad.info("Warm Up section is visible");
        return visible;
    }
    
    public boolean isMainWorkoutSectionVisible() {
    	LoggerLoad.info("Checking Main Workout section is visible...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean visible = wait.until(ExpectedConditions.visibilityOf(mainWorkoutSection)).isDisplayed();
        LoggerLoad.info("Main Workout section is visible");
        return visible;
    }
    
    public boolean isCoolDownSectionVisible() {
    	LoggerLoad.info("Checking Cool Down Section is visible...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean visible = wait.until(ExpectedConditions.visibilityOf(coolDownSection)).isDisplayed();
        LoggerLoad.info("Cool Down Section is visible");
        return visible;
    }
    
    // Helper wait and click method
    private void waitAndClick(WebElement element, String name) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        LoggerLoad.info("Clicked: " + name);
    }
    
    public void clickViewFullScheduleBtn() {
    	waitAndClick(fullScehduleBtn, "View Full Schedule");
    }
    
    public void clickMarkAsCompletedBtn() {
    	waitAndClick(markAsCompletedBtn, "Mark as Completed");
    }
    
    public void clickUndoOption() {
    	waitAndClick(UndoBtn, "Undo");
    }
    


}

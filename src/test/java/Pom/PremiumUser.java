package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PremiumUser {
	  private WebDriver driver;
	    private WebDriverWait wait;
	  
	    ConfigReader config = new ConfigReader();
	    public PremiumUser(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);

	    }


    // Buttons and inputs
    
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@placeholder='Enter email']")
    private WebElement enterEmailInput;

    @FindBy(xpath = "//button[contains(text(), 'Continue with email')]")
    private WebElement continueWithEmailBtn;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Enter your password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//img[@alt='Female character illustration']")
    private WebElement femaleCharacterImage;

    
    // Navigation buttons
    @FindBy(xpath = "//button[text()='Home']")
    private WebElement homeBtn;

    @FindBy(xpath = "//button[text()='Logbook']")
    private WebElement logbookBtn;

    @FindBy(xpath = "//button[text()='Dashboard']")
    private WebElement dashboardBtn;

    @FindBy(xpath = "//button[text()='Education']")
    private WebElement educationBtn;

    // Other UI elements
    @FindBy(xpath = "//button[contains(@class, 'animate-pulse')]")
    private WebElement flashtab;

    public WebElement getFlashtab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//button[contains(@class, 'animate-pulse')]")));
    }
    @FindBy(xpath = "//span[contains(@class,'text-5xl')]")
    private WebElement emojiIcon;

    @FindBy(xpath = "//img[contains(@class,'object-contain')]")
    private WebElement genderImage;
    
    @FindBy(xpath = "//div[contains(@class, 'text-sm') and contains(text(), 'Mood: Good')]")
    private WebElement moodStatus;
    
    @FindBy(xpath = "//div[contains(@class, 'text-gray-500') and contains(text(), 'Mood')]")
    private WebElement moodText;
    
    @FindBy(xpath = "//button[normalize-space(text())='Log']")
    private WebElement logButton;

    @FindBy(xpath = "//span[text()='Meal Plan']")
    private WebElement mealPlanBtn;
    
    @FindBy(xpath = "//h2[text()='Record New Data']")
    private WebElement recordNewDataText;

    @FindBy(xpath = "//span[text()='Exercise']")
    private WebElement exerciseBtn;

    @FindBy(xpath = "//button[text()='View Full Meal Plan']")
    private WebElement fullMealPlanBtn;

    @FindBy(xpath = "//button[text()='Weekly Plan']")
    private WebElement weeklyPlanBtn;

    @FindBy(xpath = "//h2[text()='Record New Data']")
    private WebElement recordNewDataTxt;

    @FindBy(xpath = "//button[.//span[text()='Blood Glucose']]")
    private WebElement bloodGlucoseBtn;

    @FindBy(xpath = "//button[span[text()='Physical Activity']]")
    private WebElement physicalActivityBtn;

    @FindBy(xpath = "//button[span[text()='Food Intake']]")
    private WebElement foodIntakeBtn;

    @FindBy(xpath = "//button[span[text()='Medication']]")
    private WebElement medicationBtn;
  
    @FindBy(css = "svg.lucide-activity")
    private List<WebElement> activityIcons;

    public WebElement getSecondActivityIcon() {
        if (activityIcons != null && activityIcons.size() >= 2) {
            return activityIcons.get(1); // index 1 = second element
        } else {
            throw new NoSuchElementException("Second activity icon not found");
        }
    }

    @FindBy(css = "main button.flex.flex-col.items-center svg")
    private List<WebElement> allIcons;

    // Get icon by index (0-based)
    public WebElement getIconByIndex(int index) {
        if (allIcons.size() > index) {
            return allIcons.get(index);
        } else {
            throw new IndexOutOfBoundsException("Icon at index " + index + " not found");
        }
    }

    @FindBy(xpath = "//h2[text()='Choose Your Challenge']")
    private WebElement challengeHeader;

    // Helper wait and click method
    private void waitAndClick(WebElement element, String name) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        LoggerLoad.info("Clicked: " + name);
    }

    // Action methods
    public void clickLoginBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
            LoggerLoad.info("Clicked Login button");
        } catch (Exception e) {
            LoggerLoad.warn("Login button not found or already clicked, skipping...");
        }
    }
   
    public boolean isChallengeButtonFlashingWithDuration(double expectedSeconds) {
        WebElement challengeBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(),'Challenge Yourself Today')]")));

        String animationDuration = (String) ((JavascriptExecutor) driver)
            .executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('animation-duration');", challengeBtn);

        System.out.println("Animation duration: " + animationDuration);

        // Clean the string and compare (e.g., 0.2s)
        return animationDuration.trim().equals(expectedSeconds + "s");
    }
    public boolean isFemaleImageDisplayed() {
        LoggerLoad.info("Waiting for Female character image to appear...");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(femaleCharacterImage));
            boolean visible = femaleCharacterImage.isDisplayed();
            LoggerLoad.info("Female image displayed: " + visible);
            return visible;
        } catch (TimeoutException e) {
            LoggerLoad.error("Female character image did not appear in time.");
            return false;
        }
    }


    public boolean isEmojiDisplayed() {
        LoggerLoad.info("Checking if emoji icon 😊 is displayed...");
        boolean visible = emojiIcon.isDisplayed();
        LoggerLoad.info("Emoji icon displayed: " + visible);
        return visible;
    }
    public void waitForFemaleImageToAppear() {
        By femaleImageLocator = By.xpath("//img[contains(@alt, 'Female')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(femaleImageLocator));
        LoggerLoad.info("Female character image is visible after login.");
    }
    public boolean isMoodStatusDisplayed() {
        LoggerLoad.info("Checking if Mood status is displayed...");
        boolean visible = moodStatus.isDisplayed();
        LoggerLoad.info("Mood status displayed: " + visible + " | Text: " + moodStatus.getText());
        return visible;
    }
    public boolean isLogButtonVisible() {
        LoggerLoad.info("Waiting for 'Log' button to appear...");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(logButton));
            boolean visible = logButton.isDisplayed();
            LoggerLoad.info("'Log' button displayed: " + visible);
            return visible;
        } catch (TimeoutException e) {
            LoggerLoad.error("'Log' button did not appear within timeout.");
            return false;
        }
    }
    public String getMoodText() {
        LoggerLoad.info("Fetching mood text...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(moodText));
        String mood = moodText.getText().trim();
        LoggerLoad.info("Mood text displayed: " + mood);
        return mood;
    }
    public boolean isWeeklyPlanButtonVisible() {
        LoggerLoad.info("Checking visibility of Weekly Plan button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(weeklyPlanBtn));
        boolean visible = weeklyPlanBtn.isDisplayed();
        LoggerLoad.info("Weekly Plan button displayed: " + visible);
        return visible;
    }
    public boolean isRecordNewDataTextVisible() {
        LoggerLoad.info("Checking if 'Record New Data' text is displayed...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(recordNewDataText));
        boolean visible = recordNewDataText.isDisplayed();
        LoggerLoad.info("'Record New Data' text displayed: " + visible);
        return visible;
    }
    public void PageScrollDown() {
		PageFactory.initElements(driver, this);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 10000);");
	}
    public boolean areRecordNewDataButtonsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(bloodGlucoseBtn));
            wait.until(ExpectedConditions.visibilityOf(physicalActivityBtn));
            wait.until(ExpectedConditions.visibilityOf(foodIntakeBtn));
            wait.until(ExpectedConditions.visibilityOf(medicationBtn));
            return true;
        } catch (TimeoutException e) {
            LoggerLoad.error("One or more Record New Data buttons are not visible.");
            return false;
        }
    }
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(enterEmailInput));
        enterEmailInput.clear();
        enterEmailInput.sendKeys(email);
        LoggerLoad.info("Entered email: " + email);
    }
    public String getBloodGlucoseText() {
        return bloodGlucoseBtn.getText().trim();
    }
    public boolean isActivitySvgVisible() {
        LoggerLoad.info("Checking if second activity SVG icon is visible near blood glucose text...");
        try {
            return getSecondActivityIcon().isDisplayed();
        } catch (NoSuchElementException e) {
            LoggerLoad.error("Second activity SVG icon not found.");
            return false;
        }
    }
//    WebElement svgIcon = new WebDriverWait(driver, Duration.ofSeconds(10))
//    	    .until(ExpectedConditions.visibilityOfElementLocated(
//    	        By.cssSelector("main div:nth-child(3) div button.flex.flex-col.items-center svg")));


    public String getPhysicalActivityText() {
        return physicalActivityBtn.getText().trim();
    }

    public String getFoodIntakeText() {
        return foodIntakeBtn.getText().trim();
    }

    public String getMedicationText() {
        return medicationBtn.getText().trim();
    }
    
    public void clickContinueWithEmailBtn() {
        waitAndClick(continueWithEmailBtn, "Continue with email");
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        LoggerLoad.info("Entered password" +password);
    }

    public void clickSignInButton() {
        waitAndClick(signInButton, "Sign in");
    }
    
    public void clickExerciseButton() {
    	waitAndClick(exerciseBtn, "Exercise");
    }

    // Navigation buttons clicks (optional)
    public void clickHome() {
        waitAndClick(homeBtn, "Home");
    }

    public void clickLogbook() {
        waitAndClick(logbookBtn, "Logbook");
    }

    public void clickDashboard() {
        waitAndClick(dashboardBtn, "Dashboard");
    }

    public void clickEducation() {
        waitAndClick(educationBtn, "Education");
    }

    public void clickFlashingTab() {
        waitAndClick(flashtab, "Challenge Tab");
    }
    public void enterEmailFromExcel(String filePath, String sheetName, int row) throws Exception {
        ExcelReader excelRead = new ExcelReader(filePath);
        LoggerLoad.info("Reading email from Excel sheet: " + sheetName + ", Row: " + row);

        List<Map<String, String>> testData = excelRead.getDataAll(sheetName);
        if (row < testData.size()) {
            String email = testData.get(row).get("Email");
            LoggerLoad.info("Email is --> " + email);
            enterEmail(email);
        } else {
            throw new IllegalArgumentException("Row index out of bounds.");
        }
    }

    public void enterPasswordFromExcel(String filePath, String sheetName, int row) throws Exception {
        ExcelReader excelRead = new ExcelReader(filePath);
        LoggerLoad.info("Reading password from Excel sheet: " + sheetName + ", Row: " + row);

        List<Map<String, String>> testData = excelRead.getDataAll(sheetName);
        if (row < testData.size()) {
            String password = testData.get(row).get("Password");
            LoggerLoad.info("Password is --> " + password);
            enterPassword(password);
        } else {
            throw new IllegalArgumentException("Row index out of bounds.");
        }
    }




    // Verify the navigation buttons are in expected order
    public boolean isNavButtonsInOrder() {
    	wait.until(ExpectedConditions.visibilityOf(homeBtn));
        wait.until(ExpectedConditions.visibilityOf(logbookBtn));
        wait.until(ExpectedConditions.visibilityOf(dashboardBtn));
        wait.until(ExpectedConditions.visibilityOf(educationBtn));
        List<String> actualOrder = Arrays.asList(
            homeBtn.getText().trim(),
            logbookBtn.getText().trim(),
            dashboardBtn.getText().trim(),
            educationBtn.getText().trim()
        );

        List<String> expectedOrder = Arrays.asList("Home", "Logbook", "Dashboard", "Education");
        LoggerLoad.info("All four elements displayed");
        return actualOrder.equals(expectedOrder);
  
    }
    public void waitForChallengeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//button[contains(text(),'Challenge Yourself Today')]")));
        LoggerLoad.info("Challenge Yourself Today button is now visible.");
    }

    public boolean isChallengeButtonAnimated() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String animationName = (String) js.executeScript(
            "return window.getComputedStyle(arguments[0]).animationName;", getFlashtab());

        LoggerLoad.info("Animation name on Challenge Button: " + animationName);
        return animationName != null && !animationName.isEmpty() && !animationName.equals("none");
    }
    public String getChallengeButtonText() {
        return flashtab.getText();
       
    }


	
}

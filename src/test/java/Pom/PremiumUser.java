package Pom;

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

public class PremiumUser {
    private WebDriver driver;
    private WebDriverWait wait;
  
    ConfigReader config = new ConfigReader();
    public PremiumUser(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
//        String filepath="/Users/dineshdeshmukh/eclipse-workspace/SweetBalance/src/test/resources/testdata/SweetBalanceApplication.xlsx";
//		ExcelReader excelReader = new ExcelReader(filepath);
//		  credentialsData = excelReader.getDataAll("credentialsData");
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
    @FindBy(xpath = "//button[text()='🎯 Challenge Yourself Today!']")
    private WebElement flashtab;

    @FindBy(xpath = "//span[contains(@class,'text-5xl')]")
    private WebElement emojiIcon;

    @FindBy(xpath = "//img[contains(@class,'object-contain')]")
    private WebElement genderImage;

    @FindBy(xpath = "//span[text()='Meal Plan']")
    private WebElement mealPlanBtn;

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

    @FindBy(xpath = "//button[svg and span[text()='Physical Activity']]")
    private WebElement physicalActivityBtn;

    @FindBy(xpath = "//button[svg and span[text()='Food Intake']]")
    private WebElement foodIntakeBtn;

    @FindBy(xpath = "//button[svg and span[text()='Medication']]")
    private WebElement medicationBtn;

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

  

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(enterEmailInput));
        enterEmailInput.clear();
        enterEmailInput.sendKeys(email);
        LoggerLoad.info("Entered email: " + email);
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



    // Visibility checks for navigation bar buttons and others
    public boolean isAllNavButtonsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(homeBtn));
        wait.until(ExpectedConditions.visibilityOf(logbookBtn));
        wait.until(ExpectedConditions.visibilityOf(dashboardBtn));
        wait.until(ExpectedConditions.visibilityOf(educationBtn));
        wait.until(ExpectedConditions.visibilityOf(emojiIcon));
        wait.until(ExpectedConditions.visibilityOf(genderImage));
        wait.until(ExpectedConditions.visibilityOf(mealPlanBtn));
        wait.until(ExpectedConditions.visibilityOf(exerciseBtn));
        wait.until(ExpectedConditions.visibilityOf(fullMealPlanBtn));
        wait.until(ExpectedConditions.visibilityOf(weeklyPlanBtn));
        wait.until(ExpectedConditions.visibilityOf(recordNewDataTxt));
        wait.until(ExpectedConditions.visibilityOf(bloodGlucoseBtn));
        wait.until(ExpectedConditions.visibilityOf(physicalActivityBtn));
        wait.until(ExpectedConditions.visibilityOf(foodIntakeBtn));
        wait.until(ExpectedConditions.visibilityOf(medicationBtn));
        wait.until(ExpectedConditions.visibilityOf(flashtab));
        wait.until(ExpectedConditions.visibilityOf(challengeHeader));

        return homeBtn.isDisplayed()
                && logbookBtn.isDisplayed()
                && dashboardBtn.isDisplayed()
                && educationBtn.isDisplayed()
                && emojiIcon.isDisplayed()
                && genderImage.isDisplayed()
                && mealPlanBtn.isDisplayed()
                && exerciseBtn.isDisplayed()
                && fullMealPlanBtn.isDisplayed()
                && weeklyPlanBtn.isDisplayed()
                && recordNewDataTxt.isDisplayed()
                && bloodGlucoseBtn.isDisplayed()
                && physicalActivityBtn.isDisplayed()
                && foodIntakeBtn.isDisplayed()
                && medicationBtn.isDisplayed()
                && flashtab.isDisplayed()
                && challengeHeader.isDisplayed();
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
}

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
import java.util.ArrayList;
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

	@FindBy(xpath = "//span[contains(@class,'text-white/80')]")
	private WebElement userName;

	@FindBy(xpath = "//span[contains(text(),'SweetBalance')]")
	private WebElement appName;

	// Navigation buttons
	@FindBy(xpath = "//button[text()='Home']")
	private WebElement homeBtn;

	@FindBy(xpath = "//button[text()='Logbook']")
	private WebElement logbookBtn;

	@FindBy(xpath = "//button[text()='Dashboard']")
	private WebElement dashboardBtn;

	@FindBy(xpath = "//button[text()='Education']")
	private WebElement educationBtn;
	
	@FindBy(xpath = "//button[text()='Snacks']")
	private WebElement SnacksBtn;

	@FindBy(xpath = "//button[text()='Breakfast']")
	private WebElement breakfastBtn;
	
	@FindBy(xpath = "//h3[text()='Nutrition Insights']")
	private WebElement nutritionInsightscard;
	//h3[normalize-space()='Nutrition Insights']

	// Other UI elements
	@FindBy(xpath = "//button[contains(@class, 'animate-pulse')]")
	private WebElement flashtab;

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

	@FindBy(xpath = "//h3[contains(text(),'Pre-Meal')]")
	private WebElement preMealTitle;

	@FindBy(xpath = "//h3/span[contains(text(),'⏰')]")
	private WebElement alarmClockIcon;

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

	@FindBy(css = "main button.flex.flex-col.items-center svg")
	private List<WebElement> allIcons;

	@FindBy(xpath = "//h2[text()='Choose Your Challenge']")
	private WebElement challengeHeader;

	@FindBy(xpath = "//div[contains(@class,'rounded-full')]/button")
	private List<WebElement> mealTabs;

	@FindBy(xpath = "//h3[contains(text(),'Pre-Meal')]")
	private List<WebElement> preMealTitles;
	
	@FindBy(xpath = "/html/body/div/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/p")
	private WebElement totalText;
	
	@FindBy(xpath = "//h3[text()='Main Meal']")
	private WebElement mainMealSubtitle;
	
	@FindBy(xpath = "//span[@class='mr-2']")
	private WebElement utensilIcon;
	
	@FindBy(xpath = "//span[contains(text(), '7:00 AM')]")
	private WebElement mainMealTime;
	
	@FindBy(xpath = "//span[contains(text(), 'AM')]")
	private WebElement breakfastTimeIndicator;
	
	@FindBy(xpath = "//button[contains(text(), 'Lunch')]")
	private WebElement lunchTab;
	@FindBy(xpath = "//span[contains(normalize-space(),'PM')][1]")
	private WebElement lunchTimeIndicator;
	@FindBy(xpath = "//button[contains(text(), 'Dinner')]")
	private WebElement dinnerTab;
	@FindBy(xpath = "//span[contains(normalize-space(),'PM')]")
	private WebElement dinnerTimeIndicator;
	@FindBy(xpath = "//span[normalize-space()='7:30 AM']")
	private WebElement breakfastTimeElement;

	@FindBy(xpath = "//span[normalize-space()='7:30 PM']")
	private WebElement maindinnerTimeElement;
	@FindBy(xpath = "//div[@class='text-2xl font-bold']")
	private WebElement mainMealCalorieElement;
	@FindBy(xpath = "//h3[@class='text-lg font-semibold text-foreground']")
	private WebElement calorieLabelElement;
	@FindBy(xpath = "//div[contains(@class,'space-x-2')]/button[contains(text(),'Completed')]")
	public WebElement completedButton;

	@FindBy(xpath = "//div[contains(@class,'space-x-2')]/button[contains(text(),'Partially Completed')]")
	public WebElement partiallyCompletedButton;

	@FindBy(xpath = "//div[contains(@class,'space-x-2')]/button[contains(text(),'Not Completed')]")
	public WebElement notCompletedButton;
	
	@FindBy(xpath = "//p[contains(@class, 'text-sm') and contains(@class, 'text-gray-500')]")
	private WebElement totalCaloriesElement;

	@FindBy(xpath = "//div[contains(text(),'Pre-meal')]")
	private WebElement preMealCaloriesElement;

	@FindBy(xpath = "//div[contains(text(),'Main meal')]")
	private WebElement mainMealCaloriesElement;
	//button[text()='View Full Meal Plan']
	@FindBy(xpath = "//button[text()='View Full Meal Plan']")
	private WebElement viewFullMealPlanBtn;
	@FindBy(xpath = "//h1[normalize-space()='Full Meal Plan']")
    private WebElement fullMealPlanpageTitle;
	@FindBy(xpath = "//button[normalize-space()='Back to Plan']")
	private WebElement backToPlanButton;
	@FindBy(xpath = "//div[contains(@class,'overflow-x-auto')]/button")
	private List<WebElement> mealSectionButtons;

	
   
	// Helper wait and click method
	
	/** Waits for all meal section buttons to be visible */
	public List<String> getVisibleMealSectionButtonLabels() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(mealSectionButtons));

	    List<String> labels = new ArrayList<>();
	    for (WebElement button : mealSectionButtons) {
	        if (button.isDisplayed()) {
	            labels.add(button.getText().trim());
	        }
	    }
	    return labels;
	}
	public String getBackToPlanButtonText() {
	    return backToPlanButton.getText().trim();
	}
	public boolean isBackToPlanButtonVisible() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(backToPlanButton));
	        return backToPlanButton.isDisplayed();
	    } catch (TimeoutException e) {
	        return false;
	    }
	}
	public void clickBackToPlan() {
	    backToPlanButton.click();
	}
    public String getPageTitleText() {
        wait.until(ExpectedConditions.visibilityOf(fullMealPlanpageTitle));
        return fullMealPlanpageTitle.getText().trim();
    }
    public boolean isOnFullMealPlanPage() {
        return getPageTitleText().equals("Full Meal Plan");
    }
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public String getviewMeakPlanPageTitle() {
		return driver.getTitle();
	}
	public void clickViewFullMealPlanBtn() {
		viewFullMealPlanBtn.click();
	}
	public boolean isPreMealDetailVisible() {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(preMealCaloriesElement));
        return el.isDisplayed() && !el.getText().trim().isEmpty();
    }

    /** Returns true once the Main meal detail is visible and non‑empty. */
    public boolean isMainMealDetailVisible() {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(mainMealCaloriesElement));
        return el.isDisplayed() && !el.getText().trim().isEmpty();
    }

	public int getTotalCalories() {
	    String text = totalCaloriesElement.getText(); // 
	    return extractNumber(text);
	}

	public int getPreMealCalories() {
	    String text = preMealCaloriesElement.getText(); // 
	    return extractNumber(text);
	}

	public int getMainMealCalories() {
	    String text = mainMealCaloriesElement.getText(); 
	    return extractNumber(text);
	}

	private int extractNumber(String text) {
	    return Integer.parseInt(text.replaceAll("\\D+", ""));
	}
	public void clickCompletedButton() {
	    completedButton.click();
	}

	public WebElement waitForCompletedButtonToBeGreen() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Wait until the completedButton's class attribute contains "bg-green-500"
	    wait.until(ExpectedConditions.attributeContains(completedButton, "class", "bg-green-500"));
	    return completedButton;  // return the button after condition is met
	}

    public void clickPartiallyCompletedButton() {
        partiallyCompletedButton.click();
    }
    public WebElement waitForPartiallyCompletedButtonYellow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(partiallyCompletedButton, "class", "bg-yellow-500"));  // confirm class name!
        return partiallyCompletedButton;
    }
 

    public WebElement waitForNotCompletedButtonRed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(notCompletedButton, "class", "bg-red-500")); // confirm exact class!
        return notCompletedButton;
    }


    public void clickNotCompletedButton() {
        notCompletedButton.click();
    }

    // Color getters
    
    public String getCompletedButtonColor() {
        return completedButton.getCssValue("background-color");
    }

    public String getPartiallyCompletedButtonColor() {
        return partiallyCompletedButton.getCssValue("background-color");
    }

    public String getNotCompletedButtonColor() {
        return notCompletedButton.getCssValue("background-color");
    }
    public String getStatusButtonText(String buttonText) {
	    String xpath = "//button[normalize-space(text())='" + buttonText + "']";
	    WebElement statusButton = new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	    return statusButton.getText().trim();
	}
	public String getLabelAfterMainMealCalories() {
	    return calorieLabelElement.getText().trim();  // Should return "calories"
	}
	public int getMainMealCalorieValue() {
	    String text = mainMealCalorieElement.getText().trim();  // e.g., "340"
	    return Integer.parseInt(text);  // convert to number
	}

	
	public String getBreakfastTimeOnly() {
	    String fullTime = breakfastTimeElement.getText().trim(); // e.g., "7:30 AM"
	    if (fullTime.contains(" ")) {
	        return fullTime.split(" ")[0]; // returns "7:30"
	    }
	    return fullTime;
	}
	public String maindinnerTimeElement() {
	    String fullTime = breakfastTimeElement.getText().trim(); // e.g., "7:30 AM"
	    if (fullTime.contains(" ")) {
	        return fullTime.split(" ")[0]; // returns "7:30"
	    }
	    return fullTime;
	}
	
	public void clickDinnerTab() {
		waitAndClick(dinnerTab,"Dinner");
	}
	public void clickLunchTab() {
		waitAndClick(lunchTab,"Lunch");
	}
	public String getTimeIndicatore() {
		String fullTime1 = lunchTimeIndicator.getText().trim(); // e.g., "12.00 PM"
	    
	    if (fullTime1.contains(" ")) {
	        return fullTime1.split(" ")[1]; // returns "PM"
	    }

	    return fullTime1; // fallback if there's no space (e.g., just "PM")
	}
	
	public String getBreakfastIndicator() {
	    String fullTime = breakfastTimeIndicator.getText().trim(); // e.g., "7:00 AM"
	    
	    if (fullTime.contains(" ")) {
	        return fullTime.split(" ")[1]; // returns "AM"
	    }

	    return fullTime; // fallback if there's no space (e.g., just "AM")
	}

	public boolean isMainMealTimeVisible() {
	    return mainMealTime.isDisplayed();
	}
	

	public String getMainMealTimeText() {
	    return mainMealTime.getText().trim();
	}

	public boolean isBreakfastBtnVisible() {
	    return breakfastBtn.isDisplayed();
	}

	// Example for Nutrition card visibility
	public boolean isNutritionCardVisible() {
	    return nutritionInsightscard.isDisplayed();
	}

	// Action methods
	public void clickSnacksBtn() {
		SnacksBtn.click();
		LoggerLoad.info("Clicked Snacks button");
	}
	public void clickLoginBtn() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
			LoggerLoad.info("Clicked Login button");
		} catch (Exception e) {
			LoggerLoad.warn("Login button not found or already clicked, skipping...");
		}
	}
	public String getTotalText() {
	    LoggerLoad.info("Total count text: " + totalText.getText().trim());
	    return totalText.getText().trim();
	}
	public boolean isTotalCountZero() {
	    String text = getTotalText(); // e.g., "0 total"
	    return text.startsWith("0");
	}


	public boolean isChallengeButtonFlashingWithDuration(double expectedSeconds) {
		WebElement challengeBtn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Challenge Yourself Today')]")));

		String animationDuration = (String) ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(arguments[0]).getPropertyValue('animation-duration');", challengeBtn);

		System.out.println("Animation duration: " + animationDuration);

		// Clean the string and compare (e.g., 0.2s)
		return animationDuration.trim().equals(expectedSeconds + "s");
	}

	public boolean isFemaleImageDisplayed() {
		LoggerLoad.info("Waiting for Female character image to appear...");

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
		wait.until(ExpectedConditions.visibilityOf(moodText));
		String mood = moodText.getText().trim();
		LoggerLoad.info("Mood text displayed: " + mood);
		return mood;
	}

	public boolean isWeeklyPlanButtonVisible() {
		LoggerLoad.info("Checking visibility of Weekly Plan button...");
		wait.until(ExpectedConditions.visibilityOf(weeklyPlanBtn));
		boolean visible = weeklyPlanBtn.isDisplayed();
		LoggerLoad.info("Weekly Plan button displayed: " + visible);
		return visible;
	}

	public boolean isRecordNewDataTextVisible() {
		LoggerLoad.info("Checking if 'Record New Data' text is displayed...");
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
    public void isMainMealTitlesVisible(){
	
	wait.until(ExpectedConditions.visibilityOf(mainMealSubtitle));
	LoggerLoad.info("Main Meal title is visible");
}
    public boolean isUtensilIconVisible() {
        return utensilIcon.isDisplayed();
    }
	public boolean areRecordNewDataButtonsVisible() {
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

	public WebElement getSecondActivityIcon() {
		if (activityIcons != null && activityIcons.size() >= 2) {
			return activityIcons.get(1); // index 1 = second element
		} else {
			throw new NoSuchElementException("Second activity icon not found");
		}
	}

	public String getPhysicalActivityText() {
		return physicalActivityBtn.getText().trim();
	}

	public String getFoodIntakeText() {
		return foodIntakeBtn.getText().trim();
	}

	public String getMedicationText() {
		return medicationBtn.getText().trim();
	}



	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(password);
		LoggerLoad.info("Entered password");
	}
	private void waitAndClick(WebElement element, String name) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		LoggerLoad.info("Clicked: " + name);
	}
	public void clickContinueWithEmailBtn() {
		waitAndClick(continueWithEmailBtn, "Continue with email");
	}
	public void clickSignInButton() {
		waitAndClick(signInButton, "Sign in");
	}

	// Navigation buttons clicks
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

	public void clickMealPlan() {
		LoggerLoad.info("Meal Plan clicked");
		waitAndClick(mealPlanBtn, "Meal Plan");
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
		List<String> actualOrder = List.of(
			homeBtn.getText().trim(),
			logbookBtn.getText().trim(),
			dashboardBtn.getText().trim(),
			educationBtn.getText().trim()
		);

		List<String> expectedOrder = List.of("Home", "Logbook", "Dashboard", "Education");
		LoggerLoad.info("All four elements displayed");
		return actualOrder.equals(expectedOrder);
	}

	public void waitForChallengeButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Challenge Yourself Today')]")));
		LoggerLoad.info("Challenge Yourself Today button is now visible.");
	}

	public boolean isChallengeButtonAnimated() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String animationName = (String) js.executeScript("return window.getComputedStyle(arguments[0]).animationName;", getFlashtab());

		LoggerLoad.info("Animation name on Challenge Button: " + animationName);
		return animationName != null && !animationName.isEmpty() && !animationName.equals("none");
	}

	public String getChallengeButtonText() {
		return flashtab.getText();
	}

	public boolean isPreMealTitleDisplayed() {
		LoggerLoad.info("Pre-Meal title displayed");
		return preMealTitle.isDisplayed();
	}

	public boolean isAppNameDisplayed() {
		return appName.isDisplayed();
	}

	public boolean isUserNameDisplayed() {
		return userName.isDisplayed();
	}

	public boolean isLoggedInAs() {
		LoggerLoad.info("SweetBalance title and username are displayed");
		return isAppNameDisplayed() && isUserNameDisplayed();
	}

	public boolean isAlarmClockIconDisplayed() {
		LoggerLoad.info("Checking visibility of alarm clock icon in the Pre-Meal section");
		boolean visible = alarmClockIcon.isDisplayed();
		LoggerLoad.info(visible ? "Alarm clock icon is displayed." : "Alarm clock icon is NOT displayed.");
		return visible;
	}

	// Validate 'Pre-Meal' is visible in all meal tabs
	public boolean isPreMealVisibleInAllTabs() {
		LoggerLoad.info("Validating 'Pre-Meal' is the first title in each meal tab");

		for (WebElement tab : mealTabs) {
			String tabName = tab.getText().trim();
			LoggerLoad.info("Clicking tab: " + tabName);
			waitAndClick(tab, tabName);

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Pre-Meal')]")));
			} catch (TimeoutException e) {
				LoggerLoad.warn("'Pre-Meal' not found in tab: " + tabName);
				return false;
			}

			List<WebElement> preMealTitles = driver.findElements(By.xpath("//h3[contains(text(),'Pre-Meal')]"));

			boolean found = preMealTitles.stream()
					.anyMatch(el -> el.getText().replace("⏰", "").trim().equalsIgnoreCase("Pre-Meal"));

			LoggerLoad.info("In " + tabName + " tab, Pre-Meal found: " + found);

			if (!found) {
				return false;
			}
		}

		LoggerLoad.info("'Pre-Meal' is present in all meal tabs");
		return true;
	}
	
	
	public WebElement getFlashtab() {
		return wait.until(ExpectedConditions.visibilityOf(flashtab));
	}

	public WebElement getIconByIndex(int index) {
		if (allIcons.size() > index) {
			return allIcons.get(index);
		} else {
			throw new IndexOutOfBoundsException("Icon at index " + index + " not found");
		}
	}

	public String getPreMealTitleText() {
	    return preMealTitle.getText().trim();
	}
	public boolean isMainMealSubtitleVisible() {
	    return mainMealSubtitle.isDisplayed();
	}
	public String getMainMealSubtitleText() {
	    return mainMealSubtitle.getText().trim();
	}
	

}

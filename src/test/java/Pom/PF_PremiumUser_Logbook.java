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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PF_PremiumUser_Logbook {
	private WebDriver driver;
    private WebDriverWait wait;
  
    ConfigReader config = new ConfigReader();
    public PF_PremiumUser_Logbook(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(xpath = "//h2[text()='Blood Glucose Tracker']")
    private WebElement bloodGlucoseTracker;
    
    @FindBy(xpath = "//h2[text()='Meal & Nutrition']")
    private WebElement mealNutrition;
    
    @FindBy(xpath = "//h2[text()='Physical Activity']")
    private WebElement physicalActivity;
    
    @FindBy(xpath = "//h2[text()='Medical Dosage']")
    private WebElement medicalDosage;
    
    @FindBy(xpath = "//h2[text()='Log Review']")
    private WebElement logReview;
    
    @FindBy(xpath = "//div[contains(text(),'Fasting')]")
    private WebElement fastingLabel;
    
    @FindBy(xpath = "//div[contains(text(),'Pre-Meal')]")
    private WebElement preMealLabel;
    
    @FindBy(xpath = "//div[contains(text(),'Post-Meal')]")
    private WebElement postMealLabel;
    
    @FindBy(xpath = "//div[contains(text(),'Bedtime')]")
    private WebElement bedtimeLabel;
    
    @FindBy(xpath = "//div[contains(text(),'Fasting')]/following-sibling::div[contains(text(),'70-100 mg/dL')]")
    private WebElement fastingRangeValue;
    
    @FindBy(xpath = "//div[contains(text(),'Pre-Meal')]/following-sibling::div[contains(text(),'70-130 mg/dL')]")
    private WebElement preMealRangeValue;
    
    @FindBy(xpath = "//div[contains(text(),'Post-Meal')]/following-sibling::div[contains(text(),'<180 mg/dL')]")
    private WebElement postMealRangeValue;
    
    @FindBy(xpath = "//div[contains(text(),'Bedtime')]/following-sibling::div[contains(text(),'100-140 mg/dL')]")
    private WebElement bedtimeRangeValue;
    
    @FindBy(xpath = "//g[@class='recharts-cartesian-axis-ticks']//text[contains(., '70')]")
    private WebElement yAxisMinLabelBloodGlucose;

    @FindBy(xpath = "//g[@class='recharts-cartesian-axis-ticks']//text[contains(., '180')]")
    private WebElement yAxisMaxLabelBloodGlucose;

    @FindBy(xpath = "//g[@class='recharts-cartesian-axis recharts-xAxis xAxis']//text")
    private List<WebElement> xAxisTicks;
    
    @FindBy(xpath = "//h2[contains(text(),'Meal & Nutrition')]/preceding-sibling::svg")
    private WebElement mealNutritionIcon;
    
    @FindBy(xpath = "//h2[contains(text(),'Medical Dosage')]/preceding-sibling::svg")
    private WebElement medicalDosageIcon;
    
    @FindBy(xpath = "//h2[contains(text(),'Physical Activity')]/preceding-sibling::svg")
    private WebElement physicalActivityIcon;
    
    @FindBy(xpath = "//h3[contains(text(),'7-Day Aggregate Nutrition')]")
    private WebElement day7AggregateNutritionSection;
    
    @FindBy(xpath = "//h3[contains(text(),'Daily Nutrition Breakdown')]")
    private WebElement dailyNutritionSection;
    
    @FindBy(xpath = "//span[text()='Carbs']")
    private WebElement carbsLegendText;
    
    @FindBy(xpath = "//span[text()='Protein']")
    private WebElement proteinLegendText;
    
    @FindBy(xpath = "//span[text()='Fats']")
    private WebElement fatsLegendText;



    
    public boolean isBloodGlucoseTrackerVisible() {
        LoggerLoad.info("Checking visibility of Blood Glucose Tracker...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bloodGlucoseTracker));
        boolean visible = bloodGlucoseTracker.isDisplayed();
        LoggerLoad.info("Blood Glucose Tracker displayed: " + visible);
        return visible;
    }
    public boolean isMealNutritionVisible() {
        LoggerLoad.info("Checking visibility of Meal & Nutrition...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mealNutrition));
        boolean visible = mealNutrition.isDisplayed();
        LoggerLoad.info("Meal & Nutrition displayed: " + visible);
        return visible;
    }
    public boolean isMedicalDosageVisible() {
        LoggerLoad.info("Checking visibility of Medical Dosage...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(medicalDosage));
        boolean visible = medicalDosage.isDisplayed();
        LoggerLoad.info("Medical Dosage displayed: " + visible);
        return visible;
    }
    public boolean isPhysicalActivityVisible() {
        LoggerLoad.info("Checking visibility of Physical Activity...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(physicalActivity));
        boolean visible = physicalActivity.isDisplayed();
        LoggerLoad.info("Physical Activity displayed: " + visible);
        return visible;
    }
    public boolean isLogReviewrVisible() {
        LoggerLoad.info("Checking visibility of Log Review...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logReview));
        boolean visible = logReview.isDisplayed();
        LoggerLoad.info("Log Review displayed: " + visible);
        return visible;
    }
    
    public boolean isFastingRangeVisible(String range) {
        LoggerLoad.info("Checking fasting blood glucose range is correctly displayed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fastingRangeValue));
        String actual = fastingRangeValue.getText().trim();
        return actual.equals(range);
    }
    public boolean isPreMealRangeVisible(String range) {
        LoggerLoad.info("Checking pre-meal blood glucose range is correctly displayed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(preMealRangeValue));
        String actual = preMealRangeValue.getText().trim();
        return actual.equals(range);
    }
    public boolean isPostMealRangeVisible(String range) {
        LoggerLoad.info("Checking post-meal blood glucose range is correctly displayed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(postMealRangeValue));
        String actual = postMealRangeValue.getText().trim();
        return actual.equals(range);
    }
    public boolean isBedtimeRangeVisible(String range) {
        LoggerLoad.info("Checking bedtime blood glucose range is correctly displayed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bedtimeRangeValue));
        String actual = bedtimeRangeValue.getText().trim();
        return actual.equals(range);
    }
    public boolean isFastingTextViolet() {
    	LoggerLoad.info("Checking fasting is displayed in purple color");
        String expectedColor = "rgba(91, 33, 182, 1)"; // Tailwind's text-violet-800
        return fastingLabel.getCssValue("color").equals(expectedColor);
    }
    public boolean isPreMealTextEmberald() {
    	LoggerLoad.info("Checking pre-meal is displayed in green color");
        String expectedColor = "rgba(6, 95, 70, 1)"; // Tailwind's text-emerald-800
        return preMealLabel.getCssValue("color").equals(expectedColor);
    }
    public boolean isPostMealTextAmber() {
    	LoggerLoad.info("Checking post-meal is displayed in yellow color");
        String expectedColor = "rgba(146, 64, 14, 1)"; // Tailwind's text-amber-800
        return postMealLabel.getCssValue("color").equals(expectedColor);
    }
    public boolean isBedtimeTextRed() {
    	LoggerLoad.info("Checking bedtime is displayed in red color");
        String expectedColor = "rgba(159, 18, 57, 1)"; // Tailwind's text-rose-800
        return bedtimeLabel.getCssValue("color").equals(expectedColor);
    }
    public boolean isYAxisMinCorrectBloodGlucose(int minRange) {
        return yAxisMinLabelBloodGlucose.getText().trim().equals(String.valueOf(minRange));
    }
    public boolean isYAxisMaxCorrectBloodGlucose(int maxRange) {
        return yAxisMaxLabelBloodGlucose.getText().trim().equals(String.valueOf(maxRange));
    }
    
    public List<String> getXAxisDates() {
        return xAxisTicks.stream()
                         .map(e -> e.getText().trim())
                         .collect(Collectors.toList());
    }
    public List<String> getExpectedLast7Days() {
        List<String> last7Days = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd", Locale.ENGLISH);
        LocalDate today = LocalDate.now();

        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            last7Days.add(formatter.format(date));
        }

        return last7Days;
    }
    public boolean isXAxisLast7DaysCorrect() {
        List<String> actual = getXAxisDates();
        List<String> expected = getExpectedLast7Days();

        // Compare only if actual contains at least the last 7 dates
        return actual.containsAll(expected);
    }
    
    
    public boolean isMealNutritionIconLeftOfTitle() {
        return mealNutritionIcon.isDisplayed() && mealNutrition.isDisplayed();
    }
    public boolean isMedicalDosageIconLeftOfTitle() {
        return medicalDosageIcon.isDisplayed() && medicalDosage.isDisplayed();
    }
    public boolean isPhysicalActivityIconLeftOfTitle() {
        return physicalActivityIcon.isDisplayed() && physicalActivity.isDisplayed();
    }
    public boolean isDay7AggregateNutritionSectionVisible() {
    	LoggerLoad.info("Checking visibility of 7-Day Aggregate Nutrition Section...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(day7AggregateNutritionSection));
        boolean visible = day7AggregateNutritionSection.isDisplayed();
        LoggerLoad.info("7-Day Aggregate Nutrition Section displayed: " + visible);
        return visible;
    }
    public boolean isDailyNutritionSectionVisible() {
    	LoggerLoad.info("Checking visibility of Daily Nutrition Section...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dailyNutritionSection));
        boolean visible = dailyNutritionSection.isDisplayed();
        LoggerLoad.info("Daily Nutrition Section displayed: " + visible);
        return visible;
    }
    public boolean isCarbsTextPink() {
        String color = carbsLegendText.getCssValue("color");
        return color.equals("rgb(255, 99, 132)");
    }
    public boolean isProteinTextBlue() {
        String color = proteinLegendText.getCssValue("color");
        return color.equals("rgb(54, 162, 235)");
    }
    public boolean isFatsTextYellow() {
        String color = fatsLegendText.getCssValue("color");
        return color.equals("rgb(255, 206, 86)");
    }

    




    
    
    
    
  
  

}

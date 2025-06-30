Feature: Functional and Non-Functional Test Validation for Premium Account User

  Background: 
    Given the user is logged into the app

  Scenario: Verify the presence of "Pre-meal" title in each meal section
    Given the user is in home page
    When the user clicks meal section
    Then the user should see "Pre-Meal" title

  Scenario: Verify the presence of icon for Pre-meal
    Given the user is in home page
    When the user clicks meal section
    Then the user should see alarm clock icon

  Scenario: Verify pre-meal title is shown before main meal
    Given the user is in home page
    When the user clicks meal section
    Then the user should see pre-meal in first place of each meal section

  Scenario: Verify "None" is displayed for Pre-Meal Snack by default
    Given User is in home page
    When the user clicks snack section
    Then the user should see Pre-Meal entry displays as "None" by default

  Scenario: Verify calorie in pre-meal snack
    Given User is in home page
    When the user clicks snack section
    Then the user should see 0 calorie in pre-meal snack

  Scenario: Verify the presence of meal title for main meal in snack
    Given User is in home page
    When the user clicks snack section
    Then the user should see meal title for main-meal in snack

  Scenario: Verify meal section contains dish description in snack
    Given User is in home page
    When the user clicks snack section
    Then the user should see description for the dish in snack

  Scenario: Verify the presence of Sub title "Main-Meal"
    Given User is in home page
    When the user clicks meal section
    Then the user should see "Main-meal" as sub title

  Scenario: Verify the presence of icon for main-meal
    Given User is in home page
    When the user clicks meal section
    Then the user should see utensil icon for each main-meal

  Scenario: Verify the time format in each main-meal
    Given User is in home page
    When the user clicks meal section
    Then the user should see "hh:mm" based time in main-meal (e.g., 1:00)

  Scenario: Validate the indicator for breakfast main-meal
    Given User is in home page
    When the user clicks meal section
    Then the user should see indicator "AM" for breakfast main-meal

  Scenario: Validate the indicator for lunch main-meal
    Given User is in home page
    When the user clicks meal section
    Then the user should see indicator "PM" for lunch main-meal

  Scenario: Validate the indicator for dinner main-meal
    Given User is in home page
    When the user clicks meal section
    Then the user should see indicator "PM" for dinner main-meal

  Scenario: Validate the indicator for snack main-meal
    Given User is in home page
    When the user clicks meal section
    Then the user should see indicator "PM" for snack main-meal

  Scenario: Verify the time in main-breakfast
    Given User is in home page
    When the user clicks meal section
    Then the user should see 7:30 o'clock

  Scenario: Verify the time in main-lunch
    Given User is in home page
    When the user clicks meal section
    Then the user should see 12:30 o'clock

  Scenario: Verify the time in main-dinner
    Given User is in home page
    When the user clicks meal section
    Then the user should see 6:30 o'clock

  Scenario: Verify the time in main-snack
    Given User is in home page
    When the user clicks meal section
    Then the user should see 3:30 o'clock

  Scenario: Verify calories for main-meal is shown for each meal
    Given the user is in home page
    When the user clicks meal section
    Then the user should see the main-meal calorie value

  Scenario: Validate the text "Calorie" in main-meal
    Given the user is in home page
    When the user clicks meal section
    Then the user should see text "calorie" after the calorie value in main meal

  Scenario: Verify the presence of ✅ Completed button
    Given the user is in home page
    When the user clicks meal section
    Then the user should see "✅ Completed" button

  Scenario: Verify the presence of ⚠️ Partially Completed button
    Given the user is in home page
    When the user clicks meal section
    Then the user should see "⚠️ Partially Completed" button

  Scenario: Verify the presence of ❌ Not Completed button
    Given the user is in home page
    When the user clicks meal section
    Then the user should see "❌ Not Completed" button

  Scenario: Verify color change of completed button
    Given the user is in home page
    When the user marks meal as completed
    Then the button color should change to green

  Scenario: Verify color change of partially completed button
    Given the user is in home page
    When the user marks meal as partially completed
    Then the button color should change to yellow

  Scenario: Verify color change of not completed button
    Given the user is in home page
    When the user marks meal as not completed
    Then the button color should change to red

  Scenario: Verify presence of nutrition insight summary card in each meal section
    Given the user is in home page
    When the user views a meal section
    Then the user should see Nutrition Insight summary card

  Scenario: Verify title in nutrition flex card
    Given the user is in home page
    When the user views a meal section
    Then the user should see title "Nutrition Insight"

  Scenario: Verify sub-title in nutrition flex card
    Given the user is in home page
    When the user clicks meal section
    Then the user should see subtitle "Calorie"

  Scenario: Verify total calorie count from pre-meal and meal
    Given the user is in home page
    When the user clicks meal section
    Then total calorie count should equal the sum of Pre-Meal and Meal calories

  Scenario: Verify each meal calorie detail on the right side
    Given the user is in home page
    When the user clicks meal section
    Then the user should see calorie detail on the right side of its section

  Scenario: Verify meal calorie detail matches pre-meal and main meal
    Given the user is in home page
    When the user clicks meal section
    Then calorie in flex card should match with the meal

  Scenario: Verify that the donut chart is displayed
    Given the user is in home page
    When the user clicks meal section
    Then the user should see donut chart

  Scenario: Validate that donut chart displays total calories
    Given the user is in home page
    When the user clicks meal section
    Then the user should see total calories in donut chart

  Scenario: Verify color segments exist in donut chart
    Given the user is in home page
    When the user clicks meal section
    Then the user should see distinct color segment in each macro

  Scenario: Validate macro percentage distribution in donut chart
    Given the user is in home page
    When the user clicks meal section
    Then macro percentages should match expected values

  Scenario: Verify macro segment colors match bar chart
    Given the user is in home page
    When the user clicks meal section
    Then each segment color should match its corresponding label

  Scenario: Verify bar chart is visible in meal section
    Given the user is in home page
    When the user clicks meal section
    Then the user should see macronutrient bar chart

  Scenario: Validate each macro has a horizontal bar
    Given the user is in home page
    When the user clicks meal section
    Then the user should see progress bars for carbs, protein, fat, and fiber

  Scenario: Verify bar chart values match macro values
    Given the user is in home page
    When the user clicks meal section
    Then each nutrient bar should show value consistent with label

  Scenario: Validate bar chart percentages add up to 100%
    Given the user is in home page
    When the user clicks meal section
    Then all macro percentages should add up to 100%

  Scenario: Verify presence of macro labels and percentages below the chart
    Given the user is in home page
    When the user views macro section
    Then each macronutrient should display name and percentage

  Scenario: Validate legend color matches chart segment
    Given the user is in home page
    When the user views macro legend
    Then legend color should match its chart segment

  Scenario: Verify navigation to View Full Meal Plan
    Given the user is in home page
    When the user clicks View Meal Plan button
    Then the user should be redirected to Full Meal Plan page

  Scenario: Verify title in View Meal Plan page
    Given the user is on Full Meal Plan page
    When the user views the page
    Then the user should see title "Full Meal Plan"

  Scenario: Verify presence of Back to Plan button
    Given the user is on Full Meal Plan page
    When the user views navigation controls
    Then the user should see "Back to plan" button

  Scenario: Verify meal section button in View Plan page
    Given the user is on Full Meal Plan page
    When the user views the meal sections
    Then the user should see each meal section button

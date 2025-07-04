Feature: Functional and Non-Functional Test Validation for Premium Account User

  Background: 
   Given the user is in password auth page
    When the user clicks sign in after entering password

  Scenario: Verify the presence of "Pre-meal" title in each meal section
    When the user clicks meal section
    Then the user should see "Pre-Meal" title under the four tabs

  Scenario: Verify the presence of icon for Pre-meal
    When the user clicks meal section
    Then the user should see alarm clock icon

  Scenario: Verify pre-meal title is shown before main meal
    When the user clicks meal section
    Then the user should see pre-meal in first place of each meal section

  Scenario: Verify "None" is displayed for Pre-Meal Snack by default
    When the user clicks snack section
    Then the user should see Pre-Meal entry displays as "None" by default

  Scenario: Verify calorie in pre-meal snack
    When the user clicks snack section
    Then the user should see 0 calorie in pre-meal snack

  Scenario: Verify the presence of meal title for main meal in snack
    When the user clicks snack section
    Then the user should see meal title for main-meal in snack

  Scenario: Verify meal section contains dish description in snack
    When the user clicks snack section
    Then the user should see description for the dish in snack

  Scenario: Verify the presence of Sub title "Main-Meal"
    When the user clicks meal section
    Then the user should see "Main-meal" as sub title

  Scenario: Verify the presence of icon for main-meal
    When the user clicks meal section
    Then the user should see utensil icon for each main-meal

  Scenario: Verify the time format in each main-meal
    When the user clicks meal section
    Then the user should see "hh:mm" based time in main-meal 

  Scenario: Validate the indicator for breakfast main-meal
    When the user clicks meal section
    Then the user should see indicator "AM" for breakfast main-meal

  Scenario: Validate the indicator for lunch main-meal
    When the user clicks meal section
    Then the user should see indicator "PM" for lunch main-meal

  Scenario: Validate the indicator for dinner main-meal
    When the user clicks meal section
    Then the user should see indicator "PM" for dinner main-meal

  Scenario: Validate the indicator for snack main-meal
    When the user clicks meal section
    Then the user should see indicator "PM" for snack main-meal

  Scenario: Verify the time in main-breakfast
    When the user clicks meal section
    Then the user should see 7:30 o'clock

  Scenario: Verify the time in main-lunch
    When the user clicks meal section
    Then the user should see 12:30 o'clock

  Scenario: Verify the time in main-dinner
    When the user clicks meal section
    Then the user should see 7:30 o'clock

  Scenario: Verify the time in main-snack
    When the user clicks meal section
    Then the user should see 3:30 o'clock

  Scenario: Verify calories for main-meal is shown for each meal
    When the user clicks meal section
    Then the user should see the main-meal calorie value

  Scenario: Validate the text "Calories" in main-meal
    When the user clicks meal section
    Then the user should see text "Calories" after the calorie value in main meal

	  Scenario: Verify the presence of ✅ Completed button
	    When the user clicks meal section
	    Then the user should see "✅ Completed" button

  Scenario: Verify the presence of ⚠️ Partially Completed button
    When the user clicks meal section
    Then the user should see "⚠️ Partially Completed" button

  Scenario: Verify the presence of ❌ Not Completed button
    When the user clicks meal section
    Then the user should see "❌ Not Completed" button

  Scenario: Verify color change of completed button
    When the user marks meal as completed
    Then the button color should change to green

  Scenario: Verify color change of partially completed button
    When the user marks meal as partially completed
    Then the button color should change to yellow

  Scenario: Verify color change of not completed button
    When the user marks meal as not completed
    Then the button color should change to red

  Scenario: Verify presence of nutrition insight summary card in each meal section
    When the user views a meal section
    Then the user should see Nutrition Insight summary card

  Scenario: Verify title in nutrition flex card
    When the user views a meal section
    Then the user should see title "Nutrition Insight"

  Scenario: Verify sub-title in nutrition flex card
    When the user clicks meal section
    Then the user should see subtitle "Calories"

  Scenario: Verify total calorie count from pre-meal and meal
    When the user clicks meal section
    Then total calorie count should equal the sum of Pre-Meal and Meal calories

  Scenario: Verify each meal calorie detail on the right side
    When the user clicks meal section
    Then the user should see calorie detail on the right side of its section

  Scenario: Verify navigation to View Full Meal Plan
    When the user clicks View Meal Plan button
    Then the user should be redirected to Full Meal Plan page

  Scenario: Verify title in View Meal Plan page
    Given the user is on Full Meal Plan page
    When the user views the page
    Then the user should see title "Full Meal Plan"

  Scenario: Verify presence of Back to Plan button
    Given the user is on Full Meal Plan page
    When the user views navigation controls
    Then the user should see "Back to plan" button on view full Meal Plan

  Scenario: Verify meal section button in View Plan page
    Given the user is on Full Meal Plan page
    When the user views the meal sections
    Then the user should see each meal section button

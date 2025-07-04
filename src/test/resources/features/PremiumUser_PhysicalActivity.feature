@physicalActity
Feature: Physical Activity Validation and Food Intake 

  Background:
    Given User is in home page after logged into app

  #Scenario: Verify title in physical activity form
    #When User clicks physical activiy
    #Then User should see title "Physical Activity" on the popup
#
  #Scenario: Verify subtext in physical activity form
    #Then User should see subtext "Track your fitness journey" activity popup
#
  #Scenario: Verify fields in physical activity
    #Then User should see field for Activity Type, Duration, Date, Intensity
#
  #Scenario: Verify dropdown for Activity Type
    #Then User should see dropdown for activity type
#
  #Scenario: Verify dropdown options for Activity Type
    #Then User should see "Walking, Running, Cycling, Weight Training, Yoga, HIIT, Other" activity type
#
  #Scenario: Verify input field for Duration
    #Then User should see input field for duration
#
  #Scenario: Verify placeholder text for Duration
    #Then User should see "30" in placeholder field
#
  #Scenario: Verify dropdown for Duration options
    #Then User should see drop down duration
#
  #Scenario: Verify dropdown values for Duration
    #Then User should see "minutes, hours" activity popup
#
  #Scenario: Verify date picker in activity form
    #Then User should see date picker on physical Activity popup
#
  #Scenario: Verify presence of Intensity field
    #Then User should see intensity field
#
  #Scenario: Verify intensity options
    #Then User should see "Light, Moderate, Vigorous" on activity popup
   
#
  #Scenario: Verify save activity button
    #Then User should see save activity button
    @FoodIntake
  
Scenario: Verify title in Food Intake form
    When User clicks Food Intake
    Then User should see title "Food Intake Tracker" on food popup

  Scenario: Verify subtext in form
    Then User should see subtext "Track what you eat to manage your diabetes better" in the food popup

  Scenario: Verify presence of 4 tabs
    Then User should see "Breakfast, Lunch, Dinner, Snack" tabs

  Scenario: Verify fields in Food Intake form
    Then User should see field for Food Name, Serving Size, Calories, Date, Notes

  Scenario: Verify default meal tab
    Then User should see "Breakfast" tab selected by default

  Scenario: Verify input field for food name
    Then User should see input field for food name

  Scenario: Verify placeholder in food name field
    Then User should see text "e.g., Grilled Chicken Salad" as placeholder

  Scenario: Verify dropdown for Serving Size
    Then User should see dropdown for serving size

  Scenario: Verify default value in Serving Size
    Then User should see "Medium (1 cup)" as default

  Scenario: Verify options in Serving Size
    Then User should see "Small (1/2 cup), Medium (1 cup), Large (2 cups), Custom" in foodIntake popup

  Scenario: Verify calculator icon in calorie field
    Then User should see calculator icon in calorie

  Scenario: Verify input field for calorie
    Then User should see input field for calorie

  Scenario: Verify placeholder in calorie field
    Then User should see text "eg.250" as placeholder

  Scenario: Verify helper text under calorie field
    Then User should see "Enter calories or click the calculator icon for automatic calculation." after popoup

  Scenario: Verify date picker after popup
    Then User should see date picker

  Scenario: Verify default value in Date field
    Then User should see toadys date

  Scenario: Verify input for notes
    Then User should see input block for notes

  Scenario: Verify placeholder in notes
    Then User should see "Add any additional information..."after the foodintake popup

  Scenario: Verify save food entry button
    Then User should see save food entry button
    
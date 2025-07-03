Feature: Functional and non-functional test validation for home page

  Background:
    Given User is logged into the app

  Scenario: Verify meal section contains dish title
    Given User is in home page
    When User clicks meal section
    Then User should see dish title

   Scenario: Verify meal section contains dish description
    Given User is in home page
    When User clicks meal section
    Then User should see description for the dish 
    
  Scenario: Verify pre-meal item is shown for each meal
    Given User is in home page
    When User clicks meal section
    Then User should see the pre-meal item name

  Scenario: Verify calories for pre-meal is shown for each meal
    Given User is in home page
    When User clicks meal section
    Then User should see the pre-meal calorie value 
    
    Scenario: Validate the indicator for breakfast pre-meal
    Given User is in home page
    When User clicks meal section
    Then User should see indicator "AM" for breakfast pre-meal

  Scenario: Validate the indicator for lunch pre-meal
    Given User is in home page
    When User clicks meal section
    Then User should see indicator "PM" for lunch pre-meal

  Scenario: Validate the indicator for dinner pre-meal
    Given User is in home page
    When User clicks meal section
    Then User should see indicator "PM" for dinner pre-meal

  Scenario: Verify the time format in each pre-meal
    Given User is in home page
    When User clicks meal section
    Then User should see "hh:mm" based time in pre-meal (eg : 1:00)

  Scenario: Verify the time in pre-breakfast
    Given User is in home page
    When User clicks meal section
    Then User should see 7'o clock

  Scenario: Verify the time in pre-lunch
    Given User is in home page
    When User clicks meal section
    Then User should see the 12 o'clock

  Scenario: Verify the time in pre-dinner
    Given User is in home page
    When User clicks meal section
    Then User should see 7'o clock

  Scenario: Verify Carbs bar color for each meal
    Given User is in home page
    When User clicks meal section
    Then User should see green color for Carbs

  Scenario: Verify Fat bar color
    Given User is in home page
    When User clicks meal section
    Then User should see purple color for Fat

  Scenario: Verify Protein bar color
    Given User is in home page
    When User clicks meal section
    Then User should see pink color for Protein

  Scenario: Verify unit of measurement for Carbs is in grams
    Given User is in home page
    When User clicks meal section
    Then It should display the unit as "g"

  Scenario: Verify unit of measurement for Protein is in grams
    Given User is in home page
    When User clicks meal section
    Then It should display the unit as "g"

  Scenario: Verify unit of measurement for Fat is in grams
    Given User is in home page
    When User clicks meal section
    Then It should display the unit as "g"

  Scenario: Validate the text "calories" in pre-meal
    Given User is in home page
    When User clicks meal section
    Then User should see text "calories" after the calorie value in pre meal
    
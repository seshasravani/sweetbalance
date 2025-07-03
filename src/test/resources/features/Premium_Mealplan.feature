  Feature: Validation for View Full Meal Plan

  Background:
    Given User clicks view meal plan after reaching home page

  Scenario: Verify each meal section has Pre meal title
    Given User is in View Meal plan
    When User clicks Meal sections
    Then Each meal section should display a pre-meal item with the format "Pre-meal: <followed item by name>"

  Scenario: Verify pre-meal includes description under the item name
    Then Item description should be displayed below the item name

  Scenario: Verify Pre meal calorie in view full plan
    Then Calories value should be displayed

  Scenario: Verify pre meal preparation in view full plan
    Then Preparation instructions displayed if available, if not then "N/A"

  Scenario: Verify Nutrients (Pre-meal portion)
    Then User should see "Nutrients (Pre-meal portion)" heading in full plan

  Scenario: Verify nutrients list (Pre-meal portion)
    Then User should see "carb, protein, fat, fibre"

  Scenario: Verify nutrients value (Pre-meal portion)
    Then User should see value present in all each nutrient

  Scenario: Verify pre-breakfast time
    Then Pre-meal time for Breakfast displayed should be "7:00 AM"

  Scenario: Verify pre-lunch time
    Then Pre-meal time for lunch displayed should be "12:30AM"

  Scenario: Verify pre-dinner time
    Then Pre-meal time for lunch displayed should be "6:30AM"

  Scenario: Verify each meal section has meal title
    Then Each meal section should display a meal item with the format "Mainl: <followed item by name>"

  Scenario: Verify meal includes description under the item name
    Then Item description should be displayed below the item name

  Scenario: Verify meal preparation
    Then Preparation instructions displayed if available, if not then "N/A"

  Scenario: Verify Nutrients information
    Then User should see "Nutrients information" heading in full plan

  Scenario: Verify meal total calorie
    Then Total Calories value should be displayed

  Scenario: Verify nutrients list (meal portion)
    Then User should see "carb, protein, fat, fibre"

  Scenario: Verify nutrients value (meal portion)
    Then User should see value present in all each nutrient

  Scenario: Verify ingredients details present in main meal
    Then User should see ingredients list for the main meal

  Scenario: Verify Diabetes Management Tips heading
    Then User should see heading "Diabetes Management Tips"

  Scenario: Verify tips description
    Then User should see tips under diabetes tips

  Scenario: Verify "Glycemic Impact:"
    Then User should see text "Glycemic Impact:"

  Scenario: Verify impact value
    Then User should see impact value

  Scenario: Validate impact value
    Then Impact value should be low/medium/high

  Scenario: Validate back to plan button
    Given User is in view full plan page
    When User clicks back to plan button
    Then User should redirected to Home page

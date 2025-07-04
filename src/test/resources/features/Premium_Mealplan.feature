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
    Then User should see list "carb, protein, fat, fibre"

  Scenario: Verify meal includes description under the item name
    Then Item description should be displayed below the item name

  Scenario: Verify meal preparation
    Then Preparation instructions displayed if available, if not then "N/A"

  Scenario: Verify Nutrients information
    Then User should see "Nutrients information" heading in full plan

  Scenario: Verify nutrients list (meal portion)
    Then User should see "carb, protein, fat, fibre"

  Scenario: Verify Diabetes Management Tips heading
    Then User should see heading "Diabetes Management Tips"

  Scenario: Validate back to plan button
    Given User is in view full plan page
    When User clicks back to plan button
    Then User should redirected to Home page

@PremiumUser_LogbookMealAndNutrition
Feature: Premium User Logbook Functionality for Meal and Nutrition

  Background:
    Given User is Logged into the app
  
  
  Scenario: Verify presence of Meal & Nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see Meal & Nutrition Section 
    
  Scenario: Verify title of Meal & Nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see Title "Meal & Nutrition"
    
  Scenario: Verify icon for Meal & Nutrition section is displayed
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see Icon  on the left side of "Meal & Nutrition" title
    
  Scenario: Verify the presence of 7-day aggregate nutrition section in Meal & Nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the section "7-Day Aggregate Nutrition"
    
  Scenario: Verify the presence of Daily Nutrition breakdown in Meal & Nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the section "Daily Nutrition breakdown"
    
  Scenario: Verify text color of Carbs in 7-day aggregate nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see carbs text colour pink
    
  Scenario: Verify text color of Protein in 7-day aggregate nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see protein Text colour blue
    
  Scenario: Verify text color of Fats in 7-day aggregate nutrition section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see Fats text colour yellow
    
  Scenario: Verify last 7 days are displayed on X-axis in Daily Nutrition breakdown section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the X-axis display the last 7 days ending today
    
    
  Scenario: Verify bar chart behavior when user has not logged any meals
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see no bars in Daily Nutrition breakdown section
    
  Scenario: Verify pie chart is hidden when user has not logged any meals
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should not see any pie chart in 7-day aggregate Nutrition section
    
  Scenario: Verify Carbs card displays 0g and 0%  in Daily nutrition breakdown section when there is no logs
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the Carbs card  displayed "0g (0%)"
    
  Scenario: Verify Protein card displays 0g and 0% in Daily nutrition breakdown section when there is no logs
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the protein card  displayed "0g (0%)"
    
  Scenario: Verify Fats card displays 0g and 0% in Daily nutrition breakdown section when there is no logs
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the fats card  displayed "0g (0%)"
      
  Scenario: Verify bar chart behavior when user has logged meals
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see Bars with nutrient distribution
    
  Scenario: Verify pie chart is visible when user has logged meals
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see pie chart displayed with nutrient distribution
    
  Scenario: Verify Carbs card displays correct value in Daily nutrition breakdown section when there is  logs
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see the value in the carbs card
    
  Scenario: Verify protein card displays correct value in Daily nutrition breakdown section when there is  logs
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see the value in protein card
    
    
  Scenario: Verify fats card displays correct value in Daily nutrition breakdown section when there is  logs
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see the value in fats card
    
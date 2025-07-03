@PremiumUser_LogbookLogReview
Feature: Premium User Logbook Functionality for Log Review

  Background:
    Given User is Logged into the app
  
  Scenario: Verify the Title of Log review section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the title "Log Review"
    
  Scenario: Verify table header in log review section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see table header "Date","Blood Glucose","Nutrition","Activity",Medication"
    
  Scenario: Verify log review displays last 7 days of date entries including today
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see date of last seven days including today
    
  Scenario: Verify the display of date format
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the date format as "MMM dd, yyyy"
    
  Scenario: Verify the order of date
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the date ordered in descending order for last 7 days including today
    
  Scenario: Verify the blood glucose value in log review section if there is no log 
    Given User have not log any blood glucose value in home page 
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under blood glucose
    
  Scenario: Verify the nutrient value in log review section if there is no log
    Given User have not log any nutrition value in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under Nutrition value
    
  Scenario: Verify the physical activity value in log review section if there is no log
    Given User have not log any Physical activity in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under Activity
    
  Scenario: Verify the entries of Medication in log review section if there is no value
    Given User have not log any Medication dosage in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under Medication
    
  Scenario: Verify the blood glucose entries in log review section if there is log
    Given User log blood glucose value in Home page
    When User navigate to logbook page
    Then User should see logged  value for those days under Blood glucose
    
  Scenario: Verify the nutrient value entries in log review section if there is log
    Given User log Nutrient value in Home page
    When User navigate to logbook page
    Then User should see logged value for those days under Nutrient value
    
  Scenario: Verify the physical activity entries in log review section if there is log
    Given User log Physical Activity in home page
    When User navigate to logbook page
    Then User should see logged value  for those days under physical activity
    
  Scenario: Verify the medication value in log review section if there is log
    Given User log Medication dosage in Home page
    When User navigate to logbook page
    Then User should see logged value for those under Medication Dosage
    
  
  
  
    
     

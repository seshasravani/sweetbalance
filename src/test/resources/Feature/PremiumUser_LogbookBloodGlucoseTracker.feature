@PremiumUser_LogbookBloodGlucoseTracker
Feature: Premium User Logbook Functionality for Blood Glucose

  Background:
    Given User is Logged into the app
  
  Scenario: Verify presence of Blood Glucose Tracker section
    Given User is on the homepage
    When User navigate to logbook page 
    Then User should see Blood Glucose Tracker  
    
  Scenario: Verify title of Blood Glucose tracker section
    Given User is on the homepage
    When User navigate to logbook page 
    Then User should see title "Blood Glucose Tracker"
    
  Scenario: Verify colour codes for Fasting 
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see "Fasting" displayed in purple
    
  Scenario: Verify Fasting glucose type range displayed
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the range for "Fasting" be "70-100 mg/dL"
    
  Scenario: Verify colour codes for Pre-Meal
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see "Pre-Meal" displayed in green
    
  Scenario: Verify pre-meal glucose type range displayed
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the range for "pre meal" be "70-130 mg/dL"
    
  Scenario: Verify colour codes for Post-Meal
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see "Post-Meal"  displayed in yellow
    
  Scenario: Verify Post-meal glucose type range displayed
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the range for "post meal" be "<180 mg/dL"
    
  Scenario: Verify colour codes for Bedtime
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see "Bedtime" displayed in red
    
  Scenario: Verify bedtime glucose type range displayed
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the range for "Bedtime" be "100-140 mg/dL"
    
  Scenario: Verify last 7 days are displayed on X-axis
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the X-axis display the last 7 days ending today
    
  Scenario: Verify Y-axis starts at 70 in glucose chart
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see Y-axis minimum value  70
    
  Scenario: Verify Y-axis ends at 180 in glucose chart
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see X-axis Maximum value 180
@PremiumUser_Exercise
Feature: Premium User Exercise Schedule Functionality

  Background:
    Given User is Logged into the app
    
  Scenario: Verify "View Full Schedule" button is displayed
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then "View Full Schedule" button is displayed on the right
    
  Scenario: Verify navigation to "Today's Exercise Schedule" page
    Given User is on the homepage
    When User clicks the "View Full Schedule" button
    Then User is redirected to "Today's Exercise Schedule" page
    
  Scenario: Verify "Warm Up" tab is displayed
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then "Warm Up" tab is visible
    
  Scenario: Verify "Main Workout" tab is displayed
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then "Main Workout" tab is visible
    
  Scenario: Verify "Cool Down" tab is displayed
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then "Cool Down" tab is visible
    
  Scenario: Verify Exercise name is displayed under "Warm Up" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Exercise name is displayed under "Warm Up" tab
    
  Scenario: Verify Exercise name is displayed under "Main Workout" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Exercise name is displayed under "Main Workout" tab
    
  Scenario: Verify Exercise name is displayed under "Cool Down" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Exercise name is displayed under "Cool Down" tab
    
  Scenario: Verify Exercise description is displayed under "Warm Up" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Description is shown below the Exercise name under "Warm Up"
    
  Scenario: Verify Exercise description is displayed under "Main Workout" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Description is shown below the Exercise name under "Main Workout"
    
  Scenario: Verify Exercise description is displayed under "Cool Down" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Description is shown below the Exercise name under "Cool Down"
    
  Scenario: Verify duration is displayed under "Warm Up" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Duration is displayed under "Warm Up" tab
    
  Scenario: Verify calories are displayed under "Warm Up" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Calories are displayed under "Warm Up" tab
    
  Scenario: Verify intensity level is displayed under "Warm Up" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Intensity level is displayed under "Warm Up" tab
    
    
  Scenario: Verify duration is displayed under "Main Workout" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Duration is displayed under "Main Workout" tab

       
  Scenario: Verify calories are displayed under "Main Workout" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Calories are displayed under "Main Workout" tab
    
   
  Scenario: Verify intensity level is displayed under "Main Workout" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Intensity level is displayed under "Main Workout" tab
    
    
  Scenario: Verify duration is displayed under "Cool Down" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Duration is displayed under "Cool Down" tab
    
    
  Scenario: Verify calories are displayed under "Cool Down" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Calories are displayed under "Cool Down" tab
    
    
  Scenario: Verify intensity level is displayed under "Cool Down" tab
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then Intensity level is displayed under "Cool Down" tab
    
  Scenario: Verify "Mark As Completed" button is displayed
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then "Mark As Completed" button is displayed for all three sections
    
  Scenario: Verify success dialog is shown after marking as completed
    Given User is on the homepage
    When User clicks the "Mark As Completed" button
    Then Success dialog is shown
    
  Scenario: Verify button status changes to "Completed"
    Given User is on the homepage
    When User clicks the "Mark As Completed" button
    Then Button changes to "Completed"
    
  Scenario: Verify undo option is displayed after marking completed
    Given User is on the homepage
    When User clicks the "Mark As Completed" button
    Then Undo option is visible
    
  Scenario: Verify button reverts back after undo
    Given User is in the Exercise section 
    When User clicks Undo after marking Exercise as completed
    Then Button changes back to "Mark As Completed"
    
  Scenario: Verify navigation to "View full schedule"
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then User should redirect to Exercise schedule
    
  Scenario: Verify page title is displayed
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then User should see title "Today's Exercise Schedule"
    
  Scenario: Verify "Back to Home" button is visible
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then User should see "Back to Home" button in Today's Exercise schedule page
    
  Scenario: Verify "Warm Up" section is displayed
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Warm Up" section should be visible
    
  Scenario: Verify warm-up exercise name
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then Exercise name should be visible
    
  Scenario: Verify warm-up exercise description
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Warm Up" Exercise description should be visible
    
  Scenario: Verify warm-up duration
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Warm Up" Exercise durations should be visible
    
  Scenario: Verify warm-up calories
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Warm Up" Exercise calories should be visible
    
  Scenario: Verify warm-up intensity
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Warm Up" Exercise intensity should be visible
    
  Scenario: Verify "Main Workout" section is displayed
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Main Workout" section should be visible
    
  Scenario: Verify Main Workout exercise name
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Main Workout" Exercise name should be visible
    
  Scenario: Verify Main Workout exercise description
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Main Workout" Exercise description should be visible
    
  Scenario: Verify Main Workout duration
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Main Workout" Exercise durations should be visible
    
  Scenario: Verify Main Workout calories
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Main Workout" Exercise calories should be visible
    
  Scenario: Verify Main Workout intensity
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Main Workout" Exercise intensity should be visible
    
  Scenario: Verify "Cool Down" section is displayed
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Cool Down" section should be visible
    
  Scenario: Verify Cool Down exercise name
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Cool Down" Exercise name should be visible
    
  Scenario: Verify Cool Down exercise description
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Cool Down" Exercise description should be visible
    
  Scenario: Verify Cool Down duration
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Cool Down" Exercise durations should be visible
    
  Scenario: Verify Cool Down calories
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Cool Down" Exercise calories should be visible
    
  Scenario: Verify Cool Down intensity
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then "Cool Down" Exercise intensity should be visible
    
  Scenario: Verify the intensity value
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then Exercise intensity should low/medium/hard
    
  Scenario: Verify total duration is displayed
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then total duration should be displayed
    
  Scenario: Verify total duration matches the sum of individual workout durations
    Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then total duration should equal the sum of all individual durations
    
  Scenario: Verify total calories matches the sum of individual workout calories
  Given User is in the Exercise section 
    When User clicks "view full schedule"
    Then total calories should equal the sum of all individual calories
    
  
    


















    
  
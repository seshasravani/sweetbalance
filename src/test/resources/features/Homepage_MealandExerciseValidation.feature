Feature: Meal and Exercise Section Validation for Registered Free Account User

  Background:
    Given User logs into the app
    Given User is in home page
     
  Scenario: Verify the presence of "Nutrition Insights" heading 
    When User clicks meal section
    Then User should see "Nutrition Insights" heading for each of the meal section

  Scenario: Verify the presence of Carbs value for nutrition
    Then User should see Carbs value for the main 

  Scenario: Verify the presence of Protein value for nutrition
    Then User should see Protein value for the main
    
  Scenario: Verify the presence of Fat value for nutrition
    Then User should see Fat value for the main meal
    
    Scenario: Verify the time format in pre-meal snack
    Then User should see "hh:mm" based time in pre-meal snack (eg: 1:00)

  Scenario: Verify the time in pre-snack
    Then User should see 3 o'clock
    
    Scenario: Verify the navigation of "View Full Plan" button
    When User clicks "View Full Plan" button
    Then User should be redirected to subscription page

  Scenario: Verify the title in Exercise section
    When User clicks exercise section
    Then User should see title "Today's Exercise Plan"

  Scenario: Verify the presence of exercise list
    Then User should see exercises list for the day
    
    Scenario: Verify the presence of time in each exercise
    Then User should see scheduled time of each exercise

  Scenario: Verify the time for morning exercise
    Then Morning exercise should be scheduled for 7 o'clock

  Scenario: Verify the time for evening exercise
    Then Evening exercise should be scheduled for 5 o'clock

  
  Scenario: Verify the title for each exercise plan
    Then User should see plan title for each exercise

  Scenario: Verify the presence of duration in each exercise plan
    Then User should see a duration in each exercise item

  Scenario: Verify the presence of "View Full Schedule" button
    Then User should see button with text "View Full Schedule"

  Scenario: Verify the navigation of "View Full Schedule" button
    When User clicks view full schedule button after reaching exercise section
    Then User should be redirected to subscription page
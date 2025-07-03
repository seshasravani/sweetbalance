Feature: Validation for home page - Registered user

  Background: 
    Given User is in password auth page

  Scenario: Verify App name after sign in
    When User clicks sign in after entering password
    Then User should see SweetBalance text on the left side of the page

  Scenario: Verify user name in home page
    When User clicks sign in after entering password
    Then User should see name displayed at the top-right corner of the home page

  Scenario: Verify the presence of logout link
    When User clicks sign in after entering password
    Then User should see Logout link in the top-right corner
    
   Scenario: Verify the presence of top navigation bar
    When User clicks sign in after entering password
    Then User should see top navigation bar on the page

  Scenario: Verify the presence of Home text in navigation bar
    When User clicks sign in after entering password
    Then User should see "Home" tab in the top navigation bar

  Scenario: Verify the presence of Dashboard text in navigation bar
    When User clicks sign in after entering password
    Then User should see "Dashboard" tab in the top navigation bar

  Scenario: Verify the presence of Education text in navigation bar
    When User clicks sign in after entering password
    Then User should see "Education" tab in the top navigation bar

   Scenario: Verify the text "Current status" in home page
    When User clicks sign in after entering password
    Then User should see "Current Status" section heading on the home page

  Scenario: Verify the text "Last updated" in home page
    When User clicks sign in after entering password
    Then User should see "Last updated" label below Current Status
   
  Scenario: Verify the time for last update in home page
    When User clicks sign in after entering password
    Then User should see timestamp displayed next to the "Last updated" label

  Scenario: Verify the time format for last update
    When User clicks sign in after entering password
    Then User should see last updated timestamp in 12-hour format as hh:mm:ss or relative format like "3 min ago" or "2 hr ago"

  Scenario: Verify 12-hour clock indicator is visible
    When User clicks sign in after entering password
    Then User should see 12-hour clock indicator with AM/PM 
    
   Scenario: Verify Latest HbA1C label is visible
    When User clicks sign in after entering password
    Then User should see "Latest HbA1C" label

  Scenario: Verify BMI label is visible
    When User clicks sign in after entering password
    Then User should see "BMI" label

  Scenario: Verify Average Blood Sugar label is visible
    When User clicks sign in after entering password
    Then User should see "Average Blood Sugar" label 
    
    Scenario: Verify condition text for HbA1C value less than 5.7
    When User clicks sign in after entering password
    Then User should see "Normal" as the condition text

  Scenario: Verify condition text for HbA1C between 5.7 and 6.4
    When User clicks sign in after entering password
    Then User should see "Pre-diabetic" as the condition text

  Scenario: Verify condition text for HbA1C greater than or equal 6.5
    When User clicks sign in after entering password
    Then User should see "Diabetic" as the condition text
    
    Scenario: Verify BMI text for value less than 18.5
    When User clicks sign in after entering password
    Then User should see "Underweight" as the BMI category

  Scenario: Verify BMI text for value between 18.5 and 24.9
    When User clicks sign in after entering password
    Then User should see "Normal" as the BMI category

  Scenario: Verify BMI text for value between 25.0 and 29.9
    When User clicks sign in after entering password
    Then User should see "Overweight" as the BMI category

  Scenario: Verify BMI text for value 30.0 or above
    When User clicks sign in after entering password
    Then User should see "Obese" as the BMI category
    
  Scenario: Verify units for average blood sugar
    When User clicks sign in after entering password
    Then User should see mg/dL unit below Average Blood Sugar
    
    Scenario: Verify title in flex container
    When User clicks sign in after entering password
    Then User should see "Today's Meal Plan" title

  Scenario: Verify "Today’s Meal Plan" section is visible
    When User clicks sign in after entering password
    Then User should see tabs: Breakfast, Lunch, Dinner, Snacks

  Scenario: Verify Breakfast tab is selected by default
    When User clicks sign in after entering password
    Then "Breakfast" tab should be selected by default

  Scenario: Verify the presence of side tab in flex container
    When User clicks sign in after entering password
    Then User should see sidebar tab container within the flex layout

  Scenario: Verify the text "Meal plan" in flex container
    When User clicks sign in after entering password
    Then User should see "Meal Plan" label in the sidebar section

  Scenario: Verify the text "Exercise" in flex container
    When User clicks sign in after entering password
    Then User should see "Exercise" label in the sidebar section

  Scenario: Verify the symbol utensil cross in "Meal plan"
    When User clicks sign in after entering password
    Then User should see utensil icon (crossed fork and knife) in the Meal Plan tab

  Scenario: Verify the symbol dumbbell in "Exercise"
    When User clicks sign in after entering password
    Then User should see dumbbell icon in the Exercise tab

  Scenario: Verify View Full Plan button is visible
    When User clicks sign in after entering password
    Then User should see "View Full Plan" button in the Meal Plan section
   

     
    
   
    
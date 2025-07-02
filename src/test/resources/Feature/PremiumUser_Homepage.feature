Feature: Home Page Validation for Registered Premium Account User

  Background: 
    Given the user is in password auth page
    When the user clicks sign in after entering password

  Scenario: Verify order of text in navigation bar
    Then the user should see the navigation bar displaying items in the order: Home, Logbook, Dashboard, Education

  Scenario: Verify the presence of animation in challenge yourself button
    Then the user should see flashing challenge yourself button

  Scenario: Verify the duration of animation
    Then the button should flash in 0.2 seconds

  Scenario: Verify the presence of Challenge yourself today button
    Then the user should see a "Challenge yourself today!" button

  Scenario: Verify the presence of gender image in the grid
    Then the user should see a gender-specific image based on the gender selected during onboarding

  Scenario: Verify the presence of emoji on top right of gender image
    Then the user should see an emoji displayed on the top-right corner of the gender image

  Scenario: Verify the label for gender image
    Then the user should see label "Mood:" below the gender image

  Scenario: Verify the presence of log button
    Then the user should see log button under gender image

  Scenario: Verify display mood text based on emoji
    Then the user should see mood text based on the emoji

  Scenario: Verify the presence of Weekly plan button
    Then the user should see Week plan button

  Scenario: Verify the presence of "Record New Data" in the bottom
    Then the user should see "Record New Data" text

  Scenario: Verify the presence of 4 button option below Record New Data
    Then the user should see 4 button options

  Scenario: Verify the first button text "Blood Glucose"
    Then the user should see text Blood Glucose

  Scenario: Verify the second button text "Physical Activity"
    Then the user should see text Physical Activity

  Scenario: Verify the third button text "Food Intake"
    Then the user should see text Food Intake

  Scenario: Verify the fourth button text "Medication"	
    Then the user should see text Medication

  Scenario: Verify icon for Blood Glucose
    Then the user should see Activity icon in Blood Glucose

  Scenario: Verify icon for Physical Activity
    Then the user should see Running icon in Physical Activity

  Scenario: Verify icon for Food Intake
    Then the user should see Pizza icon in Food Intake

  Scenario: Verify icon for Medication
    Then the user should see Pill icon in Medication
    
   
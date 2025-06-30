Feature: Verification on button navigation in home page

  Background:
    Given User logged onto the application

  Scenario: Verify user able to download weekly plan
    Given User is in home page
    When User clicks Weekly plan
    Then User should get pdf download of weekly plan

  Scenario: Verify the navigation of Blood Glucose button
    When User clicks on Blood glucose button
    Then User should redirect to Blood Glucose popup window

  Scenario: Verify the navigation of Physical Activity button
    When User clicks on physical activity button
    Then User should redirect to physical activity popup window

  Scenario: Verify the navigation of Food Intake button
    When User clicks on food intake button
    Then User should redirect to food intake popup window

  Scenario: Verify the navigation of Medication button
    When User clicks on medication button
    Then User should redirect to medication popup window

  Scenario: Verify the navigation of log button
    When User clicks log button
    Then User should redirected to dashboard page

    
    #Feature: verification on log status
    #Background: User clicked log button after reaching home page 
    #Scenario: Verify user able to change the log 
    #Given User is in dashboard page
    #When User clicks home tab after logging emotional state in dashboard
    #Then User should see emoji and mood text is changed 

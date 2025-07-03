   Feature: verification on log status
   
    Background: User clicked log button after reaching home page 
    
    Scenario: Verify user able to change the log 
    Given User is in dashboard page
    When User clicks home tab after logging emotional state in dashboard
    Then User should see emoji and mood text is changed
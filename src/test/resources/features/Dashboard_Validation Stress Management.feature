Feature: Validation on Stress Management Technique Section for Registered Free user dashboard page

  Background:
    Given User is in Home Page after logged in
    And User is in the Dashboard Page

  Scenario: Verify the header Stress Management Techniques
    When User scrolls to the Stress Management section
    Then User should see the Title "Stress Management Techniques"

  Scenario: Verify the navigation bar order
    Then User should see tabs "Meditation", "Breathing", "Movement" and "Mindfulness"

 Scenario: Verify tab navigation
    When User clicks on each tab
    Then User should see corresponding display section
    
   Scenario: Verify Guided Meditation section is visible
    When User clicks Meditation tab
    Then User should see the content with title "Guided Meditation"
    
    Scenario: Verify audio playback functionality
    When User clicks audio play button
    Then User Should see meditation audio should start playing and the progress bar should update accordingly

  Scenario: Verify the Title displayed under Movement tab
    When User clicks Movement Tab
    Then User should see title "Gentle Movement"
    
    Scenario: Verify the title under Mindfulness tab
    When User clicks Mindfulness tab
    Then User should see title "Present Moment Awareness"
    
    Scenario: Verify heading and description is displayed under Breathing tab
    When User clicks breathing tab under stress management techniques
    Then User should see the heading "4-7-8 Breathing Technique"
    And User should see the description "A natural tranquilizer for the nervous system"
    
    
  Scenario: Verify Start button is displayed under Breathing tab
    Then User should see the "Start Breathing Exercise" button

  Scenario: Verify Cycle completed counter is displayed
    Then User should see the "Cycles completed" counter text and value starting at 0

  Scenario: Verify current phase counter is displayed
    Then User should see the label 'Current phase' with a hyphen (-) as its current value
    
    Scenario: Verify stop button of breathing exercise
    When User clicks the "Stop" button during the breathing exercise
    Then User should see breathing exercise stops
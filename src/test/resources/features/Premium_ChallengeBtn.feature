Feature: Homepage Challenge Button Functionality

  Background: 
    Given User is logged into app

  Scenario: Verify the navigation of the Challenge button
    When User clicks Challenge button
    Then User should get pop window

  Scenario: Verify the title of the popup
    When User clicks Challenge button
    Then User should see title "Choose Your Challenge"

  Scenario: Verify the subtext in the popup
    When User clicks Challenge button
    Then User should see sub text "Select a program that best fits your health goals"

  Scenario: Verify the presence of two option buttons
    When User clicks Challenge button
    Then User should see two options for challenge option

  Scenario: Verify the first option text
    When User clicks Challenge button
    Then User should see "10-Day Challenge Postprandial Blood Glucose Reduction" as first option

  Scenario: Verify the second option text
    When User clicks Challenge button
    Then User should see "4-Week Program Blood Sugar Reduction Plan" as first option

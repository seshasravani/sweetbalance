Feature: Home Page Validation for Registered Free Account User

  Background:
    Given User is in password auth page

  Scenario: Verify order of text in navigation bar
    When User clicks sign in after entering password
    Then User should see the navigation bar displaying items in the order: Home, Dashboard, Education

  Scenario: Verify the presence of collapse toggle
    Then User should see a caret toggle icon next to the "Today's Meal Plan" title

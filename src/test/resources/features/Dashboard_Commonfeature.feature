Feature: Dashboard page validation for Registered Free account user

  Background: 
    Given User logged into the app

  Scenario: Verify the Welcome Message is displayed with name
    Given User is in Home Page
    When User clicks the Dashboard on the navigation bar
    Then User should see the "Welcome Back,full name" message

  Scenario: Verify the text is displayed below welcome message
    Then User should see the text "Track your metrics, manage your diet, and stay healthy with our comprehensive tools."

  Scenario: Verify Upgrade to premium button is visible
    Then User should see "Upgrade to Premium" button

  Scenario: Verify the header Account Information is present
    Then User should see the header "Account Information" with correct spelling

  Scenario: Verify Save Changes button is visible
    Then User should see "Save Changes" button

  Scenario: Verify all the fields under Account Information are Displayed
    Then User should see all the fields under Account Information section

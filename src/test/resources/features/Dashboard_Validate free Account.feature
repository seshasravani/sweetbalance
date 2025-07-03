Feature: Validation on Account Information section for registered free user dashboard page

  Background:
    Given User is in Home Page after logged in
    And User is in Dashboard page

  Scenario: Verify age should accept only Numeric Value
    When User edit age field with valid data
    Then User should see that entered age is displayed in that field

  Scenario: Verify height should accept only Numeric Value
    When User Edit height field with valid data
    Then User should see that entered height is displayed in Height field

  Scenario: Verify Weight should accept only Numeric Value
    When User Edit Weight field with valid data
    Then User should see that entered weight is displayed in Weight field

  Scenario: Verify Exercise Routine Level dropdown is displayed with options
    When User clicks the dropdown of Exercise Routine Level
    Then User should see the dropdown with options "Easy","Medium","Hard"

  Scenario: Verify Cuisine Preferences dropdown is displayed with options
    When User clicks the dropdown of Cuisine Preferences
    Then User should see the dropdown with list of cuisine types "Indian","American","Continental","Mediterranean","Asian","Middle Eastern","Mexican"

  Scenario: Verify Food Allergies dropdown is displayed with options
    When User clicks the dropdown of Food Allergies
    Then User should see the dropdown list of common allergy options "None","Dairy","Gluten","Shellfish","Soy","Eggs","Nuts","Other"

  Scenario: Verify account details cannot be updated with invalid data
    When User edit with invalid data and click save changes
    Then User should see Error message

  Scenario: Verify account details can be updated with valid data
    When User edit all fields and click Save Changes
    Then User should see messages "Changes Saved Your profile has been updated successfully!"

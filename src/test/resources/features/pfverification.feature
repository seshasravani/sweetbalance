#Author: Sravani
Feature: Profile Form Verification

  Background:
    Given User is on complete profile form page

  Scenario: Verify Create Account button is enabled after valid input
    When cp User clicks continue with email button after entering a valid new email
    And User checks the Terms & conditions box after filling all fields
    Then Create Account button should be enabled

  Scenario: Verify Create Account form with valid data
    When User clicks create account button after filling valid data in all fields
    Then User should redirected to upload blood report

 Scenario: Verify Create Account form with invalid data
    When User clicks create account button after filling invalid data
    Then User should see error message

  Scenario: Verify presence of Upload Blood Report button
    When User clicks create account button after filling valid data in all fields
    Then User should see Upload Blood Report button

  Scenario: Verify presence of Step Through Onboarding button
    When User clicks create account button after filling valid data in all fields
    Then User should see Step Through Onboarding button

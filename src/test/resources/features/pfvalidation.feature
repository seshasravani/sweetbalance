#Author: Sravani
Feature: Complete Profile Form validation for new user

Background: User is on login page after clicking login in launch page

Given User is on the login page

When User clicks continue with email button after entering a valid new email



Scenario: User is on login page after clicking login in launch page
Then Full Name input field should be displayed


Scenario: Verify Username field is visible
Then Username input field for profile validation should be displayed

Scenario: Verify Password field is visible
Then Password input field should be displayed

Scenario: Verify Terms & Conditions checkbox is visible
Then Terms & Conditions checkbox should be displayed

Scenario: Verify Create Account button is disabled initially
Then Create Account button should be disabled











#Author: Sravani
Feature: Login Page UI Verification

Scenario: Verify login form header is played

Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see Welcome back heading

Scenario: Verify sub text of the header
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see Sign in to your account or create a new one

Scenario: Verify the presence of close button
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see close button at the right corner

Scenario: Verify the presence of close button
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see an input field to enter email

Scenario: Verify email input field is displayed
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see an input field to enter email

Scenario: Validate placeholder text in email field
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see text Enter Email in email field placeholder 

Scenario: Verify Continue with Email button is displayed
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see a Continue with email button

Scenario: Verify Continue with Email button is enabled
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see Continue with email button to be enabled

Scenario: Verify Continue with Google button is displayed
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see a Continue with Google button

Scenario: Verify OR separator is visible
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see an OR separator

Scenario: Verify Terms and Privacy message is displayed
Given User is on SweetBalance homepage
When User clicks on Login link
Then User should see By continuing you agree to our T&C and Privacy






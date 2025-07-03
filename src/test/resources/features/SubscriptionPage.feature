Feature: Subscription page validation

Background: User completes onboarding process

Given User is in the homepage
When User clicks view full plan button in homepage

Scenario: Verify Daily Meal Plan availability
Then Both Free and Premium should show Daily Meal Plan as available

Scenario: Verify Weekly Meal Plan availability
Then Weekly Meal Plan should be available only in Premium

Scenario: Verify Personalized Exercise Plan availability
Then Personalized Exercise Plan should be available only in Premium

Scenario: Verify 10-Day Quick Reversal Plan availability
Then 10-Day Quick Reversal Plan should be available only in Premium

Scenario: Verify 30-Day Blood Sugar Reduction Plan
Then 30-Day Blood Sugar Reduction Plan should be available only in Premium

Scenario: Verify Glucose Level Graph availability
Then Both Free and Premium should show Glucose Level Graph as available

Scenario: Verify BMI Calculation availability
Then Both Free and Premium should show BMI Calculation as available

Scenario: Verify Downloadable Meal Plan PDF availability
Then Downloadable Meal Plan PDF should be available only in Premium

Scenario: Verify Reminders availability
Then Reminders should be available only in Premium

Scenario: Verify Continue free button is visible
Then The "Continue free" button should be visible

Scenario: Verify Upgrade to Premium button is visible
Then The "Upgrade to Premium" button should be visible

Scenario: Verify Free Account label
Then It should display "Free Account" 

Scenario: Verify Premium Account label 
Then It should display "Premium Account" 

Scenario: Verify unavailable features are marked with gray X
Then Features not included should have gray X icons

Scenario: Verify available features are marked with purple tick
Then All included features should have purple checkmarks

Scenario: Verify total number of features listed
Then It should list exactly 9 features

Scenario: Verify position of Continue free button
Then "Continue free" button should appear 

Scenario: Verify position of Upgrade to Premium button
Then "Upgrade to Premium" button should appear

Scenario: Verify terms and conditions text is visible
Then Terms & Conditions and Privacy Policy text should be visible

Scenario: Verify upgrade message header is displayed
Then It should show the text “Upgrade to premium for complete diabetes management”

Scenario: Verify visual separation between Free and Premium plans
Then The Free and Premium plans should be displayed side-by-side in clearly separated columns
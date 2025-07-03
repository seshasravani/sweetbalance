Feature: Post-Onboarding Navigation and Upgrade Flow

Background: User clicks submit / continue after completing onboarding process
Given User is in upgrade page

Scenario: Verify user able to go to subscription payment screen
When User clicks the "Upgrade to Premium" button
Then User should be redirected to the subscription payment screen

Scenario: Verify title of Upgrade screen
When User clicks the "Upgrade to Premium" button
Then Page title should be "Upgrade to Premium"

Scenario: Verify sub text 
When User clicks the "Upgrade to Premium" button
Then User should see "Get personalized insights and advanced features to better manage your diabetes."

Scenario: Verify the presence of "premium features" 
When User clicks the "Upgrade to Premium" button
Then User should see text "premium features"

Scenario: verify the description for premium feature 
When User clicks the "Upgrade to Premium" button
Then User should see text "✓Personalized meal plans,✓Advanced analytics,✓Priority support"

Scenario: verify the presence of subscription price
When User clicks the "Upgrade to Premium" button
Then User should see "$9.99/month"

Scenario: verify the presence of cancel anytime text
When User clicks the "Upgrade to Premium" button
Then User should see cancel anytime text below the pricing details

Scenario: Verify the presence of "Card Number"
When User clicks the "Upgrade to Premium" button
Then User should see heading "Card Number"

Scenario: Verify the presence of fields in payment
When User clicks the "Upgrade to Premium" button
Then User should see card number, expiration , cvv field

Scenario: Verify  presence of payment button
When User clicks the "Upgrade to Premium" button
Then User should see "Pay $9.99 USD" button

Scenario: Verify  terms and renewal message
When User clicks the "Upgrade to Premium" button
Then User should see terms of service and auto-renewal notice 

Scenario: Verify the presence of terms and auto-renewal note
When User clicks the "Upgrade to Premium" button
Then User should see "By completing this purchase, you agree to our Terms of Service and Privacy Policy. Your subscription will automatically renew each month until cancelled."

Scenario: Verify user able to go to home page
When user clicks the "Continue free" button
Then User should be redirected to the home page


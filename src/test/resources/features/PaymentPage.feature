Feature: Upgrade to Premium Subscription

  Background:
    Given User is on the subscription page
    And User clicks the "Upgrade to Premium" button

  Scenario: Verify user is unable to proceed with empty payment fields
    When User clicks the "Pay $9.99 USD" button without entering any card details
    Then User should see validation messages for all required fields

  Scenario: Verify user is unable to proceed with invalid card number
    When User enters an invalid card number
    And User clicks the "Pay $9.99 USD" button
    Then Error message should be displayed for invalid card number

  Scenario: Verify user is unable to proceed with expired card
    When User enters an expired card
    And User clicks the "Pay $9.99 USD" button
    Then Error message should be displayed for expired card

  Scenario: Verify user can successfully upgrade with valid payment details
    When User enters valid payment details
    And User clicks the "Pay $9.99 USD" button
    Then User should be redirected to the confirmation or home page with premium access enabled

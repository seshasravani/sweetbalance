Feature: Login page field and functional Validation

Background: User clicked login button after reaching SweetBalance app homepage

Scenario: Verify email input accepts valid existing email

Given User is on the login page
When Registered user clicks continue with email button after entering a valid existing email
Then User should get password field



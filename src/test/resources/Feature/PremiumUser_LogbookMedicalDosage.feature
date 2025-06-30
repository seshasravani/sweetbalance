@PremiumUser_LogbookMedicalDosage
Feature: Premium User Logbook Functionality for Medical Dosage

  Background:
    Given User is Logged into the app
    
  Scenario: Verify the presence of Medical Dosage section
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the section Medical Dosage
    
  Scenario: Verify the title "Medical dosage"
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the title "Medical Dosage"
    
  Scenario: Verify the icon beside medical dosage
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the icon on left side of title
    
  Scenario: Verify the Y-axis has text "Number of Doses"
    Given User is on the homepage
    When User navigate to logbook page
    Then User should see the text "Number of Doses"on Y-axis
    
  Scenario: Verify display empty chart when no medication is scheduled
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see no bars in the chart
    
  Scenario: Verify Total scheduled will display 0 doses, if no medication is scheduled
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see "0 doses"  value in the Total scheduled statistics
     
  Scenario: Verify Doses Taken will display 0 doses , if no medication is displayed
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see "0 doses" value in the Doses taken statistics
    
  Scenario: Verify Doses Missed will display 0 doses, if no Medication is displayed
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see "0 doses" value in the Doses Missed statistics
    
  Scenario: Verify the colour of Total Scheduled text
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see purple colour text
    
  Scenario: Verify the colour of Doses Taken text
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see green colour text
    
  Scenario: Verify the colour of Doses Missed text
    Given User has not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see yellow colour text
    
  
  Scenario: verify green colour bar is displayed for doses taken on one week schedule
    Given User has taken the scheduled dose for a day
    When User navigate to logbook page
    Then User should see green colour bar for that day 

  Scenario: Verify red colour bard is displayed for doses missed on one week schedule
    Given User has taken the scheduled dose for a day
    When User navigate to logbook page
    Then User should see red colour bar for that day
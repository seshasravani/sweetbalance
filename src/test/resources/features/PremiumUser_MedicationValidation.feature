Feature: Medication Tracker Validation

  Background:
    Given the user is on the home page after logging into the app

  # --- UI Verification ---

  Scenario: Verify title in Medication form
    When the user clicks Medication
    Then the user should see title "Diabetes Medication Tracker" after medication pop

  Scenario: Verify subtext in form
    Then the user should see subtext "Keep track of your medications and never miss a dose"

  Scenario: Verify the heading in form
    Then the user should see heading "Your Medications"

  Scenario: Verify the heading in flex
    Then the user should see heading "Today's Medications" in flex

  Scenario: Verify the presence of date picker
    Then the user should see date picker in tracker

  Scenario: Verify the default value in datepicker
    Then the user should see today's date as default value in datepicker

  Scenario: Verify message if no medication is added
    Then the user should see message "No medications added yet\nClick the 'Add Medication' button to get started"

  Scenario: Verify the presence of Add Medication button
    Then the user should see Add medication button

  Scenario: Verify the presence of Close button
    Then the user should see Close button in the form

  # --- Add Medication Form Validation ---

  Scenario: Verify presence of iframe
    When the user clicks Add Medication
    Then the user should see iframe

  Scenario: Verify the presence of Cancel button
    Then the user should see Cancel button

  Scenario: Verify heading in iframe
    Then the user should see headingafter clicking add medication "Add new medication"

  Scenario: Verify the fields in iframe
    Then the user should see fields "Medication, Dosage, Frequency, Date, Take with food, Notes (optional)"

  Scenario: Verify dropdown in medication field
    Then the user should see dropdown for Medication

  Scenario: Verify options in medication dropdown
    Then the user should see following options in medication dropdown:
      | Select a medication         |
      | Metformin (Oral)           |
      | Glipizide (Oral)           |
      | Januvia (Oral)             |
      | Jardiance (Oral)           |
      | Trulicity (Injectable)     |
      | Insulin Glargine (Injectable) |
      | Insulin Lispro (Injectable)   |
      | Insulin NPH (Injectable)      |
      | Other (Custom Medication)     |

  Scenario: Verify dosage input field
    Then the user should see input field for Dosage

  Scenario: Verify dosage placeholder
    Then the user should see placeholder text "e.g., 500mg or 10 units"

  Scenario: Verify dropdown for frequency
    Then the user should see dropdown for Frequency

  Scenario: Verify options for frequency
    Then the user should see following options in frequency dropdown:
      | Once daily         |
      | Twice daily        |
      | Three times daily  |

  Scenario: Verify checkbox for Take with food
    Then the user should see checkbox for Take with food

  Scenario: Verify text block for Notes
    Then the user should see text block for Notes

  Scenario: Verify Add Medication button
    Then the user should see Add medication button

   #--- Functional Testing ---

  Scenario: Add medication with valid data
    When the user fills out the medication form with valid data
    And clicks Add Medication
    Then the Add Medication button changes to "Adding"
    And the user should be redirected to the tracker page with newly added medication displayed
    And the user should see Remove button next to the added medication
    And the user should see schedule time below the added medication
    And the user should see Mark as Taken button for each schedule

  Scenario: Verify scheduled time for once daily
    When the user selects Once daily in frequency
    Then the user should see Scheduled at 8:00

  Scenario: Verify scheduled time for twice daily
    When the user selects Twice daily in frequency
    Then the user should see Scheduled at 8:00 and 20:00

  Scenario: Verify scheduled time for three times daily
    When the user selects Three times daily in frequency
    Then the user should see Scheduled at 8:00, 14:00, and 20:00

  Scenario: Add medication without dosage
    When the user leaves dosage field blank and clicks Add Medication
    Then the user should see alert message "Error in adding medication Please try again"

  Scenario: Add medication with invalid dosage
    When the user enters invalid dosage and clicks Add Medication
    Then the user should see alert message "Error in adding medication Please try again"

  Scenario: Remove selected medication from dropdown
    When the user selects a medication
    Then the user should see remove icon "X"
    When the user clicks remove icon
    Then the Medication field should show "Select Medication"

   #--- Date Picker Testing ---

  Scenario: Verify datepicker popup
    When the user clicks the date field
    Then the user should see calendar popup

  Scenario: Verify today's date is highlighted
    Then the user should see today's date highlighted in the calendar

  Scenario: Verify presence of previous and next buttons in calendar
    Then the user should see Previous and Next buttons in the date picker

  Scenario: Verify user can select previous date
    When the user selects previous date
    Then the selected date should appear in the date field

  Scenario: Verify note field character limit
    When the user enters more than 250 words in Notes and clicks Add Medication
    Then the user should see error message "Notes cannot exceed 250 words"

   #--- Post-Medication Actions ---

  Scenario: Remove added medication
    When the user clicks Remove button for an added medication
    Then the user should see alert "Are you sure you want to remove this medication? This action cannot be undone."

  Scenario: Confirm medication removal
    When the user accepts the alert
    Then the user should see notification "Medication removed successfully"
    And the medication should no longer be visible in the tracker

  Scenario: Cancel medication removal
    When the user declines the alert
    Then the user should be redirected to the medication tracker

  Scenario: Mark medication as taken
    When the user clicks Mark as Taken button
    Then the medication should be marked as taken

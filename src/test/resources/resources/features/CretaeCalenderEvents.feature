Feature: get page title
@C
  Scenario: to get page title
Given Go to login page
Then Enter valid username  and password
  Then navigate to "Activities" then "Calendar Events"
  And verify pagetitle is "All Calendar Events" displayed

    @AA
    Scenario: find column names
    Given Go to login page
    Then Enter valid username  and password
    Then navigate to "Activities" then "Calendar Events"
    And user verifies that column names are displayed
      | TITLE             |
      | CALENDAR          |
      | START             |
      | END               |
      | RECURRENT         |
      | RECURRENCE        |
      | INVITATION STATUS |
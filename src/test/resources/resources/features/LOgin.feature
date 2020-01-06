Feature: To login page
  @Login
  Scenario: To login valid credentials
    Given Go to login page
    Then Enter valid username  and password
    And verify pagetitle is "Dashboard" displayed
@Regression
Feature: Navigate to the website and validate the home page title and elements

  Scenario: Validate the home page title and the presence of the buttons
    Then home page title should be "TEK Insurance UI"
    And the "Create Primary Account" link is displayed
    And the "Login" link is displayed

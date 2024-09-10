@Regression
Feature: Customer Service Portal Page - Accounts data validation

  Background: Login with CSR credentials
    When user click on "Login" link
    Then validate "Sign in to your Account" title
    When  user enter "supervisor" on field "Username"
    And  user enter "tek_supervisor" on field "Password"
    Then user click on "Sign In" button
    Then validate "Customer Service Portal" account title
    When user click on "Accounts" link


  Scenario: In Customer Service Portal navigate to Accounts page and validate table records
    Then the default number of records per page should be 5


  Scenario Outline: In Customer Service Portal navigate to Accounts page and validate table records
    When the user selects to show <actualSelectRecord> records per page
    Then exactly <expectedTableRow> records should be displayed on the page
    Examples:
      | actualSelectRecord | expectedTableRow |
      | 10                 | 10               |
      | 25                 | 25               |
      | 50                 | 50               |
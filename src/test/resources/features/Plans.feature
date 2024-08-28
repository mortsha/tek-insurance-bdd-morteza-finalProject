@Regression @Plan
Feature: Customer Service Portal Page and validation

  Background: Login with CSR credentials
    When user click on "Login" link
    Then validate "Sign in to your Account" title
    When  user enter "supervisor" on field "Username"
    And  user enter "tek_supervisor" on field "Password"
    Then user click on "Sign In" button
    Then validate "Customer Service Portal" account title

@PlansUS1
  Scenario: Login with CSR Account and validate the data
    When user click on "Plans" link
    Then validate 4 row of data is present

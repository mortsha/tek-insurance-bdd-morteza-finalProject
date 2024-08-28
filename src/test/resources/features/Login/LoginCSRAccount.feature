@Smoke @Regression @Login_US
Feature: Login feature with positive and negative test

  Background: Navigate to login page
    When user click on "Login" link
    Then validate "Sign in to your Account" title

    @Login_US1
  Scenario: Success Login with CSR Account
    When  user enter "supervisor" on field "Username"
    And  user enter "tek_supervisor" on field "Password"
    Then user click on "Sign In" button
    Then validate "Customer Service Portal" account title

  @Login_US2
  Scenario: Success Login to Primary Account
    When  user enter "Steve5670" on field "Username"
    And  user enter "Anything@123" on field "Password"
    Then user click on "Sign In" button
    Then validate "Primary Account Portal" account title

  @Login_US3
  Scenario Outline:  Negative login with invalid credentials
    When  user enter "<Username>" on field "Username"
    And  user enter "<Password>" on field "Password"
    Then user click on "Sign In" button
    Then validate the error message as expected "<ErrorMessage>"

    Examples:
      | Username      | Password      | ErrorMessage                 |
      | wrongUsername | NoPassword    | User wrongUsername not found |
      | supervisor    | wrongPassword | Password not matched         |




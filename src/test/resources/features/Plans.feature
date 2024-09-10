@Smoke @Regression
Feature: Customer Service Portal Account - Plans and validation

  Background: Login with CSR credentials
    When user click on "Login" link
    Then validate "Sign in to your Account" title
    When  user enter "supervisor" on field "Username"
    And  user enter "tek_supervisor" on field "Password"
    Then user click on "Sign In" button
    Then validate "Customer Service Portal" account title
    When user click on "Plans" link

  Scenario: Login with CSR Account and validate the data
    Then validate 4 row of data is present

  Scenario: Validate Created and Expire date on plans page
    Then validate Date Created is today date in EST Time Zone
    Then validate Date Expire is a day after EST Time Zone


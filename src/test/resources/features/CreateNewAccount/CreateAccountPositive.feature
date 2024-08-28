@Smoke @Regression
Feature: Create new Account with Valid data

  Background: Navigate to primary account holder page and fill up the form
    When user click on "Create Primary Account" link
    Then validate "Create Primary Account Holder" title
    When user fill the create new account form
      | EmailAddress     | random     |
      | FirstName        | Steve      |
      | Gender           | Male       |
      | EmploymentStatus | Tester     |
      | Title            | Mr.        |
      | LastName         | Dew        |
      | MaritalStatus    | Single     |
      | DateOfBirth      | 10/10/2000 |


  @UserStory2
  Scenario: Navigate to primary account holder page and fill up the form
    Then user click on "Create Account" button
    Then validate "Sign up your account" title
    Then validate email shows as expected in sign up page


  @UserStory5
  Scenario: Navigate to primary account holder and create a valid account
    Then user click on "Create Account" button
    And validate "Sign up your account" title
    And validate email shows as expected in sign up page
    When  user enter "username" on field "Username"
    And  user enter "Anything@123" on field "Password"
    And  user enter "Anything@123" on field "Confirm"
    Then user click on "Submit" button
    When user wait 3 seconds to redirect to sign in page
    Then validate sign in  "Sign in to your Account" title
    And user enter "username" on field "Username"
    And  user enter "Anything@123" on field "Password"
    Then user click on "Sign In" button
    Then validate "Primary Account Portal" account title
    When user click on "Profile" button
    Then validate full name displayed at Profile Section



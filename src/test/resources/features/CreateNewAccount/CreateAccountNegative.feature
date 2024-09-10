@Smoke @Regression
Feature: Create new Account with Invalid data

  Background: Navigate to primary account holder page and validate title
    When user click on "Create Primary Account" link
    Then validate "Create Primary Account Holder" title

  Scenario: Creating account with existing email and error message
    When user fill the create new account form
      | EmailAddress     | Steve7274@happy.ca |
      | FirstName        | Steve              |
      | Gender           | Male               |
      | EmploymentStatus | Tester             |
      | Title            | Mr.                |
      | LastName         | Dew                |
      | MaritalStatus    | Single             |
      | DateOfBirth      | 10/10/2000         |
    Then user click on "Create Account" button
    Then validate error message as expected for email "Steve7274@happy.ca"


  Scenario: Creating account with age less than 18 and validate error message
    When user fill the create new account form
      | EmailAddress     | Steve7274@happy.ca |
      | FirstName        | Steve              |
      | Gender           | Male               |
      | EmploymentStatus | Tester             |
      | Title            | Mr.                |
      | LastName         | Dew                |
      | MaritalStatus    | Single             |
      | DateOfBirth      | 10/10/2010         |
    Then user click on "Create Account" button
    Then validate error message as expected "you must be 18 years or older to create account"


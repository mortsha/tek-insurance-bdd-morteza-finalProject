@Regression
Feature: Create Primary Account page and validation

  @UserStory1
  Scenario: Navigate to Create Primary Account page and validate title
    When user click on "Create Primary Account" link
    Then validate "Create Primary Account Holder" title
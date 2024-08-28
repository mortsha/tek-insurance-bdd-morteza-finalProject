@Smoke @Regression @Profile
Feature: Login with credentials and validate profile page

  Background: Navigate to login page
    When user click on "Login" link
    Then validate "Sign in to your Account" title

  @Profile2
  Scenario Outline:  Login with Both CSR And Primary Account and validate profile sections
    When  user enter "<username>" on field "Username"
    And  user enter "<password>" on field "Password"
    Then user click on "Sign In" button
    Then validate "<expectedTitle>" account title
    When user click on "Profile" button
    Then validate information in profile side drawer
      | STATUS      | <status>          |
      | USER TYPE   | <userType>        |
      | FULL NAME   | <fullName>        |
      | USERNAME    | <usernameProfile> |
      | AUTHORITIES | <authorities>     |

    Examples:
      | username   | password       | expectedTitle           | status | userType | fullName   | usernameProfile | authorities |
      | supervisor | tek_supervisor | Customer Service Portal | Active | CSR      | Supervisor | supervisor      | admin       |
      | Steve5670  | Anything@123   | Primary Account Portal  | Active | CUSTOMER | Steve Dew  | steve5670       | customer    |


    Scenario: Login with CSR credentials and log out and validate home page
      When  user enter "supervisor" on field "Username"
      And  user enter "tek_supervisor" on field "Password"
      Then user click on "Sign In" button
      Then validate "Customer Service Portal" account title
      When user click on "Profile" button
      When user click on "Logout" button
      Then home page title should be "Tek Insurance UI"
      And the "Create Primary Account" link is displayed
      And the "Login" link is displayed


Feature: Register Flow Feature Test Suite

  @Smoke @Regression
  Scenario: Access the Account Page after successful registration
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    When "privacyPolicyToggle" from "RegisterPage" is clicked
    And "continueBtn" from "RegisterPage" is clicked
    Then the current url contains the following keyword: "success"

  Scenario: User remains on Register Page when continue button is not clicked during register flow
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    When "privacyPolicyToggle" from "RegisterPage" is clicked
    Then the current url contains the following keyword: "register"

  @Regression
  Scenario: User remains on Register Page when Privacy Policy is not enabled during register flow
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And "continueBtn" from "RegisterPage" is clicked
    Then the current url contains the following keyword: "register"

  @run
  Scenario Outline: An error message is displayed when the user is trying to register with invalid <attribute> data
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form is completed with the following data:
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
      | password  | <password>  |
    When "continueBtn" from "RegisterPage" is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!   |
      | <attribute> must be between 1 and 32 characters! |
    Examples:
      | attribute  | firstname                                            | lastname                                             | email  | password |
      | First Name | ananannanannanaanannanannnanannanannnannanannananana | random                                               | random | random   |
      | Last Name  | random                                               | ananannaanannanannnanannananannanannnannanannananana | random | random   |
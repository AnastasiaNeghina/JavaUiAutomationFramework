Feature: Register Flow Feature Test Suite

  @Smoke @Regression
  Scenario: Access the Account Page after successful registration
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    And the continueButton is clicked
    Then the new page url contains "success" keyword

  Scenario: User remains on Register Page when continue button is not clicked during register flow
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    Then the new page url contains "register" keyword

  @Regression
  Scenario: User remains on Register Page when Privacy Policy is not enabled during register flow
    Given Home page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the continueButton is clicked
    Then the new page url contains "register" keyword
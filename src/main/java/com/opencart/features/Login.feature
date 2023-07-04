Feature: Login Feature Test Suite

  Scenario Outline: An error message is displayed when the user logs in with invalid data <attribute>
    Given the "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered intro the login form:
      | <email>    |
      | <password> |
    When "loginBtn" from "LoginPage" is clicked
    Then the following error messages are displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute | email               | password     |
      | email     | falsemail@gmail.com | anan         |
      | password  | an@gmail.com        | falspassword |

  Scenario Outline: A valid user is able to log into the system with valid data
    Given the "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered intro the login form:
      | <email>    |
      | <password> |
    When "loginBtn" from "LoginPage" is clicked
    Then the current url contains the following keyword: "account"
    Examples:
      | email        | password |
      | an@gmail.com | anan     |

Feature: Access

  @login @valid  
  Scenario Outline: Login with valid credentials
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    Then user is able to see <title>
  
  Examples:
    | username      | password     | title     |
    | standard_user | secret_sauce | Products  |
  
  @login @invalid
  Scenario Outline: Login with invalid credentials
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    Then user gets an error which contains <error>
  
  Examples:
    | username        | password     | error        |
    | standard_user   | secret_sauc  | do not match |
    | locked_out_user | secret_sauce | locked       |

  @logout
  Scenario: Logout with valid credentials
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    And user clicks logout button
    Then user logs out
  
  Examples:
    | username      | password     | logoText  |
    | standard_user | secret_sauce | Swag Labs |
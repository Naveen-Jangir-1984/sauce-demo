Feature: Logout

  @logout
  Scenario: With Valid Credentials
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    And user clicks logout button
    Then user logs out
  
  Examples:
    | username      | password     | logoText  |
    | standard_user | secret_sauce | Swag Labs |

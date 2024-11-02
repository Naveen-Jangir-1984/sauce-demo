Feature: Inventory
  
  @count
  Scenario Outline: Items count
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    Then number of items displayed are <count>
  
  Examples:
    | username      | password     | count  |
    | standard_user | secret_sauce | 6      |
    
  @filter
  Scenario Outline: Filter
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    And user selects filter option as <filter>
    Then items are displayed in <filter> order
  
  Examples:
    | username      | password     | filter      |
    | standard_user | secret_sauce | A to Z      |
    | standard_user | secret_sauce | Z to A      |
    | standard_user | secret_sauce | low to high |
    | standard_user | secret_sauce | high to low |

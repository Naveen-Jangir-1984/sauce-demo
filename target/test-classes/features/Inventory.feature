Feature: Inventory
  
  @items
  Scenario Outline: Items count
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    Then number of items displayed are <count>
  
  Examples:
    | username      | password     | count  |
    | standard_user | secret_sauce | 6      |

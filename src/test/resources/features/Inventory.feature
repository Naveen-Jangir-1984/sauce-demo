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
    And user selects filter as <option>
    Then products are displayed in <option> order
  
  Examples:
    | username      | password     | option      |
    | standard_user | secret_sauce | A to Z      |
    | standard_user | secret_sauce | Z to A      |
    | standard_user | secret_sauce | low to high |
    | standard_user | secret_sauce | high to low |
    
  @select
  Scenario Outline: Select items
    Given user is on the login page
    When user enters <username> as username
    And user enters <password> as password
    And user clicks login button
    And user clicks on add to cart button for <product>
    Then <product> is displayed on the cart
  
  Examples:
    | username      | password     | product  |
    | standard_user | secret_sauce | Backpack |
    | standard_user | secret_sauce | Onesie   |

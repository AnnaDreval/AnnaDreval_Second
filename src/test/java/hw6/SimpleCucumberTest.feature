Feature: Home Page tests

  Scenario: Home Page Interface test
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user name PITER CHAILOVSKII is displayed
    And Service subcategory in the header contains options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table with pages   |
      | Different Elements |
      | Performance        |
    And Service subcategory in the left section contains the same options
    Given I'm on the Different Elements page
    Then Different elements interface contains all elements
    And There is a Right Section
    And There is Left Section
    When Select checkboxes:
      | Water |
      | Wind  |
    And I select Selen radiobutton
    And I select Yellow dropdown item
    Then There are logs about all actions:
      | Water  |
      | Wind   |
      | Yellow |
      | Selen  |
    When Unselect checkboxes:
      | Water |
      | Wind  |
    Then There are logs about all actions:
      | Water |
      | Wind  |
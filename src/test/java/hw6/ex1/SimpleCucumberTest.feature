Feature: Home Page tests

  Scenario: Home Page Interface test
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user name PITER CHAILOVSKII is displayed
    Then Service subcategory in the header contains options
    And Service subcategory in the left section contains options
    Given I'm on the Different Elements page
    Then Different elements interface contains all elements
    And There is a Right Section
    And There is Left Section
    When I select Water
#      |Water|
#      |Wind|
#    And I select radiobutton
#    And I select dropdown item
#    Then There are logs about all actions
#    When I unselect checkboxes
#    Then There are logs about all actions
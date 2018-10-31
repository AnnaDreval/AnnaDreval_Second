Feature: Service Page tests

  Scenario:
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user icon is displayed on the header
    And Service subcategory in the header contains options
    And Service subcategory in the left section contains options
    Given I'm on the Different Elements page
    Then Different elements interface contains all elements
    And There is a Right Section
    And There is Left Section
    When I select checkboxes
    Then There are checkbox logs on the info-panel section
    When I select radiobutton
    Then There is radiobutton log on the info-panel section
    When I select dropdown item
    Then There is dropdown log on the info-panel section
    When I select checkboxes
    Then There are checkbox logs about unselect
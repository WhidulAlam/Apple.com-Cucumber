Feature: Test search functionalities
  Scenario: Validate apple search is working
    Given user click on Search icon from menu bar
    When user enters text "Air Tag" in search box
    And user press Enter on SearchBox
    Then user navigate to search results

  @dataDriven_test
  Scenario Outline: Validate apple search is working for multiple product
    Given user click on Search icon from menu bar
    When user enters text "<product>" in search box
    And user press Enter on SearchBox
    Then user navigate to search results
    Examples:
      | product |
      | Air Tag |
      | Watch   |
      | Mac     |

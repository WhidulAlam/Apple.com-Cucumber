Feature: Check device coverage functionalities
  Background:
#    Given Click on check coverage link upon mouse hovering on Support from menu
#    And  Type the characters captcha & click submit button
#    Then user will see coverage details

  Scenario: Check device coverage
    Given Click on check coverage link upon mouse hovering on Support from menu
    When user Enter a device serial number "F18Q3T54G5MN" to check Coverage
    And  Type the characters captcha & click submit button
    Then user will see coverage details

  @dataDriven_Test
  Scenario Outline: Check device coverage for multiple device
    Given Click on check coverage link upon mouse hovering on Support from menu
    When  user Enter a device serial number "<serialNumber>" to check Coverage
    And  Type the characters captcha & click submit button
    Then user will see coverage details
    Examples:
      |  serialNumber  |
      |  F18Q3T54G5MN  |
      |  GG3DD4KL4k    |
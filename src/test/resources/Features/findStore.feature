Feature: Test find store Functionalities

  Background:
#    Given Click on Find store link upon mouse hovering on Store from menu
#    Then user Find a store successfully

  Scenario:find a apple store near to user
    Given Click on Find store link upon mouse hovering on Store from menu
    When user enters a ZipCode "11432" & click on drop down of zip code
    Then user Find a store successfully

  @dataDriven_Test
  Scenario Outline:find multiple zipCode apple store near to user
    Given Click on Find store link upon mouse hovering on Store from menu
    When user enters a ZipCode "<zipCode>" & click on drop down of zip code
    Then user Find a store successfully

    Examples:
      | zipCode |
      | 11432   |
      | 10003   |
      | 11217   |

  @dataTable_Test
  Scenario:find apple store near to using data table
    Given Click on Find store link upon mouse hovering on Store from menu
    When user enters a ZipCode & click on drop down of zip code
      | zipCode |
      | 10003   |
    Then user Find a store successfully
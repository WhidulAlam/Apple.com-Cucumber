Feature: Test Purchases Functionalities

  Background:
#    Given user Click on Shop All Accessories link upon mouse hovering on Accessories from menu bar
#    Then user purchased successfully

  Scenario: purchases an iPad
    Given user Click on Shop All Accessories link upon mouse hovering on Accessories from menu bar
    When user searching product "Refurbished 11 inch iPad Pro Wi Fi 1TB Space Gray (3rd Generation)" & click the product upon scrolling down
    And click on Connectivity "Wi-Fi" & Storage "1TB" then clicks on GrayColour, AddToBag, CheckOut, ContinueAsGuest upon scrolling down
    Then user purchased successfully

  @dataDriven_test
  Scenario Outline: purchases iPad fo multiple product
    Given user Click on Shop All Accessories link upon mouse hovering on Accessories from menu bar
    When user searching product "<products>" & click the product upon scrolling down
    And click on Connectivity "<connectivity>" & Storage "<storage>" then clicks on GrayColour, AddToBag, CheckOut, ContinueAsGuest upon scrolling down
    Then user purchased successfully

    Examples:
      |                          products                                  |    connectivity      |   storage    |
      | Refurbished 11 inch iPad Pro Wi Fi 1TB Space Gray (3rd Generation) |      Wi-Fi           |      1TB     |
      | Refurbished 11 inch iPad Pro Wi Fi 1TB Space Gray (3rd Generation) |   Wi-Fi + Cellular   |    512GB     |
Feature: Trade in Functionalities
  Scenario: Check iPhone trade in price
    Given user navigate to Apple trade in page upon clicking on Apple Trade In link from Store Menu
    When user click on Find your trade-in-Value for good condition "iPhone 11" & then click on SmartPhone
    Then user will see trade in price is "Get $200 trade-in credit toward a new iPhone.1"

#    Examples:
#       | iPhone_model |                    Trade-in-value              |
#       | Iphone 11    | Get $200 trade-in credit toward a new iPhone.1 |
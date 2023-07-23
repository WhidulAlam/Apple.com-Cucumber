Feature:Test functionalities

  Background:
#    Given user Click on Explore All iPhone link upon mouse hovering on iPhone from menu then click on Buy button
#    When clicks on iPhone14, BlueColour, 256GB, NoTradeIn, Buy, connectToAny, NoAppleCare, AddToBag, ReviewBag, checkOut, ContinueAsGuest, DeliversFree, ShippingAddressButton upon scrolling down
#    Then user is purchased successfully

  Scenario: A user purchases an iPhone 14 online
    Given user Click on Explore All iPhone link upon mouse hovering on iPhone from menu then click on Buy button
    When clicks on iPhone14, BlueColour, 256GB, NoTradeIn, Buy, connectToAny, NoAppleCare, AddToBag, ReviewBag, checkOut, ContinueAsGuest, DeliversFree, ShippingAddressButton upon scrolling down
    And user enters shipping address credentials FN"Whidul", LN"Alam", SA"85 Homelawn st.", ZC"11432-2634", CN"Jamaica, NY", EA"w.a.riyadneta@gmail.com", PN"64-785-4606"
    Then user is purchased successfully

  @dataDriven_test
  Scenario Outline:purchases iPhone 14 online for multiple user
    Given user Click on Explore All iPhone link upon mouse hovering on iPhone from menu then click on Buy button
    When clicks on iPhone14, BlueColour, 256GB, NoTradeIn, Buy, connectToAny, NoAppleCare, AddToBag, ReviewBag, checkOut, ContinueAsGuest, DeliversFree, ShippingAddressButton upon scrolling down
    And user enters shipping address credentials FN"<FirstName>", LN"<LastName>", SA"<StreetAddress>", ZC"<ZipCode>", CN"<City&StateName>", EA"<EmailAddress>", PN"<PhoneNumber>"
    Then user is purchased successfully
    Examples:
    | FirstName | LastName |   StreetAddress   |  ZipCode | City&StateName |      EmailAddress     |  PhoneNumber  |
    |  Whidul   |   Alam   |  85 Homelawn st.  |11432-2634|   Jamaica, NY  |w.a.riyadneta@gmail.com|  64-785-4606  |
    |  Daniel   | Vettori  |  80 Homelawn st.  |11432-2634|   Jamaica, NY  |denialvettori@gmail.com|  64-784-6065  |


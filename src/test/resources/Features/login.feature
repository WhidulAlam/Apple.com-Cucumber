
@Login_test
Feature: Test login functionalities
  Background:
    Given user click Bag icon & then click sign in again


  @positive_test
  Scenario: Check login is successful with valid credentials
    And user performs appleId "w.a.riyadneta@gmail.com" and password "Apple1990$$" to login
    Then user should be enter Verification Code to login

  @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials for multiple users
    And user performs appleId "<appleId>" and password "<password>" to login
    Then user should be enter Verification Code to login

    Examples:
      |       appleId            |   password  |
      | w.a.riyadneta@gmail.com | Apple1990$$ |
      | w.a.riyadneta@gmail.com | Apple1990$$ |
      | w.a.riyadneta@gmail.com | Apple1990$$ |


  @dataTable_test
  Scenario: Check login is successful using data table
    And user performs all the required steps upon to login
      |       appleId            |   password  |
      | w.a.riyadneta@gmail.com | Apple1990$$ |
    Then user should be enter Verification Code to login


  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    And user performs appleId "w.a.riyadneta@gmail.com" and password "Apple1992$$" to login
    Then user is failed to login

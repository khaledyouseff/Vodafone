Feature: select item functionality
  Scenario: login successfully and click on an item
    Given user open url and go login page and login and go to homePage to select item
    When fill valid mobile number as "01140342431" and password as "Khaled1997#"
    Then user go to itemPage successfully
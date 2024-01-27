Feature: select item functionality
  Scenario: login successfully and click on an item 1
    Given user open url and go login page and login and go to homePage to select item 1
    When fill valid mobile number as "01140342431" and password as "Khaled1997#" and click item 1 add to cart
    Then user add item 1 to cart successfully
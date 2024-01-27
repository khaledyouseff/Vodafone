Feature: select item functionality
  Scenario: login successfully and click on an item 2
    Given user open url and go login page and login and go to homePage to select item 2
    When fill valid mobile number as "01140342431" and password as "Khaled1997#" and click item 2 add to cart
    Then user add item 2 to cart successfully
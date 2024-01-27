Feature: select item functionality
  Scenario: login successfully and click on an item 3
    Given user open url and go login page and login and go to homePage to select item 3
    When fill valid mobile number as "01140342431" and password as "Khaled1997#" and click item 3 add to cart
    Then user add item 3 to cart successfully
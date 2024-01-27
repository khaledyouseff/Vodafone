Feature: select item functionality
  Scenario: login successfully and click on an item
    Given user open url and go login page and login and go to homePage to select item
    When fill valid mobile number as "01140342431" and password as "Khaled1997#" and click add to cart
    Then user add item to cart successfully
Feature: login functionality
  Scenario: user enters valid username and password
    Given user open url and go to login page
    When fill valid username and password
    Then user login successfully
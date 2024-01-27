Feature: login functionality
  Scenario: user enters valid username and password
    Given user open url and go to login page
    When fill valid mobile number as "01140342431" and password as "Khaled1997#"
    Then user login successfully
Feature: App UI Automation

  @app
  Scenario: Successfull Login
    Given user is on homepage
    And user click on burger icon
    And user click log in
    When User enters username & password
    And user click login
    Then User successfully login in the app
Feature: Bibit Explore - Logout

  @web
  Scenario: User Search Product Investment in Explore
    Given user has login with valid account
    And user click on explore button
    And explore pages is shown to user
    When user search for product investment
    And user click on the product
    Then the product page is shown to user

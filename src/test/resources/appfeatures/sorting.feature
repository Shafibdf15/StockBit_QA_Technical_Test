Feature: Sorting product

  @app
  Scenario: Sorting by Name Descending and price Ascending
    Given user is in homepage
      And user click on sorting feature
      When  user sort product by Name - Descending
      Then product is sorted by name descending
      When user sort product by Price - Ascending
      Then product is sorted by price ascending
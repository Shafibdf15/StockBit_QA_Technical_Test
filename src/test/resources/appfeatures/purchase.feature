Feature: Buying a product

  @app
  Scenario: User buy a product
    Given user has login with saucelab account
      When  user click on Sauce Labs Backpack product
      And user selected blue color variant
      And user set the item quantity to two
      And user click on Add to Cart
      And user navigate to cart page
      And user checkout
      And user fill the required information and click to payment
      And finalize the payment
      Then user successfully buy the product
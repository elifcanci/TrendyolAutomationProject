Feature: Trendyol Cart Transactions

  Scenario: User adds product to cart and confirms price
    Given Cart price must be correct
    When User adds the product to the cart
    Then Cart price must be correct

  Scenario: User removes item from cart
    Given User removes item from cart
    When User adds the product to the cart
    Then An item must be removed from the cart

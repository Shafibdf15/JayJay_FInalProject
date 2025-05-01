Feature: Handling Web Core Function

  @web
  Scenario: Adding Product to Cart
    Given user has login with valid account
    When user click product and add to cart
    Then Message indicating product has been added is shown
    And User can validate item in cart page

  @web
  Scenario: Purchasing a product with Valid Data
    Given User has product in Cart
    When User click place order button
    And User has fill the required data
    And User click purchase button
    Then PopUp messeage indicating purchase successfull is shown

  @web
  Scenario:  Purchasing a product with empty Data
    Given User has product in Cart
    When User click place order button
    And user click purchase button
    Then Alert message is shown directing user to fill the required field

  @web
  Scenario: Deleting item from Cart
    Given User has product in Cart
    When User click on delete button
    Then Product will be removed from Cart


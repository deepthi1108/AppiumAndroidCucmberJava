@test
Feature: Misguided App
  I want to place an order

  Scenario: TC01_User wants to place the order
    Given I am on the home page of the app as an anonymous user
    When I tap on the menu bar
    And I select the "clearance" from the menu bar
    And I select the product number "7"
    And I add the product to the bag
    And I select the size of the product as "8"
    Then I allow the notifications
    When I select the shopping bag
    And I tap on the checkout to make payment
    Then I should be displayed SignIn and Register screen
   
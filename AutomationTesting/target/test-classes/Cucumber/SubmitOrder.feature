@tag
Feature: Purchase the order from Ecommerce website

  Background: 
    Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And CheckOut <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation Page

    Examples: 
      | name              | password    | productName |
      | anshika@gmail.com | Iamking@000 | ZARA COAT 3 |

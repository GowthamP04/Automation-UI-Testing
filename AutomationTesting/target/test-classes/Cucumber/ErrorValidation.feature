	@tag
Feature: Error Validation

  @Sanity
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name              | password  |
      | anshika@gmail.com | Iamking@0 |

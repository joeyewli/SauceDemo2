@cart
Feature: Cart

  Scenario: Adding items to basket
    Given I am login on the inventory page
    When I add 4 items
    Then cart will have 4 items in it


  Scenario: Removing items from basket
    Given I am login on the inventory page
    And I have 2 items in the cart
    When I remove 2 items
    Then cart will have 0 items in it

  Scenario: Removing items from basket
    Given I am login on the inventory page
    And I have 6 items in the cart
    When I remove 2 items
    And I remove 1 items
    And I add 2 items
    And I remove 3 items
    Then cart will have 2 items in it

  Scenario Outline: Adding/removing from basket
    Given I am login on the inventory page
    When I add <toBasket> items
    And I remove <fromBasket> items
    Then cart will have <remainder> items in it

    Examples:
      | toBasket | fromBasket | remainder |
      | 6        | 6          | 0         |
      | 6        | 0          | 6         |
      | 0        | 0          | 0         |
      | 1        | 1          | 0         |
      | 6        | 3          | 3         |

@now
Scenario: Clicking Cart in InventoryPage will load the Cart Page
  Given I am login on the inventory page
  When I click on the Cart
  Then I will be in the Your Cart Page

  @end @now
  Scenario: End
    Then QUIT DRIVER
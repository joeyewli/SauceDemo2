@checkout
Feature: Checkout

  Scenario: Cancel in Checkout Page will return me to the Cart Page
    Given I am login on the Cart page
    And I checkout
    When I click cancel in the Checkout page
    Then I will be in the Your Cart Page

  Scenario: Continue in the Checkout Page will proceed to the Checkout Overview Page
    Given I am login on the Cart page
    And I checkout
    When I enter my details- first name = John, last name = Lewis, postcode = zipcode
    And I click on continue
    Then I will be in the Checkout: Overview page

  Scenario Outline: User will get an error and can't continue to checkout without filling all mandatory data
    Given I am login on the Cart page
    And I checkout
    When I enter my details- first name = <firstName>, last name = <lastName>, postcode = <zipcode>
    And I click on continue
    Then I will get an error message <error> in the Checkout page

    Examples:
      | firstName | lastName | zipcode | error                   |
      |           |          |         | First Name is required  |
      | John      |          |         | Last Name is required   |
      | John      | Lewis    |         | Postal Code is required |

  @cart
  Scenario: sum of 2 cart items
    Given I am login on the inventory page
    When I add 2 items
    And I click on the Cart
    And I checkout
    And I enter my details- first name = John, last name = Lewis, postcode = Ha
    And I click on continue
    Then Item total is the sum of all items in the cart
    And tax = 8 percent of Item total
    And Total = Tax and Item Total

  @now @cart @addToCart @emptyCartCheckoutOverview
  Scenario Outline:  sum of cart items
    Given I am login on the inventory page
    When I add <items> items
    And I click on the Cart
    And I checkout
    And I enter my details- first name = John, last name = Lewis, postcode = Ha
    And I click on continue
    Then Item total is the sum of all items in the cart
    And tax = 8 percent of Item total
    And Total = Tax and Item Total

    Examples:
      | items |
      | 1     |
      | 2     |
      | 3     |
      | 4     |
      | 5     |
      | 6     |


  @end @now
  Scenario: End
    Then QUIT DRIVER
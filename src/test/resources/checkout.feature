@cart
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

  @now
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


  @end @now
  Scenario: End
    Then QUIT DRIVER
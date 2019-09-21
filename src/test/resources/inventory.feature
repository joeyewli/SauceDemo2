@inventory
Feature: InventoryPage

  @links
  Scenario: Check all links are working
    Given I am login on the inventory page
    When I click on all the links
    Then all links works


  Scenario: Test
    Given I am login on the inventory page
    Then testing

  @footer
  Scenario: Footers should have social media, copyrights, terms of service and privacy policy
    Given I am login on the inventory page
    Then Twitter is in the footer
    And Facebook is in the footer
    And LinkedIn is in the footer
    And © 2019 Sauce Labs. All Rights Reserved. is in the footer
    And Terms of Service is in the footer
    And Privacy Policy is in the footer

  @notTestable
  Scenario: All inventory images are displayed
    Given I am login on the inventory page
    Then all images are displayed

  @filter
  Scenario: Sorting prices from low to high
    Given I am login on the inventory page
    When I sort Price (low to high)
    Then the Item prices are sorted from low to high

  @filter
  Scenario: Sorting prices from high to low
    Given I am login on the inventory page
    When I sort Price (high to low)
    Then the Item prices are sorted from high to low

  @filter
  Scenario: Sorting Items in Ascending order
    Given I am login on the inventory page
    When I sort Name (A to Z)
    Then the Items are sorted in ascending order

  @filter
  Scenario: Sorting Items in Descending order
    Given I am login on the inventory page
    When I sort Name (Z to A)
    Then the Items are sorted in descending order

  @end
  Scenario: End
    Then QUIT DRIVER
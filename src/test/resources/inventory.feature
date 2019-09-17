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


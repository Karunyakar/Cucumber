
Feature: Purchase the order from Letshop website
  I want to use this template for my feature file


  @tag2
  Scenario:Postive tests of purchase the order 
    Given I logged with useremail <email> and password <password>
    When I added the product to cart
    And products are checkout
    Then confirmation page will be displayed

Feature: Add the product to the Shopping Cart

  @Before
  Scenario Outline: Product Search by entering the product name
    Given User is on the BestBuy Website
    When User enters "<searchitem>" in the search bar
    Then List of products are displayed
    And User locates the item by the modelnumber "<model>" from Search results and add product to cart
    Then Validate the item are added to the cart

    Examples: 
      | searchitem | model     |
      | iphone 13  | A2483-GRY |
      | iphone 12  | MGF43LL/A |

  Scenario: Shopping Cart page options
    When User clicks on the Shopping Cart
    Then Validate Order Summary and Check Out option is enabled

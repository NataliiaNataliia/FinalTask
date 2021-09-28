Feature: Smoke
  As a user
  I want to test some of the main site functionalities
  So that I can be sure that these features work correctly

  Scenario Outline: Check search by full product name functionality
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<productNameKeyword>' into the search field
    And User clicks on search button
    Then User checks that keyword equals to '<nameOfProduct>'

    Examples:
      | homePage              | productNameKeyword                              | nameOfProduct                              |
      | https://www.ebay.com/ | lancôme paris color design eye shadoow 209      | lancôme paris color design eye shadoow 209 |

  Scenario Outline: Check that cart counter changes after adding an item to the cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of add to cart button
    And User clicks on add to cart button
    Then User checks that the number of products displayed in cart counter is '<numberOfProducts>'

    Examples:
      | homePage              | keyword                                          | numberOfProducts    |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara  | 1                   |

  Scenario Outline: Check the possibility to checkout without previous registration
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of buy it now button
    And User clicks on buy it now button
    And User checks visibility of checkout popup
    And User clicks on checkout as guest button
    Then User checks if checkout page is enabled for guest

    Examples:
      | homePage              | keyword                                          |       |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara  |       |

  Scenario Outline: Check that total to be paid is being updated after changing the quantity of items while checkout
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of buy it now button
    And User clicks on buy it now button
    And User checks visibility of checkout popup
    And User clicks on checkout as guest button
    And User clicks on product quantity field
    And User changes the number of items for checkout
    Then User checks that total to be paid in the cart on subtotal section is '<totalTobePaid>'

    Examples:
      | homePage              | keyword                                          |totalTobePaid  |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara  |GBP 25.89      |

  Scenario Outline: Check the guest checkout with valid data
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of buy it now button
    And User clicks on buy it now button
    And User checks visibility of checkout popup
    And User clicks on checkout as guest button
    And User enters the name '<name>' into the input field
    And User enters the lastname '<lastName>'
    And User enters the city '<city>'
    And User enters the street address '<streetAddress>'
    And User enters email '<email>'
    And User confirms email '<email>'
    And User enters the phone '<phoneNumber>' into input field
    And User clicks on submit button
    Then User checks if summary ship to panel is displayed

    Examples:
      | homePage              | keyword                                         | name    | lastName | city | streetAddress | email         | phoneNumber |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara | Ivan    | Ivanov   | Kyiv | Zarechnaya    |ivan@gmail.com | 507862295   |

  Scenario Outline: Check that checkout is not available with an invalid email
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of buy it now button
    And User clicks on buy it now button
    And User checks visibility of checkout popup
    And User clicks on checkout as guest button
    And User enters the name '<name>' into the input field
    And User enters the lastname '<lastName>'
    And User enters the city '<city>'
    And User enters the street address '<streetAddress>'
    And User enters the phone '<phoneNumber>' into input field
    And User enters email '<email>'
    And User clicks on submit button
    Then User checks that message '<message>' is displayed
    Then User checks that the next step is not available

    Examples:
      | homePage              | keyword                                         | name    | lastName | city | streetAddress | email         | phoneNumber | message         |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara | Ivan    | Ivanov   | Kyiv | Zarechnaya    |-2//?<>$%+i    | 507862295   | look like an email address|

  Scenario Outline: Check filter by functionality
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User checks the checkbox from the filter section
    Then User checks that products have been filtered in accordance with the '<filterWord>'

    Examples:
      | homePage              | keyword             | filterWord |
      | https://www.ebay.com/ | foligain minoxidil  | shampoo    |

  Scenario Outline: Check that added products are displayed in the cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of add to cart button
    And User clicks on add to cart button
    And User enters the keyWord '<keyWord>' into the search field
    Then User clicks on the search button
    And User clicks on a product from the search result page to go to a product card page
    And User checks visibility of add to cart button
    And User clicks on add to cart button
    Then User checks that the amount of products in the Cart is <numberOfProducts>

    Examples:
      | homePage              | keyword                                          | keyWord              | numberOfProducts |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara  | foligain minoxidil   | 2                |

  Scenario Outline: Check deletion of the product from the cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on a product from search result page to go to a product card page
    And User checks visibility of add to cart button
    And User clicks on add to cart button
    Then User removes the product from the cart
    Then User checks that the cart is empty

    Examples:
      | homePage              | keyword                                          |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara  |


  Scenario Outline: Check that changing to 0 products in the cart is not available
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User enters the keyword '<keyword>' into the search field
    And User clicks on search button
    And User clicks on the second product from search result page to go to a product card page
    And User checks visibility of buy it now button
    And User clicks on buy it now button
    And User checks visibility of checkout popup
    And User clicks on checkout as guest button
    And User clicks on product quantity field
    And User changes the number of items in the cart to maximum
    Then User changes the number of items to '<numberOfItems>'
    And User clicks on update button
    Then User checks that subtotal is not changed to zero

    Examples:
      | homePage              | keyword                                          | numberOfItems |
      | https://www.ebay.com/ | Maybelline Lash Sensational Multiplying Mascara  | 0             |


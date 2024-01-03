Feature: This feature verify some functionality of the product

Scenario: verify product price range
  Given Enter smart watches in search component
  When hit enter key
  Then User click on brand and price
  And verify Price of watch as per selected range
  
Scenario: verify selected item added to the bag
  Given Enter safari bags in search component
  When press enter key
  Then User click on bag
  And click on add to bag button  
  
Feature: Booking one page
  
  As a user 
  I want Booking one page
  So that I can enter
 
  Scenario Outline: Verify when user come on to Booking one page, all expected fields are availabe on the page
    Given I am on "<POS>" tours page
    When I select a tour
    Then I should be on tour details page
    When I select BOOK NOW button
    Then I should be on booking one page
    And I should see all fields on Booking one page as expected

    # Trip title, Select tour year dropdown, Travellers dropdown, Previous/Next month button, Coupon input, Coupon apply Button,
    # Payable today, Total price for booking, Total price for sidebar, Why book with us field,
    Examples: 
      | POS |
      #   | UK  |
      | USA |
      | NZ  |
      | AU  |

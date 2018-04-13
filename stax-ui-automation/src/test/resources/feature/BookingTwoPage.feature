Feature: Booking Two page
  
  As a user 
  I want Booking two page
  So that I can enter all travellers information on page

  
  Scenario Outline: Verify when user come on to Booking Two page, all expected fields are availabe on the page
    Given I am on "<POS>" tours page
    When I select a tour
    Then I should be on tour details page
    When I select BOOK NOW button
    Then I should be on booking one page
    When I select continue button on booking one page
    Then I should be on booking two page
    And I should see all fields on Booking Two page as expected for "<POS>"

    # To verify First name, Last name, DOB DOB month, DOB Yea, Gender, Phone number, Email,
    #  Name on card, Card Number, Expiry Month, Expiry year, Security code,
    # Country dropdown, street, city, state - for US and County - for other POS, Zipcode,
    # Check boxs for Supplier booking T&C and STA booking T&C
    # Book now button
    Examples: 
      | POS |
      | UK  |
      | USA |
      | NZ  |
      | AU  |

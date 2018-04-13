Feature: Cheapest price selected
  
  As a user
  I want to see cheapest price selected for tour for all available price 
  So that I dont have to look for cheapest price

  @test
  Scenario Outline: Verify when user come on to Booking Two page, all expected fields are availabe on the page
    Given I am on "<POS>" tours page
    When I get the price for first tour
    And I select a tour
    Then I should be on tour details page
    When I select BOOK NOW button
    Then I should be on booking one page
    And I should see cheapest price selected in calender from all available price

    Examples: 
      | POS |
      #   | UK  |
      | USA |
      | NZ  |
      | AU  |

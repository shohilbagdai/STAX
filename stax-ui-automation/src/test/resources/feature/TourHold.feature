Feature: Tour Hold
  
  As a user
  I want Tour Hold function 
  So that I can hold a tour

  Scenario Outline: Verify when user come on to Booking Two page, all expected fields are availabe on the page
    Given I am on "<POS>" tours page
    When I select a tour
    Then I should be on tour details page
    When I select BOOK NOW button
    Then I should be on booking one page
    When I select tour date after seventy days from dropdown
    Then I should see HOLD TOUR check box available on page
    And I should see "pay deposit" option in Booking option field
    And I should see "pay full amount" option in Booking option field

    Examples: 
      | POS |
      #   | UK  |
      | USA |
      | NZ  |
      | AU  |

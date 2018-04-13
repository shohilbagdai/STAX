Feature: STAX UK booking
  
  As an automation tester 
  I want to do booking for all POS Tours
  SO that I can use that for smoke test

  Scenario Outline: End to end tours booking for diffreant POS as per examples
    Given I am on "<POS>" tours page
    When I select a tour
    Then I should be on tour details page
    When I select BOOK NOW button
    Then I should be on booking one page
    When I select continue button on booking one page
    Then I should be on booking two page
    When I fill all traveller details for "<POS>"
    And select book now
    Then I should be on confirmation page 

    Examples: 
      | POS |
      #  | UK  |
      | USA |
      | NZ  |
      | AU  |
# right now this scenario covers USA, NZ, and AU with new checkout page

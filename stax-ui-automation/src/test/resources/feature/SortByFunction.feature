Feature: Sort By Function
  As a user 
  I want sort by function on tour search page
  So that I can view tour as per my preference

  Scenario Outline: Verify when user come on tour result page RECOMMENDATION is selected by default on Sort by function dropdown
    Given I am on "<POS>" tours page
    Then I should see Sort by dropdown on tours page
    And RECOMMENDATION should be selected by default

    Examples: 
      | POS |
      | UK  |
      | USA |
      | NZ  |
      | AU  |

Feature: Tour load functionality
  As a user
  I want to verify that when I comes on the page tours load on the page
  So that I can choose from loaded tours

  Scenario Outline: Verify when user comes on the page tours load on the page
    Given I am on "<POS>" tours page
    Then I should see tours are loaded on the page

    # we are verifying that at least six tours are loaded on the page
    Examples: 
      | POS |
      | UK  |
      | USA |
      | NZ  |
      | AU  |

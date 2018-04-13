Feature: Tour Search Functionality
  As a user
  I want search functionality
  So that I can search for particular Tour

  Scenario Outline: Verify user can search for tour via search input field and result comes back depended on value inputted
    Given I am on "<POS>" tours page
    When I search for "<word>" in search input area
    Then I should see search result pop up comes up
    And I should see returned search result contains "<word>" which I searched for

    Examples: 
      | POS | word      |
      | UK  | asia      |
      | USA | australia |
      | NZ  | london    |
      | AU  | euro      |

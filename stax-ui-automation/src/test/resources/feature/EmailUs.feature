Feature: Email us feature
  
  As a user 
  I want an email us page
  Sot that I can email my enquiry about any pertucular tour

@emailtest
  Scenario Outline: Verify when user come on to Email us page, user can see all input fields
    Given I am on "<POS>" tours page
    When I select a tour
    Then I should be on tour details page
    When I select Email us on tours details page
    Then I should see Email us pop up windown
    And I should see all required inputs in Email us pop up window

    # First name, Last name, Email address, Telephone Number, DOB, month, year,
    # Departure Month, How can we help drop down, How can we help input, Send my email button
    Examples: 
      | POS |
      #| UK  |
      | USA |
      | NZ  |
      | AU  |

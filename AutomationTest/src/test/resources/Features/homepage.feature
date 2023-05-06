Feature: Feature to verify J.P Morgan homeapge Logo

  Scenario: Validate J.P Morgan logo is displayed on home page
    Given Web Browser is open
    And User is on google search page
    When User enters a search text as J.P Morgan
    And Hits Enter
    Then User is navigated to results page
    When User click on first link displayed from results
    Then User navigated to J.P morgan Home Page and J.P morgan Logo is displayed

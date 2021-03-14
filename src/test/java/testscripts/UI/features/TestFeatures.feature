Feature: Search Weather Feature
  Verify if user is able to search "weather in city" at the navigation bar

  Scenario: Search valid city and select Enter on keyboard to search
    Given user is on homepage
    When user enters ho chi minh city in the navigation search box
    And user selects enter on keyboard to search
    Then find page is displayed with correct page title
    And find page header as Weather in your city is displayed
    And search form is displayed with the previous city entered


  Scenario: Search valid city and submit using enter on keyboard
    Given user is on homepage
    When user selects weather search box
    And user enters "ho chi minh" city and submit using enter on keyboard
    Then find page is displayed
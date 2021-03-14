Feature: Search Weather Feature
  Verify if user is able to Search weather in city

  Scenario: Search valid city and click search
    Given user is on homepage
    When user enters ho chi minh city
    And user clicks search
    Then find page is displayed


#  Scenario: Search valid city and submit using enter on keyboard
#    Given user is on homepage
#    When user selects weather search box
#    And user enters "ho chi minh" city and submit using enter on keyboard
#    Then find page is displayed
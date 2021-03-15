Feature: Testing Search Feature REST API
  User should be able to submit GET request to the web service, represented by Openweathermap

  Scenario: Data retrieval from web service
    When user wants to get ho chi minh city weather
    Then the response data is returned

  Scenario: Data retrieval empty from web service
    When user wants to get @ city weather
    Then the response empty data is returned
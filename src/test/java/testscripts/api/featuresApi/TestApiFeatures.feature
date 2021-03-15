Feature: Testing Search Feature REST API
  User should be able to submit GET request to the web service, represented by Openweathermap

  Scenario: Data retrieval from web service
    When user wants to get ho chi minh city weather
    Then the response data is returned

  Scenario: Data retrieval empty from web service
    When user wants to get @ city weather
    Then the response empty data is returned

  Scenario: Verify search successful with valid keyword
    Given API data already setup
    When user calls APIs with search keyword "Ho Chi Minh"
    Then Response status code should be 200
    And Response body schema should be exactly the same with expected contract
    And Response body should contain attribute name is "Ho chi minh city"

  Scenario: Verify search failed with invalid keyword
    Given API data already setup
    When user calls APIs with search keyword "@"
    Then Response status code should be 500
    And Response body is exactly the same as below
    """
      {
      "cod": 500,
      "message": "Internal server error"
      }
    """

Feature: Testing Search Feature REST API
  User should be able to submit GET request to the web service, represented by OpenWeatherMap

#  Scenario: Verify search successful with valid keyword
#    Given API data already setup
#    When user calls APIs with search keyword "ho Chi Minh"
#    Then response status code should be 200
#    And response body schema should be exactly the same with expected contract
#    And response body should contain attribute name is "ho chi minh" city

  Scenario: Verify search failed with invalid keyword
    Given API data already setup
    When user calls APIs with search keyword "@"
    Then response status code should be 400
    And response body is exactly the same as below:
      """{
        "cod": 400,
        "message": "Invalid city"
      }
      """
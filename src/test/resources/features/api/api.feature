Feature: Automation Test Rest API

  @api
  Scenario: Getting list of user data
    Given User has prepare url for "Get_user"
    When user send GET request to endpoint
    Then validation status code is equals to 200
    And response will contain list of user information

  @api
  Scenario: Creating user data
    Given User has prepare url for "create"
    And user has create request body
    When user send POST request to endpoint
    Then validation status code is equals to 200
    And validate response body the same as requested

  @api
  Scenario: Deleting user data
    Given User has posted a new data to endpoint "create"
    And user has prepare url "Get_user"
    When user send DELETE request
    Then validation status code is equals to 200
    And validate request GET to endpoint "get_deleted_user", returns response 404

  @api
  Scenario: Updating existing user
    Given User has posted a new data to endpoint "create"
    And user has prepare url "Get_user"
    When User send Request PUT to update data
    Then validation status code is equals to 200
    And validate response body follow updated data

  @api
  Scenario: Getting list of tag data
    Given User has prepare url for "Get_tag"
    When user send GET request to endpoint
    Then validation status code is equals to 200
    And response will not send empty data
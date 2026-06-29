Feature: Automation Test REST API

  @api
  Scenario: Creating new data
    Given user has prepared url for "base_url"
    And user has create data body
    When user hit POST to endpoint
    Then validate status code is equals to 201
    And response will contain the new written data
    And response passed the json schema validation "schemas.json"

  @api
  Scenario: Get Request on POST data
    Given user has prepared url for "base_url"
    When user hit GET to endpoint
    Then validate id field is not null on all post
    And response passed the json schema validation "arrayschemas.json"

  @api
  Scenario: Delete Request on POST data
    Given user has prepared url for "get_id"
    When user hit DELETE to endpoint posts with id "6"
    Then validate status code is equals to 200
    And validate the data has been deleted
    And response passed the json schema validation "deletion.json"

  @api
  Scenario: Update data on POST data
    Given user has prepared url for "get_id"
    And user has create data body for update
    When user hit PUT to endpoint posts with id "7"
    Then validate the response match the updated data
    And response passed the json schema validation "schemas.json"



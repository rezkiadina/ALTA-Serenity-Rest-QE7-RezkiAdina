Feature: Reqres Feature

  @Tugas
  Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send post register request
    Then Status code should be 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"

  @Tugas
  Scenario: Post register user with invalid json
    Given Post register user without password json
    When Send post register request
    Then Status code should be 400 Bad Request
    And Response body should contain error "Missing password"
Feature: Reqres Feature

  @Latihan
  Scenario: Post new user with valid json
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "RezkiAdina" and job "QA Engineer"
    And Validate post create user json schema


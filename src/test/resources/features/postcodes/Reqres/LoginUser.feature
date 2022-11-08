Feature: Reqres Login User Featur
  Scenario: Login User with valid json
    Given Login user with valid json
    When Send Login User Request
    Then Status code should be 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"

    Scenario: Login user with invalid json
      Given Post login user without password json
      When Send Login User Request
      Then Status code should be 400 Bad Request
      And Response body should contain error "Missing password"


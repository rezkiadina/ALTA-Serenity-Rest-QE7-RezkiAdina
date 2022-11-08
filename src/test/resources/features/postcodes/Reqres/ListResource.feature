Feature: Reqres List ResourceFeature
  @Tugas
  Scenario Outline: Get list resource with parameter id
    Given Get list resource with parameter id <id>
    When Send get list resource request
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |
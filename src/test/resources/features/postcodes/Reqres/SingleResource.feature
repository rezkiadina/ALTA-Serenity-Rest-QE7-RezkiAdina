Feature: Reqres Feature
  @Tugas
  Scenario Outline: Get single resource with parameter id
    Given Get single resource with parameter id <id>
    When Send get single resource request
    Then Status code should be 200 OK
    And Validate get single resource json schema
    Examples:
      | id |
      | 2  |

    @Tugas
  Scenario Outline: Get single resource with invalid parameter id
    Given Get single resource with invalid parameter id "<id>"
    When Send get single resource request
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 23   |
      | 2xsj |
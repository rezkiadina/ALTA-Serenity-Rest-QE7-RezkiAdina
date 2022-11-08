Feature: Reqres Feature
@Tugas
 Scenario Outline: Get single user with parameter id
    Given Get single user with parameter id <id>
    When Send get single user request
    Then Status code should be 200 OK
    And Validate get single user json schema
   Examples:
     | id |
     | 1 |
     | 2 |

  @Tugas
  Scenario Outline: Get single user with invalid parameter
    Given Get single user with invalid parameter id "<id>"
    When Send get single user request
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | 23   |
      | 2xsj |


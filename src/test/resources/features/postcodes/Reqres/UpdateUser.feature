Feature: Reqres Feature

  @Latihan
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with id <id>
    When Send put update user request
    Then Status code should be 200 OK
    And Response body should contain name "RezkiAdina Update" and job "QA Engineer Update"
    And Validate put update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |

    @Tugas
    Scenario Outline: Patch update user with valid json
      Given Patch update user with valid json with id <id>
      When Send patch update user request
      Then Status code should be 200 OK
      And Response body should contain name "RAdina Update" and job "QA Update"
      And Validate patch update user json schema
      Examples:
        | id |
        | 1  |
        | 2  |


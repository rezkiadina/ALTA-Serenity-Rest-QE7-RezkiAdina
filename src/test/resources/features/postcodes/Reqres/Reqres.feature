Feature: Reqres Feature
  @Latihan
  Scenario Outline: Get list user with parameter page
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |


        @Latihan
        Scenario Outline: Delete user with valid id
          Given Delete user with id <id>
          When Send delete user request
          Then Status code should be 204 No Content
          Examples:
            | id |
            | 2  |


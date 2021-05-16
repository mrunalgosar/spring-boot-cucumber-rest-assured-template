Feature: Session Test Feature

  Scenario: Session create scenario
    Given user creates a session with following details
      """
      {
        "name": "Test Automation Guild",
        "session_description": "Some random description",
        "session_length": 3
      }
      """
    Then user deletes session with name as "Test Automation Guild"
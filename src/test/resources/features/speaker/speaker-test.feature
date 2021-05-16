Feature: Speaker Test Feature

  Scenario: Speaker Creation Scenario
    Given user creates a speaker with following details
    """
    {
        "firstName": "user 1",
        "last_name": "user 1 last name",
        "title": "Developer",
        "company": "Google",
        "speaker_bio": "random speaker bio"
    }
    """
    Then user deletes speaker with name as "user 1"
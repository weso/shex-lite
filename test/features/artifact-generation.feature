Feature: Build an artifact from an existing java domain model
  As a developer,
  I want to be able to build an artifact from a generated domain model from an existing ontological model.
  So I can get a java artifact that contains the sameclasses as the generated domain model.

    Scenario: Build an artifact from a generated domain model
        Given a generated domain model
        When the user selects to build an artifact
        Then the system builds an artifact

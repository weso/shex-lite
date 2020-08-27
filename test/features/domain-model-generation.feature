Feature: Gnerate a domain model from an ontological model
  As a developer,
  I want to be able to generate a domain model from an existing ontological model.
  So I can get a domain model in Java that represent the same as the ontological model.

    Scenario: Generate a java domain model
        Given an ontological model, composed by shape expressions
        When the user selects to generate a domain model
        Then the system generates a domain model in java

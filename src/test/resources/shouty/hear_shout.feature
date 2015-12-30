Feature: Hear Shout

  Rules:
  - if the shouter is within 1km of the listener, the listener hears the shout
  - if the shouter is more than 1km away from the listener, the listener doesn’t hear the shout
  - the message can’t be empty
  - the message must be shorter than 140 characters

  Questions:
  - what happens if the listener arrives 5 minutes after a shout?
  - what happens in two dimensions?

  Scenario: Out of range shout is not heard
    Given Lucy is 1100m from Sean
    When Sean shouts
    Then Lucy should hear nothing

  Scenario: In range shout is heard
    Given Lucy is 900m from Sean
    When Sean shouts
    Then Lucy should hear Sean's shout

Feature: Hear Shout

  Rules
  =====
  - Need to be within 1000m of shouter to hear a shout

  Questions
  =========
  - Do heard messages disappear when I move out of range?
  - Do unheard messages appear when I move into range?
  - Do messages have an expiry date/time?

  Scenario: Out of range shout is not heard
    Given Lucy is 1100m from Sean
    When Sean shouts
    Then Lucy should hear nothing
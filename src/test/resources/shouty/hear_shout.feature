Feature: Hear Shout

  Rules
  =====
  - Need to be within 1000m of shouter to hear a shout

  Questions
  =========
  - Do we call it a "shout" or a "message"? (We're using both ATM) Ubiquitous Language FTW
  - Do heard messages disappear when I move out of range?
  - Do unheard messages appear when I move into range?
  - Do messages have an expiry date/time?

  Scenario: Out of range shout is not heard
    Given Lucy is 1100m from Sean
    When Sean shouts
    Then Lucy should hear nothing

  @wip
  Scenario: Within range shout is heard
    Given Lucy is 800m from Sean
    When Sean shouts
    Then Lucy should hear the message
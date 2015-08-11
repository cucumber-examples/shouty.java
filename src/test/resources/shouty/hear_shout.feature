Feature: Hear Shout

  Rules:
  - Everyone within 1 km hears the shout
  - Max 140 characters
  - Text only

  Questions:
  - Do shouters need to be registered?
  - Should people hear their own shouts?
  - Should I hear my neighbour's morning shout when I come home from work?

  Distances:
  - Piccadilly Circus is less than a km from Leicester Square
  - Piccadilly Circus is more than a km from Heathrow

  Scenario: Lucy can't hear Sean
    Given "Sean" is at "Piccadilly Circus Station"
    And "Lucy" is at "Heathrow Terminal 5"
    When "Sean" shouts "hello"
    Then "Lucy" should not hear anything

  Scenario: Lucy can hear Sean
    Given "Sean" is at "Piccadilly Circus Station"
    And "Lucy" is at "Leicester Square Station"
    When "Sean" shouts "hello"
    Then "Lucy" should hear "hello"

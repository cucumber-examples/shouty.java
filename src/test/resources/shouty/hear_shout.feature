Feature: Hear Shout

  Shouts can be heard by people who are nearby

  Rules:
  - Must be within 1km
  - List most recent shouts first

  Notes:
  - No UI for now (only domain layer)
  - Geo locations supplied by UI in outer hexagon

  Questions:
  - Do people hear their own shouts?
  - When do people get created?

  Scenario: Jill can't hear Jack
    Given "Jill" is 1500m from "Jack"
    When "Jack" shouts
    Then "Jill" can't hear anything

  Scenario: Jill can hear Jack
    Given "Jill" is 500m from "Jack"
    When "Jack" shouts "hello"
    Then "Jill" can hear "hello"
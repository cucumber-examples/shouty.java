Feature: Hear Shout

  Rules:
  - Must be within 1 mile
  - Shout must have a location
  - Must allow special characters (UTF-8)
  - Internet only (no SMS or email)

  New Rules:
  - Every received message should have sender

  Questions:
  - Should people hear their own messages?

  Background:
    Given the following locations:
      | locationName | lat        | lon         |
      | Morgan       | 40.0517512 | -75.5073917 |
      | Chicago      | 41.8826612 | -87.6254926 |
      | Majestic     | 40.0521154 | -75.503627  |

  Scenario: Osha and Nancy within range
    Given Osha is in Morgan
    And Nancy is in Majestic
    When Osha shouts "hello"
    Then Nancy should receive Osha's "hello" shout

  Scenario: Osha and Nancy beyond range
    Given Osha is in Morgan
    And Nancy is in Chicago
    When Osha shouts "hello"
    Then Nancy should not hear anything

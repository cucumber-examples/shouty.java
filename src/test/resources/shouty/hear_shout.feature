Feature: Hear Shout

  Rules:
  - Must receive the whole message
  - Unlimited messages (for now at least)
  - Must be within 1km from shouter

  Personae:
  - Sam is the Shouter
  - Lisa is the Listener

  Distances:
  - Chancery P is 32km from Airport

  Background:
    Given the following locations:
      | place              | lat   | lon   |
      | Chancery Pavillion | 12.96 | 77.59 |
      | Bengaluru Airport  | 13.20 | 77.70 |
      | Brigade Road       | 12.97 | 77.60 |

  Scenario: Sam is too far away from Lisa
    Given Sam is in "Chancery Pavillion"
    Given Lisa is in "Bengaluru Airport"
    Then Lisa hears nothing

  Scenario: Sam is 500m away from Lisa
    Given Sam is in "Chancery Pavillion"
    Given Lisa is in "Brigade Road"
    When Sam shouts "hello"
    Then Lisa hears "hello"

  Scenario: Lisa hears Sam's shout

  Scenario: Sam shouts lots of messages

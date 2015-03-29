@distance
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

  Scenario: Sam is too far away from Lisa
    Given "Chancery Pavillion" is at 12.96,77.59
    Given "Bengaluru Airport" is at 13.20,77.70
    Given Sam is in "Chancery Pavillion"
    Given Lisa is in "Bengaluru Airport"
    When Sam shouts "hello"
    Then Lisa hears nothing

  @focus
  Scenario: Sam is 500m away from Lisa
    Given "Chancery Pavillion" is at 12.96,77.59
    Given "Brigade Road" is at 13.20,77.70
    Given Sam is in "Chancery Pavillion"
    Given Lisa is in "Brigade Road"
    When Sam shouts "hello"
    Then Lisa hears "hello"

  Scenario: Lisa hears Sam's shout

  Scenario: Sam shouts lots of messages

Feature: Hear Shout

  Rules:
  - Range of 100m

  Todo:
  - Max 140 characters
  - Only send message nearest 20 people
  - Shouter receives acknowledgement when shout is received

  Scenario: Chloe receives a message from Richard
    Given Chloe is within 100m of Richard
    When Richard shouts "hello"
    Then Chloe hears "hello"

  Scenario: Chloe is too far away

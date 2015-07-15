Feature: Hear Shout

  Scenario: Listener is within range
    Given a person named Lucy is at location 99
    And a person named Sean is at location 0
    When Sean shouts "hello"
    Then Lucy hears "hello"

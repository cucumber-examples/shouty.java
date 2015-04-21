Feature: Hear Shout

  Basic shout: Listener can hear shouts made in close proximity
    Range: 1000 feet

  Personas:
    Linda Listener
    Shawn Shouter


  Scenario: Listener doesn't hear shout
    When Shawn shouts "Hello"
    Then Linda hears nothing

  @wip
  Scenario: Listener hears shout
    When Shawn shouts "Hello"
    Then Linda hears "Hello"
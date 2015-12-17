Feature: Hear Shout

  Rules:
  - broadcast to anyone within a 1 mile radius
  - assume message is valid length etc.
  - assume users have the app installed
  - just use text message (no images etc)

  Scenario: A listener is within range
    Given Fred is at location (0,0)
    And Tom is at location (0,0)
    When Tom shouts "Hello!"
    Then Fred hears "Hello!"

  Scenario: A listener is out of range
    Given Fred is at location (0,0)
    And Tom is at location (1000,1000)
    When Tom shouts "Hello!"
    Then Fred does not hear "Hello!"

   Scenario Outline: Listeners in and out of range
     Given Fred is at location <Listener Location>
     And Tom is at location <Shouter Location>
     When Tom shouts "Hello"
     Then Fred <Should hear?> "Hello"

     Examples:
       | Listener Location | Shouter Location | Should hear?  |
       | (0,0)             | (0,0)            | hears         |
       | (0,0)             | (1000,1000)      | does not hear |
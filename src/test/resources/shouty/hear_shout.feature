Feature: Hear Shout

  A description goes here...

  Scenario: Listener doesn't hear a shout
  	Then "Sally" does not hear a shout
  	
  Scenario: Listener hears a shout
    Given "Sally" is on the network
    When "Bob" shouts "hello world"
    Then "Sally" hears "hello world"
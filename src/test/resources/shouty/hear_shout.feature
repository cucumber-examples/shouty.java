Feature: Hear Shout

  A description goes here...

  Scenario: A sent shout is heard
  	Given "Tom" is on Shouty
  	And "Sally" is on Shouty
  	When "Tom" sends a shout
  	Then "Sally" hears the shout
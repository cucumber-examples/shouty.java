Feature: Hear Shout
  
  Just getting started with basic functionality

  Scenario: Out of Range
    Given maximum range is 50 feet
    And Fred is at location 0
    And Mary is at location 60
    When Fred shouts "Hello!"
    Then Mary hears nothing

  Scenario: In Range
    Given maximum range is 50 feet
    And Fred is at location 0
    And Mary is at location 40
    When Fred shouts "Hello!"
    Then Mary hears "Hello!"

Feature: Hear Shout
  
  Just getting started with basic functionality

  Background: 
    Given maximum range is 50 feet
    And Fred is at location 0

  Scenario: Out of Range
    And Mary is at location 60
    When Fred shouts "Hello!"
    Then Mary hears nothing

  Scenario: In Range
    And Mary is at location 40
    When Fred shouts "Hello!"
    Then Mary hears "Hello!"

  Scenario Outline: Checking range
    And Mary is at location <location>
    When Fred shouts "Hello!"
    Then Mary hears <what>

    Examples: 
      | location | what     |
      | 40       | "Hello!" |
      | 60       | nothing  |

  Scenario: multiple listeners
    And Mary is at location 40
    And Tom is at location 80
    When Mary shouts "Hi"
    Then the following people hear "Hi"
      | Tom  |
      | Fred |

  @WIP
  Scenario: Not finished
    Then Tom hears "Hello"

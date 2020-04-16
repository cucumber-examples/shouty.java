Feature: Hear Shout

  Scenario: Nobody is shouting
    Given nobody has shouted
    When Lucy checks the Shouty app
    Then she should hear nothing


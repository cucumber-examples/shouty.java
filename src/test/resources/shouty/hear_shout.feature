Feature: Hear Shout

  @API_1.0.0
  Scenario: Nobody has shouted
    Given nobody has shouted
    When Lucy checks the Shouty app
    Then she should hear nothing

  @API_1.1.0
  Scenario: Somebody has shouted
    Given somebody has shouted
    When Lucy checks the Shouty app
    Then she should hear 1 shout

  @API_1.1.0
  Scenario: Somebody shouted “Hello World”
    Given somebody has shouted "Hello World"
    When Lucy checks the Shouty app
    Then she should hear "Hello World"

  @API_1.1.0
  Scenario: Sean shouted a message
    Given Sean has shouted
    When Lucy checks the Shouty app
    Then she should hear a shout from Sean

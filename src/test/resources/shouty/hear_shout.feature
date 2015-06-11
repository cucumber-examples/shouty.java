Feature: Hear Shout

  As a listener
  I want to hear shouts from people near me
  So I can find local information

  Rules:

  - listener must be within 1 mile to hear a shout
  - shouts do not persist - you have to be there when the shout happens to hear iy

  Scenario: the listener is within range
    Given Hiro has logged into shouty from 0ft
    And Beymax has logged into shouty from 5279ft
    When Hiro shouts "Food truck at Riverside Dr now!"
    Then Beymax should receive the shout "Food truck at Riverside Dr now!"

  Scenario: the listener is out of range

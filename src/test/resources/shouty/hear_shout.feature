Feature: Hear Shout

  Shouts have a range of approximately 1000m

  Scenario: In range shout is heard
    Given Lucy is at 0, 0
    And Sean is at 0, 900
    When Sean shouts
    Then Lucy should hear Sean

  Scenario: Out of range shout is not heard
    Given Lucy is at 0, 0
    And Sean is at 800, 800
    When Sean shouts
    Then Lucy should hear nothing

    Scenario: Multiple shouters
      Given Lucy is at 0, 0
      And Sean is at 0, 500
      And Oscar is at 1100, 0
      When Sean shouts
      And Oscar shouts
      Then Lucy should not hear Oscar
      But Lucy should hear Sean
      